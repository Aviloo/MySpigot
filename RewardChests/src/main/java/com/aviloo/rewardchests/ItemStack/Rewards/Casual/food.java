package com.aviloo.rewardchests.ItemStack.Rewards.Casual;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class food {
    public static ItemStack applesStack(){
        ItemStack item = new ItemStack(Material.APPLE, 10);
        return item;
    }
    public static ItemStack chickenStack(){
        ItemStack item = new ItemStack(Material.CHICKEN, 14);
        return item;
    }
    public static ItemStack pigStack(){
        ItemStack item = new ItemStack(Material.PORKCHOP, 6);
        return item;
    }
    public static ItemStack cowStack(){
        ItemStack item = new ItemStack(Material.BEEF, 8);
        return item;
    }
    public static ItemStack cowCookedStack(){
        ItemStack item = new ItemStack(Material.COOKED_BEEF, 4);
        return item;
    }
}
