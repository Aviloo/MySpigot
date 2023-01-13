package com.aviloo.mytraderreloaded.DonateShop.Inventories.Events;

import com.aviloo.mytraderreloaded.DonateShop.Inventories.MainInventory;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class VaultInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Донат валюта")){
            Player player = (Player) event.getWhoClicked();
            switch (event.getCurrentItem().getType()){
                case RED_STAINED_GLASS_PANE:
                    player.closeInventory();
                    break;
                case SPECTRAL_ARROW:
                    player.openInventory(MainInventory.getInv(player));
                    break;
                case REDSTONE_BLOCK:
                    player.closeInventory();
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&7[Система] &fВы можете приобрести донат-валюту на нашем сайте. " +
                                    "&7(P.S: www.Orumii.su )"));
                    break;
                case REDSTONE:
                    switch (event.getCurrentItem().getAmount()){
                        case 10:
                            player.closeInventory();
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                    "&7[Система] &fВы можете приобрести донат-валюту на нашем сайте. " +
                                            "&7(P.S: www.Orumii.su )"));
                            break;
                        case 50:
                            player.closeInventory();
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                    "&7[Система] &fВы можете приобрести донат-валюту на нашем сайте. " +
                                            "&7(P.S: www.Orumii.su ) "));
                            break;
                    }
            }
        }
    }
}
