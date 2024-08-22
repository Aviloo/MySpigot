package me.aviloo.mycrafts.Menu;

import me.aviloo.mycrafts.Items.EnchantedManager;
import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EnchantedMenu {
    public static final EnchantedMenu instance = new EnchantedMenu();
    public final Inventory inventory = Bukkit.createInventory(
            null,54, ChatColor.GRAY+"Уникальные крафты"
    );

    EnchantedMenu() {
        inventory.setItem(2, EnchantedManager.getDamageBook());
        inventory.setItem(3, EnchantedManager.getDigSpeedBook());
        inventory.setItem(4, EnchantedManager.getDurabilityBook());
        inventory.setItem(5, EnchantedManager.getProtectionBook());
        inventory.setItem(6, EnchantedManager.getPowerBook());
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, MenuUtil.createCraftItem());
        inventory.setItem(49, MenuUtil.createInfoItem());
        inventory.setItem(21,new ItemStack(Material.BOOKSHELF,3));
        inventory.setItem(22,new ItemStack(Material.EMERALD,2));
        inventory.setItem(23,new ItemStack(Material.LAPIS_LAZULI,7));
        inventory.setItem(30,new ItemStack(Material.DIAMOND,8));

        MenuUtil.createStroke(inventory,2,3,4,5,6,21,22,23,30,31,32,48,49,50);
    }
}
