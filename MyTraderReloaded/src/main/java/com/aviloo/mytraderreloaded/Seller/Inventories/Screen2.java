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

public class Screen2 {
    public static Inventory sellInventory(Player player){

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

        ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta red_glassMeta = red_glass.getItemMeta();
        red_glassMeta.setDisplayName("Закрыть");
        red_glass.setItemMeta(red_glassMeta);

        ItemStack apple = new ItemStack(Material.APPLE,1);
        ItemMeta appleMeta = apple.getItemMeta();
        appleMeta.setDisplayName(ChatColor.WHITE+ "Яблоко");
        ArrayList<String> appleLore = new ArrayList<>();
        appleLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("APPLE"));
        appleLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("APPLE"));
        appleLore.add(" ");
        appleLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        appleLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        appleMeta.setLore(appleLore);
        apple.setItemMeta(appleMeta);

        ItemStack sugar = new ItemStack(Material.SUGAR,1);
        ItemMeta sugarMeta = sugar.getItemMeta();
        sugarMeta.setDisplayName(ChatColor.WHITE+"Сахар");
        ArrayList<String> sugarLore = new ArrayList<>();
        sugarLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("SUGAR"));
        sugarLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("SUGAR"));
        sugarLore.add(" ");
        sugarLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        sugarLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        sugarMeta.setLore(sugarLore);
        sugar.setItemMeta(sugarMeta);

        ItemStack dragonBreath = new ItemStack(Material.DRAGON_BREATH,1);
        ItemMeta dragonMeta = dragonBreath.getItemMeta();
        dragonMeta.setDisplayName(ChatColor.WHITE + "Дыхание дракона");
        ArrayList<String> dragonLore = new ArrayList<>();
        dragonLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("DRAGON_BREATH"));
        dragonLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("DRAGON_BREATH"));
        dragonLore.add(" ");
        dragonLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        dragonLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        dragonMeta.setLore(dragonLore);
        dragonBreath.setItemMeta(dragonMeta);

        ItemStack membrane = new ItemStack(Material.PHANTOM_MEMBRANE,1);
        ItemMeta membraneMeta = membrane.getItemMeta();
        membraneMeta.setDisplayName(ChatColor.WHITE+"Чешуя фантома");
        ArrayList<String> membraneLore = new ArrayList<>();
        membraneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("PHANTOM_MEMBRANE"));
        membraneLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("PHANTOM_MEMBRANE"));
        membraneLore.add(" ");
        membraneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        membraneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        membraneMeta.setLore(membraneLore);
        membrane.setItemMeta(membraneMeta);

        ItemStack melon = new ItemStack(Material.MELON_SLICE,1);
        ItemMeta melonMeta = melon.getItemMeta();
        melonMeta.setDisplayName(ChatColor.WHITE+"Долька арбуза");
        ArrayList<String> melonLore = new ArrayList<>();
        melonLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("MELON_SLICE"));
        melonLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("MELON_SLICE"));
        melonLore.add(" ");
        melonLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        melonLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        melonMeta.setLore(melonLore);
        melon.setItemMeta(melonMeta);

        ItemStack bottle = new ItemStack(Material.GLASS_BOTTLE,1);
        ItemMeta bottleMeta = bottle.getItemMeta();
        bottleMeta.setDisplayName(ChatColor.WHITE+"Пузырёк");
        ArrayList<String> bottleLore = new ArrayList<>();
        bottleLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("GLASS_BOTTLE"));
        bottleLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("GLASS_BOTTLE"));
        bottleLore.add(" ");
        bottleLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        bottleLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        bottleMeta.setLore(bottleLore);
        bottle.setItemMeta(bottleMeta);

        ItemStack ink = new ItemStack(Material.INK_SAC,1);
        ItemMeta inkMeta = ink.getItemMeta();
        inkMeta.setDisplayName(ChatColor.WHITE+"Чернила");
        ArrayList<String> inkLore = new ArrayList<>();
        inkLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("INK_SAC"));
        inkLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("INK_SAC"));
        inkLore.add(" ");
        inkLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        inkLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        inkMeta.setLore(inkLore);
        ink.setItemMeta(inkMeta);

        ItemStack sweet = new ItemStack(Material.SWEET_BERRIES,1);
        ItemMeta sweetMeta = sweet.getItemMeta();
        sweetMeta.setDisplayName(ChatColor.WHITE+"Сладкие ягоды");
        ArrayList<String> sweetLore = new ArrayList<>();
        sweetLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("SWEET_BERRIES"));
        sweetLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("SWEET_BERRIES"));
        sweetLore.add(" ");
        sweetLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        sweetLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        sweetMeta.setLore(sweetLore);
        sweet.setItemMeta(sweetMeta);

        ItemStack seeds = new ItemStack(Material.WHEAT_SEEDS,1);
        ItemMeta seedsMeta = seeds.getItemMeta();
        seedsMeta.setDisplayName(ChatColor.WHITE+"Семена пшеницы");
        ArrayList<String> seedsLore = new ArrayList<>();
        seedsLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("WHEAT_SEEDS"));
        seedsLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("WHEAT_SEEDS"));
        seedsLore.add(" ");
        seedsLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        seedsLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        seedsMeta.setLore(seedsLore);
        seeds.setItemMeta(seedsMeta);

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

        inv.setItem(12,apple);
        inv.setItem(13,sugar);
        inv.setItem(14,dragonBreath);
        inv.setItem(21,membrane);
        inv.setItem(22,melon);
        inv.setItem(23,bottle);
        inv.setItem(30,ink);
        inv.setItem(31,sweet);
        inv.setItem(32,seeds);
        inv.setItem(48,back);
        //inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        /*
        ItemStack[] inv_stack = {red_glass,red_glass,red_glass,red_glass,info,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,apple,sugar,dragonBreath,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,membrane,melon,bottle,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,ink,sweet,seeds,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass};

        inv.setContents(inv_stack);
         */

        return inv;
    }
}
