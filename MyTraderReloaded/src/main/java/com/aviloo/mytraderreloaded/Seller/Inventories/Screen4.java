package com.aviloo.mytraderreloaded.Seller.Inventories;

import com.aviloo.mytraderreloaded.Seller.Utils.PriceManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Screen4 {
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

        ItemStack Zombie = new ItemStack(Material.ROTTEN_FLESH,1);
        ItemMeta zombieMeta = Zombie.getItemMeta();
        zombieMeta.setDisplayName(ChatColor.WHITE+"Гнилая плоть");
        ArrayList<String> zombieLore = new ArrayList<>();
        zombieLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("ROTTEN_FLESH"));
        zombieLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("ROTTEN_FLESH"));
        zombieLore.add(" ");
        zombieLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        zombieLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        zombieMeta.setLore(zombieLore);
        Zombie.setItemMeta(zombieMeta);

        ItemStack Kelp = new ItemStack(Material.DRIED_KELP,1);
        ItemMeta kelpMeta = Kelp.getItemMeta();
        kelpMeta.setDisplayName(ChatColor.WHITE+"Ламинария");
        ArrayList<String> kelpLore = new ArrayList<>();
        kelpLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("DRIED_KELP"));
        kelpLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("DRIED_KELP"));
        kelpLore.add(" ");
        kelpLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        kelpLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        kelpMeta.setLore(kelpLore);
        Kelp.setItemMeta(kelpMeta);

        ItemStack WarpedPlants = new ItemStack(Material.WARPED_PLANKS,1);
        ItemMeta plantsMeta = WarpedPlants.getItemMeta();
        plantsMeta.setDisplayName(ChatColor.WHITE+"Warped Planks");
        ArrayList<String> plantsLore = new ArrayList<>();
        plantsLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("WARPED_PLANKS"));
        plantsLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("WARPED_PLANKS"));
        plantsLore.add(" ");
        plantsLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        plantsLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        plantsMeta.setLore(plantsLore);
        WarpedPlants.setItemMeta(plantsMeta);

        ItemStack Honey = new ItemStack(Material.HONEY_BOTTLE,1);
        ItemMeta HoneyMeta = Honey.getItemMeta();
        HoneyMeta.setDisplayName(ChatColor.WHITE+"Бутылочка Мёда");
        ArrayList<String> HoneyLore = new ArrayList<>();
        HoneyLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("HONEY_BOTTLE"));
        HoneyLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("HONEY_BOTTLE"));
        HoneyLore.add(" ");
        HoneyLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        HoneyLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        HoneyMeta.setLore(HoneyLore);
        Honey.setItemMeta(HoneyMeta);

        ItemStack Rail = new ItemStack(Material.RAIL,1);
        ItemMeta railMeta = Rail.getItemMeta();
        railMeta.setDisplayName(ChatColor.WHITE+"Рельса");
        ArrayList<String> railLore = new ArrayList<>();
        railLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("RAIL"));
        railLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("RAIL"));
        railLore.add(" ");
        railLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        railLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        railMeta.setLore(railLore);
        Rail.setItemMeta(railMeta);

        ItemStack Cane = new ItemStack(Material.SUGAR_CANE,1);
        ItemMeta caneMeta = Cane.getItemMeta();
        caneMeta.setDisplayName(ChatColor.WHITE+"Тростник");
        ArrayList<String> caneLore = new ArrayList<>();
        caneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("SUGAR_CANE"));
        caneLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("SUGAR_CANE"));
        caneLore.add(" ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        caneMeta.setLore(caneLore);
        Cane.setItemMeta(caneMeta);

        ItemStack Shell = new ItemStack(Material.SHULKER_SHELL,1);
        ItemMeta shellMeta = Shell.getItemMeta();
        shellMeta.setDisplayName(ChatColor.WHITE+"Панцирь шалкера");
        ArrayList<String> shellLore = new ArrayList<>();
        shellLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("SHULKER_SHELL"));
        shellLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("SHULKER_SHELL"));
        shellLore.add(" ");
        shellLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        shellLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        shellMeta.setLore(shellLore);
        Shell.setItemMeta(shellMeta);

        ItemStack Bone = new ItemStack(Material.BONE,1);
        ItemMeta boneMeta = Bone.getItemMeta();
        boneMeta.setDisplayName(ChatColor.WHITE+"Кость");
        ArrayList<String> boneLore = new ArrayList<>();
        boneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("BONE"));
        boneLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("BONE"));
        boneLore.add(" ");
        boneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        boneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        boneMeta.setLore(boneLore);
        Bone.setItemMeta(boneMeta);

        ItemStack BlockCopper = new ItemStack(Material.COPPER_BLOCK,1);
        ItemMeta copperMeta = BlockCopper.getItemMeta();
        copperMeta.setDisplayName(ChatColor.WHITE+"Блок меди");
        ArrayList<String> copperLore = new ArrayList<>();
        copperLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("COPPER_BLOCK"));
        copperLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("COPPER_BLOCK"));
        copperLore.add(" ");
        copperLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        copperLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        copperMeta.setLore(copperLore);
        BlockCopper.setItemMeta(copperMeta);

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

        inv.setItem(12,Zombie);
        inv.setItem(13,Kelp);
        inv.setItem(14,WarpedPlants);
        inv.setItem(21,Honey);
        inv.setItem(22,Rail);
        inv.setItem(23,Cane);
        inv.setItem(30,Shell);
        inv.setItem(31,Bone);
        inv.setItem(32,BlockCopper);
        inv.setItem(48,back);
        //inv.setItem(48,leaders);
        inv.setItem(49,info);
        inv.setItem(50,reputation);

        /*
        ItemStack[] inv_stacks = {red_glass,red_glass,red_glass,red_glass,info,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,Zombie,Kelp,WarpedPlants,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,Honey,Rail,Cane,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,Shell,Bone,BlockCopper,red_glass,red_glass,red_glass,
                red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass,red_glass};
        inv.setContents(inv_stacks);
         */

        return inv;
    }
}
