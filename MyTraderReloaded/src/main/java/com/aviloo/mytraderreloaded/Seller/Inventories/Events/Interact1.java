package com.aviloo.mytraderreloaded.Seller.Inventories.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Interact1 implements Listener {
    private JavaPlugin plugin;

    public Interact1(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Скупщик ")){
            try {
                switch (event.getCurrentItem().getType()) {
                    case REDSTONE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 3");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. красной пыли.");
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
                                    player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 64));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 192");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. красной пыли.");
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
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.GUNPOWDER), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.GUNPOWDER, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 5");
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
                                    player.getInventory().removeItem(new ItemStack(Material.GUNPOWDER, 64));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 320");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 3.5");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 224");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 2.4");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 153.6");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 1.5");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 96");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 2.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. тростника.");
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "secretCaneCommandssss " + player.getName() + " 1");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 134.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. тростника.");
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "secretCaneCommandssss " + player.getName() + " 64");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 5.1");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 326.4");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 2.1");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 134.4");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 7.3");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 467.2");
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
