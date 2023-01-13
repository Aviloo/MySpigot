package com.aviloo.rewardchests.Commands.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class getItemStack {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player, 27, ChatColor.GRAY + "Адм.Панель : Предметы из ларцов");

        ItemStack pickaxe = new ItemStack(Material.STONE_PICKAXE,1);
        ItemMeta pickMeta = pickaxe.getItemMeta();
        pickMeta.setDisplayName(ChatColor.WHITE+"Зачарованная древесина");
        pickMeta.addEnchant(Enchantment.DIG_SPEED,6,true);
        pickMeta.setUnbreakable(true);
        pickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        pickMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> pickLore = new ArrayList<>();
        pickLore.add(ChatColor.YELLOW+"Чтобы получить,");
        pickLore.add(ChatColor.YELLOW+"нажмите ЛКМ.");
        pickMeta.setLore(pickLore);
        pickaxe.setItemMeta(pickMeta);

        ItemStack fishingrod = new ItemStack(Material.TROPICAL_FISH,1);
        ItemMeta rodMeta = fishingrod.getItemMeta();
        rodMeta.setDisplayName(ChatColor.YELLOW+"Удача рыбака");
        rodMeta.addEnchant(Enchantment.LUCK,3,true);
        rodMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        rodMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> rodLore = new ArrayList<>();
        rodLore.add(ChatColor.YELLOW+"Чтобы получить,");
        rodLore.add(ChatColor.YELLOW+"нажмите ЛКМ.");
        rodMeta.setLore(rodLore);
        fishingrod.setItemMeta(rodMeta);

        ItemStack[] inv_content = {pickaxe,fishingrod};

        inv.setContents(inv_content);

        return inv;
    }
}
