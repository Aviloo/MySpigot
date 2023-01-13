package com.aviloo.rewardchests.Commands.Inventory;

import com.aviloo.rewardchests.ItemStack.Rewards.Special.fishingRod;
import com.aviloo.rewardchests.ItemStack.Rewards.Special.woodPickaxeUltimate;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class getItemStackInteract implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.GRAY + "Адм.Панель : Предметы из ларцов")) {
            switch (event.getCurrentItem().getType()) {
                case STONE_PICKAXE:
                    player.closeInventory();
                    player.getInventory().addItem(woodPickaxeUltimate.ultimateWoodPickAxeStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] "+ChatColor.WHITE+"Вам был добавлен предмет.");
                    break;
                case TROPICAL_FISH:
                    player.closeInventory();
                    player.getInventory().addItem(fishingRod.fishingRodStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] "+ChatColor.WHITE+"Вам был добавлен предмет.");
                    break;
            }
            event.setCancelled(true);
        }

            }
    }


