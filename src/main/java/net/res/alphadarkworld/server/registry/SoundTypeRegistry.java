package net.res.alphadarkworld.server.registry;

import net.minecraftforge.common.util.ForgeSoundType;

public class SoundTypeRegistry {
    
    public static final ForgeSoundType ALPHA_WOOD = new ForgeSoundType(1.0F, 1.0F, 
        SoundRegistry.WOOD_BREAK, SoundRegistry.WOOD_STEP, SoundRegistry.WOOD_PLACE, SoundRegistry.WOOD_HIT, SoundRegistry.NO_FALL_SOUND);

    public static final ForgeSoundType ALPHA_DIRT = new ForgeSoundType(1.0F, 1.0F, 
        SoundRegistry.DIRT_BREAK, SoundRegistry.DIRT_STEP, SoundRegistry.DIRT_PLACE, SoundRegistry.DIRT_HIT, SoundRegistry.NO_FALL_SOUND);

    public static final ForgeSoundType ALPHA_SAND = new ForgeSoundType(1.0F, 1.0F, 
        SoundRegistry.DIRT_BREAK, SoundRegistry.SAND_STEP, SoundRegistry.SAND_PLACE, SoundRegistry.SAND_HIT, SoundRegistry.NO_FALL_SOUND);

    public static final ForgeSoundType ALPHA_GRASS = new ForgeSoundType(1.0F, 1.0F, 
        SoundRegistry.GRASS_BREAK, SoundRegistry.GRASS_STEP, SoundRegistry.GRASS_PLACE, SoundRegistry.GRASS_HIT, SoundRegistry.NO_FALL_SOUND);

    public static final ForgeSoundType ALPHA_STONE = new ForgeSoundType(1.0F, 1.0F, 
        SoundRegistry.STONE_BREAK, SoundRegistry.STONE_STEP, SoundRegistry.STONE_PLACE, SoundRegistry.STONE_HIT, SoundRegistry.NO_FALL_SOUND);

    public static final ForgeSoundType ALPHA_DENSE_STONE = new ForgeSoundType(1.0F, 1.6F, 
        SoundRegistry.STONE_BREAK, SoundRegistry.STONE_STEP, SoundRegistry.STONE_PLACE, SoundRegistry.STONE_HIT, SoundRegistry.NO_FALL_SOUND);

    public static final ForgeSoundType ALPHA_GLASS = new ForgeSoundType(1.0F, 0.8F, 
        SoundRegistry.GLASS_BREAK, SoundRegistry.STONE_STEP, SoundRegistry.STONE_PLACE, SoundRegistry.STONE_HIT, SoundRegistry.NO_FALL_SOUND);
}
