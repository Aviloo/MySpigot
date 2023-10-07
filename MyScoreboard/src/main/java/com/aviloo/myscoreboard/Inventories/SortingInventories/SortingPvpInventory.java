package com.aviloo.myscoreboard.Inventories.SortingInventories;

import com.aviloo.myscoreboard.Inventories.StatisticInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SortingPvpInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Тэги типа: «ПВП»");

        ItemStack close = new ItemStack(Material.BARRIER,1);
        ItemMeta cMeta = close.getItemMeta();
        cMeta.setDisplayName(ChatColor.RED+"Закрыть");
        close.setItemMeta(cMeta);
        inv.setItem(53,close);

        ItemStack reset = new ItemStack(Material.STRUCTURE_VOID,1);
        ItemMeta rMeta = reset.getItemMeta();
        rMeta.setDisplayName(ChatColor.YELLOW+"Сбросить");
        ArrayList<String> rLore = new ArrayList<>();
        rLore.add(" ");
        rLore.add(ChatColor.GRAY+"Сбрасывает выбранные слоты");
        rLore.add(ChatColor.GRAY+"к стандартным.");
        rLore.add(" ");
        rMeta.setLore(rLore);
        reset.setItemMeta(rMeta);
        inv.setItem(49,reset);

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(45,back);

        ItemStack sorting = new ItemStack(Material.TRAPPED_CHEST,1);
        ItemMeta sortMeta = sorting.getItemMeta();
        sortMeta.setDisplayName(ChatColor.YELLOW+"Сортировать");
        ArrayList<String> sortLore = new ArrayList<>();
        sortLore.add(" ");
        sortLore.add(ChatColor.GRAY+"Разделите тэги по группам.");
        sortLore.add(" ");
        sortMeta.setLore(sortLore);
        sorting.setItemMeta(sortMeta);
        inv.setItem(50,sorting);

        ItemStack info = new ItemStack(Material.PAPER,1);
        ItemMeta iMeta = info.getItemMeta();
        iMeta.setDisplayName(ChatColor.YELLOW+"Информация");
        ArrayList<String> iLore = new ArrayList<>();
        iLore.add(" ");
        iLore.add(ChatColor.GREEN+"➤"+ChatColor.WHITE+" Здесь можно редактировать");
        iLore.add(ChatColor.WHITE+"тэги в блоке статистики.");
        iLore.add(ChatColor.GREEN+"➤"+ChatColor.WHITE+" Кнопка «Сортировать» - позволяет");
        iLore.add(ChatColor.WHITE+"разделить тэги по группам.");
        iLore.add(ChatColor.GREEN+"➤"+ChatColor.WHITE+" Кнопка «Сбросить» - сбрасывает");
        iLore.add(ChatColor.WHITE+"выбранные ранее тэги.");
        iLore.add(" ");
        iMeta.setLore(iLore);
        info.setItemMeta(iMeta);
        inv.setItem(48,info);

        ItemStack hand_durability = new ItemStack(Material.CONDUIT,1);
        ItemMeta hdMeta = hand_durability.getItemMeta();
        hdMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность предмета в руке");
        ArrayList<String> hdLore = new ArrayList<>();
        hdLore.add(" ");
        hdLore.add(ChatColor.GRAY+"Отображает прочность предмета в вашей руке.");
        hdLore.add(" ");
        hdLore.add(ChatColor.GRAY+"Тип: ПВП");
        hdLore.add(StatisticInventory.getPriceLore(player,"hand_durability"));
        StatisticInventory.getSlotsLore(player,hdLore);
        hdMeta.setLore(hdLore);
        hand_durability.setItemMeta(hdMeta);
        inv.setItem(11,hand_durability);

        ItemStack totem_count = new ItemStack(Material.CONDUIT,2);
        ItemMeta tcMeta = totem_count.getItemMeta();
        tcMeta.setDisplayName(ChatColor.DARK_AQUA+"Количество тотемов");
        ArrayList<String> tcLore = new ArrayList<>();
        tcLore.add(" ");
        tcLore.add(ChatColor.GRAY+"Отображает кол-во тотемов в инвентаре.");
        tcLore.add(" ");
        tcLore.add(ChatColor.GRAY+"Тип: ПВП");
        tcLore.add(StatisticInventory.getPriceLore(player,"totem_count"));
        StatisticInventory.getSlotsLore(player,tcLore);
        tcMeta.setLore(tcLore);
        totem_count.setItemMeta(tcMeta);
        inv.setItem(12,totem_count);

        ItemStack helmet_durability = new ItemStack(Material.CONDUIT,3);
        ItemMeta hedMeta = helmet_durability.getItemMeta();
        hedMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность шлема");
        ArrayList<String> hedLore = new ArrayList<>();
        hedLore.add(" ");
        hedLore.add(ChatColor.GRAY+"Отображает прочность шлема.");
        hedLore.add(" ");
        hedLore.add(ChatColor.GRAY+"Тип: ПВП");
        hedLore.add(StatisticInventory.getPriceLore(player,"helmet_durability"));
        StatisticInventory.getSlotsLore(player,hedLore);
        hedMeta.setLore(hedLore);
        helmet_durability.setItemMeta(hedMeta);
        inv.setItem(13,helmet_durability);

        ItemStack chestplate_durability = new ItemStack(Material.CONDUIT,4);
        ItemMeta chdMeta = chestplate_durability.getItemMeta();
        chdMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность нагрудника");
        ArrayList<String> chdLore = new ArrayList<>();
        chdLore.add(" ");
        chdLore.add(ChatColor.GRAY+"Отображает прочность нагрудника.");
        chdLore.add(" ");
        chdLore.add(ChatColor.GRAY+"Тип: ПВП");
        chdLore.add(StatisticInventory.getPriceLore(player,"chestplate_durability"));
        StatisticInventory.getSlotsLore(player,chdLore);
        chdMeta.setLore(chdLore);
        chestplate_durability.setItemMeta(chdMeta);
        inv.setItem(14,chestplate_durability);

        ItemStack leggings_durability = new ItemStack(Material.CONDUIT,5);
        ItemMeta ldMeta = leggings_durability.getItemMeta();
        ldMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность понож");
        ArrayList<String> ldLore = new ArrayList<>();
        ldLore.add(" ");
        ldLore.add(ChatColor.GRAY+"Отображает прочность понож.");
        ldLore.add(" ");
        ldLore.add(ChatColor.GRAY+"Тип: ПВП");
        ldLore.add(StatisticInventory.getPriceLore(player,"leggings_durability"));
        StatisticInventory.getSlotsLore(player,ldLore);
        ldMeta.setLore(ldLore);
        leggings_durability.setItemMeta(ldMeta);
        inv.setItem(15,leggings_durability);

        ItemStack boots_durability = new ItemStack(Material.CONDUIT,6);
        ItemMeta bdMeta = boots_durability.getItemMeta();
        bdMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность ботинок");
        ArrayList<String> bdLore = new ArrayList<>();
        bdLore.add(" ");
        bdLore.add(ChatColor.GRAY+"Отображает просность ботинок.");
        bdLore.add(" ");
        bdLore.add(ChatColor.GRAY+"Тип: ПВП");
        bdLore.add(StatisticInventory.getPriceLore(player,"boots_durability"));
        StatisticInventory.getSlotsLore(player,bdLore);
        bdMeta.setLore(bdLore);
        boots_durability.setItemMeta(bdMeta);
        inv.setItem(20,boots_durability);

        return inv;
    }

}
