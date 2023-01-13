package com.aviloo.serverutilsandtools.ServerTools.NoAucOnEnd;

import org.bukkit.ChatColor;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class NoAucOnEnd implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();

        if(event.getMessage().contains("/auc") || event.getMessage().contains("/ah") ||
        event.getMessage().contains("/auctionhouse")){
            if(player.getLocation().getWorld().getName().equalsIgnoreCase("world_the_end")){
                event.setCancelled(true);
                player.sendMessage(ChatColor.GRAY+"[Система] " + ChatColor.WHITE+ "В энде "+ChatColor.RED+"нельзя"+ChatColor.WHITE+" использовать аукцион.");
            }
        }
    }
}
