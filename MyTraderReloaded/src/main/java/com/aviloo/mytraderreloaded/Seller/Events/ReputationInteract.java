package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.Screen1;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class ReputationInteract implements Listener {

    private void screenBack(Player player){
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen1")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen2")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen3")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen4")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen5")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "ScreenE")){
            player.openInventory(Screen1.sellInventory(player));
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals("Товары за репутацию")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    screenBack(player);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,5,1);
                    break;
                case BARRIER:
                    player.sendMessage(ChatColor.GRAY+"[Скупщик] "+ChatColor.RED+"Вы еще не разблокировали этот" +
                            "товар.");
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
    }
}
