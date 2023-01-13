package com.aviloo.mydaily.Quests;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CoalQuest implements Listener {

    protected static void giveReward(Player player){
        player.sendMessage(ChatColor.GRAY+"[Система] "+
                ChatColor.WHITE+"Вы выполнили ежедневный квест. Чтобы посмотреть список квестов" +
                ", кликните на" +
                " Джошуа (На спавне).");
        player.sendTitle(ChatColor.GREEN+"Пройденно",ChatColor.WHITE+"Вы выполнили ежедневный квест",
                15,25,15);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,1,1);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"eco give "+player.getName()+" 150");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"bpaddexp "+player.getName()+" 20");
    }

    private static final ConcurrentHashMap<UUID,Boolean> CoalQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isCoalQuestComplete(Player player){
        if(CoalQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> CoalCount = new ConcurrentHashMap<>();

    public static void addCoal(Player player){
        CoalCount.put(player.getUniqueId(),CoalCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getCoal(Player player){
        return CoalCount.get(player.getUniqueId());
    }
    public static void setCoalQuestDefault(Player player){
        CoalCount.put(player.getUniqueId(),0);
        CoalQuestStatus.put(player.getUniqueId(),false);
    }

    public static Boolean hasPlayedToday(Player player){
        if(CoalCount.containsKey(player)){return true;}
        return false;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(!event.getBlock().getType().equals(Material.COAL_ORE)){return;}
        if(event.getPlayer() == null){return;}

        Player player = event.getPlayer();
        if(getCoal(player) == 100){
            CoalQuestStatus.put(player.getUniqueId(),true);
            addCoal(player);
            giveReward(player);
        }
        if(getCoal(player) < 100){addCoal(player);}
    }
}
