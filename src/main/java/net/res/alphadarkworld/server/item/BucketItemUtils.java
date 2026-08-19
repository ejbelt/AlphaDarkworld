package net.res.alphadarkworld.server.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BucketItemUtils {
    public static ItemStack createFilledResult(ItemStack pEmptyStack, Player pPlayer, ItemStack pFilledStack, boolean pPreventDuplicates) {
      boolean flag = pPlayer.getAbilities().instabuild;
      if (pPreventDuplicates && flag) {
         if (!pPlayer.getInventory().contains(pFilledStack)) {
            pPlayer.getInventory().add(pFilledStack);
         }

         return pEmptyStack;
      } else {
         if (!flag) {
            pEmptyStack.shrink(1);
         }

         if (pEmptyStack.isEmpty()) {
            
            return pFilledStack;
         } else {
            if (!pPlayer.getInventory().add(pFilledStack)) {
               pPlayer.drop(pFilledStack, false);
            }

            return pEmptyStack;
         }
      }
   }
   
   public static ItemStack createFilledResult(ItemStack pEmptyStack, Player pPlayer, ItemStack pFilledStack) {
      return createFilledResult(pEmptyStack, pPlayer, pFilledStack, true);
   }
}
