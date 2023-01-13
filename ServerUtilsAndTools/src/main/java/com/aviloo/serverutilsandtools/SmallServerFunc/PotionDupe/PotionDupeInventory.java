package com.aviloo.serverutilsandtools.SmallServerFunc.PotionDupe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class PotionDupeInventory {

    public static Inventory getInventory(Player player){
        Inventory inventory = Bukkit.createInventory(player, InventoryType.DROPPER, ChatColor.WHITE+"Ультимативная зельеварка");
        return inventory;
    }
}
