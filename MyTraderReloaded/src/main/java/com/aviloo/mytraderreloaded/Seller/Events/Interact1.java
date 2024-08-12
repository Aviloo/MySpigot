package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.ReputationProductInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Interact1 implements Listener {
    private JavaPlugin plugin;

    public Interact1(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(!Objects.equals(MyTraderReloaded.getTraderType(), "Screen1")){return;}
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Скупщик")){
            try {
                switch (event.getCurrentItem().getType()) {
                    case CHEST_MINECART:
                        if(!MySQLManager.isConnected()){
                            LoadScreen.openLoadInventory(player);
                            break;
                        }
                        player.openInventory(ReputationProductInventory.getInv(player));
                        break;
                    case PLAYER_HEAD:
                        break;
                    case SPECTRAL_ARROW:
                        player.closeInventory();
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,5,1);
                        break;
                    case BARRIER:
                        player.sendMessage(ChatColor.GRAY+"[Скупщик] "+ChatColor.RED+"Извините. Мы больше не" +
                                " нуждаемся в данном товаре.");
                        player.closeInventory();
                        break;
                    case REDSTONE:
                        if (PriceManager.isQuantityBlocked("REDSTONE")){
                            player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Торговец больше не" +
                                    " принимает данный товар. Приходите завтра.");
                            break;
                        }
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 1)) {
                                    PriceManager.priceChecker("REDSTONE");
                                    PriceManager.addSoldQuantity("REDSTONE",1);
                                    player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 1));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPrice("REDSTONE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " "+
                                            //PriceManager.getCurrentPrice("REDSTONE"));
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. красной пыли.");
                                    PlayersStats.addSoldCount(player,1);
                                    PlayersStats.addEarned(player, PriceManager.getCurrentPrice("REDSTONE"));
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 64)) {
                                    PriceManager.priceChecker("REDSTONE");
                                    PriceManager.addSoldQuantity("REDSTONE",64);
                                    player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 64));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64("REDSTONE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " "
                                            //+PriceManager.getCurrentPriceFor64("REDSTONE"));
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. красной пыли.");
                                    PlayersStats.addSoldCount(player,64);
                                    PlayersStats.addEarned(player, PriceManager.getCurrentPriceFor64("REDSTONE"));
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case GUNPOWDER:
                        if (PriceManager.isQuantityBlocked("GUNPOWDER")){
                            player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Торговец больше не" +
                                    " принимает данный товар. Приходите завтра.");
                            break;
                        }
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.GUNPOWDER), 1)) {
                                    PriceManager.priceChecker("GUNPOWDER");
                                    PriceManager.addSoldQuantity("GUNPOWDER",1);
                                    player.getInventory().removeItem(new ItemStack(Material.GUNPOWDER, 1));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPrice("GUNPOWDER"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 5");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. пороха.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.GUNPOWDER), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.GUNPOWDER), 64)) {
                                    PriceManager.priceChecker("GUNPOWDER");
                                    PriceManager.addSoldQuantity("GUNPOWDER",64);
                                    player.getInventory().removeItem(new ItemStack(Material.GUNPOWDER, 64));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64("GUNPOWDER"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 320");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. пороха.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.GUNPOWDER), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case ROSE_BUSH:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.ROSE_BUSH), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.ROSE_BUSH, 1));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPrice("ROSE_BUSH"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 3.5");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. розы.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.ROSE_BUSH), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.ROSE_BUSH), 64)) {
                                    player.getInventory().removeItem(new ItemStack(Material.ROSE_BUSH, 64));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64("ROSE_BUSH"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 224");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. розы.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.ROSE_BUSH), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case CLAY_BALL:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.CLAY_BALL), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.CLAY_BALL, 1));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPrice("CLAY_BALL"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 2.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. глины.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.CLAY_BALL), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.CLAY_BALL), 64)) {
                                    player.getInventory().removeItem(new ItemStack(Material.CLAY_BALL, 64));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64("CLAY_BALL"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 153.6");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. глины.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.CLAY_BALL), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case QUARTZ:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.QUARTZ), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.QUARTZ, 1));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPrice("QUARTZ"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 1.5");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. квартца.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.QUARTZ), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.QUARTZ), 64)) {
                                    player.getInventory().removeItem(new ItemStack(Material.QUARTZ, 64));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64("QUARTZ"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 96");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. квартца.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.QUARTZ), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case SUGAR_CANE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SUGAR_CANE, 1));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPrice("SUGAR_CANE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 2.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. тростника.");
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "secretCaneCommandssss " + player.getName() + " 1");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 64)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SUGAR_CANE, 64));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64("SUGAR_CANE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 134.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. тростника.");
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "secretCaneCommandssss " + player.getName() + " 64");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case DEAD_BUSH:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.DEAD_BUSH), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.DEAD_BUSH, 1));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPrice("DEAD_BUSH"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 5.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. мёртвого куста.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.DEAD_BUSH), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.DEAD_BUSH), 64)) {
                                    player.getInventory().removeItem(new ItemStack(Material.DEAD_BUSH, 64));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64("DEAD_BUSH"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 326.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. мёртвых кустов.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.DEAD_BUSH), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case WHEAT:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.WHEAT, 1));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPrice("WHEAT"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 2.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. пшеницы.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 64)) {
                                    player.getInventory().removeItem(new ItemStack(Material.WHEAT, 64));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64("WHEAT"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 134.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. пшеницы.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case BLAZE_POWDER:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_POWDER), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.BLAZE_POWDER, 1));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPrice("BLAZE_POWDER"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 7.3");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. порошка блейза.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_POWDER), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_POWDER), 64)) {
                                    player.getInventory().removeItem(new ItemStack(Material.BLAZE_POWDER, 64));
                                    EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64("BLAZE_POWDER"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 467.2");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. порошка блейза.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_POWDER), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case RED_STAINED_GLASS_PANE:
                        player.closeInventory();
                        break;
                }
            }catch (NullPointerException npe){return;}
            event.setCancelled(true);
        }
    }
}
