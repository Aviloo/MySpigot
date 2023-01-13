package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerQuest implements Listener {
    private static final ConcurrentHashMap<UUID,Boolean> PlayerQuestStatus = new ConcurrentHashMap<>();
    public static Boolean isPlayerQuestComplete(Player player){
        return PlayerQuestStatus.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID,Integer> PlayerCount = new ConcurrentHashMap<>();
    public static void addPlayer(Player player){
        PlayerCount.put(player.getUniqueId(),PlayerCount.getOrDefault(player.getUniqueId(),0)+1);
    }
    public static Integer getPlayer(Player player){
        return PlayerCount.get(player.getUniqueId());
    }

    public static void setPlayerDefault(Player player){
        PlayerCount.put(player.getUniqueId(),0);
        PlayerQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onKill(PlayerDeathEvent event){
        if(event.getEntity().getKiller() == null){return;}
        if(!(event.getEntity().getKiller() instanceof Player)){return;}

        Player player = (Player) event.getEntity().getKiller();
        if(getPlayer(player) == 15){
            PlayerQuestStatus.put(player.getUniqueId(),true);
            addPlayer(player);
            CoalQuest.giveReward(player);
        }
        if(getPlayer(player) < 15){addPlayer(player);}
    }
}
