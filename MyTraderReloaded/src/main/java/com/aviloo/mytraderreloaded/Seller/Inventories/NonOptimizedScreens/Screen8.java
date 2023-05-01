package com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Screen8 {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54,"");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(backMeta);

        ItemStack reputation = new ItemStack(Material.CHEST_MINECART,1);
        ItemMeta repMeta = reputation.getItemMeta();
        repMeta.setDisplayName(ChatColor.YELLOW+"Репутация у скупщика");
        reputation.setItemMeta(repMeta);

        ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta red_glassMeta = red_glass.getItemMeta();
        red_glassMeta.setDisplayName("Закрыть");
        red_glass.setItemMeta(red_glassMeta);

        ItemStack info = new ItemStack(Material.PAPER,1);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.YELLOW+"Информация");
        ArrayList<String> infoLore = new ArrayList<>();
        infoLore.add(" ");
        infoLore.add(ChatColor.WHITE+"Каждый"+ChatColor.GREEN+" день "+ChatColor.WHITE+", реального времени, ");
        infoLore.add(ChatColor.WHITE+"торговец обновляеться.");
        infoLore.add(" ");
        infoMeta.setLore(infoLore);
        info.setItemMeta(infoMeta);

        ItemStack rose = new ItemStack(Material.WITHER_ROSE,1);

        ItemStack mangrove = new ItemStack(Material.MANGROVE_PROPAGULE,1);

        ItemStack seeds = new ItemStack(Material.WHEAT_SEEDS,1);

        ItemStack book = new ItemStack(Material.BOOK,1);

        ItemStack dust = new ItemStack(Material.GLOWSTONE_DUST,1);

        ItemStack ender = new ItemStack(Material.ENDER_PEARL,1);

        ItemStack honeycomb = new ItemStack(Material.HONEYCOMB,1);

        ItemStack cactus = new ItemStack(Material.CACTUS,1);

        ItemStack pumpkin = new ItemStack(Material.PUMPKIN,1);

        inv.setItem(12,rose);
        inv.setItem(13,mangrove);
        inv.setItem(14,seeds);
        inv.setItem(21,book);
        inv.setItem(22,dust);
        inv.setItem(23,ender);
        inv.setItem(30,honeycomb);
        inv.setItem(31,cactus);
        inv.setItem(32,pumpkin);
        inv.setItem(48,back);
        //inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        return inv;
    }

}
