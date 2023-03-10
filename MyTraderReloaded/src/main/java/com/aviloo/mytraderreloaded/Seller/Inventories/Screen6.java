package com.aviloo.mytraderreloaded.Seller.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Screen6 {

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

        ItemStack bamboo = new ItemStack(Material.BAMBOO,1);

        ItemStack cookie = new ItemStack(Material.COOKIE,1);

        ItemStack GlowInk = new ItemStack(Material.GLOW_INK_SAC,1);

        ItemStack black = new ItemStack(Material.BLACK_DYE,1);

        ItemStack wart = new ItemStack(Material.NETHER_WART,1);

        ItemStack beetroot = new ItemStack(Material.BEETROOT_SEEDS,1);

        ItemStack nuggets = new ItemStack(Material.IRON_NUGGET,1);

        ItemStack lily = new ItemStack(Material.LILY_OF_THE_VALLEY,1);

        ItemStack pearl = new ItemStack(Material.PEARLESCENT_FROGLIGHT,1);

        inv.setItem(12,bamboo);
        inv.setItem(13,cookie);
        inv.setItem(14,GlowInk);
        inv.setItem(21,black);
        inv.setItem(22,wart);
        inv.setItem(23,beetroot);
        inv.setItem(30,nuggets);
        inv.setItem(31,lily);
        inv.setItem(32,pearl);
        inv.setItem(48,back);
        //inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        return inv;
    }
}
