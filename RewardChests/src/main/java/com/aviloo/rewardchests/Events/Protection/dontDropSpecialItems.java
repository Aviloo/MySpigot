package com.aviloo.rewardchests.Events.Protection;

import com.aviloo.rewardchests.ItemStack.Rewards.Special.fishingRod;
import com.aviloo.rewardchests.ItemStack.Rewards.Special.woodPickaxeUltimate;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class dontDropSpecialItems implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {

        Player player = event.getPlayer();
        if (player.isOp()) {
            if (player.getDisplayName().equals("Aviloo")){
                event.setCancelled(false);
                player.sendMessage(ChatColor.WHITE+ "Вы успешно выкинули этот предмет.");
            }
            if (player.getDisplayName().equals("Fullvision")){
                event.setCancelled(false);
                player.sendMessage(ChatColor.WHITE+ "Вы успешно выкинули этот предмет.");
            }
            if (event.getItemDrop().equals(fishingRod.fishingRodStack()) || event.getItemDrop().equals(woodPickaxeUltimate.ultimateWoodPickAxeStack())) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED+ "Вы не можете выкинуть этот предмет.");
            }
        }
    }
}
