package me.aviloo.myAdmins.Utils.StorageUtils;

import me.aviloo.myAdmins.Models.PluginPlayer;
import me.aviloo.myAdmins.MyAdmins;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public class UsermapStorageUtil {

    private static Logger logger = MyAdmins.getPlugin().getLogger();

    private static Map<UUID, PluginPlayer> usermap = new HashMap<>();

    private static FileConfiguration usermapConfig = MyAdmins.getPlugin().usermapFileManager.getUsermapConfig();

    private static final String PLAYER_PLACEHOLDER = "%PLAYER%";

    public static void saveUsermap() throws IOException {
        for(Map.Entry<UUID, PluginPlayer> entry : usermap.entrySet()){
            usermapConfig.set("users.data."+entry.getKey() + ".uuid", entry.getValue().getUuid().toString());
            usermapConfig.set("users.data."+entry.getKey() + ".name", entry.getValue().getName());
            usermapConfig.set("users.data."+entry.getKey() + ".address", entry.getValue().getAddress());
            usermapConfig.set("users.data."+entry.getKey() + ".banned", entry.getValue().isBanned());
            usermapConfig.set("users.data."+entry.getKey() + ".muted",entry.getValue().isMuted());



        }
        MyAdmins.getPlugin().usermapFileManager.saveUsermapConfig();

    }

    public static void restoreUsermap() throws IOException {
        usermap.clear();
        usermapConfig.getConfigurationSection("users.data").getKeys(false).forEach(key ->{
            UUID uuid = UUID.fromString(key);

            UUID ownerUUID = UUID.fromString(usermapConfig.getString("users.data."+ key +".uuid"));
            String name = usermapConfig.getString("users.data."+ key +".name");
            String address = usermapConfig.getString("users.data." + key + ".address");
            boolean banned = usermapConfig.getBoolean("users.data." + key + ".banned");
            boolean muted = usermapConfig.getBoolean("users.data." + key + ".muted");

            PluginPlayer player = new PluginPlayer(ownerUUID,name,address,
                    banned,muted);

            usermap.put(uuid, player);
        });
    }

    public static boolean isUserExisting(Player player){
        UUID uuid = player.getUniqueId();
        if (usermap.containsKey(uuid)){
            return true;
        }
        return false;
    }

    public static Set<UUID> getRawUsermapList(){
        return usermap.keySet();
    }

    public static void addPluginPlayer(UUID uuid, PluginPlayer player){
        usermap.put(uuid, player);
    }
}
