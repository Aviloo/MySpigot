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

public class ScreenFourthInteract implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equals("Боевой пропуск (У вас 3 уровень)")){
            try {
                switch (event.getCurrentItem().getType()) {
                    case EMERALD_BLOCK:
                        ItemStack item_first = new ItemStack(Material.DIAMOND, 7);
                        ItemStack item_second = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
                        ItemStack item_third = new ItemStack(Material.OAK_WOOD, 40);
                        rewards.getRewardItem(item_first, player);
                        rewards.getRewardItem(item_second, player);
                        rewards.getRewardItem(item_third, player);
                        player.sendMessage(ChatColor.WHITE + "[Система] " + ChatColor.GRAY + "Вы получили четвертый уровень боевого пропуска.");
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
