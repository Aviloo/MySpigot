package com.aviloo.serverutilsandtools.AdminTools.AdminMode;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class AMUtils {
    private static Set<Player> onlinePlayers = new HashSet<>();

    public static void addPlayer(Player player){
        onlinePlayers.add(player);
    }

    public static void removePlayer(Player player){
        onlinePlayers.remove(player);
    }

    public static Integer getPlayersCount(){
        if(onlinePlayers.size() > 64){
            return 64;
        }
        return onlinePlayers.size();
    }
}
