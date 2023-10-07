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

public class SortingStatisticInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Тэги типа: «Статистика»");

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

        ItemStack kills = new ItemStack(Material.CONDUIT,1);
        ItemMeta kMeta = kills.getItemMeta();
        kMeta.setDisplayName(ChatColor.DARK_AQUA+"Убийства");
        ArrayList<String> kLore = new ArrayList<>();
        kLore.add(" ");
        kLore.add(ChatColor.GRAY+"Отображает кол-во ваших убийств.");
        kLore.add(" ");
        kLore.add(ChatColor.GRAY+"Тип: Статистика");
        kLore.add(ChatColor.YELLOW+"Стоимость: "+ChatColor.DARK_GRAY+"Отсутствует.");
        StatisticInventory.getSlotsLore(player,kLore);
        kMeta.setLore(kLore);
        kills.setItemMeta(kMeta);
        inv.setItem(11,kills);

        ItemStack deaths = new ItemStack(Material.CONDUIT,2);
        ItemMeta dMeta = deaths.getItemMeta();
        dMeta.setDisplayName(ChatColor.DARK_AQUA+"Смертей");
        ArrayList<String> dLore = new ArrayList<>();
        dLore.add(" ");
        dLore.add(ChatColor.GRAY+"Отображает кол-во ваших смертей.");
        dLore.add(" ");
        dLore.add(ChatColor.GRAY+"Тип: Статистика");
        dLore.add(ChatColor.YELLOW+"Стоимость: "+ChatColor.DARK_GRAY+"Отсутствует.");
        StatisticInventory.getSlotsLore(player,dLore);
        dMeta.setLore(dLore);
        deaths.setItemMeta(dMeta);
        inv.setItem(12,deaths);

        ItemStack hours = new ItemStack(Material.CONDUIT,3);
        ItemMeta hMeta = hours.getItemMeta();
        hMeta.setDisplayName(ChatColor.DARK_AQUA+"Отыграно");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(" ");
        hLore.add(ChatColor.GRAY+"Отображает кол-во часов в игре.");
        hLore.add(" ");
        hLore.add(ChatColor.GRAY+"Тип: Статистика");
        hLore.add(ChatColor.YELLOW+"Стоимость: "+ChatColor.DARK_GRAY+"Отсутствует.");
        StatisticInventory.getSlotsLore(player,hLore);
        hMeta.setLore(hLore);
        hours.setItemMeta(hMeta);
        inv.setItem(13,hours);

        ItemStack mobs_killed = new ItemStack(Material.CONDUIT,4);
        ItemMeta mkMeta = mobs_killed.getItemMeta();
        mkMeta.setDisplayName(ChatColor.DARK_AQUA+"Мобов Убито");
        ArrayList<String> mkLore = new ArrayList<>();
        mkLore.add(" ");
        mkLore.add(ChatColor.GRAY+"Отображает кол-во убитых вами мобов.");
        mkLore.add(" ");
        mkLore.add(ChatColor.GRAY+"Тип: Статистика");
        mkLore.add(StatisticInventory.getPriceLore(player,"mobs_killed"));
        StatisticInventory.getSlotsLore(player,mkLore);
        mkMeta.setLore(mkLore);
        mobs_killed.setItemMeta(mkMeta);
        inv.setItem(14,mobs_killed);

        ItemStack blocks_break = new ItemStack(Material.CONDUIT,5);
        ItemMeta bbMeta = blocks_break.getItemMeta();
        bbMeta.setDisplayName(ChatColor.DARK_AQUA+"Блоков Сломано");
        ArrayList<String> bbLore = new ArrayList<>();
        bbLore.add(" ");
        bbLore.add(ChatColor.GRAY+"Отображает кол-во сломанных блоков.");
        bbLore.add(" ");
        bbLore.add(ChatColor.GRAY+"Тип: Статистика");
        bbLore.add(StatisticInventory.getPriceLore(player,"blocks_break"));
        StatisticInventory.getSlotsLore(player,bbLore);
        bbMeta.setLore(bbLore);
        blocks_break.setItemMeta(bbMeta);
        inv.setItem(15,blocks_break);

        ItemStack kd = new ItemStack(Material.CONDUIT,6);
        ItemMeta kdMeta = kd.getItemMeta();
        kdMeta.setDisplayName(ChatColor.DARK_AQUA+"KD");
        ArrayList<String> kdLore = new ArrayList<>();
        kdLore.add(" ");
        kdLore.add(ChatColor.GRAY+"Отображает соотношение убийств к смертям.");
        kdLore.add(" ");
        kdLore.add(ChatColor.GRAY+"Тип: Статистика");
        kdLore.add(StatisticInventory.getPriceLore(player,"kills_deaths"));
        StatisticInventory.getSlotsLore(player,kdLore);
        kdMeta.setLore(kdLore);
        kd.setItemMeta(kdMeta);
        inv.setItem(20,kd);

        return inv;
    }

}
