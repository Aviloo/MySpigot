package com.aviloo.myscoreboard.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CustomInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,36, ChatColor.WHITE+"Кастомизация");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(31,back);

        ItemStack style = new ItemStack(Material.RED_DYE,1);
        ItemMeta styleMeta = style.getItemMeta();
        styleMeta.setDisplayName(ChatColor.YELLOW+"Стиль скорборда");
        ArrayList<String> styleLore = new ArrayList<>();
        styleLore.add(" ");
        styleLore.add(ChatColor.GRAY+"Выбери цвет скорборда!");
        styleLore.add(" ");
        styleMeta.setLore(styleLore);
        style.setItemMeta(styleMeta);
        inv.setItem(11,style);

        ItemStack stats = new ItemStack(Material.MAP,1);
        ItemMeta statsMeta = stats.getItemMeta();
        statsMeta.setDisplayName(ChatColor.YELLOW+"Настройки тэгов");
        ArrayList<String> statsLore = new ArrayList<>();
        statsLore.add(" ");
        statsLore.add(ChatColor.GRAY+"Выбери отображаемую статистику");
        statsLore.add(" ");
        statsMeta.setLore(statsLore);
        stats.setItemMeta(statsMeta);
        inv.setItem(15,stats);

        return inv;
    }

}
