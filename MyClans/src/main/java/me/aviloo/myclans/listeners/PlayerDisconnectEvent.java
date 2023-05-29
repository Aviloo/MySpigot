package me.aviloo.myclans.listeners;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.logging.Logger;

public class PlayerDisconnectEvent implements Listener {

    FileConfiguration clansConfig = MyClans.getPlugin().getConfig();
    Logger logger = MyClans.getPlugin().getLogger();

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        MyClans.connectedPlayers.remove(player);
        if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
            logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aPlayer removed from connected players list"));
        }
    }

    @EventHandler (priority = EventPriority.NORMAL)
    public void onBedrockPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if (MyClans.getFloodgateApi() != null){
            if (MyClans.bedrockPlayers.containsKey(player)){
                MyClans.bedrockPlayers.remove(player);
                if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                    logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aBedrock player removed from bedrock players list"));
                }
            }
        }
    }
}
