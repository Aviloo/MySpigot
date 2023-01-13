package com.aviloo.mytraderreloaded.DonateShop.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ShieldInventory implements Listener {

    private static final ConcurrentHashMap<Player,Boolean> absorptionStatus = new ConcurrentHashMap<>();
    public static void setAbsorptionStatus(Player player,Boolean bool){
        absorptionStatus.put(player,bool);
    }

    private static final ConcurrentHashMap<Player,Boolean> speedStatus = new ConcurrentHashMap<>();
    public static void setSpeedStatus(Player player,Boolean bool){
        speedStatus.put(player,bool);
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Особые щиты");

        ItemStack empty = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta eMeta = empty.getItemMeta();
        eMeta.setDisplayName("Выход");
        empty.setItemMeta(eMeta);

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName("Назад");
        back.setItemMeta(bMeta);

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack barrier1 = new ItemStack(Material.BARRIER,5);
        ItemMeta b1Meta = barrier1.getItemMeta();
        b1Meta.setDisplayName(ChatColor.YELLOW+"Отсутствует");
        barrier1.setItemMeta(b1Meta);
        ItemStack barrier2 = new ItemStack(Material.BARRIER,6);
        ItemMeta b2Meta = barrier2.getItemMeta();
        b2Meta.setDisplayName(ChatColor.YELLOW+"Отсутствует");
        barrier2.setItemMeta(b2Meta);

        ItemStack absorption = new ItemStack(Material.SHIELD,7);
        ItemMeta aMeta = absorption.getItemMeta();
        aMeta.setDisplayName(ChatColor.YELLOW+"Щиты Поглощения");
        aMeta.addEnchant(Enchantment.LUCK,1,true);
        aMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> aLore = new ArrayList<>();
        MainInventory.loreEditor(aLore," ",
                "&fКликните,чтобы узнать подробнее.",
                " ");
        aMeta.setLore(aLore);
        absorption.setItemMeta(aMeta);

        ItemStack aFirst = new ItemStack(Material.SHIELD,1);
        ItemMeta afMeta = aFirst.getItemMeta();
        afMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&eЩит Поглощения &7(Ур.1)"));
        afMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS,1,true);
        afMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> afLore = new ArrayList<>();
        MainInventory.loreEditor(afLore," ",
                "&7Уровень предмета: 1",
                "&7Характеристики: ",
                "&7- добавляет 3 единицы брони",
                "&7- -0,01 единицы скорости передвижения",
                " ",
                "&fСтоимость: &615 Орури",
                "&fили &630000 Монет.",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        afMeta.setLore(afLore);
        aFirst.setItemMeta(afMeta);

        ItemStack aSecond = new ItemStack(Material.SHIELD,2);
        ItemMeta asMeta = aSecond.getItemMeta();
        asMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&eЩит Поглощения &7(Ур.2)"));
        asMeta.addEnchant(Enchantment.KNOCKBACK,1,true);
        asMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> asLore = new ArrayList<>();
        MainInventory.loreEditor(asLore," ",
                "&7Уровень предмета: 2",
                "&7Характеристики: ",
                "&7- добавляет 7 единицы брони",
                "&7- -0,014 единицы скорости передвижения",
                " ",
                "&fСтоимость: &630 Орури",
                "&fили &665000 Монет.",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        asMeta.setLore(asLore);
        aSecond.setItemMeta(asMeta);

        ItemStack aThird = new ItemStack(Material.SHIELD,3);
        ItemMeta atMeta = aThird.getItemMeta();
        atMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&eЩит Поглощения &7(Ур.3)"));
        atMeta.addEnchant(Enchantment.FIRE_ASPECT,1,true);
        atMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> atLore = new ArrayList<>();
        MainInventory.loreEditor(atLore," ",
                "&7Уровень предмета: 3",
                "&7Характеристики: ",
                "&7- добавляет 9 единицы брони",
                "&7- -0,014 единицы скорости передвижения",
                " ",
                "&fСтоимость: &640 Орури",
                "&fили &685000 Монет.",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        atMeta.setLore(atLore);
        aThird.setItemMeta(atMeta);

        ItemStack speed = new ItemStack(Material.SHIELD,8);
        ItemMeta sMeta = speed.getItemMeta();
        sMeta.setDisplayName(ChatColor.YELLOW+"Щиты Скорости");
        sMeta.addEnchant(Enchantment.DIG_SPEED,1,true);
        sMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> sLore = new ArrayList<>();
        MainInventory.loreEditor(sLore," ",
                "&fКликните,чтобы узнать подробнее.",
                " ");
        sMeta.setLore(sLore);
        speed.setItemMeta(sMeta);

        ItemStack sFirst = new ItemStack(Material.SHIELD,4);
        ItemMeta sfMeta = sFirst.getItemMeta();
        sfMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&eЩит Скорости &7(Ур.1)"));
        sfMeta.addEnchant(Enchantment.ARROW_FIRE,1,true);
        sfMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> sfLore = new ArrayList<>();
        MainInventory.loreEditor(sfLore," ",
                "&7Уровень предмета: 1",
                "&7Характеристики: ",
                "&7- добавляет 0.7 скорости атаки",
                "&7- -0,025 единицы скорости передвижения",
                " ",
                "&fСтоимость: &615 Орури",
                "&fили &630000 Монет.",
                " ",
                "&fКликните, чтобы купить.",
                "&fЛКМ - купить за Орури.",
                "&fПКМ - купить за Монеты.",
                " ");
        sfMeta.setLore(sfLore);
        sFirst.setItemMeta(sfMeta);

        if(!absorptionStatus.get(player) && !speedStatus.get(player)){
            ItemStack[] inv_stack = {empty,air,air,air,air,air,air,air,empty,
                    empty,air,air,air,back,air,air,air,empty,
                    air,air,air,absorption,air,air,air,air,air,
                    air,air,air,speed,air,air,air,air,air,
                    empty,air,air,air,air,air,air,air,empty,
                    empty,air,air,air,air,air,air,air,empty};
            inv.setContents(inv_stack);
        }
        if(!absorptionStatus.get(player) && speedStatus.get(player)){
            ItemStack[] inv_stack = {empty,air,air,air,air,air,air,air,empty,
                    empty,air,air,air,back,air,air,air,empty,
                    air,air,air,absorption,air,air,air,air,air,
                    air,air,air,sFirst,barrier1,barrier2,air,air,air,
                    empty,air,air,air,air,air,air,air,empty,
                    empty,air,air,air,air,air,air,air,empty};
            inv.setContents(inv_stack);
        }
        if(absorptionStatus.get(player) && !speedStatus.get(player)){
            ItemStack[] inv_stack = {empty,air,air,air,air,air,air,air,empty,
                    empty,air,air,air,back,air,air,air,empty,
                    air,air,air,aFirst,aSecond,aThird,air,air,air,
                    air,air,air,speed,air,air,air,air,air,
                    empty,air,air,air,air,air,air,air,empty,
                    empty,air,air,air,air,air,air,air,empty};
            inv.setContents(inv_stack);
        }
        return inv;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        setSpeedStatus(event.getPlayer(), false);
        setAbsorptionStatus(event.getPlayer(), false);
    }
}
