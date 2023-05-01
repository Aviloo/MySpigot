package com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Screen7 {

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

        ItemStack tear = new ItemStack(Material.GHAST_TEAR,1);

        ItemStack eye = new ItemStack(Material.SPIDER_EYE,1);

        ItemStack foot = new ItemStack(Material.RABBIT_FOOT,1);

        ItemStack beetroot = new ItemStack(Material.BEETROOT,1);

        ItemStack wheat = new ItemStack(Material.WHEAT,1);

        ItemStack slime = new ItemStack(Material.SLIME_BALL,1);

        ItemStack breath = new ItemStack(Material.DRAGON_BREATH,1);

        ItemStack honey = new ItemStack(Material.HONEYCOMB_BLOCK,1);

        ItemStack kelp = new ItemStack(Material.KELP,1);

        inv.setItem(12,tear);
        inv.setItem(13,eye);
        inv.setItem(14,foot);
        inv.setItem(21,beetroot);
        inv.setItem(22,wheat);
        inv.setItem(23,slime);
        inv.setItem(30,breath);
        inv.setItem(31,honey);
        inv.setItem(32,kelp);
        inv.setItem(48,back);
        //inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        return inv;
    }

}
