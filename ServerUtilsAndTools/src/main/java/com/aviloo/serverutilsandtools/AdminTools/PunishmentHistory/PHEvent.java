package com.aviloo.serverutilsandtools.AdminTools.PunishmentHistory;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.time.LocalDate;

public class PHEvent implements Listener {

    @EventHandler
    public void onBan(PlayerQuitEvent event){
        Player player = event.getPlayer();
        LocalDate date = LocalDate.now();
        if(player.isBanned()){

        }
    }
}
