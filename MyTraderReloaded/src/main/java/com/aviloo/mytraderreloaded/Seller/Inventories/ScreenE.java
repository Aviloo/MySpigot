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

public class ScreenE {

    public static Inventory getInventory(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.DARK_PURPLE+"Эпический скупщик");

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

        //Main Items

        ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta red_glassMeta = red_glass.getItemMeta();
        red_glassMeta.setDisplayName("Закрыть");
        red_glass.setItemMeta(red_glassMeta);

        ItemStack diamond = new ItemStack(Material.DIAMOND,1);
        ItemMeta dMeta = diamond.getItemMeta();
        dMeta.setDisplayName(ChatColor.WHITE+"Алмаз");
        ArrayList<String> dLore = new ArrayList<>();
        dLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("DIAMOND"));
        dLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("DIAMOND"));
        dLore.add(" ");
        dLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        dLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        dMeta.setLore(dLore);
        diamond.setItemMeta(dMeta);

        ItemStack blaze = new ItemStack(Material.BLAZE_ROD,1);
        ItemMeta bMeta = blaze.getItemMeta();
        bMeta.setDisplayName(ChatColor.WHITE+"Стержень блейза");
        ArrayList<String> bLore = new ArrayList<>();
        bLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("BLAZE_ROD"));
        bLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("BLAZE_ROD"));
        bLore.add(" ");
        bLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        bLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        bMeta.setLore(bLore);
        blaze.setItemMeta(bMeta);

        ItemStack tnt = new ItemStack(Material.TNT,1);
        ItemMeta tMeta = tnt.getItemMeta();
        tMeta.setDisplayName(ChatColor.WHITE+"Динамит");
        ArrayList<String> tLore = new ArrayList<>();
        tLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("TNT"));
        tLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("TNT"));
        tLore.add(" ");
        tLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        tLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        tMeta.setLore(tLore);
        tnt.setItemMeta(tMeta);

        ItemStack breath = new ItemStack(Material.DRAGON_BREATH,1);
        ItemMeta brMeta = breath.getItemMeta();
        brMeta.setDisplayName(ChatColor.WHITE+"Дыхание дракона");
        ArrayList<String> brLore = new ArrayList<>();
        brLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("DRAGON_BREATH"));
        brLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("DRAGON_BREATH"));
        brLore.add(" ");
        brLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        brLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        brMeta.setLore(brLore);
        breath.setItemMeta(brMeta);

        ItemStack brick = new ItemStack(Material.BRICK,1);
        ItemMeta briMeta = brick.getItemMeta();
        briMeta.setDisplayName(ChatColor.WHITE+"Кирпич");
        ArrayList<String> briLore = new ArrayList<>();
        briLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("BRICK"));
        briLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("BRICK"));
        briLore.add(" ");
        briLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        briLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        briMeta.setLore(briLore);
        brick.setItemMeta(briMeta);

        ItemStack nuggets = new ItemStack(Material.GOLD_NUGGET,1);
        ItemMeta nMeta = nuggets.getItemMeta();
        nMeta.setDisplayName(ChatColor.WHITE+"Кусочек золота");
        ArrayList<String> nLore = new ArrayList<>();
        nLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("GOLD_NUGGET"));
        nLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("GOLD_NUGGET"));
        nLore.add(" ");
        nLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        nLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        nMeta.setLore(nLore);
        nuggets.setItemMeta(nMeta);

        ItemStack zHead = new ItemStack(Material.ZOMBIE_HEAD,1);
        ItemMeta zMeta = zHead.getItemMeta();
        zMeta.setDisplayName(ChatColor.WHITE+"Голова зомби");
        ArrayList<String> zLore = new ArrayList<>();
        zLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("ZOMBIE_HEAD"));
        zLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("ZOMBIE_HEAD"));
        zLore.add(" ");
        zLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        zLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        zMeta.setLore(zLore);
        zHead.setItemMeta(zMeta);

        ItemStack shell = new ItemStack(Material.SHULKER_SHELL,1);
        ItemMeta sMeta = shell.getItemMeta();
        sMeta.setDisplayName(ChatColor.WHITE+"Панцирь шалкера");
        ArrayList<String> sLore = new ArrayList<>();
        sLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("SHULKER_SHELL"));
        sLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("SHULKER_SHELL"));
        sLore.add(" ");
        sLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        sLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        sMeta.setLore(sLore);
        shell.setItemMeta(sMeta);

        ItemStack heart = new ItemStack(Material.HEART_OF_THE_SEA,1);
        ItemMeta hMeta = heart.getItemMeta();
        hMeta.setDisplayName(ChatColor.WHITE+"Сердце моря");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("HEART_OF_THE_SEA"));
        hLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("HEART_OF_THE_SEA"));
        hLore.add(" ");
        hLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        hLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        hLore.add(" ");
        hLore.add(ChatColor.GOLD+"Это особенный товар!");
        hLore.add(ChatColor.WHITE+"Снижение цены произойдет после 3-х");
        hLore.add(ChatColor.WHITE+"проданных ед. этого товара!");
        hLore.add(ChatColor.WHITE+"Продать можно "+ChatColor.RED+"только "+ChatColor.WHITE+"9 ед. этого товара.");
        hLore.add(ChatColor.WHITE+"Поспешите ;)");
        hLore.add(" ");
        hMeta.setLore(hLore);
        heart.setItemMeta(hMeta);

        ItemStack info = new ItemStack(Material.PAPER,1);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.YELLOW+"Информация");
        ArrayList<String> infoLore = new ArrayList<>();
        infoLore.add(" ");
        infoLore.add(ChatColor.YELLOW+"➤"+ChatColor.WHITE+"Каждый"+ChatColor.GREEN+" день "+ChatColor.WHITE+
                ", реального времени, ");
        infoLore.add(ChatColor.WHITE+"торговец обновляеться.");
        infoLore.add(" ");
        infoLore.add(ChatColor.YELLOW+"➤"+ChatColor.WHITE+"Очки репутации можно ");
        infoLore.add(ChatColor.WHITE+"получить продавая предметы скупщику ");
        infoLore.add(" ");
        infoLore.add(ChatColor.YELLOW+"➤"+ChatColor.WHITE+"Если продать сразу 64 ед.");
        infoLore.add(ChatColor.WHITE+"товара, получите дополнительно 9 монет. ");
        infoLore.add(" ");
        infoMeta.setLore(infoLore);
        info.setItemMeta(infoMeta);

        inv.setItem(12,diamond);
        inv.setItem(13,blaze);
        inv.setItem(14,tnt);
        inv.setItem(21,breath);
        inv.setItem(22,brick);
        inv.setItem(23,shell);
        inv.setItem(30,zHead);
        inv.setItem(31,nuggets);
        inv.setItem(32,heart);
        inv.setItem(48,back);
        //inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        /*
        ItemStack[] inv_stacks = {red_glass,red_glass,red_glass,red_glass,info,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,diamond,blaze,tnt,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,breath,brick,shell,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,zHead,nuggets,heart,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass};
        inv.setContents(inv_stacks);
         */
        return inv;
    }
}
