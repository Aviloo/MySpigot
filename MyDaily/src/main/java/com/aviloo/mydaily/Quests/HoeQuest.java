package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HoeQuest implements Listener {
    private static final ConcurrentHashMap<UUID,Boolean> HoeQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isHoeQuestComplete(Player player){
        if(HoeQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> HoeCount = new ConcurrentHashMap<>();

    private static void addHoe(Player player){
        HoeCount.put(player.getUniqueId(), HoeCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getHoe(Player player){
        return HoeCount.get(player.getUniqueId());
    }
    public static void setHoeQuestDefault(Player player){
        HoeCount.put(player.getUniqueId(),0);
        HoeQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void itemBreak(PlayerItemBreakEvent event){
        Player player = event.getPlayer();
        if(event.getBrokenItem().getType().equals(Material.IRON_HOE)) {
            if (getHoe(player) == 1) {
                HoeQuestStatus.put(player.getUniqueId(), true);
                addHoe(player);
                CoalQuest.giveReward(player);
            }
            if (getHoe(player) < 1) {
                addHoe(player);
            }
        }
        if(event.getBrokenItem().getType().equals(Material.DIAMOND_HOE)){
            if (getHoe(player) == 1) {
                HoeQuestStatus.put(player.getUniqueId(), true);
                addHoe(player);
                CoalQuest.giveReward(player);
            }
            if (getHoe(player) < 1) {
                addHoe(player);
            }
        }
        if(event.getBrokenItem().getType().equals(Material.NETHERITE_HOE)){
            if (getHoe(player) == 1) {
                HoeQuestStatus.put(player.getUniqueId(), true);
                addHoe(player);
                CoalQuest.giveReward(player);
            }
            if (getHoe(player) < 1) {
                addHoe(player);
            }
        }
    }
}
