package com.aviloo.rewardchests.Events;

import com.aviloo.rewardchests.ItemStack.Chests.fisherChest;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class fishingEvent implements Listener {

    @EventHandler
    public void onFish(PlayerFishEvent event){
        Player player = event.getPlayer();
        if(Math.random() <= 0.00004){ // 0.004 %
            event.setCancelled(true);
            player.getInventory().addItem(fisherChest.chestStack());
            player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпал сундук рыбака.");
        }
    }
}
