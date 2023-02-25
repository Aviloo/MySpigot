package com.aviloo.mytraderreloaded.Seller.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Screen3 {
    public static Inventory getInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Скупщик   ");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(backMeta);

        ItemStack leaders = new ItemStack(Material.PLAYER_HEAD,1);
        ItemMeta lMeta = leaders.getItemMeta();
        lMeta.setDisplayName(ChatColor.YELLOW+"Лидеры продаж");
        leaders.setItemMeta(lMeta);

        ItemStack reputation = new ItemStack(Material.CHEST_MINECART,1);
        ItemMeta repMeta = reputation.getItemMeta();
        repMeta.setDisplayName(ChatColor.YELLOW+"Репутация у скупщика");
        reputation.setItemMeta(repMeta);

        ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta red_glassMeta = red_glass.getItemMeta();
        red_glassMeta.setDisplayName("Закрыть");
        red_glass.setItemMeta(red_glassMeta);

        ItemStack RawCod = new ItemStack(Material.COOKED_COD,1);
        ItemMeta RawMeta = RawCod.getItemMeta();
        RawMeta.setDisplayName(ChatColor.WHITE+"Приготовленная треска");
        ArrayList<String> RawLore = new ArrayList<>();
        RawLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 3.3 монеты");
        RawLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 211.2 монеты");
        RawLore.add(" ");
        RawLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        RawLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        RawMeta.setLore(RawLore);
        RawCod.setItemMeta(RawMeta);

        ItemStack spiderEye = new ItemStack(Material.SPIDER_EYE,1);
        ItemMeta EyeMeta = spiderEye.getItemMeta();
        EyeMeta.setDisplayName(ChatColor.WHITE+"Глаз паука");
        ArrayList<String> EyeLore = new ArrayList<>();
        EyeLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 5.1 монеты");
        EyeLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 326.4 монеты");
        EyeLore.add(" ");
        EyeLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        EyeLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        EyeMeta.setLore(EyeLore);
        spiderEye.setItemMeta(EyeMeta);

        ItemStack cobblestone = new ItemStack(Material.COBBLESTONE,1);
        ItemMeta cobleMeta = cobblestone.getItemMeta();
        cobleMeta.setDisplayName(ChatColor.WHITE+"Булыжник");
        ArrayList<String> cobleLore = new ArrayList<>();
        cobleLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 0.5 монеты");
        cobleLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 32 монет");
        cobleLore.add(" ");
        cobleLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        cobleLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        cobleMeta.setLore(cobleLore);
        cobblestone.setItemMeta(cobleMeta);

        ItemStack MagmaBlock = new ItemStack(Material.MAGMA_BLOCK,1);
        ItemMeta magmaMeta = MagmaBlock.getItemMeta();
        magmaMeta.setDisplayName(ChatColor.WHITE+"Магма");
        ArrayList<String> magmaLore = new ArrayList<>();
        magmaLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 1.5 монеты");
        magmaLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 96 монет");
        magmaLore.add(" ");
        magmaLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        magmaLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        magmaMeta.setLore(magmaLore);
        MagmaBlock.setItemMeta(magmaMeta);

        ItemStack Cane = new ItemStack(Material.SUGAR_CANE,1);
        ItemMeta caneMeta = Cane.getItemMeta();
        caneMeta.setDisplayName(ChatColor.WHITE+"Тростник");
        ArrayList<String> caneLore = new ArrayList<>();
        caneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 2.1 монеты");
        caneLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 134.4 монеты");
        caneLore.add(" ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        caneMeta.setLore(caneLore);
        Cane.setItemMeta(caneMeta);

        ItemStack String = new ItemStack(Material.STRING,1);
        ItemMeta strMeta = String.getItemMeta();
        strMeta.setDisplayName(ChatColor.WHITE+"Нить");
        ArrayList<String> strLore = new ArrayList<>();
        strLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 1.9 монеты");
        strLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 121.6 монет");
        strLore.add(" ");
        strLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        strLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        strMeta.setLore(strLore);
        String.setItemMeta(strMeta);

        ItemStack Sand = new ItemStack(Material.SAND,1);
        ItemMeta sandMeta = Sand.getItemMeta();
        sandMeta.setDisplayName(ChatColor.WHITE+"Песок");
        ArrayList<String> sandLore = new ArrayList<>();
        sandLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 0.4 монеты");
        sandLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 25.6 монет");
        sandLore.add(" ");
        sandLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        sandLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        sandMeta.setLore(sandLore);
        Sand.setItemMeta(sandMeta);

        ItemStack Coal = new ItemStack(Material.COAL,1);
        ItemMeta coalMeta = Coal.getItemMeta();
        coalMeta.setDisplayName(ChatColor.WHITE+"Уголь");
        ArrayList<String> coalLore = new ArrayList<>();
        coalLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 1 монеты");
        coalLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 64 монеты");
        coalLore.add(" ");
        coalLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        coalLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        coalMeta.setLore(caneLore);
        Coal.setItemMeta(coalMeta);

        ItemStack Arrow = new ItemStack(Material.ARROW,1);
        ItemMeta arrowMeta = Arrow.getItemMeta();
        arrowMeta.setDisplayName(ChatColor.WHITE+"Стрела");
        ArrayList<String> arrowLore = new ArrayList<>();
        arrowLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 4.3 монеты");
        arrowLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 275.2 монеты");
        arrowLore.add(" ");
        arrowLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        arrowLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        arrowMeta.setLore(arrowLore);
        Arrow.setItemMeta(arrowMeta);

        ItemStack info = new ItemStack(Material.PAPER,1);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.YELLOW+"            Информация");
        ArrayList<String> infoLore = new ArrayList<>();
        infoLore.add(" ");
        infoLore.add(ChatColor.WHITE+"Каждый"+ChatColor.GREEN+" день "+ChatColor.WHITE+", реального времени, ");
        infoLore.add(ChatColor.WHITE+"торговец обновляеться.");
        infoLore.add(" ");
        infoMeta.setLore(infoLore);
        info.setItemMeta(infoMeta);

        inv.setItem(12,RawCod);
        inv.setItem(13,spiderEye);
        inv.setItem(14,cobblestone);
        inv.setItem(21,MagmaBlock);
        inv.setItem(22,Cane);
        inv.setItem(23,String);
        inv.setItem(30,Sand);
        inv.setItem(31,Coal);
        inv.setItem(32,Arrow);
        inv.setItem(53,back);
        inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        /*
        ItemStack[] inv_stacks = {red_glass,red_glass,red_glass,red_glass,info,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,RawCod,spiderEye,cobblestone,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,MagmaBlock,Cane,String,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,Sand,Coal,Arrow,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass};
        inv.setContents(inv_stacks);
         */

        return inv;
    }
}
