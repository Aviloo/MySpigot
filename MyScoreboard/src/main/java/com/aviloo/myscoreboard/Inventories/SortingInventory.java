package com.aviloo.myscoreboard.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SortingInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,36, ChatColor.WHITE+"Сортировка Тэгов");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(31,back);

        ItemStack pvp = new ItemStack(Material.TOTEM_OF_UNDYING,1);
        ItemMeta pMeta = pvp.getItemMeta();
        pMeta.setDisplayName(ChatColor.BLUE+"Тэги для пвп");
        pvp.setItemMeta(pMeta);
        inv.setItem(11,pvp);

        ItemStack stats = new ItemStack(Material.BOOK,1);
        ItemMeta sMeta = stats.getItemMeta();
        sMeta.setDisplayName(ChatColor.BLUE+"Статистические тэги");
        stats.setItemMeta(sMeta);
        inv.setItem(13,stats);

        ItemStack other = new ItemStack(Material.GUNPOWDER,1);
        ItemMeta oMeta = other.getItemMeta();
        oMeta.setDisplayName(ChatColor.BLUE+"Прочие тэги");
        other.setItemMeta(oMeta);
        inv.setItem(15,other);

        return inv;
    }

}
