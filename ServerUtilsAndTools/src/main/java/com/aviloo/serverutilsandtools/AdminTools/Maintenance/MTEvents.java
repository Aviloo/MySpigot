package com.aviloo.serverutilsandtools.AdminTools.Maintenance;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MTEvents implements Listener {

    @EventHandler (priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onConnect(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(MTUtils.getStatus()){
            if(player.isOp()){return;}
            player.kickPlayer("Сейчас на сервере проходят тех.работы. Приносим свои извинения за неудобства. " +
                    "С любовью администрация Orumii.");
        }
        if(!MTUtils.getStatus()){
            MTUtils.addPlayer(player);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        MTUtils.removePlayer(player);
    }
}
