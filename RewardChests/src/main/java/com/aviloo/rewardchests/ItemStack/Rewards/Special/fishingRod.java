package com.aviloo.rewardchests.ItemStack.Rewards.Special;

import com.google.common.collect.Multimap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class fishingRod {
    public static ItemStack fishingRodStack(){
        ItemStack item = new ItemStack(Material.FISHING_ROD,1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Удача рыбака");
        itemMeta.addEnchant(Enchantment.LUCK,3,true);
        itemMeta.addEnchant(Enchantment.LURE,2,true);
        itemMeta.addEnchant(Enchantment.MENDING,1,true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.setUnbreakable(false);
        item.setItemMeta(itemMeta);
        return item;
    }
}
