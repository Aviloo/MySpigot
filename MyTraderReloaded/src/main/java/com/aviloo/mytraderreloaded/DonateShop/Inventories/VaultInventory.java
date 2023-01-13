package com.aviloo.mytraderreloaded.DonateShop.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class VaultInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,45, ChatColor.WHITE+"Донат валюта");

        ItemStack empty = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta eMeta = empty.getItemMeta();
        eMeta.setDisplayName("Выход");
        empty.setItemMeta(eMeta);

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName("Назад");
        back.setItemMeta(bMeta);

        ItemStack ten = new ItemStack(Material.REDSTONE,10);
        ItemMeta tMeta = ten.getItemMeta();
        tMeta.setDisplayName(ChatColor.YELLOW+"10 Орури");
        ArrayList<String> tLore = new ArrayList<>();
        MainInventory.loreEditor(tLore," ",
                "&7Стоимость: &65 рублей",
                " ",
                "&fКликните, чтобы купить.",
                " ");
        tMeta.setLore(tLore);
        ten.setItemMeta(tMeta);

        ItemStack fifth = new ItemStack(Material.REDSTONE,50);
        ItemMeta fMeta = fifth.getItemMeta();
        fMeta.setDisplayName(ChatColor.YELLOW+"50 Орури");
        ArrayList<String> fLore = new ArrayList<>();
        MainInventory.loreEditor(fLore," ",
                "&7Стоимость: &625 рублей",
                " ",
                "&fКликните, чтобы купить.",
                " ");
        fMeta.setLore(fLore);
        fifth.setItemMeta(fMeta);

        ItemStack hundred = new ItemStack(Material.REDSTONE_BLOCK,64);
        ItemMeta hMeta = hundred.getItemMeta();
        hMeta.setDisplayName(ChatColor.YELLOW+"100 Орури");
        ArrayList<String> hLore = new ArrayList<>();
        MainInventory.loreEditor(hLore," ",
                "&7Стоимость: &650 рублей",
                " ",
                "&fКликните, чтобы купить.",
                " ");
        hMeta.setLore(hLore);
        hundred.setItemMeta(hMeta);

        inv.setItem(0,empty);
        inv.setItem(8,empty);
        inv.setItem(9,empty);
        inv.setItem(17,empty);
        inv.setItem(27,empty);
        inv.setItem(35,empty);
        inv.setItem(36,empty);
        inv.setItem(44,empty);
        inv.setItem(21,ten);
        inv.setItem(22,fifth);
        inv.setItem(23,hundred);
        inv.setItem(13,back);
        return inv;
    }
}
