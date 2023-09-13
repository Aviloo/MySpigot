package com.aviloo.myscoreboard.Inventories;

import com.aviloo.myscoreboard.Boards.BoardManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CustomInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Кастомизация")){
            try{
                switch (event.getCurrentItem().getType()){
                    case ORANGE_BANNER:
                        BoardManager.setColor(player,"original");
                        player.closeInventory();
                        break;
                    case RED_BANNER:
                        BoardManager.setColor(player,"red");
                        player.closeInventory();
                        break;
                    case LIGHT_BLUE_BANNER:
                        BoardManager.setColor(player,"blue");
                        player.closeInventory();
                        break;
                    case PURPLE_BANNER:
                        BoardManager.setColor(player,"pink");
                        player.closeInventory();
                        break;
                    case LIGHT_GRAY_BANNER:
                        BoardManager.setColor(player,"gray");
                        player.closeInventory();
                        break;
                    case BARRIER:
                        player.closeInventory();
                        break;
                }
            }catch (NullPointerException e){return;}
            event.setCancelled(true);
        }
    }
}
