package net.res.alphadarkworld.server.registry;

import net.res.alphadarkworld.AlphaDarkworld;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegistry {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AlphaDarkworld.MOD_ID);

    //Datapacks themselves can't add the custom tunes. So We'll add them here.

    public static RegistryObject<SoundEvent> ALPHALAND_MUSIC= registerSoundEvent("music.alphalands");
    public static RegistryObject<SoundEvent> ALPHALAND_FOREST_MUSIC= registerSoundEvent("music.alphalands.forest");
    public static RegistryObject<SoundEvent> ALPHALAND_OCEAN_MUSIC= registerSoundEvent("music.alphalands.ocean");
    public static RegistryObject<SoundEvent> SKYLAND_MUSIC= registerSoundEvent("music.skylands");
    public static RegistryObject<SoundEvent> SNOWLAND_MUSIC = registerSoundEvent("music.snowland");
    public static RegistryObject<SoundEvent> CAVELAND_MUSIC = registerSoundEvent("music.cavelands");
    public static RegistryObject<SoundEvent> DARK_LAND_MUSIC = registerSoundEvent("music.darklands");
    public static RegistryObject<SoundEvent> ICEY_OCEAN_AMBIENT = registerSoundEvent("icey_ocean_ambient_loop");
    public static RegistryObject<SoundEvent> MOSS_CAVE_LOOP = registerSoundEvent("ambient.caveland_loop");
    public static RegistryObject<SoundEvent> DARKNESS_LOOP = registerSoundEvent("ambient.wormhole");
    public static RegistryObject<SoundEvent> SILENCE = registerSoundEvent("silent");

    public static RegistryObject<SoundEvent> DROOPY_DISC = registerSoundEvent("record.droopy_likes_your_face");

    //Custom block sounds for extra nostalgia

    public static RegistryObject<SoundEvent> NO_FALL_SOUND = registerSoundEvent("blocks.falling.generic");

    public static RegistryObject<SoundEvent> GRASS_STEP = registerSoundEvent("blocks.alpha_grass.step");
    public static RegistryObject<SoundEvent> GRASS_HIT = registerSoundEvent("blocks.alpha_grass.hit");
    public static RegistryObject<SoundEvent> GRASS_BREAK = registerSoundEvent("blocks.alpha_grass.break");
    public static RegistryObject<SoundEvent> GRASS_PLACE = registerSoundEvent("blocks.alpha_grass.place");

    public static RegistryObject<SoundEvent> DIRT_STEP = registerSoundEvent("blocks.alpha_dirt.step");
    public static RegistryObject<SoundEvent> DIRT_HIT = registerSoundEvent("blocks.alpha_dirt.hit");
    public static RegistryObject<SoundEvent> DIRT_BREAK = registerSoundEvent("blocks.alpha_dirt.break");
    public static RegistryObject<SoundEvent> DIRT_PLACE = registerSoundEvent("blocks.alpha_dirt.place");

    public static RegistryObject<SoundEvent> SAND_STEP = registerSoundEvent("blocks.alpha_sand.step");
    public static RegistryObject<SoundEvent> SAND_HIT = registerSoundEvent("blocks.alpha_sand.hit");
    public static RegistryObject<SoundEvent> SAND_BREAK = registerSoundEvent("blocks.alpha_sand.break");
    public static RegistryObject<SoundEvent> SAND_PLACE = registerSoundEvent("blocks.alpha_sand.place");

    public static RegistryObject<SoundEvent> STONE_STEP = registerSoundEvent("blocks.alpha_stone.step");
    public static RegistryObject<SoundEvent> STONE_HIT = registerSoundEvent("blocks.alpha_stone.hit");
    public static RegistryObject<SoundEvent> STONE_BREAK = registerSoundEvent("blocks.alpha_stone.break");
    public static RegistryObject<SoundEvent> STONE_PLACE = registerSoundEvent("blocks.alpha_stone.place");

    public static RegistryObject<SoundEvent> WOOD_STEP = registerSoundEvent("blocks.alpha_wood.step");
    public static RegistryObject<SoundEvent> WOOD_HIT = registerSoundEvent("blocks.alpha_wood.hit");
    public static RegistryObject<SoundEvent> WOOD_BREAK = registerSoundEvent("blocks.alpha_wood.break");
    public static RegistryObject<SoundEvent> WOOD_PLACE = registerSoundEvent("blocks.alpha_wood.place");

    public static RegistryObject<SoundEvent> GLASS_BREAK = registerSoundEvent("blocks.alpha_glass.break");

    public static RegistryObject<SoundEvent> DOOR_OPEN = registerSoundEvent("blocks.alpha_door.open");
    public static RegistryObject<SoundEvent> DOOR_CLOSE = registerSoundEvent("blocks.alpha_door.close");

    
    public static RegistryObject<SoundEvent> BUTTON_UP = registerSoundEvent("blocks.alpha_button.up");
    public static RegistryObject<SoundEvent> BUTTON_DOWN = registerSoundEvent("blocks.alpha_button.down");

    //Mobs

    public static RegistryObject<SoundEvent> FROZEN_ZOMBIE_AMBIENT = registerSoundEvent("entity.frozen_zombie.ambient");
    public static RegistryObject<SoundEvent> FROZEN_ZOMBIE_HURT = registerSoundEvent("entity.frozen_zombie.hurt");
    public static RegistryObject<SoundEvent> FROZEN_ZOMBIE_DEATH = registerSoundEvent("entity.frozen_zombie.death");

    private static RegistryObject<SoundEvent> registerSoundEvent(String sound)
    {
        return SOUNDS.register(sound, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AlphaDarkworld.MOD_ID, sound)));
    }
}
