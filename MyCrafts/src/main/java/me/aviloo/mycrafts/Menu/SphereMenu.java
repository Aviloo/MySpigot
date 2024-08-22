package me.aviloo.mycrafts.Menu;

import me.aviloo.mycrafts.Items.SphereManager;
import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SphereMenu {
    public static final SphereMenu instance = new SphereMenu();
    public final Inventory inventory = Bukkit.createInventory(
                null, 54, ChatColor.GRAY + "Уникальные крафты");

    SphereMenu() {
        inventory.setItem(3, SphereManager.getSphereOcean());
        inventory.setItem(4, SphereManager.getSphereNether());
        inventory.setItem(5, SphereManager.getSphereEnd());
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, MenuUtil.createCraftItem());
        inventory.setItem(21,new ItemStack(Material.HEART_OF_THE_SEA,1));
        inventory.setItem(22,new ItemStack(Material.IRON_BLOCK,3));
        inventory.setItem(23,new ItemStack(Material.GLISTERING_MELON_SLICE,4));
        inventory.setItem(30,new ItemStack(Material.FERMENTED_SPIDER_EYE,5));
        inventory.setItem(31,new ItemStack(Material.SLIME_BALL,7));
        inventory.setItem(32,new ItemStack(Material.GLOW_INK_SAC,4));
        inventory.setItem(49,MenuUtil.createInfoItem());


        MenuUtil.createStroke(inventory,3,4,5,21,22,23,30,31,32,48,49,50);
    }

}
