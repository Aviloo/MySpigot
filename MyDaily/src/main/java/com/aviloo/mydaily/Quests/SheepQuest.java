package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SheepQuest implements Listener {

    private static final ConcurrentHashMap<UUID,Boolean> SheepQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isSheepQuestComplete(Player player){
        if(SheepQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> SheepCount = new ConcurrentHashMap<>();

    private static void addSheep(Player player){
        SheepCount.put(player.getUniqueId(),SheepCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getSheep(Player player){
        return SheepCount.get(player.getUniqueId());
    }
    public static void setSheepQuestDefault(Player player){
        SheepCount.put(player.getUniqueId(),0);
        SheepQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onSheep(PlayerShearEntityEvent event){
        if(!event.getEntity().getType().equals(EntityType.SHEEP)){return;}

        Player player = event.getPlayer();
        if(getSheep(player) == 35){
            SheepQuestStatus.put(player.getUniqueId(),true);
            addSheep(player);
            CoalQuest.giveReward(player);
        }
        if(getSheep(player) < 35){addSheep(player);}
    }
}
