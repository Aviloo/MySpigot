package com.aviloo.serverutilsandtools.SmallServerFunc.FixBetterRTP;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class FBRTPEvents implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        if(!event.getMessage().startsWith("/rtp")){return;}
        event.setCancelled(true);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"rtp player "+ event.getPlayer().getName()+
                " world");
    }
}
