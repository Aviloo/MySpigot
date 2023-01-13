package com.aviloo.rewardchests.Commands.Inventory;

import com.aviloo.rewardchests.ItemStack.Chests.fisherChest;
import com.aviloo.rewardchests.ItemStack.Chests.hunterChest;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class getChestStackInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.GRAY+"Адм.Панель: Ларцы")){
            switch (event.getCurrentItem().getType()){
                case TROPICAL_FISH:
                    player.closeInventory();
                    player.getInventory().addItem(fisherChest.chestStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] "+ChatColor.WHITE+"Вам был добавлен предмет.");
                    break;
                case COOKED_PORKCHOP:
                    player.closeInventory();
                    player.getInventory().addItem(hunterChest.chestStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] "+ChatColor.WHITE+"Вам был добавлен предмет.");
                    break;
            }
            event.setCancelled(true);
        }
        
    }
}
