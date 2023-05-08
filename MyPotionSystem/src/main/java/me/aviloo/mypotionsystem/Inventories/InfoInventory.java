package me.aviloo.mypotionsystem.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InfoInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Информация о зельях");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(49,back);

        ItemStack first = new ItemStack(Material.PAPER,1);
        inv.setItem(11,first);

        ItemStack second = new ItemStack(Material.PAPER,2);
        inv.setItem(12,second);

        ItemStack third = new ItemStack(Material.PAPER,3);
        inv.setItem(13,third);

        ItemStack fourth = new ItemStack(Material.PAPER,4);
        inv.setItem(14,fourth);

        ItemStack fifth = new ItemStack(Material.PAPER,5);
        inv.setItem(15,fifth);

        ItemStack sixth = new ItemStack(Material.PAPER,6);
        inv.setItem(21,sixth);

        ItemStack seventh = new ItemStack(Material.PAPER,7);
        inv.setItem(22,seventh);

        ItemStack eighth = new ItemStack(Material.PAPER,8);
        inv.setItem(23,eighth);

        ItemStack download = new ItemStack(Material.KNOWLEDGE_BOOK,1);
        inv.setItem(31,download);

        return inv;
    }
}
