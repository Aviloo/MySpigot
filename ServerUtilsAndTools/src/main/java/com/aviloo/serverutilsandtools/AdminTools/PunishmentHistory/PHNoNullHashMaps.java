package com.aviloo.serverutilsandtools.AdminTools.PunishmentHistory;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class PHNoNullHashMaps implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.hasPlayedBefore()){ //todo заменить
            ArrayList<String> emptyList = new ArrayList<>();
            PHUtils.putPlayerHash(player,emptyList);
        }
    }
}
