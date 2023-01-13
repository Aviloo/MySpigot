package com.aviloo.rewardchests.ItemStack.Chests;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class hunterChest{

    public static ItemStack chestStack(){
        ItemStack chest = new ItemStack(Material.CHEST_MINECART,1);
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.setDisplayName(ChatColor.WHITE+"Ларец охотника");
        ArrayList<String> chestLore = new ArrayList<>();
        chestLore.add(ChatColor.YELLOW+"Чтобы использовать,");
        chestLore.add(ChatColor.YELLOW+"нажмите ПКМ.");
        chestMeta.setLore(chestLore);
        chestMeta.addEnchant(Enchantment.LUCK,1,true);
        chestMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        chestMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chest.setItemMeta(chestMeta);

        return chest;
    }

}
