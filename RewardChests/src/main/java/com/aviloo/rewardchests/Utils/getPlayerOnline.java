package com.aviloo.rewardchests.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class getPlayerOnline implements Listener {

    private static ArrayList<Player> online_players = new ArrayList<>();

    private static void addPlayer(Player player){
        if(!online_players.contains(player)){
            online_players.add(player);
        }
    }

    private static void removePlayer(Player player){
        online_players.remove(player);
    }
    public static ArrayList<Player> getOnlinePlayers(){
        return online_players;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        addPlayer(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        removePlayer(player);
    }

}
