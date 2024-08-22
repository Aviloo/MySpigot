package me.aviloo.mycrafts.Utils;

import me.aviloo.mycrafts.MyCrafts;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

public class MenuUtil {

    private static FileConfiguration items =
            MyCrafts.getPlugin().itemsFileManager.getItemsConfig();

    public static ItemStack createItemStack(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.GRAY+"<Нажмите, чтобы узнать больше>");
        lore.add(" ");
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItemStack(String HeadName){
        ItemStack item = SkullUtils.getSkullByBase64EncodedTextureUrl(
                items.getString("menu_sphere_url")).clone();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(HeadName);
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.GRAY+"<Нажмите, чтобы узнать больше>");
        lore.add(" ");
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItemStack(){
        ItemStack item = new ItemStack(Material.SPECTRAL_ARROW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+"Назад");

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItemStack(Enchantment enchantment, int level){
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(enchantment, level, true);
        item.setItemMeta(meta);
        return item;
    }

    public static int menuTaskId;

    public static void createStroke(Inventory inventory, int ... exceptions){
        ItemStack item = new ItemStack(Material.valueOf(items.getString(
                "stroke_material")));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);

            menuTaskId = Bukkit.getScheduler().runTaskAsynchronously(MyCrafts.getPlugin(),
                    () -> {
                for(int i = 0; i < 54; i++){
                    if(!ArrayUtils.contains(exceptions, i)){
                        inventory.setItem(i, item);
                    }
                }
            }).getTaskId();

    }

    public static ItemStack createCraftItem(){
        ItemStack item = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+"Попытаться создать");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Выбранный предмет: "));
        lore.add(ColorUtils.translateColorCodes("&7Шанс крафта: "));
        lore.add(ColorUtils.translateColorCodes("&7Стоимость: "));
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack createInfoItem(){
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+"Информация");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&fСверху находятся предметы, которые"));
        lore.add(ColorUtils.translateColorCodes("&fвы можете скрафтить."));
        lore.add(ColorUtils.translateColorCodes("&fКликните на предмет, чтобы увидеть"));
        lore.add(ColorUtils.translateColorCodes("&fкакие ресурсы понадобятся для его крафта"));
        lore.add(ColorUtils.translateColorCodes("&fНиже располагаются ресурсы необходимые"));
        lore.add(ColorUtils.translateColorCodes("&fдля крафта."));
        lore.add(ColorUtils.translateColorCodes("&fУ каждого крафта есть своя стоимость, а"));
        lore.add(ColorUtils.translateColorCodes("&fтакже шанс успешного крафта."));
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

}
