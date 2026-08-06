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
    public static RegistryObject<SoundEvent> SNOWLAND_MUSIC = registerSoundEvent("music.snowland");
    public static RegistryObject<SoundEvent> CAVELAND_MUSIC = registerSoundEvent("music.cavelands");
    public static RegistryObject<SoundEvent> ICEY_OCEAN_AMBIENT = registerSoundEvent("icey_ocean_ambient_loop");
    public static RegistryObject<SoundEvent> MOSS_CAVE_LOOP = registerSoundEvent("caveland_loop");
    public static RegistryObject<SoundEvent> DARKNESS_LOOP = registerSoundEvent("ambient.wormhole");
    public static RegistryObject<SoundEvent> SILENCE = registerSoundEvent("silent");

    public static RegistryObject<SoundEvent> DROOPY_DISC = registerSoundEvent("record.droopy_likes_your_face");

    private static RegistryObject<SoundEvent> registerSoundEvent(String sound)
    {
        return SOUNDS.register(sound, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AlphaDarkworld.MOD_ID, sound)));
    }
}
