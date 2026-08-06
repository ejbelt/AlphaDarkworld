package net.res.alphadarkworld.server.world.entity.animal;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

public class DarkWorldSheep extends Sheep {
    
    private static final EntityDataAccessor<Byte> DATA_WOOL_ID = SynchedEntityData.defineId(DarkWorldSheep.class, EntityDataSerializers.BYTE);
    

    public DarkWorldSheep(EntityType<? extends Sheep> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    
    private static float[] createSheepColor(DyeColor p_29866_) {
        //white no matter what.
    
        return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
    }

    public ResourceLocation getDefaultLootTable() {
        if (this.isSheared()) {
            return this.getType().getDefaultLootTable();
        } else {
            return BuiltInLootTables.SHEEP_WHITE;
        }
    }

    public static DyeColor getRandomSheepColor(RandomSource pRandom) {
        return DyeColor.WHITE;
    }

    public void setColor(DyeColor pDyeColor) {
        byte b0 = this.entityData.get(DATA_WOOL_ID);
        this.entityData.set(DATA_WOOL_ID, (byte)(b0 & 240 | pDyeColor.getId() & 15));
    }

}
