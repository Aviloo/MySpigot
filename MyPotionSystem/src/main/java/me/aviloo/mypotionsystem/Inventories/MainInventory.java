package me.aviloo.mypotionsystem.Inventories;

import me.aviloo.mypotionsystem.Utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;

public class MainInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54,ChatColor.WHITE+"Создание зелья");

        ItemStack info = new ItemStack(Material.BOOK,1);
        ItemMeta InfoMeta = info.getItemMeta();
        InfoMeta.setDisplayName(ChatColor.GRAY+"Информация о зельях");
        info.setItemMeta(InfoMeta);
        inv.setItem(49,info);

        ItemStack clean = new ItemStack(Material.STRUCTURE_VOID,1);
        ItemMeta cMeta = clean.getItemMeta();
        cMeta.setDisplayName(ChatColor.YELLOW+"Очистить");
        ArrayList<String> cLore = new ArrayList<>();
        cLore.add(" ");
        cLore.add(ChatColor.GRAY+"Очистить выбранные материалы и улучшения");
        cLore.add(" ");
        cMeta.setLore(cLore);
        clean.setItemMeta(cMeta);
        inv.setItem(48,clean);

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(50,back);

        ItemStack potion = new ItemStack(Material.POTION);
        PotionMeta PotionMeta = (PotionMeta) potion.getItemMeta();
        PotionMeta.setColor(Color.LIME);
        PotionMeta.setDisplayName(ChatColor.YELLOW+"Создать зелье");
        PotionMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        potion.setItemMeta(PotionMeta);
        inv.setItem(13,potion);

        ItemStack materials = new ItemStack(Material.RABBIT_FOOT,1);
        ItemMeta MatMeta = materials.getItemMeta();
        MatMeta.setDisplayName(ChatColor.YELLOW+"Материалы");
        ArrayList<String> MatLore = new ArrayList<>();
        MatLore.add(ChatColor.WHITE+"Выберите материалы для");
        MatLore.add(ChatColor.WHITE+"создания зелий.");
        MatLore.add(ChatColor.WHITE+" ");
        MatLore.add(ChatColor.GRAY+"Материалов выбрано: " + InventoryUtils.getSelectedMaterial(player) +"/3");
        MatLore.add(ChatColor.WHITE+" ");
        MatMeta.setLore(MatLore);
        materials.setItemMeta(MatMeta);
        inv.setItem(30,materials);

        ItemStack upgrades = new ItemStack(Material.BREWING_STAND,1);
        ItemMeta UpMeta = upgrades.getItemMeta();
        UpMeta.setDisplayName(ChatColor.YELLOW+"Улучшения рабочего места");
        ArrayList<String> UpLore = new ArrayList<>();
        UpLore.add(ChatColor.WHITE+"");
        UpMeta.setLore(UpLore);
        upgrades.setItemMeta(UpMeta);
        inv.setItem(31,upgrades);

        ItemStack abilities = new ItemStack(Material.WITCH_SPAWN_EGG,1);
        ItemMeta AbiMeta = abilities.getItemMeta();
        AbiMeta.setDisplayName(ChatColor.YELLOW+"Улучшения ведьмы");
        ArrayList<String> AbiLore = new ArrayList<>();
        AbiLore.add(" ");
        AbiMeta.setLore(AbiLore);
        abilities.setItemMeta(AbiMeta);
        inv.setItem(32,abilities);

        return inv;
    }
}
