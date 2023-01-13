package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockIgniteEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TNTQuest implements Listener {

    private static final ConcurrentHashMap<UUID,Boolean> TNTQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isTNTQuestComplete(Player player){
        if(TNTQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> TNTCount = new ConcurrentHashMap<>();

    public static void addTNT(Player player){
        TNTCount.put(player.getUniqueId(),TNTCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getTNT(Player player){
        return TNTCount.get(player.getUniqueId());
    }
    public static void setTNTQuestDefault(Player player){
        TNTCount.put(player.getUniqueId(),0);
        TNTQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler(priority = EventPriority.NORMAL,ignoreCancelled = true)
    public void blewUp(BlockIgniteEvent event){
        if(event.getPlayer() == null) {return;}
        if(!(event.getBlock().getType().equals(Material.TNT))){return;}

        Player player = event.getPlayer();
        if(getTNT(player) == 5){
            CoalQuest.giveReward(player);
            TNTQuestStatus.put(player.getUniqueId(),true);
            addTNT(player);
        }
        if(getTNT(player) < 5){addTNT(player);}
    }
}
