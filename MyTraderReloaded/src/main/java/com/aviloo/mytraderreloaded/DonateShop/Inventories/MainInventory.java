package com.aviloo.mytraderreloaded.DonateShop.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MainInventory {

    protected static void loreEditor(ArrayList<String> list,String ... lines){
        for(String str: lines){
            list.add(ChatColor.translateAlternateColorCodes('&',str));
        }
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Торговец");

        ItemStack empty = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta eMeta = empty.getItemMeta();
        eMeta.setDisplayName("Выход");
        empty.setItemMeta(eMeta);

        ItemStack barrier = new ItemStack(Material.BARRIER,1);
        ItemMeta barMeta = barrier.getItemMeta();
        barMeta.setDisplayName(ChatColor.GRAY+"Временно недоступно.");
        ArrayList<String> barLore = new ArrayList<>();
        loreEditor(barLore," ",
                ChatColor.WHITE+"P.S: Будет доступно в ближайшем обновлении.",
                " ");
        barMeta.setLore(barLore);
        barrier.setItemMeta(barMeta);

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack shield = new ItemStack(Material.SHIELD,1);
        ItemMeta sMeta = shield.getItemMeta();
        sMeta.setDisplayName(ChatColor.YELLOW+"Особые Щиты");
        ArrayList<String> sLore = new ArrayList<>();
        loreEditor(sLore," ",
                "&7Здесь продаются щиты,",
                "&7которые обладают особыми ",
                "&7свойствами.",
                " ",
                "&fКликните ,чтобы посмотреть.",
                " ");
        sMeta.setLore(sLore);
        shield.setItemMeta(sMeta);

        ItemStack mushroom = new ItemStack(Material.RED_MUSHROOM_BLOCK,1);
        ItemMeta mMeta = mushroom.getItemMeta();
        mMeta.setDisplayName(ChatColor.YELLOW+"Особые Приваты");
        ArrayList<String> mLore = new ArrayList<>();
        loreEditor(mLore," ",
                "&7Здесь продаются приваты,",
                "&7которые нельзя получить в ",
                "&7обычном выживании.",
                " ",
                "&fКликните, чтобы посмотреть.",
                " ");
        mMeta.setLore(mLore);
        mushroom.setItemMeta(mMeta);

        ItemStack vault = new ItemStack(Material.REDSTONE_BLOCK,1);
        ItemMeta vMeta = vault.getItemMeta();
        vMeta.setDisplayName(ChatColor.YELLOW+"Донат Валюта");
        ArrayList<String> vLore = new ArrayList<>();
        loreEditor(vLore," ",
                "&7Здесь продается донат валюта",
                " ",
                "&fКликните, чтобы посмотреть",
                " ");
        vMeta.setLore(vLore);
        vault.setItemMeta(vMeta);

        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta bMeta = book.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Улучшенные зачарования");
        ArrayList<String> bLore = new ArrayList<>();
        loreEditor(bLore," ",
                "&7Здесь продаются зачарования,",
                "&7которые нельзя получить в обычном",
                "&7выживании.",
                " ",
                "&fКликните, чтобы посмотреть",
                " ");
        bMeta.setLore(bLore);
        book.setItemMeta(bMeta);

        ItemStack egg = new ItemStack(Material.MAGMA_CUBE_SPAWN_EGG,1);
        EggsInventory.itemStackRedactor(egg,"Яйца для спавнеров"," ",
                "&7Здесь продаются яйца для спавнеров,",
                "&7которые нельзя получить в обычном",
                "&7выживании.",
                " ",
                "&fКликните, чтобы посмотреть",
                " ");

        ItemStack another = new ItemStack(Material.CYAN_SHULKER_BOX,1);
        EggsInventory.itemStackRedactor(another,"Полезные предметы"," ",
                "&7Здесь продаются предметы,",
                "&7которые нельзя получить в обычном",
                "&7выживании.",
                " ",
                "&fКликните, чтобы посмотреть",
                " ");

        ItemStack[] inv_stack = {empty,air,air,air,air,air,air,air,empty,
        empty,air,air,air,air,air,air,air,empty,
        air,air,air,vault,shield,mushroom,air,air,air,
        air,air,air,egg,another,barrier,air,air,air,
        empty,air,air,air,air,air,air,air,empty,
        empty,air,air,air,air,air,air,air,empty};
        inv.setContents(inv_stack);
        return inv;
    }
}
