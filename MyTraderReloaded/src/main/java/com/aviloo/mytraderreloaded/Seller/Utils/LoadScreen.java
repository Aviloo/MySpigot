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
import org.jetbrains.annotations.NotNull;

public class LoadScreen implements Listener {

    private static JavaPlugin plugin;

    public LoadScreen(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static Inventory inventory = Bukkit.createInventory(null,45,"Загрузка...");

    private static ItemStack first_button = new ItemStack(Material.BIRCH_BUTTON,1);
    private static ItemStack second_button = new ItemStack(Material.BIRCH_BUTTON,1);
    private static ItemStack third_button = new ItemStack(Material.BIRCH_BUTTON,1);
    private static ItemStack fourth_button = new ItemStack(Material.BIRCH_BUTTON,1);
    private static ItemStack fifth_button = new ItemStack(Material.BIRCH_BUTTON,1);

    private static void updateFirstMeta(){
        ItemMeta meta = first_button.getItemMeta();
        meta.setDisplayName("20%");
        first_button.setItemMeta(meta);
        first_button.setType(Material.DARK_OAK_BUTTON);
    }

    private static void updateSecondMeta(){
        ItemMeta meta = second_button.getItemMeta();
        meta.setDisplayName("40%");
        second_button.setItemMeta(meta);
        second_button.setType(Material.DARK_OAK_BUTTON);
    }

    private static void updateThirdMeta(){
        ItemMeta meta = third_button.getItemMeta();
        meta.setDisplayName("60%");
        third_button.setItemMeta(meta);
        third_button.setType(Material.DARK_OAK_BUTTON);
    }

    private static void updateFourthMeta(){
        ItemMeta meta = fourth_button.getItemMeta();
        meta.setDisplayName("80%");
        fourth_button.setItemMeta(meta);
        fourth_button.setType(Material.DARK_OAK_BUTTON);
    }

    private static void updateFifthMeta(){
        ItemMeta meta = fifth_button.getItemMeta();
        meta.setDisplayName("100%");
        fifth_button.setItemMeta(meta);
        fifth_button.setType(Material.DARK_OAK_BUTTON);
    }

    public static void setupLoadInventory(){
        inventory.setItem(20,first_button);
        inventory.setItem(21,second_button);
        inventory.setItem(22,third_button);
        inventory.setItem(23,fourth_button);
        inventory.setItem(24,fifth_button);
    }

    public static void openLoadInventory(@NotNull Player player){
        player.openInventory(inventory);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            updateFirstMeta();
            player.playSound(player.getLocation(),Sound.BLOCK_STONE_BUTTON_CLICK_OFF,3,0);
        },15);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            updateSecondMeta();
            player.playSound(player.getLocation(),Sound.BLOCK_STONE_BUTTON_CLICK_OFF,3,0);
        },30);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            updateThirdMeta();
            player.playSound(player.getLocation(),Sound.BLOCK_STONE_BUTTON_CLICK_OFF,3,0);
        },45);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            updateFourthMeta();
            player.playSound(player.getLocation(),Sound.BLOCK_STONE_BUTTON_CLICK_OFF,3,0);
        },60);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            updateFifthMeta();
            player.playSound(player.getLocation(),Sound.BLOCK_STONE_BUTTON_CLICK_OFF,3,0);
        },75);
        Bukkit.getScheduler().runTaskLater(plugin,() -> {
            player.closeInventory();
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,9,1);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',""+
                    "&c[Ошибка] &fДанная функция не доступна. Пожалуйста, сообщите об этом администрации."));
        },85);
    }

}
