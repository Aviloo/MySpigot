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
        }
        if(PlayerReputation.getReputation(player) >= NeedRep) {
            item.setType(material);
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            for (String str : lore) {
                LoreList.add(ChatColor.translateAlternateColorCodes('&', str));
            }
        }
        meta.setLore(LoreList);
        item.setItemMeta(meta);
        inv.setItem(index,item);
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,45, ChatColor.WHITE+"Товары за репутацию");

        ItemStack first = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,100,first,Material.GOLD_INGOT,"&fЗолотой слиток",
                12," ");

        return inv;
    }
}
