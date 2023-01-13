package com.aviloo.mydaily.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEntityEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AxolotlQuest implements Listener {

    private static final ConcurrentHashMap<UUID,Boolean> AxolotlQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isAxolotlQuestComplete(Player player){
        if(AxolotlQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> AxolotlCount = new ConcurrentHashMap<>();

    public static void addAxolotl(Player player){
        AxolotlCount.put(player.getUniqueId(), AxolotlCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getAxolotl(Player player){
        return AxolotlCount.get(player.getUniqueId());
    }
    public static void setAxolotlQuestDefault(Player player){
        AxolotlCount.put(player.getUniqueId(),0);
        AxolotlQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onBuket(PlayerBucketEntityEvent event){
        if(!event.getEntity().getType().equals(EntityType.AXOLOTL)){return;}

        Player player = event.getPlayer();
        if(getAxolotl(player) == 15){
            AxolotlQuestStatus.put(player.getUniqueId(),true);
            addAxolotl(player);
            CoalQuest.giveReward(player);
        }
        if(getAxolotl(player) < 15){addAxolotl(player);}
    }
}
