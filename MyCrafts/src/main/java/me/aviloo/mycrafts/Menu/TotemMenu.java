package me.aviloo.mycrafts.Menu;

import me.aviloo.mycrafts.Items.TotemsManager;
import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TotemMenu {

    public static final TotemMenu instance = new TotemMenu();
    public final Inventory inventory = Bukkit.createInventory(
            null,54, ChatColor.GRAY+"Уникальные крафты");

    TotemMenu(){
        inventory.setItem(3, TotemsManager.getTotemOfAgility());
        inventory.setItem(4, TotemsManager.getTotemOfStrength());
        inventory.setItem(5, TotemsManager.getTotemOfPower());
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, MenuUtil.createCraftItem());
        inventory.setItem(49, MenuUtil.createInfoItem());
        inventory.setItem(21,new ItemStack(Material.TOTEM_OF_UNDYING,1));
        inventory.setItem(22, new ItemStack(Material.RABBIT_FOOT,5));
        inventory.setItem(23, new ItemStack(Material.SUGAR,16));
        inventory.setItem(30, new ItemStack(Material.ECHO_SHARD,3));

        MenuUtil.createStroke(inventory,3,4,5,21,22,23,30,31,32,48,49,50);

    }

}
