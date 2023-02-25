package com.aviloo.mytraderreloaded.Seller.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayersStats implements Listener {

    private static final ConcurrentHashMap<UUID,Integer> SoldCount = new ConcurrentHashMap<>();

    public static Integer getSoldCount(Player player){
        return SoldCount.get(player.getUniqueId());
    }

    public static void addSoldCount(Player player,Integer value){
        SoldCount.put(player.getUniqueId(),SoldCount.getOrDefault(player.getUniqueId(),0)+value);
    }

    public static void setSoldCountDefault(Player player){
        SoldCount.put(player.getUniqueId(),0);
    }

    private static final TreeMap<UUID,Integer> Earned = new TreeMap<>(); // сортировать по этой мапе

    public static Integer getEarned(Player player){
        return SoldCount.get(player.getUniqueId());
    }

    public static void addEarned(Player player,Integer value){
        SoldCount.put(player.getUniqueId(),SoldCount.getOrDefault(player.getUniqueId(),0)+value);
    }

    public static void setEarnedDefault(Player player){
        SoldCount.put(player.getUniqueId(),0);
    }

    private final ConcurrentHashMap<UUID,Boolean> hasPlayedToday = new ConcurrentHashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!hasPlayedToday.containsKey(player.getUniqueId())){
            hasPlayedToday.put(player.getUniqueId(),true);
            setSoldCountDefault(player);
            setEarnedDefault(player);
        }
    }

    protected static void sortPlayers(){
        Iterator iterator = Earned.values().iterator();
        while (iterator.hasNext()){
            int value =(int)iterator.next();
        }
    }
}
