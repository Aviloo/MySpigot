package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.*;

public class PlayerStats implements Listener {

    private static MyTraderReloaded plugin;
    public PlayerStats(MyTraderReloaded plugin){
        this.plugin = plugin;
    }

    private static HashMap<UUID,Double> EarnedHashMap = new HashMap<>();

    public static double getEarnedPlayerStats(UUID uuid){
        return EarnedHashMap.get(uuid);
    }

    public static void setEarnedPlayerStats(UUID uuid,double earned){
        EarnedHashMap.put(uuid,earned);
    }

    public static void addEarnedPlayerStats(UUID uuid,String ProductType,int ProductCount){
        EarnedHashMap.put(uuid, EarnedHashMap.getOrDefault(uuid, 0.0)
                + PriceManager.getCurrentPrice(ProductType) * ProductCount);

    }

    @EventHandler (priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event){
        EarnedHashMap.put(event.getPlayer().getUniqueId(),
                EarnedHashMap.getOrDefault(event.getPlayer().getUniqueId(), 0.0));
    }

    public static UUID bestTrader;

    private static TreeMap<UUID,Double> treeMap = new TreeMap<>();

    public static void getBestTraderUUID(){
        treeMap.putAll(EarnedHashMap);

        if(treeMap.isEmpty()){
            bestTrader = null;
            return;
        }

        Map.Entry<UUID, Double> entry = treeMap.lastEntry();
        // Get the key and value of the entry
        bestTrader = entry.getKey();
        if(treeMap.get(bestTrader) == 0.0){
            bestTrader = null;
        }
        treeMap.clear();
    }

    public static void giveRewardToTrader(){
        Bukkit.getScheduler().runTaskLater(plugin,() -> {
            PlayerStats.getBestTraderUUID();
            if(PlayerStats.bestTrader == null){
                Bukkit.getConsoleSender().sendMessage("Лучший игрок невыявлен.");
            }

            if(Bukkit.getOfflinePlayer(PlayerStats.bestTrader).isOnline()){
                EconomyManager.givePoints(Bukkit.getOfflinePlayer(PlayerStats.bestTrader).getUniqueId(),
                        45);
                Bukkit.getOfflinePlayer(PlayerStats.bestTrader)
                        .getPlayer().sendMessage("Вы получили награду.");
                Bukkit.getConsoleSender().sendMessage("Игроку выдана награда!");

            }
            if(!Bukkit.getOfflinePlayer(PlayerStats.bestTrader).isOnline()){
                EconomyManager.givePoints(Bukkit.getOfflinePlayer(PlayerStats.bestTrader).getUniqueId(),
                        45);
                Bukkit.getConsoleSender().sendMessage("Игроку выдана награда!");

            }
        },1080000); // через 15 часов
    }


}
