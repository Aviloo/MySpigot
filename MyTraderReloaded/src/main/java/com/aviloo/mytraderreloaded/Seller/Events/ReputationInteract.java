package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.Seller.Inventories.InfoInventory;
import com.aviloo.mytraderreloaded.Seller.Inventories.SellerInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.EconomyManager;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerStats;
import com.aviloo.mytraderreloaded.Seller.Utils.PriceManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class ReputationInteract implements Listener {

    private void sellProduct(Player player,String ProductType,int amount){
        bonusByEffectHeroOfVillage(player,ProductType,amount);
        PlayerStats.addEarnedPlayerStats(player.getUniqueId(),ProductType,amount);
        player.getInventory().removeItem(new ItemStack(Material.valueOf(ProductType), amount));
        if(amount == 1){
            EconomyManager.giveMoney(player, PriceManager.getPriceReputation(ProductType));
        }
        if(amount == 64){
            EconomyManager.giveMoney(player, PriceManager.getPriceReputation64(ProductType));
        }
    }

    private static void bonusByEffectHeroOfVillage(Player player, String ClickedProductType,int amount){
        if(player.getActivePotionEffects().contains(PotionEffectType.HERO_OF_THE_VILLAGE)){
            if(amount == 64){
                EconomyManager.giveMoney(player,
                        PriceManager.getPriceReputation64(ClickedProductType) * 0.15); // 15% бонусов
            }
            if(amount == 1){
                EconomyManager.giveMoney(player,
                        PriceManager.getPriceReputation(ClickedProductType) * 0.15); // 15% бонусов
            }
        }else return;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.GRAY+"Товары за репутацию")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.openInventory(SellerInventory.inventory);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,5,1);
                    break;
                case BARRIER:
                    player.sendMessage(ChatColor.GRAY+"[Скупщик] "+ChatColor.RED+"Вы еще не разблокировали этот " +
                            "товар.");
                    player.closeInventory();
                    break;
                case PAPER:
                    player.openInventory(InfoInventory.inventory);
                    break;
                case GOLD_NUGGET:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Золотой самородок.");
                        sellProduct(player,"GOLD_NUGGET_R",1);
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Золотой самородок.");
                        sellProduct(player,"GOLD_NUGGET_R",64);
                    }
                    break;
                case WHEAT:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Пшеница.");
                        sellProduct(player,"WHEAT_R",1);
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Пшеница.");
                        sellProduct(player,"WHEAT_R",64);
                    }
                    break;
                case LAPIS_LAZULI:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.LAPIS_LAZULI), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Лазурит.");
                        sellProduct(player,"LAPIS_LAZULI_R",1);
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.LAPIS_LAZULI), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Лазурит.");
                        sellProduct(player,"LAPIS_LAZULI_R",64);
                    }
                    break;
                case TOTEM_OF_UNDYING:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.TOTEM_OF_UNDYING), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Тотем.");
                        sellProduct(player,"TOTEM_OF_UNDYING_R",1);
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.TOTEM_OF_UNDYING), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Тотем.");
                        sellProduct(player,"TOTEM_OF_UNDYING_R",64);
                    }
                    break;
                case CAKE:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.CAKE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Торт.");
                        sellProduct(player,"CAKE_R",1);
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.CAKE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Торт.");
                        sellProduct(player,"CAKE_R",64);
                    }
                    break;
                case DIAMOND_ORE:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND_ORE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Алм. руды.");
                        sellProduct(player,"DIAMOND_ORE_R",1);
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND_ORE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Алм. руды.");
                        sellProduct(player,"DIAMOND_ORE_R",64);
                    }
                    break;
            }
            event.setCancelled(true);
        }
    }
}
