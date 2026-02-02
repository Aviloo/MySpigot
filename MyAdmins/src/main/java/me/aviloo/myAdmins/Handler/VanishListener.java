package me.aviloo.myAdmins.Handler;

import me.aviloo.myAdmins.Commands.VanishCommand;
import me.aviloo.myAdmins.MyAdmins;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class VanishListener implements Listener {

    @EventHandler
    public void onWorld(PlayerChangedWorldEvent event) {
        if(!VanishCommand.containsVanished(event.getPlayer().getUniqueId())){return;}
        if(VanishCommand.getVanished(event.getPlayer().getUniqueId())){
            for(Player ps : Bukkit.getOnlinePlayers()){
                event.getPlayer().hidePlayer(MyAdmins.getPlugin(),ps);
            }
        }
    }

}
