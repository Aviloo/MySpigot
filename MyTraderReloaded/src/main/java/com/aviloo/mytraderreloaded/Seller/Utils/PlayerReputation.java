package com.aviloo.mytraderreloaded.Seller.Utils;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerReputation implements Listener {

    protected final static LinkedHashMap<UUID,Integer> Reputation = new LinkedHashMap<>();

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
    public void onJoin(PlayerJoinEvent event) throws SQLException {
        Player player = event.getPlayer();
        if(!player.hasPlayedBefore()){ // todo Пока не подключю бд ,будет криво работать!
            Reputation.put(player.getUniqueId(),0);
            PlayersPlayedToday.put(player.getUniqueId(),true);
        }
        if(!isPlayerPlayedToday(player)){
            MySQLManager.getDataReputation(player);
            PlayersPlayedToday.put(player.getUniqueId(),true);
        }
    }

    //Utils Part
    private static final ConcurrentHashMap<UUID,Boolean> PlayersPlayedToday = new ConcurrentHashMap<>();

    protected static Boolean isPlayerPlayedToday(Player player){
        if(!PlayersPlayedToday.containsKey(player.getUniqueId())){
            return false;
        }
        return PlayersPlayedToday.get(player.getUniqueId());
    }
}
