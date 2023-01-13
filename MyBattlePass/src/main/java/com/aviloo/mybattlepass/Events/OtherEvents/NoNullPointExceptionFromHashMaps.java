package com.aviloo.mybattlepass.Events.OtherEvents;

import com.aviloo.mybattlepass.Utils.BPExp;
import com.aviloo.mybattlepass.Utils.BPLevel;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NoNullPointExceptionFromHashMaps implements Listener {

    @EventHandler (priority = EventPriority.HIGHEST,ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!player.hasPlayedBefore()){ //TODO добавить ! (ВЫПОЛНЕННО)
            BPExp.setDefault(player.getUniqueId());
            BPLevel.setDefault(player.getUniqueId());
        }
    }
}
