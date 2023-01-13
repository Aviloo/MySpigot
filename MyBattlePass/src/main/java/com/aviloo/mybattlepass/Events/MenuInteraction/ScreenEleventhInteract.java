package com.aviloo.mybattlepass.Events.MenuInteraction;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ScreenEleventhInteract implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getView().getTitle().equals("Боевой пропуск (У вас 10 уровень )")){
            Player player = (Player) event.getWhoClicked();
            try{
               switch (event.getCurrentItem().getType()){
                   case BARRIER:
                       if(event.isLeftClick()) {
                           player.closeInventory();
                       }
                       if(event.isRightClick()) {
                           player.closeInventory();
                           Bukkit.dispatchCommand(player,"menu");
                       }
                       break;
               }
            }catch (NullPointerException e){}
            event.setCancelled(true);
        }
    }
}
