package com.aviloo.myscoreboard.Utils.GlobalEvents;

import com.aviloo.myscoreboard.MyScoreboard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class GlobalDisconnectEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        MyScoreboard.connectedPlayers.remove(player);
    }

}
