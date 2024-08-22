package me.aviloo.mycrafts.Menu;

import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class Menu {

    public static final Menu instance = new Menu();

    public final Inventory inventory = Bukkit.createInventory(
            null, 54, ChatColor.GRAY+"Уникальные крафты");

    Menu(){
        inventory.setItem(20, MenuUtil.createItemStack(Material.TOTEM_OF_UNDYING,
                ChatColor.YELLOW+"Особые тотемы"));
        inventory.setItem(21, MenuUtil.createItemStack(
                ChatColor.YELLOW+"Сферы"));
        inventory.setItem(22,MenuUtil.createItemStack(Material.ENCHANTED_BOOK,
                ChatColor.YELLOW+"Улучшенные зачарования"));
        inventory.setItem(23,MenuUtil.createItemStack(Material.NETHERITE_SCRAP,
                ChatColor.YELLOW+"Особые предметы"));
        inventory.setItem(24,MenuUtil.createItemStack(Material.TNT,
                ChatColor.YELLOW+"Улучшенный динамит"));
        inventory.setItem(49,MenuUtil.createItemStack());

        MenuUtil.createStroke(inventory,20,21,22,23,24,49);

    }


}
