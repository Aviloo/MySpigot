package com.aviloo.mytraderreloaded.DonateShop.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EggsInventory {

    protected static void itemStackRedactor(@NotNull ItemStack item, String name, String ... LoreLines){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+name);
        ArrayList<String> lore = new ArrayList<>();
        for(String str : LoreLines){
            lore.add(ChatColor.translateAlternateColorCodes('&',str));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Яйца для спавнеров");

        ItemStack empty = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta eMeta = empty.getItemMeta();
        eMeta.setDisplayName("Выход");
        empty.setItemMeta(eMeta);

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName("Назад");
        back.setItemMeta(bMeta);

        ItemStack zombie = new ItemStack(Material.ZOMBIE_SPAWN_EGG,1);
        itemStackRedactor(zombie,"Яйцо зомби"," ",
                "&fМожно использовать на спавнере.",
                "",
                "&7Стоимость: ",
                "&730 Орури или 60000 монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");

        ItemStack creeper = new ItemStack(Material.CREEPER_SPAWN_EGG,1);
        itemStackRedactor(creeper,"Яйцо крипера"," ",
                "&fМожно использовать на спавнере.",
                "",
                "&7Стоимость: ",
                "&730 Орури или 60000 монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");

        ItemStack spider = new ItemStack(Material.SPIDER_SPAWN_EGG,1);
        itemStackRedactor(spider,"Яйцо паука"," ",
                "&fМожно использовать на спавнере.",
                "",
                "&7Стоимость: ",
                "&730 Орури или 60000 монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");

        ItemStack CaveSpider = new ItemStack(Material.CAVE_SPIDER_SPAWN_EGG,1);
        itemStackRedactor(CaveSpider,"Яйцо пещерного паука"," ",
                "&fМожно использовать на спавнере.",
                "",
                "&7Стоимость: ",
                "&735 Орури или 70000 монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");

        ItemStack skeleton = new ItemStack(Material.SKELETON_SPAWN_EGG,1);
        itemStackRedactor(skeleton,"Яйцо скелета"," ",
                "&fМожно использовать на спавнере.",
                "",
                "&7Стоимость: ",
                "&730 Орури или 60000 монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");

        ItemStack ZombiePiglin = new ItemStack(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG,1);
        itemStackRedactor(ZombiePiglin,"Яйцо зомби-пиглина"," ",
                "&fМожно использовать на спавнере.",
                "",
                "&7Стоимость: ",
                "&750 Орури или 100000 монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");

        ItemStack[] inv_stack = {empty,air,air,air,air,air,air,air,empty,
                empty,air,air,air,back,air,air,air,empty,
        air,air,air,zombie,creeper,spider,air,air,air,
        air,air,air,skeleton,CaveSpider,ZombiePiglin,air,air,air,
                empty,air,air,air,air,air,air,air,empty,
                empty,air,air,air,air,air,air,air,empty};
        inv.setContents(inv_stack);

        return inv;
    }
}
