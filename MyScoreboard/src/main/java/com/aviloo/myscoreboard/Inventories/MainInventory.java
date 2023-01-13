package com.aviloo.myscoreboard.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainInventory {

    private static Map<UUID,Boolean> EnableBoard = new HashMap<>();

    public static void setEnable(UUID uuid){
        EnableBoard.put(uuid,true);
    }
    public static void setDisable(UUID uuid){
        EnableBoard.put(uuid,false);
    }
    private static Boolean getStatusBoard(UUID uuid){
        return EnableBoard.get(uuid);
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,9, ChatColor.WHITE+"Скорборд");

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack enable = new ItemStack(Material.RED_SHULKER_BOX,1);
        if(getStatusBoard(player.getUniqueId())){
            enable.setType(Material.RED_SHULKER_BOX);
            ItemMeta eMeta = enable.getItemMeta();
            eMeta.setDisplayName(ChatColor.RED+"Выключить");
            enable.setItemMeta(eMeta);
        }
        if(!getStatusBoard(player.getUniqueId())){
            enable.setType(Material.GREEN_SHULKER_BOX);
            ItemMeta eMeta = enable.getItemMeta();
            eMeta.setDisplayName(ChatColor.GREEN+"Включить");
            enable.setItemMeta(eMeta);
        }

        ItemStack custom = new ItemStack(Material.EXPERIENCE_BOTTLE,1);
        ItemMeta cMeta = custom.getItemMeta();
        cMeta.setDisplayName(ChatColor.YELLOW+"Кастомизация");
        ArrayList<String> cLore = new ArrayList<>();
        cLore.add(ChatColor.GRAY+"Позволяет настроить ваш");
        cLore.add(ChatColor.GRAY+"скорборд под вас.");
        cMeta.setLore(cLore);
        custom.setItemMeta(cMeta);

        ItemStack quit = new ItemStack(Material.BARRIER,1);
        ItemMeta qMeta = quit.getItemMeta();
        qMeta.setDisplayName(ChatColor.WHITE+"Закрыть");
        quit.setItemMeta(qMeta);

        ItemStack[] inv_stack = {air,air,enable,air,custom,air,quit,air,air};
        inv.setContents(inv_stack);

        return inv;
    }
}
