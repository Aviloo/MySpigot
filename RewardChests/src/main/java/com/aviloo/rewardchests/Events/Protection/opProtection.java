package com.aviloo.rewardchests.Events.Protection;

import com.aviloo.rewardchests.ItemStack.Chests.fisherChest;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class opProtection implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){

        Player player = event.getPlayer();

        if(player.isOp()){
//            if (player.getDisplayName().equals("Aviloo")){
//                event.setCancelled(false);
//                player.sendMessage(ChatColor.WHITE+ "Вы успешно выкинули этот предмет.");
//            }
            if(event.getItemDrop().equals(fisherChest.chestStack()) && !player.getDisplayName().equals("Aviloo")){
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED+ "Вы не можете выкинуть этот предмет.");
            }
        }
    }

    @EventHandler
    public void clickChest(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if(player.isOp()){
            /*
            if(player.getDisplayName().equals("Aviloo")){
                event.setCancelled(false);
                player.sendMessage(ChatColor.WHITE+ "Вы успешно выкинули этот предмет.");
            }
             */
            if(event.getCurrentItem().equals(fisherChest.chestStack()) && !player.getDisplayName().equals("Aviloo")){
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED+ "Вы не можете выкинуть этот предмет.");
            }
        }
    }
}
