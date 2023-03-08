package com.aviloo.mytraderreloaded.Seller.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PlayersStats implements Listener { // Class frozen for undefined time

    private static JavaPlugin plugin;

    public PlayersStats(JavaPlugin plugin){
        this.plugin = plugin;
    }

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

    private static final TreeMap<UUID,Double> Earned = new TreeMap<>(); // сортировать по этой мапе

    public static Double getEarned(Player player){
        return Earned.get(player.getUniqueId());
    }

    public static void addEarned(Player player,Double value){
        Earned.put(player.getUniqueId(),Earned.getOrDefault(player.getUniqueId(),0.0)+value);
    }

    public static void setEarnedDefault(Player player){
        Earned.put(player.getUniqueId(),0.0);
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

    private static UUID leader;

    public static void sortPlayers(){
        if(Earned.isEmpty()){
            return;
        }
        SortedSet<Double> values = new TreeSet<>(Earned.values());
        for(UUID uuid : Earned.keySet()){
            if(Earned.get(uuid).equals(values.first())){
                leader = uuid;
                break;
            }

        }
    }

    public static void getLeaderHead(SkullMeta meta){ // does not work
        if(Earned.isEmpty()){
            return;
        }
        Player player = Bukkit.getServer().getPlayer(leader);
        if(player == null){
            OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(leader);
            meta.setOwningPlayer(offline);
            return;
        }
        meta.setOwningPlayer(player);
    }

    private static String getLeaderName(){
        Player player = Bukkit.getServer().getPlayer(leader);
        /*
        if(player == null){
            OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(leader);
            return offline.getName();
        }

         */
        return player.getName();
    }

    public static void setLeaderLore(ArrayList<String> list,Player player){
        if(Earned.isEmpty()){
            list.add(" ");
            list.add(ChatColor.WHITE+"Сегодняшний лидер - "+ ChatColor.GOLD+"KK10");
            list.add(ChatColor.WHITE+"Он зароботал за сегодня - "+ChatColor.AQUA+"100"+ChatColor.WHITE+" монет.");
            list.add(ChatColor.WHITE+"А продал - "+ChatColor.AQUA+"56"+ChatColor.WHITE+" ед. товара.");
            list.add(" ");
            list.add(ChatColor.GRAY+"Вы сегодня заработали - "+Earned.get(player.getUniqueId())+ChatColor.GRAY+" монет.");
            list.add(ChatColor.GRAY+"Вы сегодня продали - "+SoldCount.get(player.getUniqueId())+ChatColor.GRAY+" ед. товара.");
            list.add(" ");
            return;
        }
        list.add(" ");
        list.add(ChatColor.WHITE+"Сегодняшний лидер - "+ ChatColor.GOLD+getLeaderName());
        list.add(ChatColor.WHITE+"Он зароботал за сегодня - "+ChatColor.AQUA+Earned.get(leader)+ChatColor.WHITE+" монет.");
        list.add(ChatColor.WHITE+"А продал - "+ChatColor.AQUA+SoldCount.get(leader)+ChatColor.WHITE+" ед. товара.");
        list.add(" ");
        list.add(ChatColor.GRAY+"Вы сегодня заработали - "+Earned.get(player.getUniqueId())+ChatColor.GRAY+" монет.");
        list.add(ChatColor.GRAY+"Вы сегодня продали - "+SoldCount.get(player.getUniqueId())+ChatColor.GRAY+" ед. товара.");
        list.add(" ");
    }

    public static void updateLeader(){
        int seconds = 1;
        int period = 600;

        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            sortPlayers();
        }, seconds * 20L, period * 20L);
    }

}
