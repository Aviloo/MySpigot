package com.aviloo.mytraderreloaded.Seller.Utils;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.LinkedHashMap;
import java.util.UUID;

public class PlayerReputation implements Listener {

    private final static LinkedHashMap<UUID,Integer> Reputation = new LinkedHashMap<>();

    public static void addReputation(Player player,Integer value){
        Reputation.put(player.getUniqueId(),Reputation.getOrDefault(player.getUniqueId(),0)+value);
    }

    public static void setReputation(Player player,Integer value){
        Reputation.put(player.getUniqueId(),value);
    }

    public static void takeReputation(Player player,Integer value){
        Reputation.put(player.getUniqueId(),Reputation.getOrDefault(player.getUniqueId(),0)-value);
    }

    public static Integer getReputation(Player player){
        return Reputation.get(player.getUniqueId());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!player.hasPlayedBefore()){ // todo Пока не подключю бд ,будет криво работать!
            Reputation.put(player.getUniqueId(),0);
        }
    }

}
