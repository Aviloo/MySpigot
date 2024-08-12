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

public class Screen5 {
    public static Inventory getInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Скупщик");

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

        ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta red_glassMeta = red_glass.getItemMeta();
        red_glassMeta.setDisplayName("Закрыть");
        red_glass.setItemMeta(red_glassMeta);

        ItemStack Stairs = new ItemStack(Material.DIORITE_STAIRS,1);
        ItemMeta stMeta = Stairs.getItemMeta();
        stMeta.setDisplayName(ChatColor.WHITE+"Ступеньки");
        ArrayList<String> stLore = new ArrayList<>();
        stLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("DIORITE_STAIRS"));
        stLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("DIORITE_STAIRS"));
        stLore.add(" ");
        stLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        stLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        stMeta.setLore(stLore);
        Stairs.setItemMeta(stMeta);

        ItemStack salmon = new ItemStack(Material.SALMON,1);
        ItemMeta saMeta = salmon.getItemMeta();
        saMeta.setDisplayName(ChatColor.WHITE+"Лосось");
        ArrayList<String> saLore = new ArrayList<>();
        saLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("SALMON"));
        saLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("SALMON"));
        saLore.add(" ");
        saLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        saLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        saMeta.setLore(saLore);
        salmon.setItemMeta(saMeta);

        ItemStack PUFFERFISH = new ItemStack(Material.PUFFERFISH,1);
        ItemMeta puMeta = PUFFERFISH.getItemMeta();
        puMeta.setDisplayName(ChatColor.WHITE+"Фуга");
        ArrayList<String> puLore = new ArrayList<>();
        puLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("PUFFERFISH"));
        puLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("PUFFERFISH"));
        puLore.add(" ");
        puLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        puLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        puMeta.setLore(puLore);
        PUFFERFISH.setItemMeta(puMeta);

        ItemStack Tropical = new ItemStack(Material.TROPICAL_FISH,1);
        ItemMeta trMeta = Tropical.getItemMeta();
        trMeta.setDisplayName(ChatColor.WHITE+"Тропическая рыба");
        ArrayList<String> trLore = new ArrayList<>();
        trLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("TROPICAL_FISH"));
        trLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("TROPICAL_FISH"));
        trLore.add(" ");
        trLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        trLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        trMeta.setLore(trLore);
        Tropical.setItemMeta(trMeta);

        ItemStack Bowl = new ItemStack(Material.BOWL,1);
        ItemMeta boMeta = Bowl.getItemMeta();
        boMeta.setDisplayName(ChatColor.WHITE+"Миска");
        ArrayList<String> boLore = new ArrayList<>();
        boLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("BOWL"));
        boLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("BOWL"));
        boLore.add(" ");
        boLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        boLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        boMeta.setLore(boLore);
        Bowl.setItemMeta(boMeta);

        ItemStack Leather = new ItemStack(Material.LEATHER,1);
        ItemMeta leMeta = Leather.getItemMeta();
        leMeta.setDisplayName(ChatColor.WHITE+"Кожа");
        ArrayList<String> leLore = new ArrayList<>();
        leLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("LEATHER"));
        leLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("LEATHER"));
        leLore.add(" ");
        leLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        leLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        leMeta.setLore(leLore);
        Leather.setItemMeta(leMeta);

        ItemStack MossBlock = new ItemStack(Material.MOSS_BLOCK,1);
        ItemMeta moMeta = MossBlock.getItemMeta();
        moMeta.setDisplayName(ChatColor.WHITE+"Мох");
        ArrayList<String> moLore = new ArrayList<>();
        moLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("MOSS_BLOCK"));
        moLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("MOSS_BLOCK"));
        moLore.add(" ");
        moLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        moLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        moMeta.setLore(moLore);
        MossBlock.setItemMeta(moMeta);

        ItemStack TubeCoral = new ItemStack(Material.TUBE_CORAL,1);
        ItemMeta tuMeta = TubeCoral.getItemMeta();
        tuMeta.setDisplayName(ChatColor.WHITE+tuMeta.getDisplayName());
        ArrayList<String> tuLore = new ArrayList<>();
        tuLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("TUBE_CORAL"));
        tuLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("TUBE_CORAL"));
        tuLore.add(" ");
        tuLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        tuLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        tuMeta.setLore(tuLore);
        TubeCoral.setItemMeta(tuMeta);

        ItemStack Cane = new ItemStack(Material.SUGAR_CANE,1);
        ItemMeta caneMeta = Cane.getItemMeta();
        caneMeta.setDisplayName(ChatColor.WHITE+"Тростник");
        ArrayList<String> caneLore = new ArrayList<>();
        caneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("SUGAR_CANE"));
        caneLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("SUGAR_CANE"));
        caneLore.add(" ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        caneMeta.setLore(caneLore);
        Cane.setItemMeta(caneMeta);

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

        inv.setItem(12,Stairs);
        inv.setItem(13,salmon);
        inv.setItem(14,PUFFERFISH);
        inv.setItem(21,Tropical);
        inv.setItem(22,Bowl);
        inv.setItem(23,Leather);
        inv.setItem(30,MossBlock);
        inv.setItem(31,TubeCoral);
        inv.setItem(32,Cane);
        inv.setItem(48,back);
        //inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        /*
        ItemStack[] inv_stacks = {red_glass,red_glass,red_glass,red_glass,info,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,Stairs,salmon,PUFFERFISH,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,Tropical,Bowl,Leather,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,MossBlock,TubeCoral,Cane,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass};
        inv.setContents(inv_stacks);
         */
        return inv;
    }
}
