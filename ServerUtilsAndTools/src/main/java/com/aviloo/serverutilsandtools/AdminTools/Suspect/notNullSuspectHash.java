package com.aviloo.serverutilsandtools.AdminTools.Suspect;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class notNullSuspectHash implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Suspect.setFalse(player.getUniqueId());
    }
}
