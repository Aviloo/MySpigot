package com.aviloo.rewardchests.ItemStack.Rewards.Special;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class woodPickaxeUltimate {

    public static ItemStack ultimateWoodPickAxeStack(){
        ItemStack item = new ItemStack(Material.WOODEN_PICKAXE,1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE+"Зачарованная древесина");
        itemMeta.addEnchant(Enchantment.DIG_SPEED,6,true);
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(itemMeta);

        return item;
    }
}
