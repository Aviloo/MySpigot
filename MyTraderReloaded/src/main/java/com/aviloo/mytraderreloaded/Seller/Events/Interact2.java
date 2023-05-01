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

public class Interact2 implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        if(!Objects.equals(MyTraderReloaded.getTraderType(), "Screen2")){return;}
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
                    case APPLE:
                        if (event.getClick().isRightClick()) {
                            try {
                                if (player.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 1)) {
                                    player.getInventory().removeItem(new ItemStack(Material.APPLE, 1));
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("APPLE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 4.3");
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
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("APPLE"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 275.2");
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
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("SUGAR"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 5.1");
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
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("SUGAR"));
                                       // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 326.4");
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
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("DRAGON_BREATH"));
                                   // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 24");
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
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("DRAGON_BREATH"));
                                       // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1536");
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
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("PHANTOM_MEMBRANE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 16");
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
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("PHANTOM_MEMBRANE"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 1024");
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
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("MELON_SLICE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 3.3");
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
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("MELON_SLICE"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 211.2");
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
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("GLASS_BOTTLE"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.5");
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
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("GLASS_BOTTLE"));
                                       // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 160");
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
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("INK_SAC"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.7");
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
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("INK_SAC"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 172.8");
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
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("SWEET_BERRIES"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.4");
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
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("SWEET_BERRIES"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 153.6");
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
                                    EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("WHEAT_SEEDS"));
                                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 2.4");
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
                                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("WHEAT_SEEDS"));
                                        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getDisplayName() + " 153.6");
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
                    case RED_STAINED_GLASS_PANE:
                        player.closeInventory();
                        break;
                }
            }catch (NullPointerException npe){return;}
            event.setCancelled(true);
        }
    }
}
