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

public class SortingOtherInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Тэги типа: «Другое»");

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

        ItemStack ping = new ItemStack(Material.CONDUIT,1);
        ItemMeta pMeta = ping.getItemMeta();
        pMeta.setDisplayName(ChatColor.DARK_AQUA+"Пинг");
        ArrayList<String> pLore = new ArrayList<>();
        pLore.add(" ");
        pLore.add(ChatColor.GRAY+"Отображает ваш пинг.");
        pLore.add(" ");
        pLore.add(ChatColor.GRAY+"Тип: Прочее");
        pLore.add(StatisticInventory.getPriceLore(player,"ping"));
        StatisticInventory.getSlotsLore(player,pLore);
        pMeta.setLore(pLore);
        ping.setItemMeta(pMeta);
        inv.setItem(11,ping);

        ItemStack coords = new ItemStack(Material.CONDUIT,2);
        ItemMeta cnMeta = coords.getItemMeta();
        cnMeta.setDisplayName(ChatColor.DARK_AQUA+"Координаты");
        ArrayList<String> cnLore = new ArrayList<>();
        cnLore.add(" ");
        cnLore.add(ChatColor.GRAY+"Отображает ваши координаты.");
        cnLore.add(" ");
        cnLore.add(ChatColor.GRAY+"Тип: Прочее");
        cnLore.add(StatisticInventory.getPriceLore(player,"coords"));
        StatisticInventory.getSlotsLore(player,cnLore);
        cnMeta.setLore(cnLore);
        coords.setItemMeta(cnMeta);
        inv.setItem(12,coords);

        return inv;
    }

}
