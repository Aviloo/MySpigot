package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAnimationEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GoldenAppleQuest implements Listener {
    private static final ConcurrentHashMap<UUID,Boolean> GoldenQuestStatus = new ConcurrentHashMap<>();
    public static Boolean isGoldenQuestComplete(Player player){
        return GoldenQuestStatus.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID,Integer> GoldenCount = new ConcurrentHashMap<>();
    public static void addGolden(Player player){
        GoldenCount.put(player.getUniqueId(),GoldenCount.getOrDefault(player.getUniqueId(),0)+1);
    }
    public static Integer getGolden(Player player){
        return GoldenCount.get(player.getUniqueId());
    }

    public static void setGoldenDefault(Player player){
        GoldenCount.put(player.getUniqueId(),0);
        GoldenQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onAte(FoodLevelChangeEvent event) {
        if(event.getEntity().getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_APPLE)){
            Player player = (Player) event.getEntity();
            if(getGolden(player) == 10){
                GoldenQuestStatus.put(player.getUniqueId(),true);
                addGolden(player);
                CoalQuest.giveReward(player);
            }
            if(getGolden(player) < 10){addGolden(player);}
        }
    }
}
