package com.aviloo.myscoreboard.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class StatisticInventory {

    private static void getSlotsLore(Player player,ArrayList<String> lore){
        lore.add(" ");
        lore.add(StatisticInteract.getSlotName(1,player));
        lore.add(StatisticInteract.getSlotName(2,player));
        lore.add(StatisticInteract.getSlotName(3,player));
        lore.add(" ");
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Статистика");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(47,back);

        ItemStack close = new ItemStack(Material.BARRIER,1);
        ItemMeta cMeta = close.getItemMeta();
        cMeta.setDisplayName(ChatColor.RED+"Закрыть");
        close.setItemMeta(cMeta);
        inv.setItem(51,close);

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

        ItemStack sorting = new ItemStack(Material.TRAPPED_CHEST,1);
        ItemMeta sortMeta = sorting.getItemMeta();
        sortMeta.setDisplayName(ChatColor.YELLOW+"Сортировать");
        sorting.setItemMeta(sortMeta);
        inv.setItem(50,sorting);

        ItemStack kills = new ItemStack(Material.CONDUIT,1);
        ItemMeta kMeta = kills.getItemMeta();
        kMeta.setDisplayName(ChatColor.DARK_AQUA+"Убийства");
        ArrayList<String> kLore = new ArrayList<>();
        getSlotsLore(player,kLore);
        kMeta.setLore(kLore);
        kills.setItemMeta(kMeta);
        inv.setItem(11,kills);

        ItemStack deaths = new ItemStack(Material.CONDUIT,2);
        ItemMeta dMeta = deaths.getItemMeta();
        dMeta.setDisplayName(ChatColor.DARK_AQUA+"Смертей");
        ArrayList<String> dLore = new ArrayList<>();
        getSlotsLore(player,dLore);
        dMeta.setLore(dLore);
        deaths.setItemMeta(dMeta);
        inv.setItem(12,deaths);

        ItemStack hours = new ItemStack(Material.CONDUIT,3);
        ItemMeta hMeta = hours.getItemMeta();
        hMeta.setDisplayName(ChatColor.DARK_AQUA+"Отыграно");
        ArrayList<String> hLore = new ArrayList<>();
        getSlotsLore(player,hLore);
        hMeta.setLore(hLore);
        hours.setItemMeta(hMeta);
        inv.setItem(13,hours);

        ItemStack ping = new ItemStack(Material.CONDUIT,4);
        ItemMeta pMeta = ping.getItemMeta();
        pMeta.setDisplayName(ChatColor.DARK_AQUA+"Пинг");
        ArrayList<String> pLore = new ArrayList<>();
        getSlotsLore(player,pLore);
        pMeta.setLore(pLore);
        ping.setItemMeta(pMeta);
        inv.setItem(14,ping);

        ItemStack mobs_killed = new ItemStack(Material.CONDUIT,5);
        ItemMeta mkMeta = mobs_killed.getItemMeta();
        mkMeta.setDisplayName(ChatColor.DARK_AQUA+"Мобов Убито");
        ArrayList<String> mkLore = new ArrayList<>();
        getSlotsLore(player,mkLore);
        mkMeta.setLore(mkLore);
        mobs_killed.setItemMeta(mkMeta);
        inv.setItem(15,mobs_killed);

        ItemStack blocks_break = new ItemStack(Material.CONDUIT,6);
        ItemMeta bbMeta = blocks_break.getItemMeta();
        bbMeta.setDisplayName(ChatColor.DARK_AQUA+"Блоков Сломано");
        ArrayList<String> bbLore = new ArrayList<>();
        getSlotsLore(player,bbLore);
        bbMeta.setLore(bbLore);
        blocks_break.setItemMeta(bbMeta);
        inv.setItem(20,blocks_break);

        ItemStack clan_name = new ItemStack(Material.CONDUIT,7);
        ItemMeta cnMeta = clan_name.getItemMeta();
        cnMeta.setDisplayName(ChatColor.DARK_AQUA+"Имя Клана");
        ArrayList<String> cnLore = new ArrayList<>();
        getSlotsLore(player,cnLore);
        cnMeta.setLore(cnLore);
        clan_name.setItemMeta(cnMeta);
        inv.setItem(21,clan_name);

        ItemStack kd = new ItemStack(Material.CONDUIT,8);
        ItemMeta kdMeta = kd.getItemMeta();
        kdMeta.setDisplayName(ChatColor.DARK_AQUA+"KD");
        ArrayList<String> kdLore = new ArrayList<>();
        getSlotsLore(player,kdLore);
        kdMeta.setLore(kdLore);
        kd.setItemMeta(kdMeta);
        inv.setItem(22,kd);

        ItemStack movement_speed = new ItemStack(Material.CONDUIT,9);
        ItemMeta msMeta = movement_speed.getItemMeta();
        msMeta.setDisplayName(ChatColor.DARK_AQUA+"Скорость бега");
        ArrayList<String> msLore = new ArrayList<>();
        getSlotsLore(player,msLore);
        msMeta.setLore(msLore);
        movement_speed.setItemMeta(msMeta);
        inv.setItem(23,movement_speed);

        return inv;
    }

}
