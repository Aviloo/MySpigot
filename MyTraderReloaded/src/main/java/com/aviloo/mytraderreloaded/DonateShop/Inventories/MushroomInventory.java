package com.aviloo.mytraderreloaded.DonateShop.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MushroomInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,45, ChatColor.WHITE+"Особые приваты");

        ItemStack empty = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta eMeta = empty.getItemMeta();
        eMeta.setDisplayName("Выход");
        empty.setItemMeta(eMeta);

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName("Назад");
        back.setItemMeta(bMeta);

        ItemStack mushroom = new ItemStack(Material.RED_MUSHROOM_BLOCK,1);
        ItemMeta mMeta = mushroom.getItemMeta();
        mMeta.setDisplayName(ChatColor.YELLOW+"Приват 30x30");
        ArrayList<String> mLore = new ArrayList<>();
        MainInventory.loreEditor(mLore," ",
                "&7Стоимость:&6 40 Орури",
                "&7Можно купить только за Донат-валюту,",
                "&7или купить за монеты на аукционе.",
                " ",
                "&fЛКМ -&e открыть аукцион",
                "&fПКМ -&e купить",
                " ");
        mMeta.setLore(mLore);
        mushroom.setItemMeta(mMeta);

        inv.setItem(0,empty);
        inv.setItem(8,empty);
        inv.setItem(9,empty);
        inv.setItem(17,empty);
        inv.setItem(27,empty);
        inv.setItem(35,empty);
        inv.setItem(36,empty);
        inv.setItem(44,empty);
        inv.setItem(22,mushroom);
        inv.setItem(13,back);
        return inv;
    }
}
