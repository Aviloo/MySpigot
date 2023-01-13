package com.aviloo.mydaily.Inventory.Events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(!event.getView().getTitle().equals(ChatColor.WHITE+"Ежедневные задания")){return;}
        if(event.getCurrentItem() == null){return;}

        Player player = (Player) event.getWhoClicked();
        switch (event.getCurrentItem().getType()){
            case SPECTRAL_ARROW:
                player.playSound(player.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT,1,1);
                player.closeInventory();
                break;
            case BARRIER:
                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы уже выполнили это задание.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,1,1);
                break;
        }
        event.setCancelled(true);
    }
}
