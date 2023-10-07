package com.aviloo.myscoreboard.Utils.GlobalEvents;

import com.aviloo.myscoreboard.MyScoreboard;
import com.aviloo.myscoreboard.Utils.UsermapStorageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

public class GlobalConnectionEvent implements Listener {

    Logger logger = MyScoreboard.getPlugin().getLogger();

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        MyScoreboard.connectedPlayers.put(player, player.getName());
        if (!(UsermapStorageUtil.isUserExisting(player))){
            UsermapStorageUtil.addToUsermap(player);
            return;
        }
        if (UsermapStorageUtil.hasPlayerNameChanged(player)){
            UsermapStorageUtil.updatePlayerName(player);
        }
    }

}
