package me.aviloo.mycrafts.Items;

import me.aviloo.mycrafts.Utils.ColorUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TNTManager {

    public static ItemStack itemRed;
    public static ItemStack itemBlack;

    public static void init(){
        createRed();
        createBlack();
    }

    private static void createRed(){
        ItemStack item = new ItemStack(Material.TNT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&cКрасная роза"));
        meta.addEnchant(Enchantment.ARROW_DAMAGE,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<String>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&fМощь взрыва: 25 блоков."));
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Не нужно огниво для активации."));
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        itemRed = item;
    }

    private static void createBlack(){
        ItemStack item = new ItemStack(Material.TNT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&8Черная роза"));
        meta.addEnchant(Enchantment.ARROW_FIRE,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<String>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&fМощь взрыва: 10 блоков."));
        lore.add(ColorUtils.translateColorCodes("&fЕсли под TNT находится обсидиан, то"));
        lore.add(ColorUtils.translateColorCodes("&fон может уничтожить его."));
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Не нужно огниво для активации."));
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        itemBlack = item;
    }

    public static void spawnRed(Location location) {
        TNTPrimed tnt = location.getWorld().spawn(location,TNTPrimed.class);
        tnt.setCustomNameVisible(true);
        tnt.setCustomName(ColorUtils.translateColorCodes("Красная роза"));
        tnt.setYield(25);
        tnt.setIsIncendiary(true);
        tnt.setFireTicks(80);
        tnt.setIsIncendiary(true);

    }

    public static void spawnBlack(Location location) {
        TNTPrimed tnt = location.getWorld().spawn(location,TNTPrimed.class);
        tnt.setCustomNameVisible(true);
        tnt.setCustomName(ColorUtils.translateColorCodes("Черная роза"));
        tnt.setYield(10);
        tnt.setIsIncendiary(true);
        tnt.setFireTicks(85);
    }
}
