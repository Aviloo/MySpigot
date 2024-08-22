package me.aviloo.mycrafts.Items.Trap;

import me.aviloo.mycrafts.Utils.ColorUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TrapManager {
    public static ItemStack Trap;

    public static void init() {
        createTrap();
    }

    private static void createTrap() {
        ItemStack item = new ItemStack(Material.NETHERITE_SCRAP, 1);
        ItemMeta meta = item.getItemMeta();
        //meta.setDisplayName("§6Трапка");
        meta.setDisplayName(ColorUtils.translateColorCodes("&4Ловушка"));
        List<String> lore = new ArrayList();
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes(
                "&7Создает коробку из обсидиана"));
        lore.add(ColorUtils.translateColorCodes("&7вокруг игрока."));
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Trap = item;
    }

}
