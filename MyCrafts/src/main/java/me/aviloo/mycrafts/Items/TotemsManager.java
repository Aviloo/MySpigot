package me.aviloo.mycrafts.Items;

import me.aviloo.mycrafts.Utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TotemsManager {

    public static ItemStack getTotemOfAgility(){
        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&aТотем ловкости"));
        AttributeModifier attackSpeedModifier = new AttributeModifier("attackSpeedModifier",0.1, AttributeModifier.Operation.ADD_NUMBER);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,attackSpeedModifier);
        meta.addEnchant(Enchantment.DIG_SPEED,1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<String>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7При использовании:"));
        lore.add(ColorUtils.translateColorCodes("&7- Накладывает эффект «Скорость» на 10 сек."));
        lore.add(ColorUtils.translateColorCodes("&7- Накладывает эффект «Прыгучесть» на 10 сек."));
        lore.add(ColorUtils.translateColorCodes("&7- Создает теневую завесу."));
        lore.add(ColorUtils.translateColorCodes("&7- Накладывает эффект «Тьма» на 15 секунд"));
        lore.add(ColorUtils.translateColorCodes("&7на всех игроков в радиусе 10 блоков."));
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Когда в руке:"));
        lore.add(ColorUtils.translateColorCodes("&9+0.1 Скорость атаки"));
        lore.add(" ");

        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getTotemOfStrength(){
        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&cТотем силы"));
        AttributeModifier damageModifier = new AttributeModifier("damageModifier",1.0, AttributeModifier.Operation.ADD_NUMBER);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damageModifier);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD,1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<String>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7При использовании:"));
        lore.add(ColorUtils.translateColorCodes("&7- Накладывает эффект «Cила» на 10 сек."));
        lore.add(ColorUtils.translateColorCodes("&7- Накладывает эффект «Сопротивление» на 10 сек."));
        lore.add(ColorUtils.translateColorCodes("&7- Накладывает эффект " +
                "&7«Слабость» и «Медлительность» на 6 секунд"));
        lore.add(ColorUtils.translateColorCodes("&7на всех игроков в радиусе 10 блоков."));
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Когда в руке:"));
        lore.add(ColorUtils.translateColorCodes("&9+1 Урон"));
        lore.add(" ");

        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getTotemOfPower(){
        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&eТотем мощи"));
        AttributeModifier knockbackModifier = new AttributeModifier("knockbackModifier",1.0, AttributeModifier.Operation.ADD_NUMBER);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK,knockbackModifier);
        meta.addEnchant(Enchantment.ARROW_KNOCKBACK,1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<String>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7При использовании:"));
        lore.add(ColorUtils.translateColorCodes("&7- Накладывает эффект «Сопротивление» на 10 сек."));
        lore.add(ColorUtils.translateColorCodes("&7- Отталкивает всех игроков от использовавшего "));
        lore.add(ColorUtils.translateColorCodes("&7в радиусе 10 блоков."));
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Когда в руке:"));
        lore.add(ColorUtils.translateColorCodes("&9+1 Отбрасывающая атака"));
        lore.add(" ");

        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
