package com.aviloo.mytraderreloaded.Seller.Inventories;

import com.aviloo.mytraderreloaded.Seller.Utils.PlayerReputation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ReputationProductInventory {

    private static void ReputationItemRedactor(Inventory inv,Player player,Integer NeedRep,ItemStack item,
        Material material, String name,Integer index,String ... lore){
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> LoreList = new ArrayList<>();
        if(PlayerReputation.getReputation(player) < NeedRep){
            meta.setDisplayName(ChatColor.WHITE+"Недоступно");
            LoreList.add(ChatColor.translateAlternateColorCodes('&'," "));
            LoreList.add(ChatColor.translateAlternateColorCodes('&',
                    "&7Товар разблокируется, когда у вас будет - &b"+NeedRep));
            LoreList.add(ChatColor.translateAlternateColorCodes('&',"&7очков репутации."));
            LoreList.add(ChatColor.translateAlternateColorCodes('&',"У вас сейчас - &f"+
                    PlayerReputation.getReputation(player)+" &7очков."));
            LoreList.add(" ");
        }
        if(PlayerReputation.getReputation(player) >= NeedRep) {
            item.setType(material);
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            for (String str : lore) {
                LoreList.add(ChatColor.translateAlternateColorCodes('&', str));
            }
        }
        LoreList.add(" ");
        meta.setLore(LoreList);
        item.setItemMeta(meta);
        inv.setItem(index,item);
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,45, ChatColor.WHITE+"Товары за репутацию");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(40,back);

        ItemStack first = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,100,first,Material.GOLD_INGOT,"&fЗолотой слиток",
                12," ");

        ItemStack second = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,200,second,Material.WHEAT,"&fПшеница",
                13," ");

        ItemStack third = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,300,third,Material.LAPIS_LAZULI,"&fЛазурит",
                14," ");

        ItemStack fourth = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,400,fourth,Material.TOTEM_OF_UNDYING,"&fТотем",
                21," ");

        ItemStack fifth = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,500,fifth,Material.CAKE,"&fТорт",
                22," ");

        ItemStack sixth = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,600,sixth,Material.DIAMOND_ORE,"&fАлмазная руда",
                23," ");

        return inv;
    }
}
