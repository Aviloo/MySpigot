package me.aviloo.mypotionsystem.Inventories;

import me.aviloo.mypotionsystem.MyPotionSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

public class CraftingInventory implements Listener {

    private static MyPotionSystem plugin;
    public CraftingInventory(MyPotionSystem plugin){
        this.plugin = plugin;
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,27, ChatColor.YELLOW+"Создание ...");

        ItemStack item = new ItemStack(Material.POTION,1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setColor(Color.YELLOW);
        meta.setDisplayName("10%");
        item.setItemMeta(meta);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            meta.setColor(Color.LIME);
            meta.setDisplayName("15%");
            item.setItemMeta(meta);
        },10);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            meta.setColor(Color.AQUA);
            meta.setDisplayName("30%");
            item.setItemMeta(meta);
        },20);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            meta.setColor(Color.SILVER);
            meta.setDisplayName("40%");
            item.setItemMeta(meta);
        },30);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            meta.setColor(Color.ORANGE);
            meta.setDisplayName("50%");
            item.setItemMeta(meta);
        },40);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            meta.setColor(Color.RED);
            meta.setDisplayName("60%");
            item.setItemMeta(meta);
        },50);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            meta.setColor(Color.PURPLE);
            meta.setDisplayName("70%");
            item.setItemMeta(meta);
        },60);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            meta.setColor(Color.GRAY);
            meta.setDisplayName("80%");
            item.setItemMeta(meta);
        },70);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            meta.setColor(Color.OLIVE);
            meta.setDisplayName("90%");
            item.setItemMeta(meta);
        },80);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            meta.setColor(Color.NAVY);
            meta.setDisplayName("100%");
            item.setItemMeta(meta);
        },90);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.closeInventory();
        },100);


        return inv;
    }
}
