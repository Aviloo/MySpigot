package com.aviloo.mybattlepass.Events.MenuInteraction;

import com.aviloo.mybattlepass.Rewards.rewards;
import com.aviloo.mybattlepass.Utils.BPLevel;
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

public class ScreenSeventhInteract implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equals("Боевой пропуск (У вас 6 уровень)")){
            try {
                switch (event.getCurrentItem().getType()) {
                    case EMERALD_BLOCK:
                        if (Math.random() < 0.3) {
                            ItemStack item_first = new ItemStack(Material.SHULKER_SHELL, 10);
                            ItemStack item_second = new ItemStack(Material.ELYTRA, 1);
                            ItemMeta second_meta = item_second.getItemMeta();
                            second_meta.setDisplayName(ChatColor.GOLD + "Мальчик-Дракон");
                            second_meta.addEnchant(Enchantment.SWIFT_SNEAK, 5, true);
                            item_second.setItemMeta(second_meta);
                            rewards.getRewardItem(item_first, player);
                            rewards.getRewardItem(item_second, player);
                            rewards.getRewardCoin(700.0, player);
                            player.sendMessage(ChatColor.GRAY + "[Банк] " + ChatColor.GRAY + "Вам было зачисленно 700.0 коинов на счёт.");
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы получили седьмой уровень боевого пропуска.");
                            player.closeInventory();
                            BPLevel.addLevel(player);
                            break;
                        }
                        if (Math.random() >= 0.3 && Math.random() < 0.6) {
                            ItemStack item_first = new ItemStack(Material.SHULKER_SHELL, 10);
                            ItemStack item_second = new ItemStack(Material.NETHERITE_PICKAXE, 1);
                            ItemMeta second_meta = item_second.getItemMeta();
                            second_meta.setDisplayName(ChatColor.GOLD + "...,и я - геомант!");
                            second_meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
                            second_meta.addEnchant(Enchantment.LUCK, 1, true);
                            second_meta.addEnchant(Enchantment.KNOCKBACK, 3, true);
                            item_second.setItemMeta(second_meta);
                            rewards.getRewardItem(item_first, player);
                            rewards.getRewardItem(item_second, player);
                            rewards.getRewardCoin(700.0, player);
                            player.sendMessage(ChatColor.GRAY + "[Банк] " + ChatColor.GRAY + "Вам было зачисленно 700.0 коинов на счёт.");
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы получили седьмой уровень боевого пропуска.");
                            player.closeInventory();
                            BPLevel.addLevel(player);
                            break;
                        }
                        if (Math.random() >= 0.6 && Math.random() < 0.9) {
                            ItemStack item_first = new ItemStack(Material.SHULKER_SHELL, 10);
                            ItemStack item_second = new ItemStack(Material.NETHERITE_AXE, 1);
                            ItemMeta second_meta = item_second.getItemMeta();
                            second_meta.setDisplayName(ChatColor.GOLD + "Акс здесь!");
                            second_meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
                            second_meta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                            second_meta.addEnchant(Enchantment.FIRE_ASPECT, 4, true);
                            item_second.setItemMeta(second_meta);
                            rewards.getRewardItem(item_first, player);
                            rewards.getRewardItem(item_second, player);
                            rewards.getRewardCoin(700.0, player);
                            player.sendMessage(ChatColor.GRAY + "[Банк] " + ChatColor.GRAY + "Вам было зачисленно 700.0 коинов на счёт.");
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы получили седьмой уровень боевого пропуска.");
                            player.closeInventory();
                            BPLevel.addLevel(player);
                            break;
                        }
                        if (Math.random() >= 0.9) {
                            ItemStack item_first = new ItemStack(Material.SHULKER_SHELL, 10);
                            ItemStack item_second = new ItemStack(Material.NETHERITE_HOE, 1);
                            ItemMeta second_meta = item_second.getItemMeta();
                            second_meta.setDisplayName(ChatColor.GOLD + "Миру не нужны космонавты. Миру нужны фермеры.");
                            second_meta.addEnchant(Enchantment.KNOCKBACK, 10, true);
                            second_meta.addEnchant(Enchantment.LUCK, 999, true);
                            second_meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 999, true);
                            item_second.setItemMeta(second_meta);
                            rewards.getRewardItem(item_first, player);
                            rewards.getRewardItem(item_second, player);
                            rewards.getRewardCoin(700.0, player);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы получили седьмой уровень боевого пропуска.");
                            player.closeInventory();
                            BPLevel.addLevel(player);
                            break;
                        }
                    case GOLD_BLOCK:
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы не выполнили условия для получения награды.");
                        player.closeInventory();
                        break;
                    case COAL_BLOCK:
                        player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Чтобы получить награду,выполните предыдущее задание.");
                        player.closeInventory();
                        break;
                    case BARRIER:
                        if(event.isLeftClick()) {
                            player.closeInventory();
                        }
                        if(event.isRightClick()) {
                            player.closeInventory();
                            Bukkit.dispatchCommand(player,"menu");
                        }
                        break;
                }
            }catch (NullPointerException e){}
            event.setCancelled(true);
        }
    }
}
