package com.aviloo.mytraderreloaded.DonateShop.Inventories.Events;

import com.aviloo.mytraderreloaded.DonateShop.Inventories.MainInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MushroomInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}

        if(event.getView().getTitle().equals(ChatColor.WHITE+"Особые приваты")){
            Player player =(Player) event.getWhoClicked();
            switch (event.getCurrentItem().getType()){
                case RED_STAINED_GLASS_PANE:
                    player.closeInventory();
                    break;
                case SPECTRAL_ARROW:
                    player.openInventory(MainInventory.getInv(player));
                    break;
                case RED_MUSHROOM_BLOCK:
                    if(event.isRightClick()){
                        if(!EnchantedInteract.hasEnoughPlayerPoints(player,40)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            break;}
                        if(EnchantedInteract.hasEnoughPlayerPoints(player,40)){
                            EnchantedInteract.takePlayerPoints(player,40);
                            ItemStack item = new ItemStack(Material.RED_MUSHROOM_BLOCK,1);
                            ItemMeta meta = item.getItemMeta();
                            meta.setDisplayName(ChatColor.YELLOW+"Приват 30x30");
                            item.setItemMeta(meta);
                            player.getInventory().addItem(item);
                            player.closeInventory();
                            break;
                        }
                    }
                    if(event.isLeftClick()){
                        player.closeInventory();
                        Bukkit.dispatchCommand(player,"auc");
                        break;
                    }
                    break;
            }
            event.setCancelled(true);
        }
    }
}
