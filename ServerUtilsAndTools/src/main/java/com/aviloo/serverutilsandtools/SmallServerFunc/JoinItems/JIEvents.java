package com.aviloo.serverutilsandtools.SmallServerFunc.JoinItems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JIEvents implements Listener {

    private ItemStack joinItem(){
        ItemStack item = new ItemStack(Material.PAPER,1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Информация для новичков.");
        itemMeta.addEnchant(Enchantment.LUCK,1,true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(itemMeta);

        return item;
    }

    @EventHandler(priority = EventPriority.LOW,ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.hasPlayedBefore()){return;}
        player.getInventory().addItem(joinItem());
    }

    @EventHandler(priority = EventPriority.HIGH,ignoreCancelled = true)
    public void onUse(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Player player = event.getPlayer();
            if(player.getInventory().getItemInMainHand().getType().isAir()){return;}
            if(player.getInventory().getItemInMainHand().equals(null)){return;}
            if(!player.getInventory().getItemInMainHand().equals(joinItem())){return;}

            Bukkit.dispatchCommand(player,"menuforbegginers");
        }
    }
}
