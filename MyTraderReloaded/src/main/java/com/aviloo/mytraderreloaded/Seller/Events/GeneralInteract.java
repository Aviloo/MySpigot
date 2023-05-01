package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.Seller.Inventories.LeaderInventory;
import com.aviloo.mytraderreloaded.Seller.Inventories.ReputationProductInventory;
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
import org.bukkit.plugin.java.JavaPlugin;

public class GeneralInteract { //TODO Когда настрою все товары ,удалю другие классы Interact (кроме InteractE), чтобы всё регулировать через один класс

    private JavaPlugin plugin;

    public GeneralInteract(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Скупщик")){
            try {
                switch (event.getCurrentItem().getType()) {
                    case CHEST_MINECART:
                        player.openInventory(ReputationProductInventory.getInv(player));
                        break;
                    case PLAYER_HEAD:
                        player.openInventory(LeaderInventory.getInv(player));
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " "+
                                            PriceManager.getCurrentPrice("REDSTONE"));
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
                                    PriceManager.priceChecker("REDSTONE");
                                    PriceManager.addSoldQuantity("REDSTONE",64);
                                    player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 64));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " "
                                            +PriceManager.getCurrentPrice("REDSTONE") * 64);
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
                    case APPLE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.APPLE, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 4.3");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. яблок.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.APPLE, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 275.2");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. яблок.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case SUGAR:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SUGAR, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 5.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. сахара.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.SUGAR, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 326.4");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. сахара.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR), 64)) {
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 24");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. дыхания дракона.");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1536");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. дыхания дракона.");
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
                    case PHANTOM_MEMBRANE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.PHANTOM_MEMBRANE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.PHANTOM_MEMBRANE, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 16");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. мембраны фантома.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.PHANTOM_MEMBRANE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.PHANTOM_MEMBRANE), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.PHANTOM_MEMBRANE, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1024");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. мембраны фантома.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.PHANTOM_MEMBRANE), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case MELON_SLICE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.MELON_SLICE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.MELON_SLICE, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.3");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. арбуза.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.MELON_SLICE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.MELON_SLICE), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.MELON_SLICE, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 211.2");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. арбуза.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.MELON_SLICE), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case GLASS_BOTTLE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.GLASS_BOTTLE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.GLASS_BOTTLE, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.5");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. пустого пузырька.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.GLASS_BOTTLE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.GLASS_BOTTLE), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.GLASS_BOTTLE, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 160");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. пустого пузырька.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.GLASS_BOTTLE), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case INK_SAC:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.INK_SAC), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.INK_SAC, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.7");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. чернил.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.INK_SAC), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.INK_SAC), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.INK_SAC, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 172.8");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. чернил.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.INK_SAC), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case SWEET_BERRIES:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SWEET_BERRIES), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SWEET_BERRIES, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. ягод.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.SWEET_BERRIES), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SWEET_BERRIES), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.SWEET_BERRIES, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 153.6");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. ягод.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.SWEET_BERRIES), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case WHEAT_SEEDS:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT_SEEDS), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.WHEAT_SEEDS, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. семян пшеницы.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT_SEEDS), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT_SEEDS), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.WHEAT_SEEDS, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 153.6");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. семян пшеницы.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT_SEEDS), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case COOKED_COD:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.COOKED_COD), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.COOKED_COD, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.3");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. COOKED_COD.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.COOKED_COD), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.COOKED_COD), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.COOKED_COD, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 211.2");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. COOKED_COD.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.COOKED_COD), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case SPIDER_EYE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SPIDER_EYE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SPIDER_EYE, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 5.1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. SPIDER_EYE.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.SPIDER_EYE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SPIDER_EYE), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.SPIDER_EYE, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 326.4");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. SPIDER_EYE.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.SPIDER_EYE), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case COBBLESTONE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 0.5");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. булыжника.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 32");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. булыжника.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case MAGMA_BLOCK:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.MAGMA_BLOCK), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.MAGMA_BLOCK, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1.5");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. магмы.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.MAGMA_BLOCK), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.MAGMA_BLOCK), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.MAGMA_BLOCK, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 96");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. магмы.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.MAGMA_BLOCK), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case STRING:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.STRING), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.STRING, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1.9");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. нити.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.STRING), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.STRING), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.STRING, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 121.6");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. нити.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.STRING), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case SAND:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SAND), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SAND, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 0.4");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. песка.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.SAND), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SAND), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.SAND, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 25.6");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. песка.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.SAND), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case COAL:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.COAL), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.COAL, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. угля.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.COAL), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.COAL), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.COAL, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 64");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. угля.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.COAL), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case ARROW:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.ARROW, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 4.3");
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 стрелу.");
                                }
                                if (!player.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 1)) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            } catch (NullPointerException npe) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                        if (event.getClick().isLeftClick()) {
                            if (event.getClick().isLeftClick()) {
                                try {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 64)) {
                                        player.getInventory().removeItem(new ItemStack(Material.ARROW, 64));
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 275.2");
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 стрелы.");
                                    }
                                    if (!player.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 64)) {
                                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                    }
                                } catch (NullPointerException npe) {
                                    player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                                }
                            }
                        }
                        break;
                    case ROTTEN_FLESH:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.ROTTEN_FLESH, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.4");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 217.6");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.5");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 160");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1.9");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 121.6");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 7");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 448");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.7");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 236.8");
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
                    case SHULKER_SHELL:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.SHULKER_SHELL, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 8");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 512");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.1");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 198.4");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.3");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 147.2");
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
                    case DIORITE_STAIRS:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.DIORITE_STAIRS), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.DIORITE_STAIRS, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1.8");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 115.3");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.7");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 173.8");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.1");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 198.4");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.9");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 249.6");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 0.8");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 51.3");
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
                    case LEATHER:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.LEATHER), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.LEATHER, 1));
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.9");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 185.6");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.6");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 230.4");
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
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3");
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 193");
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
