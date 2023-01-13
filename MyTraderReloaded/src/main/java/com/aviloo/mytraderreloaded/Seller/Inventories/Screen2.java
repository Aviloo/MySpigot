package com.aviloo.mytraderreloaded.Seller.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Screen2 {
    public static Inventory sellInventory(Player player){

        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Скупщик  ");

        ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta red_glassMeta = red_glass.getItemMeta();
        red_glassMeta.setDisplayName("Закрыть");
        red_glass.setItemMeta(red_glassMeta);

        ItemStack apple = new ItemStack(Material.APPLE,1);
        ItemMeta appleMeta = apple.getItemMeta();
        appleMeta.setDisplayName(ChatColor.WHITE+ "Яблоко");
        ArrayList<String> appleLore = new ArrayList<>();
        appleLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 4.3 монеты");
        appleLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 275.2 монеты");
        appleLore.add(" ");
        appleLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        appleLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        appleMeta.setLore(appleLore);
        apple.setItemMeta(appleMeta);

        ItemStack sugar = new ItemStack(Material.SUGAR,1);
        ItemMeta sugarMeta = sugar.getItemMeta();
        sugarMeta.setDisplayName(ChatColor.WHITE+"Сахар");
        ArrayList<String> sugarLore = new ArrayList<>();
        sugarLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 5.1 монеты");
        sugarLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 326.4 монеты");
        sugarLore.add(" ");
        sugarLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        sugarLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        sugarMeta.setLore(sugarLore);
        sugar.setItemMeta(sugarMeta);

        ItemStack dragonBreath = new ItemStack(Material.DRAGON_BREATH,1);
        ItemMeta dragonMeta = dragonBreath.getItemMeta();
        dragonMeta.setDisplayName(ChatColor.WHITE + "Дыхание дракона");
        ArrayList<String> dragonLore = new ArrayList<>();
        dragonLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 24 монеты");
        dragonLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 1536 монеты");
        dragonLore.add(" ");
        dragonLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        dragonLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        dragonMeta.setLore(dragonLore);
        dragonBreath.setItemMeta(dragonMeta);

        ItemStack membrane = new ItemStack(Material.PHANTOM_MEMBRANE,1);
        ItemMeta membraneMeta = membrane.getItemMeta();
        membraneMeta.setDisplayName(ChatColor.WHITE+"Чешуя фантома");
        ArrayList<String> membraneLore = new ArrayList<>();
        membraneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 16 монеты");
        membraneLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 1024 монеты");
        membraneLore.add(" ");
        membraneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        membraneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        membraneMeta.setLore(membraneLore);
        membrane.setItemMeta(membraneMeta);

        ItemStack melon = new ItemStack(Material.MELON_SLICE,1);
        ItemMeta melonMeta = melon.getItemMeta();
        melonMeta.setDisplayName(ChatColor.WHITE+"Долька арбуза");
        ArrayList<String> melonLore = new ArrayList<>();
        melonLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 3.3 монеты");
        melonLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 211.2 монеты");
        melonLore.add(" ");
        melonLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        melonLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        melonMeta.setLore(melonLore);
        melon.setItemMeta(melonMeta);

        ItemStack bottle = new ItemStack(Material.GLASS_BOTTLE,1);
        ItemMeta bottleMeta = bottle.getItemMeta();
        bottleMeta.setDisplayName(ChatColor.WHITE+"Пузырёк");
        ArrayList<String> bottleLore = new ArrayList<>();
        bottleLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 2.5 монеты");
        bottleLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 160 монеты");
        bottleLore.add(" ");
        bottleLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        bottleLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        bottleMeta.setLore(bottleLore);
        bottle.setItemMeta(bottleMeta);

        ItemStack ink = new ItemStack(Material.INK_SAC,1);
        ItemMeta inkMeta = ink.getItemMeta();
        inkMeta.setDisplayName(ChatColor.WHITE+"Чернила");
        ArrayList<String> inkLore = new ArrayList<>();
        inkLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 2.7 монеты");
        inkLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 172.8 монеты");
        inkLore.add(" ");
        inkLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        inkLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        inkMeta.setLore(inkLore);
        ink.setItemMeta(inkMeta);

        ItemStack sweet = new ItemStack(Material.SWEET_BERRIES,1);
        ItemMeta sweetMeta = sweet.getItemMeta();
        sweetMeta.setDisplayName(ChatColor.WHITE+"Сладкие ягоды");
        ArrayList<String> sweetLore = new ArrayList<>();
        sweetLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 2.4 монеты");
        sweetLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 153.6 монеты");
        sweetLore.add(" ");
        sweetLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        sweetLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        sweetMeta.setLore(sweetLore);
        sweet.setItemMeta(sweetMeta);

        ItemStack seeds = new ItemStack(Material.WHEAT_SEEDS,1);
        ItemMeta seedsMeta = seeds.getItemMeta();
        seedsMeta.setDisplayName(ChatColor.WHITE+"Семена пшеницы");
        ArrayList<String> seedsLore = new ArrayList<>();
        seedsLore.add(ChatColor.YELLOW+"Цена за 1 штуку - 2.4 монеты");
        seedsLore.add(ChatColor.YELLOW+"Цена за 64 штуку - 153.6 монеты");
        seedsLore.add(" ");
        seedsLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        seedsLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        seedsMeta.setLore(seedsLore);
        seeds.setItemMeta(seedsMeta);

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


        ItemStack[] inv_stack = {red_glass,red_glass,red_glass,red_glass,info,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,apple,sugar,dragonBreath,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,membrane,melon,bottle,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,ink,sweet,seeds,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass};

        inv.setContents(inv_stack);
        return inv;
    }
}
