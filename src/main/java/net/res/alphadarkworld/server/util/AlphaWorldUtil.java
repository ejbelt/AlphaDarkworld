package net.res.alphadarkworld.server.util;

import destiny.penumbra_phantasm.PenumbraPhantasm;
import destiny.penumbra_phantasm.ServerConfig;
import destiny.penumbra_phantasm.server.fountain.GreatDoor;
import destiny.penumbra_phantasm.server.registry.CapabilityRegistry;
import destiny.penumbra_phantasm.server.util.DarkWorldUtil;
import destiny.penumbra_phantasm.server.util.DarkWorldUtil.GreatDoorStructureResult;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.registry.BlockRegistry;

import java.util.Optional;

public class AlphaWorldUtil {
    
    public static boolean isInSlip(ResourceKey<Level> levelResourceKey){
        return levelResourceKey.location().getPath().contains("alpha_darkness");
    }

    public static boolean isAlphaWorld(ResourceKey<Level> levelResourceKey) {
        return levelResourceKey.location().getPath().contains("alpha_");
    }

    public static void ensureAlphaGreatDoorToGreatDoor(GreatDoor source, ServerLevel sourceLevel, ServerLevel destLevel) {
		if (!source.isDestinationDarkWorld || source.destinationGreatDoorDimension == null) return;

		if (source.lightDoorPos == null || source.lightDoorDimension == null || source.lightDoorExitDirection == null) return;

		if (!source.destinationGreatDoorDimension.equals(destLevel.dimension())) return;

		if (source.destinationGreatDoorPos != null) {
			GreatDoor existing = destLevel.getCapability(CapabilityRegistry.GREAT_DOOR).resolve().map(cap -> cap.greatDoors
					.get(source.destinationGreatDoorPos)).orElse(null);

			if (existing != null) return;
		}

		BlockPos fountainPos = DarkWorldUtil.findDarkFountainPos(destLevel);
		if (fountainPos == null) return;

		Optional<GreatDoorStructureResult> placed = tryPlaceAlphaGreatDoorStructure(destLevel, fountainPos, destLevel.random);
		if (placed.isEmpty()) return;

		GreatDoorStructureResult structureResult = placed.get();

		DarkWorldUtil.createGreatDoor(destLevel, structureResult.anchorPos(), structureResult.facing(), true, source.lightDoorPos, source.lightDoorSecondLower,
				source.lightDoorDimension, source.lightDoorExitDirection, true, source.greatDoorPos, sourceLevel.dimension());
		source.destinationGreatDoorPos = structureResult.anchorPos();
		source.destinationGreatDoorDimension = destLevel.dimension();
	}

    public static Optional<GreatDoorStructureResult> tryPlaceAlphaGreatDoorStructure(ServerLevel level, BlockPos fountainPos, RandomSource random) {
		ResourceLocation structureLocation = new ResourceLocation(AlphaDarkworld.MOD_ID, "great_door");
		Optional<StructureTemplate> templateOptional = level.getStructureManager().get(structureLocation);

		if (templateOptional.isEmpty()) {
			return Optional.empty();
		}

		StructureTemplate template = templateOptional.get();
		int minR = Math.min(ServerConfig.greatDoorPlaceMinRadius, ServerConfig.greatDoorPlaceMaxRadius);
		int maxR = Math.max(ServerConfig.greatDoorPlaceMinRadius, ServerConfig.greatDoorPlaceMaxRadius);

		for (int attempt = 0; attempt < 48; attempt++) {
			double angle = random.nextDouble() * Math.PI * 2;
			double dist = minR + random.nextDouble() * (maxR - minR);
			int x = fountainPos.getX() + Mth.floor(Mth.cos((float) angle) * dist);
			int z = fountainPos.getZ() + Mth.floor(Mth.sin((float) angle) * dist);

			Rotation facing = switch (random.nextInt(4)) {
				case 0 -> Rotation.NONE;
				case 1 -> Rotation.CLOCKWISE_90;
				case 2 -> Rotation.CLOCKWISE_180;
				default -> Rotation.COUNTERCLOCKWISE_90;
			};

			int xDoorOffset = 0;
			int zDoorOffset = 0;
			if(facing == Rotation.NONE) {
				xDoorOffset -= 14;
				zDoorOffset -= 27;
			}
			if(facing == Rotation.CLOCKWISE_90) {
				xDoorOffset += 27;
				zDoorOffset += 14;
			}
			if(facing == Rotation.CLOCKWISE_180) {
				xDoorOffset += 14;
				zDoorOffset += 27;
			}
			if(facing == Rotation.COUNTERCLOCKWISE_90) {
				xDoorOffset -= 27;
				zDoorOffset += 14;
			}

			int footY = resolveAlphaGreatDoorLowerY(level, fountainPos, x+xDoorOffset, z+zDoorOffset);

			if (footY == Integer.MIN_VALUE) continue;

            if (footY <= level.getMinBuildHeight()) continue;

			BlockPos origin = new BlockPos(x, footY, z);
			Optional<GreatDoorStructureResult> placed = placeAlphaGreatDoorStructure(level, template, origin, facing.getRotated(Rotation.CLOCKWISE_180), random);

			if (placed.isPresent()) {
				return placed;
			}
		}

		return Optional.empty();
	}

	private static int resolveAlphaGreatDoorLowerY(ServerLevel level, BlockPos fountainAnchor, int x, int z) {
		BlockPos doorPos = new BlockPos(x + 27, level.getMaxBuildHeight() - 1, z - 14);
		long chunk = ChunkPos.asLong(doorPos);

		level.setChunkForced(ChunkPos.getX(chunk), ChunkPos.getZ(chunk), true);

		int y = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, doorPos).getY();
		int minY = level.getMinBuildHeight() + 5;
		int steps = 64;

		while (steps-- > 0 && y > minY) {
			BlockPos test = new BlockPos(x, y, z);
			BlockState st = level.getBlockState(test);

			if (hasGreatDoorObstructions(st)) {
				y--;
				continue;
			}

			if (!isUnsuitableGreatDoorBase(level, test)) {
				level.setChunkForced(ChunkPos.getX(chunk), ChunkPos.getZ(chunk), false);
				return y;
			}
			y--;
		}

		y = fountainAnchor.getY();
		steps = 32;

		while (steps-- > 0 && y > minY) {
			BlockPos basePos = new BlockPos(x, y, z);
			BlockState baseState = level.getBlockState(basePos);

			if (hasGreatDoorObstructions(baseState)) {
				y--;
				continue;
			}

			if (!isUnsuitableGreatDoorBase(level, basePos)) {
				level.setChunkForced(ChunkPos.getX(chunk), ChunkPos.getZ(chunk), false);
				return y;
			}
			y--;
		}

		return Integer.MIN_VALUE;
	}

	private static boolean hasGreatDoorObstructions(BlockState state) {
		if (state.isAir()) return false;

		if (!state.getFluidState().isEmpty()) return true;

		if (state.is(BlockTags.LEAVES)) return true;
		if (state.is(BlockTags.SAPLINGS)) return true;
		if (state.is(BlockTags.REPLACEABLE)) return true;
		if (state.is(Blocks.SPORE_BLOSSOM)) return true;
		if (state.is(Blocks.SWEET_BERRY_BUSH)) return true;
		if (state.is(Blocks.CACTUS)) return true;
		if (state.is(BlockTags.FLOWERS) || state.is(BlockTags.SMALL_FLOWERS)) return true;
		if (state.is(Blocks.BAMBOO) || state.is(Blocks.BAMBOO_SAPLING)) return true;
		if (state.is(Blocks.BROWN_MUSHROOM_BLOCK) || state.is(Blocks.RED_MUSHROOM_BLOCK)) return true;
		if (state.is(Blocks.CHORUS_PLANT) || state.is(Blocks.CHORUS_FLOWER)) return true;
		if (state.is(Blocks.VINE) || state.is(Blocks.CAVE_VINES) || state.is(Blocks.CAVE_VINES_PLANT)) return true;
		if (state.is(Blocks.MOSS_CARPET) || state.is(Blocks.AZALEA) || state.is(Blocks.FLOWERING_AZALEA)) return true;
		if (state.is(Blocks.BIG_DRIPLEAF) || state.is(Blocks.BIG_DRIPLEAF_STEM) || state.is(Blocks.SMALL_DRIPLEAF)) return true;
		if (state.is(BlockTags.LOGS) || state.is(BlockTags.LOGS_THAT_BURN) || state.is(BlockTags.CRIMSON_STEMS) || state.is(BlockTags.WARPED_STEMS)) return true;

		return false;
	}

	private static boolean isUnsuitableGreatDoorBase(ServerLevel level, BlockPos groundTop) {
		BlockState solid = level.getBlockState(groundTop);

		if (solid.isAir()) return true;
		if (!solid.getFluidState().isEmpty()) return true;
		if (solid.is(Blocks.BEDROCK)) return true;
		if (hasGreatDoorObstructions(solid)) return true;

		int minY = level.getMinBuildHeight();
		if (groundTop.getY() <= minY + 5) {
			return true;
		}

		return false;
	}

	private static Optional<GreatDoorStructureResult> placeAlphaGreatDoorStructure(ServerLevel level, StructureTemplate template, BlockPos origin, Rotation rot,
																			  RandomSource random) {
		StructurePlaceSettings settings = new StructurePlaceSettings().setRotation(rot).setMirror(Mirror.NONE).setIgnoreEntities(false);
		ChunkPos chunkPos = new ChunkPos(origin);

		level.setChunkForced(chunkPos.x, chunkPos.z, true);

		boolean isPlaced = template.placeInWorld(level, origin, origin, settings, random, 2);

		level.setChunkForced(chunkPos.x, chunkPos.z, false);

		if (!isPlaced) {
			return Optional.empty();
		}

		return removeSpawnerAfterPlacing(level, template, settings, origin);
	}

	private static Optional<GreatDoorStructureResult> removeSpawnerAfterPlacing(ServerLevel level, StructureTemplate template,
																				StructurePlaceSettings settings, BlockPos origin) {
		BoundingBox boundingBox = template.getBoundingBox(settings, origin);
		BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
		BlockPos foundPos = null;
		Direction facing = Direction.NORTH;

		for (int x = boundingBox.minX(); x <= boundingBox.maxX(); x++) {
			for (int y = boundingBox.minY(); y <= boundingBox.maxY(); y++) {
				for (int z = boundingBox.minZ(); z <= boundingBox.maxZ(); z++) {
					mutablePos.set(x, y, z);
					BlockState currentState = level.getBlockState(mutablePos);

					if (currentState.is(destiny.penumbra_phantasm.server.registry.BlockRegistry.GREAT_DOOR_SPAWNER.get())) {
						foundPos = mutablePos.immutable();
						facing = currentState.getValue(HorizontalDirectionalBlock.FACING);
						break;
					}
				}

				if (foundPos != null) break;

			}
			if (foundPos != null) break;

		}

		if (foundPos != null) {
			level.setBlock(foundPos, Blocks.AIR.defaultBlockState(), 3);

			return Optional.of(new GreatDoorStructureResult(foundPos, facing));
		}

		return Optional.empty();
	}


}
