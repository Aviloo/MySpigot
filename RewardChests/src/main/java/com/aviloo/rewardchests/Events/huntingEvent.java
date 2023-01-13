package com.aviloo.rewardchests.Events;

import com.aviloo.rewardchests.ItemStack.Chests.fisherChest;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class huntingEvent implements Listener {


    @EventHandler
    public void onPig(EntityDeathEvent event){


        if(event.getEntity().getKiller() == null){

        }
        if(event.getEntity().getKiller() instanceof Player){
            Player player = ((Player) event.getEntity().getKiller()).getPlayer();
            if(Math.random() <= 0.00000001) { // 0.000001 %
                player.getInventory().addItem(com.aviloo.rewardchests.ItemStack.Chests.hunterChest.chestStack());
                player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпал сундук охотника.");
            }
        }

    }
}
