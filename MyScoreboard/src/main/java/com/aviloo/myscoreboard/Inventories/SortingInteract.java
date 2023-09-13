package com.aviloo.myscoreboard.Inventories;

import com.aviloo.myscoreboard.Inventories.SortingInventories.SortingOtherInventory;
import com.aviloo.myscoreboard.Inventories.SortingInventories.SortingPvpInventory;
import com.aviloo.myscoreboard.Inventories.SortingInventories.SortingStatisticInventory;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SortingInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Сортировка Тэгов")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                    player.openInventory(StatisticInventory.getInv(player));
                    break;
                case TOTEM_OF_UNDYING:
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                    player.openInventory(SortingPvpInventory.getInv(player));
                    break;
                case BOOK:
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                    player.openInventory(SortingStatisticInventory.getInv(player));
                    break;
                case GUNPOWDER:
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                    player.openInventory(SortingOtherInventory.getInv(player));
                    break;
            }
            event.setCancelled(true);
        }

    }

}
