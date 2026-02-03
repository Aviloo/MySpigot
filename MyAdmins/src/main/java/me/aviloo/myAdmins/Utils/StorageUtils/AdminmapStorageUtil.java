package me.aviloo.myAdmins.Utils.StorageUtils;

import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.MyAdmins;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public class AdminmapStorageUtil {

    private static Logger logger = MyAdmins.getPlugin().getLogger();

    private static Map<UUID, Admin> usermap = new HashMap<>();

    private static FileConfiguration usermapConfig = MyAdmins.getPlugin().adminmapFileManager.getAdminmapConfig();

    private static final String PLAYER_PLACEHOLDER = "%PLAYER%";

    public static void saveUsermap() throws IOException {
        for(Map.Entry<UUID, Admin> entry : usermap.entrySet()){
            usermapConfig.set("users.data."+entry.getKey() + ".name", entry.getValue().getName());
            usermapConfig.set("users.data."+entry.getKey() + ".uuid", entry.getValue().getUUIDString());
            usermapConfig.set("users.data."+entry.getKey() + ".type", entry.getValue().getAdminType().getName());
            usermapConfig.set("users.data."+entry.getKey() + ".currentIP", entry.getValue().getCurrent_ip());
            usermapConfig.set("users.data."+entry.getKey() + ".LastIP", entry.getValue().getLast_ip());
            usermapConfig.set("users.data."+entry.getKey() + ".regDate", entry.getValue().getRegistration_date());
            usermapConfig.set("users.data."+entry.getKey() + ".banCount", entry.getValue().getBan_count());
            usermapConfig.set("users.data."+entry.getKey() + ".kickCount", entry.getValue().getKick_count());
            usermapConfig.set("users.data."+entry.getKey() + ".muteCount",entry.getValue().getMute_count());
            usermapConfig.set("users.data."+entry.getKey() + ".banipCount", entry.getValue().getBanip_count());
            usermapConfig.set("users.data."+entry.getKey() + ".tempbanCount", entry.getValue().getTempban_count());
            usermapConfig.set("users.data."+entry.getKey() + ".tempMuteCount", entry.getValue().getTempmute_count());
            usermapConfig.set("users.data."+entry.getKey() + ".LSTime", entry.getValue().getLast_session_time());
            usermapConfig.set("users.data."+entry.getKey() + ".LCDate", entry.getValue().getLast_connection_date());



        }
        MyAdmins.getPlugin().adminmapFileManager.saveAdminmapConfig();

    }

    public static void restoreUsermap() throws IOException {
        usermap.clear();
        usermapConfig.getConfigurationSection("users.data").getKeys(false).forEach(key ->{
            UUID uuid = UUID.fromString(key);

            String name = usermapConfig.getString("users.data." + key + ".name");
            UUID ownerUUID = UUID.fromString(usermapConfig.getString("users.data."+ key +".uuid"));
            Admin.AdminType type = Admin.AdminType.valueOf(usermapConfig.getString("users.data."+ key +".type"));
            String currentIP = usermapConfig.getString("users.data." + key + ".currentIP");
            String LastIP = usermapConfig.getString("users.data." + key + ".LastIP");
            String reg = usermapConfig.getString("users.data." + key + ".regDate");
            int ban = usermapConfig.getInt("users.data." + key + ".banCount");
            int kick = usermapConfig.getInt("users.data." + key + ".kickCount");
            int mute = usermapConfig.getInt("users.data." + key + ".muteCount");
            int banip = usermapConfig.getInt("users.data." + key + ".banipCount");
            int tempban = usermapConfig.getInt("users.data." + key + ".tempbanCount");
            int tempmute = usermapConfig.getInt("users.data." + key + ".tempMuteCount");
            String LSTime = usermapConfig.getString("users.data." + key + ".LSTime");
            String LCDate = usermapConfig.getString("users.data." + key + ".LCDate");

            Admin admin = new Admin(name,ownerUUID,type,currentIP,LastIP,
                    reg,ban,kick,mute,banip,tempban,tempmute,LSTime,LCDate);

            usermap.put(uuid, admin);
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

    public static void addAdminToMap(UUID uuid, Admin admin){
        usermap.put(uuid, admin);
    }

}
