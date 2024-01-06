package me.aviloo.myarenamanager.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class OnlineUtils implements Listener {

    public static Set<Player> online_player = new HashSet<>();

    @EventHandler(ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        online_player.add(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGH,ignoreCancelled = true)
    public void onQuit(PlayerQuitEvent event){
        online_player.remove(event.getPlayer());
    }

    public static int getOnlineCount(){
        return online_player.size();
    }

}
