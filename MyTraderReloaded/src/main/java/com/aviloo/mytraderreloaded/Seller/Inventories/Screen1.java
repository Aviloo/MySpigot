package com.aviloo.mytraderreloaded.Seller.Inventories;

import com.aviloo.mytraderreloaded.Seller.Utils.PlayersStats;
import com.aviloo.mytraderreloaded.Seller.Utils.PriceManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Screen1 {
    public static Inventory sellInventory(Player player){

        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Скупщик "); // от количества пробелов зависит номер типов(1 пробел после названия -1 тип.)

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta red_glassMeta = red_glass.getItemMeta();
        red_glassMeta.setDisplayName("Закрыть");
        red_glass.setItemMeta(red_glassMeta);

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(backMeta);

        /*
        ItemStack leaders = new ItemStack(Material.PLAYER_HEAD,1);
        SkullMeta lMeta = (SkullMeta) leaders.getItemMeta();
        ArrayList<String> lLore = new ArrayList<>();
        PlayersStats.setLeaderLore(lLore,player);
        lMeta.setDisplayName(ChatColor.YELLOW+"Лидер продаж");
        lMeta.setLore(lLore);
        leaders.setItemMeta(lMeta);
         */

        ItemStack reputation = new ItemStack(Material.CHEST_MINECART,1);
        ItemMeta repMeta = reputation.getItemMeta();
        repMeta.setDisplayName(ChatColor.YELLOW+"Репутация у скупщика");
        reputation.setItemMeta(repMeta);

        ItemStack redStone = new ItemStack(Material.REDSTONE,1);
        ItemMeta redMeta = redStone.getItemMeta();
        redMeta.setDisplayName(ChatColor.WHITE+"Редстоун");
        if(PriceManager.isQuantityBlocked("REDSTONE")){
            redStone.setType(Material.BARRIER);
        }
        ArrayList<String> redLore = new ArrayList<>();
        redLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPrice("REDSTONE"));
        redLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 192 монеты");
        redLore.add(" ");
        redLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        redLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        redMeta.setLore(redLore);
        redStone.setItemMeta(redMeta);

        ItemStack gunPowder = new ItemStack(Material.GUNPOWDER,1);
        ItemMeta gunMeta = gunPowder.getItemMeta();
        gunMeta.setDisplayName(ChatColor.WHITE + "Порох");
        ArrayList<String> gunLore = new ArrayList<>();
        gunLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 5 монеты");
        gunLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 320 монеты");
        gunLore.add(" ");
        gunLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        gunLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        gunMeta.setLore(gunLore);
        gunPowder.setItemMeta(gunMeta);

        ItemStack rose = new ItemStack(Material.ROSE_BUSH,1);
        ItemMeta roseMeta = rose.getItemMeta();
        roseMeta.setDisplayName(ChatColor.WHITE+"Роза");
        ArrayList<String> roseLore = new ArrayList<>();
        roseLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 3.5 монеты");
        roseLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 224 монеты");
        roseLore.add(" ");
        roseLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        roseLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        roseMeta.setLore(roseLore);
        rose.setItemMeta(roseMeta);

        ItemStack clay = new ItemStack(Material.CLAY_BALL);
        ItemMeta clayMeta = clay.getItemMeta();
        clayMeta.setDisplayName(ChatColor.WHITE+"Глина");
        ArrayList<String> clayLore = new ArrayList<>();
        clayLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 2.4 монеты");
        clayLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 153.6 монеты");
        clayLore.add(" ");
        clayLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        clayLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        clayMeta.setLore(clayLore);
        clay.setItemMeta(clayMeta);

        ItemStack quartz = new ItemStack(Material.QUARTZ);
        ItemMeta quartzMeta = quartz.getItemMeta();
        quartzMeta.setDisplayName(ChatColor.WHITE+"Квартц");
        ArrayList<String> quartzLore = new ArrayList<>();
        quartzLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 1.5 монеты");
        quartzLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 96 монеты");
        quartzLore.add(" ");
        quartzLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        quartzLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        quartzMeta.setLore(quartzLore);
        quartz.setItemMeta(quartzMeta);

        ItemStack cane = new ItemStack(Material.SUGAR_CANE,1);
        ItemMeta caneMeta = cane.getItemMeta();
        caneMeta.setDisplayName(ChatColor.WHITE+"Тростник");
        ArrayList<String> caneLore = new ArrayList<>();
        caneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 2.1 монеты");
        caneLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 134.4 монеты");
        caneLore.add(" ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        caneMeta.setLore(caneLore);
        cane.setItemMeta(caneMeta);

        ItemStack deadBrush = new ItemStack(Material.DEAD_BUSH,1);
        ItemMeta deadMeta = deadBrush.getItemMeta();
        deadMeta.setDisplayName(ChatColor.WHITE+"Мёртвый куст");
        ArrayList<String> deadLore = new ArrayList<>();
        deadLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 5.1 монеты");
        deadLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 326.4 монеты");
        deadLore.add(" ");
        deadLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        deadLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        deadMeta.setLore(deadLore);
        deadBrush.setItemMeta(deadMeta);

        ItemStack wheat = new ItemStack(Material.WHEAT,1);
        ItemMeta wheatMeta = wheat.getItemMeta();
        wheatMeta.setDisplayName(ChatColor.WHITE+"Пшеница");
        ArrayList<String> wheatLore = new ArrayList<>();
        wheatLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 2.1 монеты");
        wheatLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 134.4 монеты");
        wheatLore.add(" ");
        wheatLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        wheatLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        wheatMeta.setLore(wheatLore);
        wheat.setItemMeta(wheatMeta);

        ItemStack blazePowder = new ItemStack(Material.BLAZE_POWDER,1);
        ItemMeta blazeMeta = blazePowder.getItemMeta();
        blazeMeta.setDisplayName(ChatColor.WHITE+"Порошок блейза");
        ArrayList<String> blazeLore = new ArrayList<>();
        blazeLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 7.3 монеты");
        blazeLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 467.2 монеты");
        blazeLore.add(" ");
        blazeLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        blazeLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        blazeMeta.setLore(blazeLore);
        blazePowder.setItemMeta(blazeMeta);

        ItemStack info = new ItemStack(Material.PAPER,1);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.YELLOW+"Информация");
        ArrayList<String> infoLore = new ArrayList<>();
        infoLore.add(" ");
        infoLore.add(ChatColor.WHITE+"Каждый"+ChatColor.GREEN+" день "+ChatColor.WHITE+", реального времени, ");
        infoLore.add(ChatColor.WHITE+"торговец обновляеться.");
        infoLore.add(" ");
        infoMeta.setLore(infoLore);
        info.setItemMeta(infoMeta);

        inv.setItem(12,redStone);
        inv.setItem(13,gunPowder);
        inv.setItem(14,rose);
        inv.setItem(21,clay);
        inv.setItem(22,quartz);
        inv.setItem(23,cane);
        inv.setItem(30,deadBrush);
        inv.setItem(31,wheat);
        inv.setItem(32,blazePowder);
        inv.setItem(48,back);
        //inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        /*
        ItemStack[] inv_stack = {red_glass,red_glass,red_glass,red_glass,info,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass, redStone, gunPowder,rose,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,clay,quartz,cane,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,deadBrush,wheat,blazePowder,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass};
        inv.setContents(inv_stack);
         */

        return inv;
    }
}
