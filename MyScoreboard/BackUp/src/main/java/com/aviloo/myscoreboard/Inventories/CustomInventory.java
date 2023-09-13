package com.aviloo.myscoreboard.Inventories;

import com.aviloo.myscoreboard.Boards.BoardManager;
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

public class CustomInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,9, ChatColor.WHITE+"Кастомизация");

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta cMeta = close.getItemMeta();
        cMeta.setDisplayName(ChatColor.WHITE+"Закрыть");
        close.setItemMeta(cMeta);

        ItemStack original = new ItemStack(Material.ORANGE_BANNER);
        ItemMeta oMeta = original.getItemMeta();
        oMeta.setDisplayName(ChatColor.GOLD+"Стандартные настройки");
        ArrayList<String> oLore = new ArrayList<>();
        oLore.add(" ");
        oLore.add("Позволяет изменить цвет скорборда.");
        oLore.add(" ");
        if(BoardManager.getColor(player).equalsIgnoreCase("original")){
            oMeta.addEnchant(Enchantment.LUCK,1,true);
            oMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            oLore.add(ChatColor.GRAY+"Установлено");
            oLore.add(" ");
            oMeta.setLore(oLore);
            original.setItemMeta(oMeta);
        }else{
            oMeta.setLore(oLore);
            original.setItemMeta(oMeta);
        }

        ItemStack red = new ItemStack(Material.RED_BANNER);
        ItemMeta rMeta = red.getItemMeta();
        rMeta.setDisplayName(ChatColor.RED+"Красный");
        ArrayList<String> rLore = new ArrayList<>();
        rLore.add(" ");
        rLore.add("Позволяет изменить цвет скорборда.");
        rLore.add(" ");
        if(BoardManager.getColor(player).equalsIgnoreCase("red")){
            rMeta.addEnchant(Enchantment.LUCK,1,true);
            rMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            rLore.add(ChatColor.GRAY+"Установлено");
            rLore.add(" ");
            rMeta.setLore(rLore);
            red.setItemMeta(rMeta);
        }else{
            rMeta.setLore(rLore);
            red.setItemMeta(rMeta);
        }

        ItemStack blue = new ItemStack(Material.LIGHT_BLUE_BANNER);
        ItemMeta bMeta = blue.getItemMeta();
        bMeta.setDisplayName(ChatColor.AQUA+"Голубой");
        ArrayList<String> bLore = new ArrayList<>();
        bLore.add(" ");
        bLore.add("Позволяет изменить цвет скорборда.");
        bLore.add(" ");
        if(BoardManager.getColor(player).equalsIgnoreCase("blue")){
            bMeta.addEnchant(Enchantment.LUCK,1,true);
            bMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            bLore.add(ChatColor.GRAY+"Установлено");
            bLore.add(" ");
            bMeta.setLore(bLore);
            blue.setItemMeta(bMeta);
        }else{
            bMeta.setLore(bLore);
            blue.setItemMeta(bMeta);
        }

        ItemStack pink = new ItemStack(Material.PURPLE_BANNER);
        ItemMeta pMeta = blue.getItemMeta();
        pMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"Розовый");
        ArrayList<String> pLore = new ArrayList<>();
        pLore.add(" ");
        pLore.add("Позволяет изменить цвет скорборда.");
        pLore.add(" ");
        if(BoardManager.getColor(player).equalsIgnoreCase("pink")){
            pMeta.addEnchant(Enchantment.LUCK,1,true);
            pMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            pLore.add(ChatColor.GRAY+"Установлено");
            pLore.add(" ");
            pMeta.setLore(pLore);
            pink.setItemMeta(pMeta);
        }else{
            pMeta.setLore(pLore);
            pink.setItemMeta(pMeta);
        }

        ItemStack gray = new ItemStack(Material.LIGHT_GRAY_BANNER);
        ItemMeta gMeta = gray.getItemMeta();
        gMeta.setDisplayName(ChatColor.GRAY+"Серый");
        ArrayList<String> gLore = new ArrayList<>();
        gLore.add(" ");
        gLore.add("Позволяет изменить цвет скорборда.");
        gLore.add(" ");
        if(BoardManager.getColor(player).equalsIgnoreCase("gray")){
            gMeta.addEnchant(Enchantment.LUCK,1,true);
            gMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            gLore.add(ChatColor.GRAY+"Установлено");
            gLore.add(" ");
            gMeta.setLore(gLore);
            gray.setItemMeta(gMeta);
        }else{
            gMeta.setLore(gLore);
            gray.setItemMeta(gMeta);
        }

        ItemStack[] inv_stack = {air,air,original,red,blue,pink,gray,air,close};
        inv.setContents(inv_stack);

        return inv;
    }
}
