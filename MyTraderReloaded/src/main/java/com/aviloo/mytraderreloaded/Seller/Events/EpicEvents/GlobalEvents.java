package com.aviloo.mytraderreloaded.Seller.Events.EpicEvents;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class GlobalEvents implements Listener {

    private JavaPlugin plugin;

    public GlobalEvents(JavaPlugin plugin){
        this.plugin = plugin;
    }

    private void sender(Player player,String ... lines){
        for(String str : lines){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',str));
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(!MyTraderReloaded.getIsEpicType()){return;}
        Bukkit.getScheduler().runTaskLater(plugin,() -> {
            sender(event.getPlayer(),"&7====================================== ",
                    " ",
                    "&a♦&f&lВнимание - Внимание.&a♦",
                    "&fСегодня - отличный день! На сервере появился &dЭпический скупщик&f. Успей заработать на этом.",
                    " ",
                    "&7====================================== ");
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH,5,1);
            event.getPlayer().playSound(event.getPlayer().getLocation(),Sound.ENTITY_PLAYER_LEVELUP,4,1);
        },140);
    }
}
