package me.aviloo.mycrafts.Menu;

import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BlackMenu {

    public static final BlackMenu instance = new BlackMenu();
    public final Inventory inventory = Bukkit.createInventory(
            null,54, ChatColor.GRAY+"Уникальные крафты"
    );

    BlackMenu(){
        inventory.setItem(3, TNTManager.itemRed);
        inventory.setItem(5, TNTManager.itemBlack);
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, MenuUtil.createCraftItem());
        inventory.setItem(49,MenuUtil.createInfoItem());
        inventory.setItem(21,new ItemStack(Material.TNT,5));
        inventory.setItem(22,new ItemStack(Material.OBSIDIAN,1));
        inventory.setItem(23,new ItemStack(Material.GUNPOWDER,10));

        MenuUtil.createStroke(inventory,3,5,21,22,23,30,31,32,48,49,50);
    }
}
