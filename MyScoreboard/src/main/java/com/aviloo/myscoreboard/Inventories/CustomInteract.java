package com.aviloo.myscoreboard.Inventories;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CustomInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Кастомизация")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                    player.openInventory(MainInventory.getInv(player));
                    break;
                case RED_DYE:
                    player.closeInventory();
                    player.openInventory(StyleInventory.getInv(player));
                    break;
                case MAP:
                    player.closeInventory();
                    player.openInventory(StatisticInventory.getInv(player));
                    break;
            }
            event.setCancelled(true);
        }

    }

}
