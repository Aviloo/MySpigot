package com.aviloo.mytraderreloaded.DonateShop.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EnchantedInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Улучшенные зачарования");

        ItemStack empty = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta eMeta = empty.getItemMeta();
        eMeta.setDisplayName("Выход");
        empty.setItemMeta(eMeta);

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName("Назад");
        back.setItemMeta(bMeta);

        ItemStack sharp = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta sMeta = sharp.getItemMeta();
        sMeta.setDisplayName(ChatColor.YELLOW+"Острота 6");
        ArrayList<String> sLore = new ArrayList<>();
        MainInventory.loreEditor(sLore," ",
                "&fСтоимость: &6 3 Орури",
                "&fили &66000 Монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        sMeta.setLore(sLore);
        sharp.setItemMeta(sMeta);

        ItemStack efficiency = new ItemStack(Material.ENCHANTED_BOOK,2);
        ItemMeta efMeta = efficiency.getItemMeta();
        efMeta.setDisplayName(ChatColor.YELLOW+"Эффективность 6");
        ArrayList<String> efLore = new ArrayList<>();
        MainInventory.loreEditor(efLore," ",
                "&fСтоимость: &6 3 Орури",
                "&fили &66000 Монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        efMeta.setLore(efLore);
        efficiency.setItemMeta(efMeta);

        ItemStack luck = new ItemStack(Material.ENCHANTED_BOOK,3);
        ItemMeta lMeta = luck.getItemMeta();
        lMeta.setDisplayName(ChatColor.YELLOW+"Удача 4");
        ArrayList<String> lLore = new ArrayList<>();
        MainInventory.loreEditor(lLore," ",
                "&fСтоимость: &6 3 Орури",
                "&fили &66000 Монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        lMeta.setLore(lLore);
        luck.setItemMeta(lMeta);

        ItemStack protect = new ItemStack(Material.ENCHANTED_BOOK,4);
        ItemMeta pMeta = protect.getItemMeta();
        pMeta.setDisplayName(ChatColor.YELLOW+"Защита 5");
        ArrayList<String> pLore = new ArrayList<>();
        MainInventory.loreEditor(pLore," ",
                "&fСтоимость: &6 3 Орури",
                "&fили &66000 Монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        pMeta.setLore(pLore);
        protect.setItemMeta(pMeta);

        ItemStack fire = new ItemStack(Material.ENCHANTED_BOOK,5);
        ItemMeta fMeta = fire.getItemMeta();
        fMeta.setDisplayName(ChatColor.YELLOW+"Огонь 3");
        ArrayList<String> fLore = new ArrayList<>();
        MainInventory.loreEditor(fLore," ",
                "&fСтоимость: &6 3 Орури",
                "&fили &66000 Монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        fMeta.setLore(fLore);
        fire.setItemMeta(fMeta);

        ItemStack power = new ItemStack(Material.ENCHANTED_BOOK,6);
        ItemMeta poMeta = power.getItemMeta();
        poMeta.setDisplayName(ChatColor.YELLOW+"Сила 6");
        ArrayList<String> poLore = new ArrayList<>();
        MainInventory.loreEditor(poLore," ",
                "&fСтоимость: &6 3 Орури",
                "&fили &66000 Монет",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        poMeta.setLore(poLore);
        power.setItemMeta(poMeta);

        ItemStack[] inv_stack = {empty,air,air,air,air,air,air,air,empty,
                empty,air,air,air,back,air,air,air,empty,
                air,air,air,sharp,efficiency,luck,air,air,air,
                air,air,air,protect,fire,power,air,air,air,
                empty,air,air,air,air,air,air,air,empty,
                empty,air,air,air,air,air,air,air,empty};
        inv.setContents(inv_stack);

        return inv;
    }
}
