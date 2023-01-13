package com.aviloo.rewardchests.Commands.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class getChestStack {

    public static Inventory getInventory(Player player){
        Inventory inv = Bukkit.createInventory(player,27, ChatColor.GRAY+"Адм.Панель: Ларцы");

        ItemStack fish = new ItemStack(Material.TROPICAL_FISH);
        ItemMeta fishMeta = fish.getItemMeta();
        fishMeta.setDisplayName(ChatColor.WHITE+"Ларец рыбака");
        ArrayList<String> fishLore = new ArrayList<>();
        fishLore.add(ChatColor.YELLOW+"Чтобы получить,");
        fishLore.add(ChatColor.YELLOW+"нажмите ЛКМ.");
        fishMeta.setLore(fishLore);
        fish.setItemMeta(fishMeta);

        ItemStack meat = new ItemStack(Material.COOKED_PORKCHOP);
        ItemMeta meatMeta = meat.getItemMeta();
        meatMeta.setDisplayName(ChatColor.WHITE+"Ларец охотника");
        ArrayList<String> meatLore = new ArrayList<>();
        meatLore.add(ChatColor.YELLOW+"Чтобы получить,");
        meatLore.add(ChatColor.YELLOW+"нажмите ЛКМ.");
        meatMeta.setLore(meatLore);
        meat.setItemMeta(meatMeta);

        ItemStack casual = new ItemStack(Material.TRAPPED_CHEST);
        ItemMeta casualMeta = casual.getItemMeta();
        casualMeta.setDisplayName(ChatColor.WHITE+"Потрепанный ларец");
        ArrayList<String> casualLore = new ArrayList<>();
        casualLore.add(ChatColor.YELLOW+"Чтобы получить,");
        casualLore.add(ChatColor.YELLOW+"нажмите ЛКМ.");
        casualMeta.setLore(casualLore);
        casual.setItemMeta(casualMeta);

        ItemStack legend = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta legendMeta = legend.getItemMeta();
        legendMeta.setDisplayName(ChatColor.GOLD+"Легендарный ларец");
        ArrayList<String> legendLore = new ArrayList<>();
        legendLore.add(ChatColor.YELLOW+"Чтобы получить,");
        legendLore.add(ChatColor.YELLOW+"нажмите ЛКМ.");
        legendMeta.setLore(legendLore);
        legend.setItemMeta(legendMeta);

        ItemStack[] inv_content = {fish,meat,casual,legend};

        inv.setContents(inv_content);

        return inv;
    }
}
