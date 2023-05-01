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

public class Interact4 implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        if(!Objects.equals(MyTraderReloaded.getTraderType(), "Screen4")){return;}
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
                    case ROTTEN_FLESH:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.ROTTEN_FLESH, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("ROTTEN_FLESH"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. ROTTEN_FLESH.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.ROTTEN_FLESH, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("ROTTEN_FLESH"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 217.6");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. ROTTEN_FLESH.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case DRIED_KELP:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.DRIED_KELP), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.DRIED_KELP, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("DRIED_KELP"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.5");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. DRIED_KELP.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.DRIED_KELP), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.DRIED_KELP), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.DRIED_KELP, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("DRIED_KELP"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 160");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. DRIED_KELP.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.DRIED_KELP), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case WARPED_PLANKS:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.WARPED_PLANKS), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.WARPED_PLANKS, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("WARPED_PLANKS"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1.9");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. WARPED_PLANKS.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.WARPED_PLANKS), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.WARPED_PLANKS), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.WARPED_PLANKS, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("WARPED_PLANKS"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 121.6");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. WARPED_PLANKS.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.WARPED_PLANKS), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case HONEY_BOTTLE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.HONEY_BOTTLE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.HONEY_BOTTLE, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("HONEY_BOTTLE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 7");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. HONEY_BOTTLE.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.HONEY_BOTTLE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.HONEY_BOTTLE), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.HONEY_BOTTLE, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("HONEY_BOTTLE"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 448");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. HONEY_BOTTLE.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.HONEY_BOTTLE), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case RAIL:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.RAIL), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.RAIL, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("RAIL"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.7");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. RAIL.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.RAIL), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.RAIL), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.RAIL, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("RAIL"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 236.8");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. RAIL.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.RAIL), 64)) {
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
                    case SHULKER_SHELL:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SHULKER_SHELL, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("SHULKER_SHELL"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 8");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. SHULKER_SHELL.");
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
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 512");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. SHULKER_SHELL.");
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
                    case BONE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.BONE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.BONE, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("BONE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. BONE.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.BONE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.BONE), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.BONE, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("BONE"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 198.4");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. BONE.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.BONE), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case COPPER_BLOCK:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.COPPER_BLOCK), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.COPPER_BLOCK, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("COPPER_BLOCK"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.3");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. COPPER_BLOCK.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.COPPER_BLOCK), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.COPPER_BLOCK), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.COPPER_BLOCK, 64));
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("COPPER_BLOCK"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 147.2");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. COPPER_BLOCK.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.COPPER_BLOCK), 64)) {
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
