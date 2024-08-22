package me.aviloo.mycrafts.Items;

import com.sun.jna.platform.unix.X11;
import me.aviloo.mycrafts.MyCrafts;
import me.aviloo.mycrafts.Utils.ColorUtils;
import me.aviloo.mycrafts.Utils.SkullUtils;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SphereManager {

    private static FileConfiguration items =
            MyCrafts.getPlugin().itemsFileManager.getItemsConfig();

    public static ItemStack getSphereEnd() {
        ItemStack item = SkullUtils.
                getSkullByBase64EncodedTextureUrl(items.getString("first_sphere_url")).clone();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&5Сфера Энда"));
        AttributeModifier speedModifier = new AttributeModifier("speedModifier",0.09, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier attackSpeedModifier = new AttributeModifier("attackSpeedModifier",0.5, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armorModifier = new AttributeModifier("armorModifier",-1.5, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier damageModifier = new AttributeModifier("damageModifier",-1.0, AttributeModifier.Operation.ADD_NUMBER);

        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED,speedModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,attackSpeedModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR,armorModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Когда в руке:"));
        lore.add(ColorUtils.translateColorCodes("&9+0.5 Скорость атаки"));
        lore.add(ColorUtils.translateColorCodes("&9+0.09 Скорость"));
        lore.add(ColorUtils.translateColorCodes("&c-1 Урон"));
        lore.add(ColorUtils.translateColorCodes("&c-1.5 Броня"));
        lore.add(" ");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.addEnchant(Enchantment.DIG_SPEED,1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getSphereNether() {
        ItemStack item = SkullUtils.getSkullByBase64EncodedTextureUrl(items.getString("second_sphere_url")).clone();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&4Сфера Нижнего мира"));
        AttributeModifier damageModifier = new AttributeModifier("damageModifier",2.5, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier healthModifier = new AttributeModifier("healthModifier",1.5, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier attackSpeedModifier = new AttributeModifier("attackSpeedModifier",-0.5, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier knockBackModifier = new AttributeModifier("knockbackModifier",0.5, AttributeModifier.Operation.ADD_NUMBER);

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,attackSpeedModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK,knockBackModifier);
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Когда в руке:"));
        lore.add(ColorUtils.translateColorCodes("&9+2.5 Урон"));
        lore.add(ColorUtils.translateColorCodes("&9+0.5 Отбрасывающая атака"));
        lore.add(ColorUtils.translateColorCodes("&9+1.5 Максимальное здоровье"));
        lore.add(ColorUtils.translateColorCodes("&c-0.5 Скорости атаки"));
        lore.add(" ");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.addEnchant(Enchantment.ARROW_FIRE,1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getSphereOcean() {
        ItemStack item = SkullUtils.getSkullByBase64EncodedTextureUrl(items.getString("third_sphere_url")).clone();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&bСфера Океана"));
        AttributeModifier armorModifier = new AttributeModifier("armorModifier",4.5, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier healthModifier = new AttributeModifier("healthModifier",3.0, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier attackSpeedModifier = new AttributeModifier("attackSpeedModifier",-0.5, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier knockbackModifier = new AttributeModifier("knockbackModifier",0.2, AttributeModifier.Operation.ADD_NUMBER);

        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armorModifier);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,attackSpeedModifier);
        meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE,knockbackModifier);
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Когда в руке:"));
        lore.add(ColorUtils.translateColorCodes("&9+4.5 Броня"));
        lore.add(ColorUtils.translateColorCodes("&9+2 Сопротивление отбрасыванию"));
        lore.add(ColorUtils.translateColorCodes("&9+3.0 Максимальное здоровье"));
        lore.add(ColorUtils.translateColorCodes("&c-0.5 Скорости атаки"));
        lore.add(" ");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.addEnchant(Enchantment.FROST_WALKER,3,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        item.setItemMeta(meta);
        return item;
    }

}
