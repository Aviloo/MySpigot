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

public class StoneQuest implements Listener {

    private static final ConcurrentHashMap<UUID,Boolean> StoneQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isStoneQuestComplete(Player player){
        if(StoneQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> StoneCount = new ConcurrentHashMap<>();

    public static void addStone(Player player){
        StoneCount.put(player.getUniqueId(),StoneCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getStone(Player player){
        return StoneCount.get(player.getUniqueId());
    }
    public static void setStoneQuestDefault(Player player){
        StoneCount.put(player.getUniqueId(),0);
        StoneQuestStatus.put(player.getUniqueId(),false);
    }


    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(!event.getBlock().getType().equals(Material.STONE)){return;}
        if(event.getPlayer() == null){return;}

        Player player = event.getPlayer();
        if(getStone(player) == 550){
            StoneQuestStatus.put(player.getUniqueId(),true);
            addStone(player);
            CoalQuest.giveReward(player);
        }
        if(getStone(player) < 550){addStone(player);}
    }
}
