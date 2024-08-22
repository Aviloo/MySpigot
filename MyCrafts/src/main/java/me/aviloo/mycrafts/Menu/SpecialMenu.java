package me.aviloo.mycrafts.Menu;

import me.aviloo.mycrafts.Items.Trap.TrapManager;
import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SpecialMenu {
    public static final SpecialMenu instance = new SpecialMenu();
    public final Inventory inventory = Bukkit.createInventory(
            null, 54, ChatColor.GRAY+"Уникальные крафты");

    SpecialMenu(){
        inventory.setItem(4, TrapManager.Trap);
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, MenuUtil.createCraftItem());
        inventory.setItem(21,new ItemStack(Material.OBSIDIAN,8));
        inventory.setItem(22,new ItemStack(Material.IRON_INGOT,5));
        inventory.setItem(23,new ItemStack(Material.ENDER_PEARL,2));
        inventory.setItem(30,new ItemStack(Material.BLAZE_ROD,1));
        inventory.setItem(49,MenuUtil.createInfoItem());

        MenuUtil.createStroke(inventory,4,21,22,23,30,31,32,48,49,50);
    }
}
