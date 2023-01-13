package com.aviloo.serverutilsandtools.ServerTools.BanEnchants;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class InfinityBan implements Listener {

    @EventHandler
    public void onEnchant(EnchantItemEvent event){
        Player player = event.getEnchanter();

        if(event.getEnchantsToAdd().containsKey(Enchantment.ARROW_INFINITE)){
            event.setCancelled(true);
            player.sendMessage("[Система] " + ChatColor.WHITE + "На сервере нельзя зачаровать предмет на бесконечность.");
        }
    }
}
