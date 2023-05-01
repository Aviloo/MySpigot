package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.ReputationProductInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.EconomyManager;
import com.aviloo.mytraderreloaded.Seller.Utils.MySQLManager;
import com.aviloo.mytraderreloaded.Seller.Utils.PriceManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class InteractE implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        if(!Objects.equals(MyTraderReloaded.getTraderType(), "ScreenE")){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.DARK_PURPLE+"Эпический скупщик")){
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
                        player.sendMessage(ChatColor.GRAY+"[Скупщик] "+ChatColor.RED+"Извините. Мы больше не" +
                                " нуждаемся в данном товаре.");
                        player.closeInventory();
                        break;
                    case DIAMOND:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("DIAMOND"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 10");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Алмаз.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("DIAMOND"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 640");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Алмаз.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case BLAZE_ROD:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_ROD), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("BLAZE_ROD"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 6.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Стержень блейза.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_ROD), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_ROD), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("BLAZE_ROD"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 390.4");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Стержень блейза.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_ROD), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case TNT:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.TNT), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.TNT, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("TNT"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 5.8");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Динамит.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.TNT), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.TNT), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.TNT, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("TNT"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 371.3");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Динамит.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.TNT), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case DRAGON_BREATH:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.DRAGON_BREATH), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.DRAGON_BREATH, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("DRAGON_BREATH"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 40");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Дыхание дракона.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.DRAGON_BREATH), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.DRAGON_BREATH), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.DRAGON_BREATH, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("DRAGON_BREATH"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2560");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Дыхание дракона.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.DRAGON_BREATH), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case BRICK:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.BRICK), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.BRICK, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("BRICK"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Кирпич.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.BRICK), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.BRICK), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.BRICK, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("BRICK"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 256");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Кирпич.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.BRICK), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case GOLD_NUGGET:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.GOLD_NUGGET, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("GOLD_NUGGET"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 4.5");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Кусочек золота.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 64)) {
                                    player.getInventory().removeItem(new ItemStack(Material.GOLD_NUGGET, 64));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("GOLD_NUGGET"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 288");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Кусочек золота.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 64)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        break;
                    case ZOMBIE_HEAD:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.ZOMBIE_HEAD), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.ZOMBIE_HEAD, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("ZOMBIE_HEAD"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 51.5");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Голова зомби.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.ZOMBIE_HEAD), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.ZOMBIE_HEAD), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.ZOMBIE_HEAD, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("ZOMBIE_HEAD"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3300");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Голова зомби.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.ZOMBIE_HEAD), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case SHULKER_SHELL:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SHULKER_SHELL, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("SHULKER_SHELL"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 30.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Панцирь шалкера.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.SHULKER_SHELL, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("SHULKER_SHELL"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1930");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Панцирь шалкера.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case HEART_OF_THE_SEA:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.HEART_OF_THE_SEA), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.HEART_OF_THE_SEA, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("HEART_OF_THE_SEA"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 70");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Сердце моря.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.HEART_OF_THE_SEA), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.HEART_OF_THE_SEA), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.HEART_OF_THE_SEA, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("HEART_OF_THE_SEA"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 4480");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Сердце моря.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.HEART_OF_THE_SEA), 64)) {
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
