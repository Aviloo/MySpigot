package me.aviloo.mycrafts.Menu;

import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RedMenu {
    public static final RedMenu instance = new RedMenu();
    public final Inventory inventory = Bukkit.createInventory(
            null,54, ChatColor.GRAY+"Уникальные крафты"
    );

    RedMenu(){
        inventory.setItem(3, TNTManager.itemRed);
        inventory.setItem(5,TNTManager.itemBlack);
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, MenuUtil.createCraftItem());
        inventory.setItem(49,MenuUtil.createInfoItem());
        inventory.setItem(21,new ItemStack(Material.TNT,10));
        inventory.setItem(22,new ItemStack(Material.FLINT_AND_STEEL,1));
        inventory.setItem(23,new ItemStack(Material.GUNPOWDER,3));

        MenuUtil.createStroke(inventory,3,5,21,22,23,30,31,32,48,49,50);
    }
}
