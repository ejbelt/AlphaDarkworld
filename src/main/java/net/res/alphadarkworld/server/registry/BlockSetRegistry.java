package net.res.alphadarkworld.server.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class BlockSetRegistry {
    public static final BlockSetType ALPHA_WOOD_BLOCKSET = new BlockSetType("alpha_wood", true, SoundTypeRegistry.ALPHA_WOOD, 
        SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), 
        SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, 
        SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
    public static final BlockSetType ALPHA_STONE_BLOCKSET = new BlockSetType("darkner_stone", true, SoundTypeRegistry.ALPHA_STONE, 
        SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), 
        SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, 
        SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
    public static final BlockSetType ALPHA_COBBLESTONE_BLOCKSET = new BlockSetType("alpha_cobblestone", true, SoundTypeRegistry.ALPHA_STONE, 
        SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), 
        SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, 
        SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
    public static final BlockSetType ALPHA_MOSSY_COBBLESTONE_BLOCKSET = new BlockSetType("alpha_mossy_cobblestone", true, SoundTypeRegistry.ALPHA_STONE, 
        SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), 
        SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, 
        SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
    public static final BlockSetType ALPHA_BRICK_BLOCKSET = new BlockSetType("alpha_brick", true, SoundTypeRegistry.ALPHA_STONE, 
        SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), SoundRegistry.DOOR_CLOSE.get(), SoundRegistry.DOOR_OPEN.get(), 
        SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, 
        SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
}
