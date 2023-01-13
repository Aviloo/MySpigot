package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class WitherQuest implements Listener {
    private static final ConcurrentHashMap<UUID,Boolean> WitherQuestStatus = new ConcurrentHashMap<>();
    public static Boolean isWitherQuestComplete(Player player){
        return WitherQuestStatus.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID,Integer> WitherCount = new ConcurrentHashMap<>();
    public static void addWither(Player player){
        WitherCount.put(player.getUniqueId(),WitherCount.getOrDefault(player.getUniqueId(),0)+1);
    }
    public static Integer getWither(Player player){
        return WitherCount.get(player.getUniqueId());
    }

    public static void setWitherDefault(Player player){
        WitherCount.put(player.getUniqueId(),0);
        WitherQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onKill(EntityDeathEvent event){
        if(!(event.getEntity() instanceof Wither)){return;}
        if(event.getEntity().getKiller() == null || !(event.getEntity().getKiller() instanceof Player)){return;}

        Player player = event.getEntity().getKiller();
        if(getWither(player) == 3){
            WitherQuestStatus.put(player.getUniqueId(),true);
            addWither(player);
            CoalQuest.giveReward(player);
        }
        if(getWither(player) < 3){addWither(player);}
    }
}
