package com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Screen9 {

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

        ItemStack magma = new ItemStack(Material.MAGMA_BLOCK,1);

        ItemStack bone = new ItemStack(Material.BONE_BLOCK,1);

        ItemStack sea = new ItemStack(Material.SEA_PICKLE,1);

        ItemStack soul = new ItemStack(Material.SOUL_SOIL,1);

        ItemStack melon = new ItemStack(Material.MELON,1);

        ItemStack emerald = new ItemStack(Material.EMERALD,1);

        ItemStack copper = new ItemStack(Material.COPPER_INGOT,1);

        ItemStack flint = new ItemStack(Material.FLINT,1);

        ItemStack lazuli = new ItemStack(Material.LAPIS_LAZULI,1);

        inv.setItem(12,magma);
        inv.setItem(13,bone);
        inv.setItem(14,sea);
        inv.setItem(21,soul);
        inv.setItem(22,melon);
        inv.setItem(23,emerald);
        inv.setItem(30,copper);
        inv.setItem(31,flint);
        inv.setItem(32,lazuli);
        inv.setItem(48,back);
        //inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        return inv;
    }

}
