package net.res.alphadarkworld.server.util;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.util.RandomSource;
import net.minecraft.util.random.WeightedRandom;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.DungeonHooks.DungeonMob;
import net.res.alphadarkworld.server.registry.EntityRegistry;

public class AlphaDungeonHooks {

    private static ArrayList<DungeonMob> dungeonMobs = new ArrayList<DungeonMob>();

    /**
     * Adds a mob to the possible list of creatures the spawner will create.
     * If the mob is already in the spawn list, the rarity will be added to the existing one,
     * causing the mob to be more common.
     *
     * @param type Monster type
     * @param rarity The rarity of selecting this mob over others. Must be greater then 0.
     *        Vanilla Minecraft has the following mobs:
     *        Spider   100
     *        Skeleton 100
     *        Zombie   200
     *        Meaning, Zombies are twice as common as spiders or skeletons.
     * @return The new rarity of the monster,
     */
    public static float addDungeonMob(EntityType<?> type, int rarity)
    {
        if (rarity <= 0)
        {
            throw new IllegalArgumentException("Rarity must be greater then zero");
        }

        Iterator<DungeonMob> itr = dungeonMobs.iterator();
        while (itr.hasNext())
        {
            DungeonMob mob = itr.next();
            if (type == mob.type)
            {
                itr.remove();
                rarity = mob.getWeight().asInt() + rarity;
                break;
            }
        }

        dungeonMobs.add(new DungeonMob(rarity, type));
        return rarity;
    }

    /**
     * Will completely remove a Mob from the dungeon spawn list.
     *
     * @param name The name of the mob to remove
     * @return The rarity of the removed mob, prior to being removed.
     */
    public static int removeDungeonMob(EntityType<?> name)
    {
        for (DungeonHooks.DungeonMob mob : dungeonMobs)
        {
            if (name == mob.type)
            {
                dungeonMobs.remove(mob);
                return mob.getWeight().asInt();
            }
        }
        return 0;
    }

    /**
     * Gets a random mob name from the list.
     * @param rand World generation random number generator
     * @return The mob name
     */
    public static EntityType<?> getRandomDungeonMob(RandomSource rand)
    {
        DungeonHooks.DungeonMob mob = WeightedRandom.getRandomItem(rand, dungeonMobs).orElseThrow();
        return mob.type;
    }

    static
    {
        addDungeonMob(EntityRegistry.FROZEN_ZOMBIE.get(), 100);
        addDungeonMob(EntityRegistry.DARKWORLD_ZOMBIE.get(),   200);
        //addDungeonMob(EntityType.SPIDER,   100);
    }

}
