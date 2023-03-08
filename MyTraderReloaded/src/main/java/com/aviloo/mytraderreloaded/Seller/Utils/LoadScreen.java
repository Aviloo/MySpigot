package com.aviloo.mytraderreloaded.Seller.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class LoadScreen implements Listener {

    private static JavaPlugin plugin;

    public LoadScreen(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public static void LoadingMenu(Player player){
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvFirst(player));
        },5);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvSecond(player));
        },10);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvThird(player));
        },15);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvFourth(player));
        },20);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvFifth(player));
        },25);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvFirst(player));
        },30);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvSecond(player));
        },35);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvThird(player));
        },40);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvFourth(player));
        },45);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvFifth(player));
        },50);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvFirst(player));
        },55);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvSecond(player));
        },60);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvThird(player));
        },65);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvFourth(player));
        },70);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.openInventory(getInvFifth(player));
        },75);
        Bukkit.getScheduler().runTaskLater(plugin,() -> {
            player.closeInventory();
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,9,1);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',""+
                    "&c[Ошибка] &fДанная функция не доступна. Пожалуйста, сообщите об этом администрации."));
        },80);
    }

    private static Inventory getInvFirst(Player player){
        Inventory inv = Bukkit.createInventory(player,45,"Загрузка...");

        ItemStack wood = new ItemStack(Material.BIRCH_BUTTON,1);
        ItemMeta wMeta = wood.getItemMeta();
        wMeta.setDisplayName(ChatColor.WHITE+"20%");
        wood.setItemMeta(wMeta);

        ItemStack stone = new ItemStack(Material.STONE_BUTTON,1);
        ItemMeta sMeta = stone.getItemMeta();
        sMeta.setDisplayName(" ");
        stone.setItemMeta(sMeta);

        inv.setItem(20,wood);
        inv.setItem(21,stone);
        inv.setItem(22,stone);
        inv.setItem(23,stone);
        inv.setItem(24,stone);

        return inv;
    }

    private static Inventory getInvSecond(Player player){
        Inventory inv = Bukkit.createInventory(player,45,"Загрузка...");

        ItemStack wood = new ItemStack(Material.BIRCH_BUTTON,1);
        ItemMeta wMeta = wood.getItemMeta();
        wMeta.setDisplayName(ChatColor.WHITE+"40%");
        wood.setItemMeta(wMeta);

        ItemStack stone = new ItemStack(Material.STONE_BUTTON,1);
        ItemMeta sMeta = stone.getItemMeta();
        sMeta.setDisplayName(" ");
        stone.setItemMeta(sMeta);

        inv.setItem(20,wood);
        inv.setItem(21,wood);
        inv.setItem(22,stone);
        inv.setItem(23,stone);
        inv.setItem(24,stone);

        return inv;
    }

    private static Inventory getInvThird(Player player){
        Inventory inv = Bukkit.createInventory(player,45,"Загрузка...");

        ItemStack wood = new ItemStack(Material.BIRCH_BUTTON,1);
        ItemMeta wMeta = wood.getItemMeta();
        wMeta.setDisplayName(ChatColor.WHITE+"60%");
        wood.setItemMeta(wMeta);

        ItemStack stone = new ItemStack(Material.STONE_BUTTON,1);
        ItemMeta sMeta = stone.getItemMeta();
        sMeta.setDisplayName(" ");
        stone.setItemMeta(sMeta);

        inv.setItem(20,wood);
        inv.setItem(21,wood);
        inv.setItem(22,wood);
        inv.setItem(23,stone);
        inv.setItem(24,stone);

        return inv;
    }

    private static Inventory getInvFourth(Player player){
        Inventory inv = Bukkit.createInventory(player,45,"Загрузка...");

        ItemStack wood = new ItemStack(Material.BIRCH_BUTTON,1);
        ItemMeta wMeta = wood.getItemMeta();
        wMeta.setDisplayName(ChatColor.WHITE+"80%");
        wood.setItemMeta(wMeta);

        ItemStack stone = new ItemStack(Material.STONE_BUTTON,1);
        ItemMeta sMeta = stone.getItemMeta();
        sMeta.setDisplayName(" ");
        stone.setItemMeta(sMeta);

        inv.setItem(20,wood);
        inv.setItem(21,wood);
        inv.setItem(22,wood);
        inv.setItem(23,wood);
        inv.setItem(24,stone);

        return inv;
    }

    private static Inventory getInvFifth(Player player){
        Inventory inv = Bukkit.createInventory(player,45,"Загрузка...");

        ItemStack wood = new ItemStack(Material.BIRCH_BUTTON,1);
        ItemMeta wMeta = wood.getItemMeta();
        wMeta.setDisplayName(ChatColor.WHITE+"100%");
        wood.setItemMeta(wMeta);

        ItemStack stone = new ItemStack(Material.STONE_BUTTON,1);
        ItemMeta sMeta = stone.getItemMeta();
        sMeta.setDisplayName(" ");
        stone.setItemMeta(sMeta);

        inv.setItem(20,wood);
        inv.setItem(21,wood);
        inv.setItem(22,wood);
        inv.setItem(23,wood);
        inv.setItem(24,wood);

        return inv;
    }
}
