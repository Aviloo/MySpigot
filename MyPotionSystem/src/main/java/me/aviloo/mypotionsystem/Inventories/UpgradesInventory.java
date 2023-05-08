package me.aviloo.mypotionsystem.Inventories;

import me.aviloo.mypotionsystem.Utils.UpgradesManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UpgradesInventory {

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Улучшения рабочего места");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(50,back);

        ItemStack status = new ItemStack(Material.BARRIER,1);
        ItemMeta sMeta = status.getItemMeta();
        if(!UpgradesManager.getUpgradesStatus(player)){
            status.setType(Material.STRUCTURE_VOID);
            sMeta.setDisplayName(ChatColor.GREEN+"Включить");
            status.setItemMeta(sMeta);
        }
        if(UpgradesManager.getUpgradesStatus(player)){
            sMeta.setDisplayName(ChatColor.RED+"Отключить");
            status.setItemMeta(sMeta);
        }
        inv.setItem(48,status);

        ItemStack cauldron = new ItemStack(Material.CAULDRON,1);
        inv.setItem(20,cauldron);

        ItemStack gold = new ItemStack(Material.RAW_GOLD,1);
        inv.setItem(21,gold);

        ItemStack shard = new ItemStack(Material.ECHO_SHARD,1);
        inv.setItem(22,shard);

        ItemStack lava = new ItemStack(Material.LAVA_BUCKET,1);
        inv.setItem(23,lava);

        ItemStack head = new ItemStack(Material.DRAGON_HEAD,1);
        inv.setItem(24,head);

        return inv;
    }
}
