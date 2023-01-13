package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CaneQuest implements Listener {

    private static final ConcurrentHashMap<UUID,Boolean> CaneQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isCaneQuestComplete(Player player){
        if(CaneQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> CaneCount = new ConcurrentHashMap<>();

    public static void addCane(Player player){
        CaneCount.put(player.getUniqueId(), CaneCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getCane(Player player){
        return CaneCount.get(player.getUniqueId());
    }
    public static void setCaneQuestDefault(Player player){
        CaneCount.put(player.getUniqueId(),0);
        CaneQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        if(!event.getBlockPlaced().getType().equals(Material.SUGAR_CANE)){return;}

        Player player = event.getPlayer();
        if(getCane(player) == 84){
            CaneQuestStatus.put(player.getUniqueId(),true);
            addCane(player);
            CoalQuest.giveReward(player);
        }
        if(getCane(player) < 84){addCane(player);}
    }
}
