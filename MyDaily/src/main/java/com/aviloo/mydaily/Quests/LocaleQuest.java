package com.aviloo.mydaily.Quests;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLocaleChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LocaleQuest implements Listener {

    private JavaPlugin plugin;

    public LocaleQuest(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public static void setDefaultLocaleQuest(Player player){
        LocaleQuestStatus.put(player.getUniqueId(), false);
    }

    private static final ConcurrentHashMap<UUID,Boolean> LocaleQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isLocaleQuestComplete(Player player){
        if(LocaleQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    @EventHandler
    public void onLocale(PlayerLocaleChangeEvent event){
        if(!event.getLocale().equals("日本語")){return;}

        Player player = event.getPlayer();
        Bukkit.getScheduler().runTaskLater(plugin,() -> {
            LocaleQuestStatus.put(player.getUniqueId(), true);
            CoalQuest.giveReward(player);
        },36000);
    }
}
