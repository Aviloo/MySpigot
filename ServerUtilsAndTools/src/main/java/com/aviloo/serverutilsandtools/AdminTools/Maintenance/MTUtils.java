package com.aviloo.serverutilsandtools.AdminTools.Maintenance;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class MTUtils {
    //Status
    private static boolean MaintenanceStatus = false;

    public static void setTrue(){
        MaintenanceStatus = true;
    }
    public static void setFalse(){
        MaintenanceStatus = false;
    }
    public static boolean getStatus(){
        return MaintenanceStatus;
    }

    //Players List
    private static ArrayList<Player> OnlinePlayers = new ArrayList<>();

    public static void addPlayer(Player player){
        OnlinePlayers.add(player);
    }
    public static void removePlayer(Player player){
        OnlinePlayers.remove(player);
    }

    public static ArrayList<Player> getOnlinePlayers(){
        return OnlinePlayers;
    }
}
