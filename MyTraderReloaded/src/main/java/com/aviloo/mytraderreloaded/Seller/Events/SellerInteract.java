package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.Seller.Inventories.InfoInventory;
import com.aviloo.mytraderreloaded.Seller.Inventories.ReputationProductInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.LoadScreen;
import com.aviloo.mytraderreloaded.Seller.Utils.MySQLManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SellerInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        if(event.getView().getTitle().equals(ChatColor.DARK_GRAY+"Скупщик")){
            Player player = (Player) event.getWhoClicked();
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                    break;
                case PAPER:
                    player.openInventory(InfoInventory.inventory);
                    player.playSound(player.getLocation(),Sound.BLOCK_ENCHANTMENT_TABLE_USE,3,0);
                    break;
                case CHEST_MINECART:
                    if(!MySQLManager.isConnected()){
                        player.closeInventory();
                        LoadScreen.openLoadInventory(player);
                        player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,9,1);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',""+
                                "&c[Ошибка] &fДанная функция не доступна. Пожалуйста, сообщите об этом администрации."));
                        break;
                    }
                    player.openInventory(ReputationProductInventory.getInv(player));
                    break;
            }
            event.setCancelled(true);
        }

    }

}
