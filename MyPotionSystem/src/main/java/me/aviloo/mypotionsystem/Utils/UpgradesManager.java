package me.aviloo.mypotionsystem.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UpgradesManager {

    private static final ConcurrentHashMap<UUID,Boolean> UpgradesStatus = new ConcurrentHashMap<>();

    public static boolean getUpgradesStatus(Player player){
        return UpgradesStatus.get(player.getUniqueId());
    }

    public static void setUpgradesStatus(Player player,boolean status){
        UpgradesStatus.put(player.getUniqueId(),status);
    }
}
