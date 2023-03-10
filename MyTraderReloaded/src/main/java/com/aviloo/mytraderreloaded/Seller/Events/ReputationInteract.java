package com.aviloo.mytraderreloaded.Seller.Events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ReputationInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals("Товары за репутацию")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,5,1);
                    break;
                case BARRIER:
                    player.sendMessage(ChatColor.GRAY+"[Скупщик] "+ChatColor.RED+"Извините. Мы больше не" +
                            " нуждаемся в данном товаре.");
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
    }
}
