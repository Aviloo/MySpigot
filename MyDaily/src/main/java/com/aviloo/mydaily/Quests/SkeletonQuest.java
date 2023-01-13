package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SkeletonQuest implements Listener {

    private static final ConcurrentHashMap<UUID,Boolean> SkeletonQuestStatus = new ConcurrentHashMap<>();
    public static Boolean isSkeletonQuestComplete(Player player){
        return SkeletonQuestStatus.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID,Integer> SkeletonCount = new ConcurrentHashMap<>();
    public static void addSkeleton(Player player){
        SkeletonCount.put(player.getUniqueId(),SkeletonCount.getOrDefault(player.getUniqueId(),0)+1);
    }
    public static Integer getSkeleton(Player player){
        return SkeletonCount.get(player.getUniqueId());
    }

    public static void setSkeletonDefault(Player player){
        SkeletonCount.put(player.getUniqueId(),0);
        SkeletonQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onKill(EntityDeathEvent event){
        if(!(event.getEntity() instanceof Skeleton)){return;}
        if(event.getEntity().getKiller() == null || !(event.getEntity().getKiller() instanceof Player)){return;}

        Player player = event.getEntity().getKiller();
        if(getSkeleton(player) == 50){
            SkeletonQuestStatus.put(player.getUniqueId(),true);
            addSkeleton(player);
            CoalQuest.giveReward(player);
        }
        if(getSkeleton(player) < 50){addSkeleton(player);}
    }
}
