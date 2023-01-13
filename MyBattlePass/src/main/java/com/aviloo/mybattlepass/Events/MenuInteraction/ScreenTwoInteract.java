package com.aviloo.mybattlepass.Events.MenuInteraction;

import com.aviloo.mybattlepass.Rewards.rewards;
import com.aviloo.mybattlepass.Utils.BPLevel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ScreenTwoInteract implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equals("Боевой пропуск (У вас 1 уровень)")){
            try {
                switch (event.getCurrentItem().getType()) {
                    case EMERALD_BLOCK:
                        ItemStack iron = new ItemStack(Material.IRON_INGOT, 32);
                        ItemStack foot = new ItemStack(Material.RABBIT_FOOT, 10);
                        ItemStack redstone = new ItemStack(Material.REDSTONE, 16);
                        rewards.getRewardItem(iron, player);
                        rewards.getRewardItem(foot, player);
                        rewards.getRewardItem(redstone, player);
                        player.sendMessage(ChatColor.WHITE + "[Система] " + ChatColor.GRAY + "Вы получили второй уровень боевого пропуска.");
                        player.closeInventory();
                        BPLevel.addLevel(player);
                        break;
                    case GOLD_BLOCK:
                        player.sendMessage(ChatColor.WHITE + "[Система] " + ChatColor.GRAY + "Вы не выполнили условия для получения награды.");
                        player.closeInventory();
                        break;
                    case COAL_BLOCK:
                        player.sendMessage(ChatColor.WHITE + "[Система] " + ChatColor.GRAY + "Чтобы получить награду,выполните предыдущее задание.");
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
