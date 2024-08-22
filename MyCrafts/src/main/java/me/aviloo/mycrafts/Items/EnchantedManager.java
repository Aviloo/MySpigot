package me.aviloo.mycrafts.Items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantedManager {

    public static ItemStack getDamageBook(){
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.DAMAGE_ALL,6,true);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getDigSpeedBook(){
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.DIG_SPEED,6,true);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getDurabilityBook(){
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY,4,true);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getProtectionBook(){
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,5,true);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getPowerBook(){
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.ARROW_DAMAGE,6,true);
        item.setItemMeta(meta);

        return item;
    }
}