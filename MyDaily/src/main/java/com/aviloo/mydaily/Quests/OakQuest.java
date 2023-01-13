package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OakQuest implements Listener {
    private static final ConcurrentHashMap<UUID,Boolean> OakQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isOakQuestComplete(Player player){
        if(OakQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> OakCount = new ConcurrentHashMap<>();

    private static void addOak(Player player){
        OakCount.put(player.getUniqueId(),OakCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getOak(Player player){
        return OakCount.get(player.getUniqueId());
    }
    public static void setOakQuestDefault(Player player){
        OakCount.put(player.getUniqueId(),0);
        OakQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(!event.getBlock().getType().equals(Material.OAK_LOG)){return;}
        if(event.getPlayer() == null){return;}

        Player player = event.getPlayer();
        if(getOak(player) == 150){
            OakQuestStatus.put(player.getUniqueId(),true);
            addOak(player);
            CoalQuest.giveReward(player);
        }
        if(getOak(player) < 150){addOak(player);}
    }
}
