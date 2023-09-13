package com.aviloo.myscoreboard.Inventories.SortingInventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SortingOtherInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Тэги типа: «Другое»");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(47,back);

        return inv;
    }

}
