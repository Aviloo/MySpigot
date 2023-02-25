package com.aviloo.mytraderreloaded.DonateShop.Inventories.Events;

import com.aviloo.mytraderreloaded.DonateShop.Inventories.MainInventory;
import me.clip.placeholderapi.PlaceholderAPI;
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
import org.jetbrains.annotations.NotNull;

public class EnchantedInteract implements Listener {

    protected static @NotNull Boolean hasEnoughPlayerPoints(Player player, int count){
        Integer balance = Integer.valueOf(PlaceholderAPI.setPlaceholders(player,"%playerpoints_points%"));
        if(balance < count){
            return false;
        }
        return true;
    }

    protected static @NotNull Boolean hasEnoughVault(Player player, double count){
        Double balance = Double.valueOf(PlaceholderAPI.setPlaceholders(player,"%vault_eco_balance%"));
        if(balance < count){
            return false;
        }
        return true;
    }

    protected static void takePlayerPoints(Player player, int count){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "points take "
                + player.getName() + " " + count);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&7[Система] &aТранзакция прошла успешно."));
    }

    protected static void takeVault(Player player,double count){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco take "
                + player.getName() + " " + count);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&7[Система] &aТранзакция прошла успешно."));
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}

        if(event.getView().getTitle().equals(ChatColor.WHITE+"Улучшенные зачарования")){
            Player player = (Player) event.getWhoClicked();
            switch (event.getCurrentItem().getType()){
                case RED_STAINED_GLASS_PANE:
                    player.closeInventory();
                    break;
                case SPECTRAL_ARROW:
                    player.openInventory(MainInventory.getInv(player));
                    break;
                case ENCHANTED_BOOK:
                    switch (event.getCurrentItem().getAmount()){
                        case 1 : //todo дописать часть с api
                            if(AnotherInteract.isInventoryFull(player)){
                                player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                                break;
                            }
                            if(event.isLeftClick()){
                                if(!hasEnoughPlayerPoints(player,3)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughPlayerPoints(player,3)) {
                                    takePlayerPoints(player,3);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!hasEnoughVault(player,6000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughVault(player,6000)) {
                                    takeVault(player,6000);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                        case 2 :
                            if(AnotherInteract.isInventoryFull(player)){
                                player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                                break;
                            }
                            if(event.isLeftClick()){
                                if(!hasEnoughPlayerPoints(player,3)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughPlayerPoints(player,3)) {
                                    takePlayerPoints(player,3);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.DIG_SPEED, 6, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!hasEnoughVault(player,6000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughVault(player,6000)) {
                                    takeVault(player,6000);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.DIG_SPEED, 6, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                        case 3 :
                            if(AnotherInteract.isInventoryFull(player)){
                                player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                                break;
                            }
                            if(event.isLeftClick()){
                                if(!hasEnoughPlayerPoints(player,3)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughPlayerPoints(player,3)) {
                                    takePlayerPoints(player,3);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.LUCK, 4, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!hasEnoughVault(player,6000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughVault(player,6000)) {
                                    takeVault(player,6000);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.LUCK, 4, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                        case 4 :
                            if(AnotherInteract.isInventoryFull(player)){
                                player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                                break;
                            }
                            if(event.isLeftClick()){
                                if(!hasEnoughPlayerPoints(player,3)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughPlayerPoints(player,3)) {
                                    takePlayerPoints(player,3);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!hasEnoughVault(player,6000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughVault(player,6000)) {
                                    takeVault(player,6000);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                        case 5 :
                            if(AnotherInteract.isInventoryFull(player)){
                                player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                                break;
                            }
                            if(event.isLeftClick()){
                                if(!hasEnoughPlayerPoints(player,3)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughPlayerPoints(player,3)) {
                                    takePlayerPoints(player,3);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!hasEnoughVault(player,6000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughVault(player,6000)){
                                    takeVault(player,6000);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                        case 6 :
                            if(AnotherInteract.isInventoryFull(player)){
                                player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                                break;
                            }
                            if(event.isLeftClick()){
                                if(!hasEnoughPlayerPoints(player,3)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughPlayerPoints(player,3)) {
                                    takePlayerPoints(player,3);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            if(event.isRightClick()){
                                if(!hasEnoughVault(player,6000)){
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                            "&4У вас недостаточно средств."));
                                    player.closeInventory();
                                    break;}
                                if(hasEnoughVault(player,6000)) {
                                    takeVault(player,6000);
                                    ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
                                    ItemMeta meta = item.getItemMeta();
                                    meta.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
                                    item.setItemMeta(meta);
                                    player.getInventory().addItem(item);
                                    player.closeInventory();
                                    break;
                                }
                                break;
                            }
                            break;
                    }
            }
            event.setCancelled(true);
        }
    }
}
