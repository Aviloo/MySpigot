package com.aviloo.mybattlepass.Events.OtherEvents;

import com.aviloo.mybattlepass.Commands.FreeBattlePass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class FreeBattlePassBroadcast implements Listener {

    private static JavaPlugin plugin;

    public FreeBattlePassBroadcast(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(FreeBattlePass.getFreeStatus()){
            if(Objects.equals(plugin.getConfig().getString("FreeBattlePass_BroadcastMessage"), "false")){
                return;
            }
            Player player = event.getPlayer();
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Ура-Ура. На этой неделе боевой пропуск доступен " +
                        "всем " + ChatColor.GREEN + "бесплатно." + ChatColor.GRAY + " (используй комманду - /battlepass)");
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 1);
                player.sendTitle(ChatColor.AQUA + "Одна неделя", ChatColor.WHITE + "Бесплатного боевого пропуска!", 15, 25, 10);
            }, 75);
        }
    }
}
