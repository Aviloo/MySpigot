package com.aviloo.serverutilsandtools.AdminTools.AdminChat.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class AdminsList implements Listener {
    //List
    private final static List<Player> adminsList = new ArrayList<>();

    public static void addPlayer(Player player){
        adminsList.add(player);
    }

    public static void removePlayer(Player player){
        adminsList.remove(player);
    }

    public static List<Player> getAdminsList(){
        return adminsList;
    }

    //Events
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("SUAT.admin-chat")){
            addPlayer(player);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("SUAT.admin-chat")){
            removePlayer(player);
        }
    }
}
