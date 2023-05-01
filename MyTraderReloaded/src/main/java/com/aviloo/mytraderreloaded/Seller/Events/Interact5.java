package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.LeaderInventory;
import com.aviloo.mytraderreloaded.Seller.Inventories.ReputationProductInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.EconomyManager;
import com.aviloo.mytraderreloaded.Seller.Utils.MySQLManager;
import com.aviloo.mytraderreloaded.Seller.Utils.PriceManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Interact5 implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        if(!Objects.equals(MyTraderReloaded.getTraderType(), "Screen5")){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Скупщик")){
            try {
                switch (event.getCurrentItem().getType()) {
                    case CHEST_MINECART:
                        if(!MySQLManager.isConnected()){
                            player.closeInventory();
                            player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,9,1);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',""+
                                    "&c[Ошибка] &fДанная функция не доступна. Пожалуйста, сообщите об этом администрации."));
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
                        player.sendMessage(ChatColor.GRAY+"[Скупщик] "+ChatColor.RED+"Извините. Но мы больше не" +
                                " нуждаемся в данном товаре.");
                        player.closeInventory();
                        break;
                    case DIORITE_STAIRS:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.DIORITE_STAIRS), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.DIORITE_STAIRS, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("DIORITE_STAIRS"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1.8");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. DIORITE_STAIRS.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIORITE_STAIRS), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.DIORITE_STAIRS), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.DIORITE_STAIRS, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("DIORITE_STAIRS"));
                                       // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 115.3");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. DIORITE_STAIRS.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIORITE_STAIRS), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case SALMON:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SALMON), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SALMON, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("SALMON"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.7");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. SALMON.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.SALMON), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SALMON), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.SALMON, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("SALMON"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 173.8");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. SALMON.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.SALMON), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case PUFFERFISH:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.PUFFERFISH), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.PUFFERFISH, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("PUFFERFISH"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. PUFFERFISH.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.PUFFERFISH), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.PUFFERFISH), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.PUFFERFISH, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("PUFFERFISH"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 198.4");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. PUFFERFISH.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.PUFFERFISH), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case TROPICAL_FISH:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.TROPICAL_FISH), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.TROPICAL_FISH, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("TROPICAL_FISH"));
                                   // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.9");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. TROPICAL_FISH.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.TROPICAL_FISH), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.TROPICAL_FISH), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.TROPICAL_FISH, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("TROPICAL_FISH"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 249.6");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. TROPICAL_FISH.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.TROPICAL_FISH), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case BOWL:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.BOWL), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.BOWL, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("BOWL"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 0.8");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. BOWL.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.BOWL), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.BOWL), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.BOWL, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("TROPICAL_FISH"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 51.3");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. BOWL.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.BOWL), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case SUGAR_CANE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SUGAR_CANE, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("SUGAR_CANE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 2.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. тростника.");
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
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("SUGAR_CANE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 134.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. тростника.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case LEATHER:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.LEATHER), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.LEATHER, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("LEATHER"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.9");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. LEATHER.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.LEATHER), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.LEATHER), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.LEATHER, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("LEATHER"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 185.6");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. LEATHER.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.LEATHER), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case MOSS_BLOCK:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.MOSS_BLOCK), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.MOSS_BLOCK, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("MOSS_BLOCK"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.6");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. MOSS_BLOCK.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.MOSS_BLOCK), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.MOSS_BLOCK), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.MOSS_BLOCK, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("MOSS_BLOCK"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 230.4");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. MOSS_BLOCK.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.MOSS_BLOCK), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case TUBE_CORAL:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.TUBE_CORAL), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.TUBE_CORAL, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("TUBE_CORAL"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. TUBE_CORAL.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.TUBE_CORAL), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.TUBE_CORAL), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.TUBE_CORAL, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("TUBE_CORAL"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 193");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. TUBE_CORAL.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.TUBE_CORAL), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
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
