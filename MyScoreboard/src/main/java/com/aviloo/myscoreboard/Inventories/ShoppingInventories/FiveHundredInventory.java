package com.aviloo.myscoreboard.Inventories.ShoppingInventories;

import com.aviloo.myscoreboard.Utils.ShoppingUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class FiveHundredInventory {

    protected static String getStringTag(Player player){
        if(ShoppingUtil.getCurrentTag(player).equals("ping")){
            return "«Пинг»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("mobs_killed")) {
            return "«Мобов убито»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("blocks_break")){
            return "«Блоков сломано»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("coords")){
            return "«Координаты»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("kills_deaths")){
            return "«K/D»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("hand_durability")){
            return "«Прочность предмета в руке»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("totem_count")){
            return "«Кол-во тотемов»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("helmet_durability")){
            return "«Прочность шлема»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("chestplate_durability")){
            return "«Прочность нагрудника»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("leggings_durability")){
            return "«Прочность понож»";
        }
        if(ShoppingUtil.getCurrentTag(player).equals("boots_durability")){
            return "«Прочность ботинок»";
        }
        return "-";
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,3*9, ChatColor.WHITE+"Подтвердите покупку");

        ItemStack accept = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta aMeta = accept.getItemMeta();
        aMeta.setDisplayName(ChatColor.GREEN+"Подтвердить покупку");
        accept.setItemMeta(aMeta);
        inv.setItem(0,accept);
        inv.setItem(1,accept);
        inv.setItem(2,accept);
        inv.setItem(3,accept);

        inv.setItem(9,accept);
        inv.setItem(10,accept);
        inv.setItem(11,accept);
        inv.setItem(12,accept);

        inv.setItem(18,accept);
        inv.setItem(19,accept);
        inv.setItem(20,accept);
        inv.setItem(21,accept);

        ItemStack deny = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta dMeta = deny.getItemMeta();
        dMeta.setDisplayName(ChatColor.RED+"Отказаться");
        deny.setItemMeta(dMeta);
        inv.setItem(5,deny);
        inv.setItem(6,deny);
        inv.setItem(7,deny);
        inv.setItem(8,deny);

        inv.setItem(14,deny);
        inv.setItem(15,deny);
        inv.setItem(16,deny);
        inv.setItem(17,deny);

        inv.setItem(23,deny);
        inv.setItem(24,deny);
        inv.setItem(25,deny);
        inv.setItem(26,deny);

        ItemStack info = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta iMeta = info.getItemMeta();
        iMeta.setDisplayName(" ");
        ArrayList<String> iLore = new ArrayList<>();
        iLore.add(" ");
        iLore.add(ChatColor.YELLOW+"Вы действительно хотите купить ");
        iLore.add(ChatColor.YELLOW+getStringTag(player));
        iLore.add(ChatColor.YELLOW+"за 500 монет.");
        iLore.add(" ");
        iMeta.setLore(iLore);
        info.setItemMeta(iMeta);
        inv.setItem(13,info);

        return inv;
    }

}
