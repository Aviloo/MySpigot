package com.aviloo.mytraderreloaded.DonateShop.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AnotherInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,45, ChatColor.WHITE+"Полезные предметы");

        ItemStack empty = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta eMeta = empty.getItemMeta();
        eMeta.setDisplayName("Выход");
        empty.setItemMeta(eMeta);

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName("Назад");
        back.setItemMeta(bMeta);

        ItemStack barrier = new ItemStack(Material.BARRIER,1);
        ItemMeta barMeta = barrier.getItemMeta();
        barMeta.setDisplayName(ChatColor.RED+" Недоступно ");
        barrier.setItemMeta(barMeta);

        ItemStack portal = new ItemStack(Material.END_PORTAL_FRAME,1);
        EggsInventory.itemStackRedactor(portal,"Портал в энд"," ",
                "&7Все порталы в обычном мире сломаны ?",
                "&7Не проблема! Всегда можно купить свой",
                "&7персональный портал.",
                " ",
                "&fСтоимость: &6 125 Орури",
                "&fили &6250 000 Монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");

        inv.setItem(0,empty);
        inv.setItem(8,empty);
        inv.setItem(9,empty);
        inv.setItem(17,empty);
        inv.setItem(27,empty);
        inv.setItem(35,empty);
        inv.setItem(36,empty);
        inv.setItem(44,empty);
        inv.setItem(21,portal);
        inv.setItem(22,barrier);
        inv.setItem(23,barrier);
        inv.setItem(13,back);
        return inv;
    }
}
