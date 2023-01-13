package com.aviloo.mytraderreloaded.DonateShop.Inventories.Events;

import com.aviloo.mytraderreloaded.DonateShop.Inventories.MainInventory;
import com.aviloo.mytraderreloaded.DonateShop.Inventories.ShieldInventory;
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

public class ShieldInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Особые щиты")){
            switch (event.getCurrentItem().getType()){
                case RED_STAINED_GLASS_PANE:
                    player.closeInventory();
                    break;
                case SPECTRAL_ARROW:
                    player.openInventory(MainInventory.getInv(player));
                    break;
                case SHIELD:
                    switch (event.getCurrentItem().getAmount()){
                        case 1:
                            if(event.isLeftClick()){
                                if(!EnchantedInteract.hasEnoughPlayerPoints(player,15)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(EnchantedInteract.hasEnoughPlayerPoints(player,15)) {
                                    EnchantedInteract.takePlayerPoints(player,15);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"ei give "+player.getName()+" shield_tire_1");
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!EnchantedInteract.hasEnoughVault(player,30000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(EnchantedInteract.hasEnoughVault(player,30000)) {
                                    EnchantedInteract.takeVault(player,30000);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"ei give "+player.getName()+" shield_tire_1");
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                        case 2:
                            if(event.isLeftClick()){
                                if(!EnchantedInteract.hasEnoughPlayerPoints(player,30)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(EnchantedInteract.hasEnoughPlayerPoints(player,30)) {
                                    EnchantedInteract.takePlayerPoints(player,30);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"ei give "+player.getName()+" shield_tire_2");
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!EnchantedInteract.hasEnoughVault(player,65000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(EnchantedInteract.hasEnoughVault(player,65000)) {
                                    EnchantedInteract.takeVault(player,65000);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"ei give "+player.getName()+" shield_tire_2");
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                        case 3:
                            if(event.isLeftClick()){
                                if(!EnchantedInteract.hasEnoughPlayerPoints(player,40)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(EnchantedInteract.hasEnoughPlayerPoints(player,40)) {
                                    EnchantedInteract.takePlayerPoints(player,40);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"ei give "+player.getName()+" shield_tire_3");
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!EnchantedInteract.hasEnoughVault(player,85000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(EnchantedInteract.hasEnoughVault(player,85000)) {
                                    EnchantedInteract.takeVault(player,85000);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"ei give "+player.getName()+" shield_tire_3");
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                        case 4:
                            if(event.isLeftClick()){
                                if(!EnchantedInteract.hasEnoughPlayerPoints(player,15)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(EnchantedInteract.hasEnoughPlayerPoints(player,15)) {
                                    EnchantedInteract.takePlayerPoints(player,15);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"ei give "+player.getName()+" shield_tire_speed");
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!EnchantedInteract.hasEnoughVault(player,30000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(EnchantedInteract.hasEnoughVault(player,30000)) {
                                    EnchantedInteract.takeVault(player,30000);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"ei give "+player.getName()+" shield_tire_speed");
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                        case 7:
                            ShieldInventory.setSpeedStatus(player,false);
                            ShieldInventory.setAbsorptionStatus(player,true);
                            player.closeInventory();
                            player.openInventory(ShieldInventory.getInv(player));
                            break;
                        case 8:
                            ShieldInventory.setSpeedStatus(player,true);
                            ShieldInventory.setAbsorptionStatus(player,false);
                            player.closeInventory();
                            player.openInventory(ShieldInventory.getInv(player));
                            break;
                    }
                    break;
            }
            event.setCancelled(true);
        }
    }
}
