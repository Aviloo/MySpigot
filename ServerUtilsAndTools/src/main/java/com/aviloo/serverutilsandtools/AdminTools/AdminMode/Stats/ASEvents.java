package com.aviloo.serverutilsandtools.AdminTools.AdminMode.Stats;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ASEvents implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        if(!event.getPlayer().hasPermission("SUAT.adminmode") && !event.getPlayer().isOp()){return;}
        if(event.getMessage().contains("/mute")){
            AdministratorProperties.addMute(event.getPlayer().getUniqueId());
        }
        if(event.getMessage().contains("/ban")){
            AdministratorProperties.addBan(event.getPlayer().getUniqueId());
        }
        if(event.getMessage().contains("/kick")){
            AdministratorProperties.addKick(event.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(!event.getPlayer().hasPermission("SUAT.adminmode") && !event.getPlayer().isOp()){return;}
        if(!AdministratorProperties.getPlayedToday(event.getPlayer().getUniqueId())){
            AdministratorProperties.setPlayed(event.getPlayer().getUniqueId());
            AdministratorProperties.setNotAdmin(event.getPlayer().getUniqueId());
            AdministratorProperties.setDefaultBan(event.getPlayer().getUniqueId());
            AdministratorProperties.setDefaultKick(event.getPlayer().getUniqueId());
            AdministratorProperties.setDefaultMute(event.getPlayer().getUniqueId());
            AdministratorProperties.setDefaultStartTime(event.getPlayer().getUniqueId());
            AdministratorProperties.setDefaultEndTime(event.getPlayer().getUniqueId());
        }
    }
}
