package com.aviloo.myscoreboard.Inventories;

import com.aviloo.myscoreboard.Boards.BoardManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Скорборд")){
            try{
                switch (event.getCurrentItem().getType()){
                    case RED_SHULKER_BOX:
                        BoardManager.removeScoreboard(player);
                        player.closeInventory();
                        break;
                    case GREEN_SHULKER_BOX:
                        BoardManager.setBoards(player);
                        player.closeInventory();
                        break;
                    case EXPERIENCE_BOTTLE:
                        player.closeInventory();
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
