package com.aviloo.myscoreboard.Inventories.ShoppingInventories.Interact;

import com.aviloo.myscoreboard.Inventories.StatisticInventory;
import com.aviloo.myscoreboard.Utils.EconomyManager;
import com.aviloo.myscoreboard.Utils.ShoppingUtil;
import com.aviloo.myscoreboard.models.PlayerTags;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SevenHundredInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Подтвердите покупку ")){
            switch (event.getCurrentItem().getType()){
                case RED_STAINED_GLASS_PANE:
                    player.closeInventory();
                    player.openInventory(StatisticInventory.getInv(player));
                    ShoppingUtil.deleteCurrentTag(player);
                    break;
                case GREEN_STAINED_GLASS_PANE:
                    player.closeInventory();
                    player.openInventory(StatisticInventory.getInv(player));
                    EconomyManager.takeMoney(player,700.0);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,3,0);
                    PlayerTags.setBoughtTag(player);
                    break;
            }
            event.setCancelled(true);
        }

    }

}
