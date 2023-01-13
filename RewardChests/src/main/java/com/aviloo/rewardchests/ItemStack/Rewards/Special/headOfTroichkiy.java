package com.aviloo.rewardchests.ItemStack.Rewards.Special;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class headOfTroichkiy {
    public static ItemStack head(){
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.AQUA+"Голова Троицкого");
        ArrayList<String> Lore = new ArrayList<>();

        itemMeta.setLore(Lore);
        item.setItemMeta(itemMeta);
        return item;

    }
}
