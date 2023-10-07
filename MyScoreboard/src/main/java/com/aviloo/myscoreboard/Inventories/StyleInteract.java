package com.aviloo.myscoreboard.Inventories;

import com.aviloo.myscoreboard.Boards.BoardManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
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
                        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,3,0);
                        break;
                    case RED_BANNER:
                        BoardManager.setColor(player,"red");
                        player.openInventory(CustomInventory.getInv(player));
                        player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                        break;
                    case LIGHT_BLUE_BANNER:
                        BoardManager.setColor(player,"blue");
                        player.openInventory(CustomInventory.getInv(player));
                        player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                        break;
                    case PURPLE_BANNER:
                        BoardManager.setColor(player,"pink");
                        player.openInventory(CustomInventory.getInv(player));
                        player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                        break;
                    case LIGHT_GRAY_BANNER:
                        BoardManager.setColor(player,"gray");
                        player.openInventory(CustomInventory.getInv(player));
                        player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                        break;
                    case SPECTRAL_ARROW:
                        player.openInventory(CustomInventory.getInv(player));
                        player.playSound(player.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT,3,3);
                        break;
                }
            }catch (NullPointerException e){return;}
            event.setCancelled(true);
        }
    }
}
