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

public class ObsidianQuest implements Listener {

    private static final ConcurrentHashMap<UUID,Boolean> ObsidianQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isObsidianQuestComplete(Player player){
        if(ObsidianQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> ObsidianCount = new ConcurrentHashMap<>();

    private static void addObsidian(Player player){
        ObsidianCount.put(player.getUniqueId(),ObsidianCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getObsidian(Player player){
        return ObsidianCount.get(player.getUniqueId());
    }
    public static void setObsidianQuestDefault(Player player){
        ObsidianCount.put(player.getUniqueId(),0);
        ObsidianQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(!event.getBlock().getType().equals(Material.OBSIDIAN)){return;}
        if(event.getPlayer() == null){return;}

        Player player = event.getPlayer();
        if(getObsidian(player) == 40){
            ObsidianQuestStatus.put(player.getUniqueId(),true);
            addObsidian(player);
            CoalQuest.giveReward(player);
        }
        if(getObsidian(player) < 40){addObsidian(player);}
    }
}
