package com.aviloo.mytraderreloaded.Seller.Utils;


import com.aviloo.mytraderreloaded.models.PluginPlayer;
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
        if(isPlayerPlayedToday(player)){return;}
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

    //Usermap part
    public static void addReputationToUsermap(Player player,int reputation){

        if(!UsermapStorageUtil.isUserExisting(player)) {
            UsermapStorageUtil.addToUsermap(player);
            UsermapStorageUtil.addRepToOnlinePlayer(player,
                    UsermapStorageUtil.getRepByBukkitPlayer(player) + reputation);
            return;
        }

        if(UsermapStorageUtil.isUserExisting(player)){
            UsermapStorageUtil.addRepToOnlinePlayer(player,
                    UsermapStorageUtil.getRepByBukkitPlayer(player) + reputation);
        }

    }

    public static int getReputationFromUsermap(Player player){
        if(!UsermapStorageUtil.isUserExisting(player)) {
            UsermapStorageUtil.addToUsermap(player);
            return UsermapStorageUtil.getRepByBukkitPlayer(player);
        }
        if(UsermapStorageUtil.isUserExisting(player)){
            return UsermapStorageUtil.getRepByBukkitPlayer(player);
        }

        return 0;
    }

    public static void resetReputationToUsermap(Player player){

        if(!UsermapStorageUtil.isUserExisting(player)) {
            UsermapStorageUtil.addToUsermap(player);
            return;
        }

        if(UsermapStorageUtil.isUserExisting(player)){
            UsermapStorageUtil.setRepForBukkitPlayer(player, 0);
        }

    }

    public static void setReputationToUsermap(Player player, int value){
        if(!UsermapStorageUtil.isUserExisting(player)){
            UsermapStorageUtil.addToUsermap(player);
            UsermapStorageUtil.setRepForBukkitPlayer(player,value);
            return;
        }
        if(UsermapStorageUtil.isUserExisting(player)){
            UsermapStorageUtil.setRepForBukkitPlayer(player,value);
        }

    }

    public static void takeReputationFromUsermap(Player player,int value){
        if(!UsermapStorageUtil.isUserExisting(player)) {
            UsermapStorageUtil.addToUsermap(player);
            if(UsermapStorageUtil.getRepByBukkitPlayer(player) < value){
                return;
            }else {
                UsermapStorageUtil.takeRepFromBukkitPlayer(player,value);
                return;
            }
        }
        if(UsermapStorageUtil.isUserExisting(player)){
            if(UsermapStorageUtil.getRepByBukkitPlayer(player) < value){
                return;
            }else {
                UsermapStorageUtil.takeRepFromBukkitPlayer(player,value);
            }
        }

    }

}
