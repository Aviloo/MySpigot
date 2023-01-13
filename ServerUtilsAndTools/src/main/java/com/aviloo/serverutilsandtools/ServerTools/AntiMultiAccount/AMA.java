package com.aviloo.serverutilsandtools.ServerTools.AntiMultiAccount;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class AMA implements Listener {

    private JavaPlugin plugin;

    public AMA(JavaPlugin plugin){
        this.plugin = plugin;
    }

    private Set<String> playerAddresses = new HashSet<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if(!plugin.getConfig().getBoolean("AntiMultiAccount")){return;}
        Player player = event.getPlayer();
        if (playerAddresses.contains(player.getAddress().getHostName())) {
            player.kickPlayer(ChatColor.YELLOW+"Мульти-Аккаунт запрещен!");
        } else {
            Bukkit.getConsoleSender().sendMessage(player.getName()+ " " +player.getAddress().getHostName());
            playerAddresses.add(player.getAddress().getHostName());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if(!plugin.getConfig().getBoolean("AntiMultiAccount")){return;}
        playerAddresses.remove(event.getPlayer().getAddress().getHostName());
    }
}
