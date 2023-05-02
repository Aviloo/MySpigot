package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.Screen1;
import com.aviloo.mytraderreloaded.Seller.Utils.EconomyManager;
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

public class ReputationInteract implements Listener {

    private void screenBack(Player player){
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen1")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen2")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen3")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen4")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen5")){
            player.openInventory(Screen1.sellInventory(player));
        }
        if(Objects.equals(MyTraderReloaded.getTraderType(), "ScreenE")){
            player.openInventory(Screen1.sellInventory(player));
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Товары за репутацию")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    screenBack(player);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,5,1);
                    break;
                case BARRIER:
                    player.sendMessage(ChatColor.GRAY+"[Скупщик] "+ChatColor.RED+"Вы еще не разблокировали этот" +
                            "товар.");
                    player.closeInventory();
                    break;
                case RED_DYE:
                    player.closeInventory();
                    break;
                case GOLD_NUGGET:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Золотой самородок.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("GOLD_NUGGET"));
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Золотой самородок.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("GOLD_NUGGET"));
                    }
                    break;
                case WHEAT:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Пшеница.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("WHEAT"));
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Пшеница.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("WHEAT"));
                    }
                    break;
                case LAPIS_LAZULI:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.LAPIS_LAZULI), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Лазурит.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("LAPIS_LAZULI"));
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.LAPIS_LAZULI), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Лазурит.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("LAPIS_LAZULI"));
                    }
                    break;
                case TOTEM_OF_UNDYING:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.TOTEM_OF_UNDYING), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Тотем.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("TOTEM_OF_UNDYING"));
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.TOTEM_OF_UNDYING), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Тотем.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("TOTEM_OF_UNDYING"));
                    }
                    break;
                case CAKE:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.CAKE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Торт.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("CAKE"));
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.CAKE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Торт.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("CAKE"));
                    }
                    break;
                case DIAMOND_ORE:
                    if(event.isRightClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND_ORE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. Алм. руды.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPrice("DIAMOND_ORE"));
                    }
                    if(event.isLeftClick()){
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND_ORE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            break;
                        }
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. Алм. руды.");
                        EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64("DIAMOND_ORE"));
                    }
                    break;
            }
            event.setCancelled(true);
        }
    }
}
