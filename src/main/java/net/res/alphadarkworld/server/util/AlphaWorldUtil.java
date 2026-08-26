package net.res.alphadarkworld.server.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class AlphaWorldUtil {
    
    public static boolean isInSlip(ResourceKey<Level> levelResourceKey){
        return levelResourceKey.location().getPath().contains("alpha_darkness");
    }

}
