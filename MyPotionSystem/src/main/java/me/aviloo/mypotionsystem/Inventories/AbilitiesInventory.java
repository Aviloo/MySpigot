package me.aviloo.mypotionsystem.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class AbilitiesInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Улучшения ведьмы");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(50,back);

        ItemStack clean = new ItemStack(Material.STRUCTURE_VOID,1);
        ItemMeta CleanMeta = clean.getItemMeta();
        CleanMeta.setDisplayName(ChatColor.RED+"Очистить выбор.");
        clean.setItemMeta(CleanMeta);
        inv.setItem(48,clean);

        return inv;
    }

}
