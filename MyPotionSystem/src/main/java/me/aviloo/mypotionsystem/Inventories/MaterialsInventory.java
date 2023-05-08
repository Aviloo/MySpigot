package me.aviloo.mypotionsystem.Inventories;

import me.aviloo.mypotionsystem.Utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MaterialsInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Материалы");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(50,back);

        ItemStack clean = new ItemStack(Material.STRUCTURE_VOID,1);
        ItemMeta CleanMeta = clean.getItemMeta();
        CleanMeta.setDisplayName(ChatColor.RED+"Очистить выбор.");
        clean.setItemMeta(CleanMeta);
        inv.setItem(48,clean);

        ItemStack magma = new ItemStack(Material.MAGMA_CREAM,1);
        InventoryUtils.itemsEditor(magma,"&eСгусток магмы"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(11,magma);

        ItemStack tear = new ItemStack(Material.GHAST_TEAR,1);
        InventoryUtils.itemsEditor(tear,"&eСлеза гаста"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(12,tear);

        ItemStack powder = new ItemStack(Material.BLAZE_POWDER,1);
        InventoryUtils.itemsEditor(powder,"&eОгненный порошок"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(13,powder);

        ItemStack carrot = new ItemStack(Material.GOLDEN_CARROT,1);
        InventoryUtils.itemsEditor(carrot,"&eЗолотая морковь"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(14,carrot);

        ItemStack membrane = new ItemStack(Material.PHANTOM_MEMBRANE,1);
        InventoryUtils.itemsEditor(membrane,"&eМембрана фантома"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(15,membrane);

        ItemStack foot = new ItemStack(Material.RABBIT_FOOT,1);
        InventoryUtils.itemsEditor(foot,"&eЛапа кролика"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(20,foot);

        ItemStack melon = new ItemStack(Material.GLISTERING_MELON_SLICE,1);
        InventoryUtils.itemsEditor(melon,"&eСверкающий ломтик арбуза"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(21,melon);

        ItemStack eye = new ItemStack(Material.FERMENTED_SPIDER_EYE,1);
        InventoryUtils.itemsEditor(eye,"&eМаринованный глаз"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(22,eye);

        ItemStack glow = new ItemStack(Material.GLOWSTONE_DUST,1);
        InventoryUtils.itemsEditor(glow,"&eСветокаменная пыль"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(23,glow);

        ItemStack dust = new ItemStack(Material.REDSTONE,1);
        InventoryUtils.itemsEditor(dust,"&eРедстоуновая пыль"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(24,dust);

        ItemStack turtle = new ItemStack(Material.TURTLE_HELMET,1);
        InventoryUtils.itemsEditor(turtle,"&eПанцирь черепахи"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(29,turtle);

        ItemStack fish = new ItemStack(Material.PUFFERFISH,1);
        InventoryUtils.itemsEditor(fish,"&eИглобрюх"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(30,fish);

        ItemStack sugar = new ItemStack(Material.SUGAR,1);
        InventoryUtils.itemsEditor(sugar,"&eСахар"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(31,sugar);

        ItemStack wart = new ItemStack(Material.NETHER_WART,1);
        InventoryUtils.itemsEditor(wart,"&eАдский нарост"," ",
                "&fЦена покупки - 4.0 монет",
                " ",
                "&7Чтобы выбрать материал,",
                "&7нажмите ПКМ.");
        inv.setItem(32,wart);

        return inv;
    }


}
