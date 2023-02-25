package com.aviloo.mytraderreloaded.Seller.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LeaderInventory implements Listener {

    private static void headRedactor(ItemStack item,Integer NumberInTop){
        if(NumberInTop == 1){

        }
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,45, ChatColor.YELLOW+"Лидеры продаж");

        ItemStack first = new ItemStack(Material.PLAYER_HEAD,1);

        ItemStack second = new ItemStack(Material.PLAYER_HEAD,2);

        ItemStack third = new ItemStack(Material.PLAYER_HEAD,3);

        ItemStack fourth = new ItemStack(Material.PLAYER_HEAD,4);

        ItemStack fifth = new ItemStack(Material.PLAYER_HEAD,5);

        ItemStack sixth = new ItemStack(Material.PLAYER_HEAD,6);

        ItemStack seventh = new ItemStack(Material.PLAYER_HEAD,7);

        ItemStack eighth = new ItemStack(Material.PLAYER_HEAD,8);

        ItemStack ninth = new ItemStack(Material.PLAYER_HEAD,9);

        ItemStack tenth = new ItemStack(Material.PLAYER_HEAD,10);

        return inv;
    }
}
