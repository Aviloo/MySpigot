package com.aviloo.myscoreboard.Inventories;

import com.aviloo.myscoreboard.Boards.BoardManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StyleInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Стили")){
            try{
                switch (event.getCurrentItem().getType()){
                    case ORANGE_BANNER:
                        BoardManager.setColor(player,"original");
                        player.openInventory(CustomInventory.getInv(player));
                        break;
                    case RED_BANNER:
                        BoardManager.setColor(player,"red");
                        player.openInventory(CustomInventory.getInv(player));
                        break;
                    case LIGHT_BLUE_BANNER:
                        BoardManager.setColor(player,"blue");
                        player.openInventory(CustomInventory.getInv(player));
                        break;
                    case PURPLE_BANNER:
                        BoardManager.setColor(player,"pink");
                        player.openInventory(CustomInventory.getInv(player));
                        break;
                    case LIGHT_GRAY_BANNER:
                        BoardManager.setColor(player,"gray");
                        player.openInventory(CustomInventory.getInv(player));
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
