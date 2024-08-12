package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.models.PluginPlayer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public class UsermapStorageUtil {

    private static Logger logger = MyTraderReloaded.getPlugin().getLogger();

    private static Map<UUID, PluginPlayer> usermap = new HashMap<>();

    private static FileConfiguration usermapConfig = MyTraderReloaded.getPlugin().usermapFileManager.getUsermapConfig();

    private static final String PLAYER_PLACEHOLDER = "%PLAYER%";

    public static void saveUsermap() throws IOException{
        for(Map.Entry<UUID, PluginPlayer> entry : usermap.entrySet()){
            usermapConfig.set("users.data."+entry.getKey() + ".gameName", entry.getValue().getName());
            usermapConfig.set("users.data."+entry.getKey() + ".javaUUID", entry.getValue().getJavaUUID());
            usermapConfig.set("users.data."+entry.getKey() + ".rep", entry.getValue().getReputation());

        }
        MyTraderReloaded.getPlugin().usermapFileManager.saveUsermapConfig();

    }

    public static void restoreUsermap() throws IOException {
        usermap.clear();
        usermapConfig.getConfigurationSection("users.data").getKeys(false).forEach(key ->{
            UUID uuid = UUID.fromString(key);

            String javaUUID = usermapConfig.getString("users.data." + key + ".javaUUID");
            String name = usermapConfig.getString("users.data." + key + ".gameName");
            int rep = usermapConfig.getInt("users.data." + key + ".rep");

            PluginPlayer pluginPlayer = new PluginPlayer(javaUUID, name);

            pluginPlayer.setReputation(rep);

            usermap.put(uuid, pluginPlayer);
        });
    }

    public static void addToUsermap(Player player){
        UUID uuid = player.getUniqueId();
        String javaUUID = uuid.toString();
        String name = player.getName();
        PluginPlayer pluginPlayer = new PluginPlayer(javaUUID, name);
        usermap.put(uuid, pluginPlayer);
    }

    public static boolean isUserExisting(Player player){
        UUID uuid = player.getUniqueId();
        if (usermap.containsKey(uuid)){
            return true;
        }
        return false;
    }

    public static PluginPlayer getClanPlayerByBukkitPlayer(Player player){
        UUID uuid = player.getUniqueId();
        if (usermap.containsKey(uuid)){
            PluginPlayer pluginPlayer = usermap.get(uuid);
            return pluginPlayer;
        }else {
            logger.warning(ColorUtils.translateColorCodes(ColorUtils.translateColorCodes(
                            "&4[Ошибка] &fИгрок не найден.")
                    .replace(PLAYER_PLACEHOLDER, player.getName())));
        }
        return null;
    }

    public static PluginPlayer getClanPlayerByBukkitOfflinePlayer(OfflinePlayer offlinePlayer){
        UUID uuid = offlinePlayer.getUniqueId();
        if (usermap.containsKey(uuid)){
            PluginPlayer pluginPlayer = usermap.get(uuid);
            return pluginPlayer;
        }else {
            logger.warning(ColorUtils.translateColorCodes(ColorUtils.translateColorCodes(
                            "&4[Ошибка] &fИгрок не найден.")
                    .replace(PLAYER_PLACEHOLDER, offlinePlayer.getName())));
        }
        return null;
    }

    public static Player getBukkitPlayerByName(String name){
        for (PluginPlayer pluginPlayer : usermap.values()){
            if (pluginPlayer.getName().equalsIgnoreCase(name)){
                return Bukkit.getPlayer(pluginPlayer.getName());
            }else {
                logger.warning(ColorUtils.translateColorCodes(ColorUtils.translateColorCodes(
                                "&4[Ошибка] &fИгрок не найден.")
                        .replace(PLAYER_PLACEHOLDER, name)));
            }
        }
        return null;
    }

    public static OfflinePlayer getBukkitOfflinePlayerByName(String name){
        for (PluginPlayer pluginPlayer : usermap.values()){
            if (pluginPlayer.getName().equalsIgnoreCase(name)){
                return Bukkit.getOfflinePlayer(UUID.fromString(pluginPlayer.getJavaUUID()));
            }else {
                logger.warning(ColorUtils.translateColorCodes(ColorUtils.translateColorCodes(
                                "&4[Ошибка] &fИгрок не найден.")
                        .replace(PLAYER_PLACEHOLDER, name)));
            }
        }
        return null;
    }

    public static Set<UUID> getRawUsermapList(){
        return usermap.keySet();
    }

    public static Map<UUID, PluginPlayer> getUsermap() {
        return usermap;
    }

    public static void addRepToOnlinePlayer(Player player, int value){
        UUID uuid = player.getUniqueId();
        PluginPlayer pluginPlayer = usermap.get(uuid);
        int currentRep = pluginPlayer.getReputation();
        pluginPlayer.setReputation(currentRep + value);
        usermap.replace(uuid,pluginPlayer);
    }

    public static int getRepByBukkitPlayer(Player player){
        UUID uuid = player.getUniqueId();
        PluginPlayer pluginPlayer = usermap.get(uuid);
        return pluginPlayer.getReputation();
    }

    public static void setRepForBukkitPlayer(Player player, int value){
        UUID uuid = player.getUniqueId();
        PluginPlayer pluginPlayer = usermap.get(uuid);
        pluginPlayer.setReputation(value);
        usermap.replace(uuid,pluginPlayer);
    }

    public static void takeRepFromBukkitPlayer(Player player, int value){
        UUID uuid = player.getUniqueId();
        PluginPlayer pluginPlayer = usermap.get(uuid);
        pluginPlayer.setReputation(pluginPlayer.getReputation() - value);
        usermap.replace(uuid,pluginPlayer);
    }

}