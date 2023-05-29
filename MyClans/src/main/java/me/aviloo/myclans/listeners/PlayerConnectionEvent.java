package me.aviloo.myclans.listeners;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.utils.ColorUtils;
import me.aviloo.myclans.utils.UsermapStorageUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;
import java.util.logging.Logger;

public class PlayerConnectionEvent implements Listener {

    FileConfiguration clansConfig = MyClans.getPlugin().getConfig();
    Logger logger = MyClans.getPlugin().getLogger();

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        MyClans.connectedPlayers.put(player, player.getName());
        if (!(UsermapStorageUtil.isUserExisting(player))){
            UsermapStorageUtil.addToUsermap(player);
            return;
        }
        if (UsermapStorageUtil.hasPlayerNameChanged(player)){
            UsermapStorageUtil.updatePlayerName(player);
            if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aUpdated player name"));
            }
        }
    }

    @EventHandler (priority = EventPriority.NORMAL)
    public void onBedrockPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        if (MyClans.getFloodgateApi() != null){
            if (MyClans.getFloodgateApi().isFloodgatePlayer(uuid)){
                if (!(UsermapStorageUtil.isUserExisting(player))){
                    UsermapStorageUtil.addBedrockPlayerToUsermap(player);
                    return;
                }
                if (UsermapStorageUtil.hasPlayerNameChanged(player)){
                    UsermapStorageUtil.updatePlayerName(player);
                    if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                        logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aUpdated bedrock player name"));
                    }
                }
                if (UsermapStorageUtil.hasBedrockPlayerJavaUUIDChanged(player)){
                    UsermapStorageUtil.updateBedrockPlayerJavaUUID(player);
                    if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                        logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aUpdated bedrock player Java UUID"));
                    }
                }
                MyClans.bedrockPlayers.put(player, MyClans.getFloodgateApi().getPlayer(uuid).getJavaUniqueId().toString());
                if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                    logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aAdded bedrock player to connected bedrock players hashmap"));
                }
            }
        }
    }
}
