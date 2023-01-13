package com.aviloo.mytraderreloaded.DonateShop.Inventories.Events;

import com.aviloo.mytraderreloaded.DonateShop.Inventories.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(event.getCurrentItem() == null){return;}
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Торговец")){
            switch (event.getCurrentItem().getType()){
                case RED_STAINED_GLASS_PANE:
                    player.closeInventory();
                    break;
                case RED_MUSHROOM_BLOCK:
                    player.openInventory(MushroomInventory.getInv(player));
                    break;
                case SHIELD:
                    player.openInventory(ShieldInventory.getInv(player));
                    break;
                case REDSTONE_BLOCK:
                    player.openInventory(VaultInventory.getInv(player));
                    break;
                case ENCHANTED_BOOK:
                    player.openInventory(EnchantedInventory.getInv(player));
                    break;
                case MAGMA_CUBE_SPAWN_EGG:
                    player.openInventory(EggsInventory.getInv(player));
                    break;
            }
            event.setCancelled(true);
        }
    }
}
