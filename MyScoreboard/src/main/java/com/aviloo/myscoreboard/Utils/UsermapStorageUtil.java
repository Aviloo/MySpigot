package com.aviloo.myscoreboard.Utils;

import com.aviloo.myscoreboard.MyScoreboard;
import com.aviloo.myscoreboard.models.PlayerTags;
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

    private static Logger logger = MyScoreboard.getPlugin().getLogger();

    private static Map<UUID, PlayerTags> usermap = new HashMap<>();

    private static FileConfiguration usermapConfig = MyScoreboard.getPlugin().usermapFileManager.getUsermapConfig();

    private static final String PLAYER_PLACEHOLDER = "%PLAYER%";

    public static void saveUsermap() throws IOException{
        for(Map.Entry<UUID, PlayerTags> entry: usermap.entrySet()){
            usermapConfig.set("users.data." + entry.getKey() + ".javaUUID", entry.getValue().getJavaUUID());
            usermapConfig.set("users.data." + entry.getKey() + ".lastPlayerName", entry.getValue().getLastPlayerName());
            usermapConfig.set("users.data." + entry.getKey() + ".killsTag",entry.getValue().isKillsTag());
            usermapConfig.set("users.data." + entry.getKey() + ".deathsTag",entry.getValue().isDeathsTag());
            usermapConfig.set("users.data." + entry.getKey() + ".hoursTag",entry.getValue().isHoursTag());
            usermapConfig.set("users.data." + entry.getKey() + ".pingTag",entry.getValue().isPingTag());
            usermapConfig.set("users.data." + entry.getKey() + ".mobs_killedTag",entry.getValue().isMobs_killedTag());
            usermapConfig.set("users.data." + entry.getKey() + ".blocks_breakTag",entry.getValue().isBlocks_breakTag());
            usermapConfig.set("users.data." + entry.getKey() + ".coordsTag",entry.getValue().isCoordsTag());
            usermapConfig.set("users.data." + entry.getKey() + ".kills_deathsTag",entry.getValue().isKills_deathsTag());
            usermapConfig.set("users.data." + entry.getKey() + ".hand_durabilityTag",entry.getValue().isHand_durabilityTag());
            usermapConfig.set("users.data." + entry.getKey() + ".totem_countTag",entry.getValue().isTotem_countTag());
            usermapConfig.set("users.data." + entry.getKey() + ".helmet_durabilityTag",entry.getValue().isHelmet_durabilityTag());
            usermapConfig.set("users.data." + entry.getKey() + ".chestplate_durabilityTag",entry.getValue().isChestplate_durabilityTag());
            usermapConfig.set("users.data." + entry.getKey() + ".leggings_durabilityTag",entry.getValue().isLeggings_durabilityTag());
            usermapConfig.set("users.data." + entry.getKey() + ".boots_durabilityTag",entry.getValue().isBoots_durabilityTag());
        }
        MyScoreboard.getPlugin().usermapFileManager.saveUsermapConfig();
    }

    public static void restoreUsermap() throws IOException{
        usermap.clear();
        usermapConfig.getConfigurationSection("users.data").getKeys(false).forEach(key -> {
            UUID uuid = UUID.fromString(key);

            String javaUUID = usermapConfig.getString("users.data." + key + ".javaUUID");
            String lastPlayerName = usermapConfig.getString("users.data." + key + ".lastPlayerName");
            boolean killsTag = usermapConfig.getBoolean("users.data." + key + ".killsTag");
            boolean deathsTag = usermapConfig.getBoolean("users.data." + key + ".deathsTag");
            boolean hoursTag = usermapConfig.getBoolean("users.data." + key + ".hoursTag");
            boolean pingTag = usermapConfig.getBoolean("users.data." + key + ".pingTag");
            boolean mobs_killedTag = usermapConfig.getBoolean("users.data." + key + ".mobs_killedTag");
            boolean blocks_breakTag = usermapConfig.getBoolean("users.data." + key + ".blocks_breakTag");
            boolean coordsTag = usermapConfig.getBoolean("users.data." + key + ".coordsTag");
            boolean kills_deathsTag = usermapConfig.getBoolean("users.data." + key + ".kills_deathsTag");
            boolean hand_durabilityTag = usermapConfig.getBoolean("users.data." + key + ".hand_durabilityTag");
            boolean totem_countTag = usermapConfig.getBoolean("users.data." + key + ".totem_countTag");
            boolean helmet_durabilityTag = usermapConfig.getBoolean("users.data." + key + ".helmet_durabilityTag");
            boolean chestplate_durabilityTag = usermapConfig.getBoolean("users.data." + key + ".chestplate_durabilityTag");
            boolean leggings_durabilityTag = usermapConfig.getBoolean("users.data." + key + ".leggings_durabilityTag");
            boolean boots_durabilityTag = usermapConfig.getBoolean("users.data." + key + ".boots_durabilityTag");

            PlayerTags playerTags = new PlayerTags(javaUUID,lastPlayerName);

            playerTags.setKillsTag(killsTag);
            playerTags.setDeathsTag(deathsTag);
            playerTags.setHoursTag(hoursTag);
            playerTags.setPingTag(pingTag);
            playerTags.setMobs_killedTag(mobs_killedTag);
            playerTags.setBlocks_breakTag(blocks_breakTag);
            playerTags.setCoordsTag(coordsTag);
            playerTags.setKills_deathsTag(kills_deathsTag);
            playerTags.setHand_durabilityTag(hand_durabilityTag);
            playerTags.setTotem_countTag(totem_countTag);
            playerTags.setHelmet_durabilityTag(helmet_durabilityTag);
            playerTags.setChestplate_durabilityTag(chestplate_durabilityTag);
            playerTags.setLeggings_durabilityTag(leggings_durabilityTag);
            playerTags.setBoots_durabilityTag(boots_durabilityTag);

            usermap.put(uuid, playerTags);
        });
    }

    public static void addToUsermap(Player player){
        UUID uuid = player.getUniqueId();
        String javaUUID = uuid.toString();
        String lastPlayerName = player.getName();
        PlayerTags playerTags = new PlayerTags(javaUUID, lastPlayerName);
        usermap.put(uuid, playerTags);
    }

    public static boolean isUserExisting(Player player){
        UUID uuid = player.getUniqueId();
        if (usermap.containsKey(uuid)){
            return true;
        }
        return false;
    }

    public static PlayerTags getClanPlayerByBukkitPlayer(Player player){
        UUID uuid = player.getUniqueId();
        String player_not_found_1 = "&7[MyScoreboard]: &4Не удалось найти игрока по имени&6%PLAYER%&4!";
        String player_not_found_2 = "&7[MyScoreboard]: &4Убедитесь, что &6%PLAYER% &4присоединялся раньше!";
        if (usermap.containsKey(uuid)){
            PlayerTags playerTags = usermap.get(uuid);
            return playerTags;
        }else {
            logger.warning(ColorUtils.translateColorCodes(player_not_found_1
                    .replace(PLAYER_PLACEHOLDER, player.getName())));
            logger.warning(ColorUtils.translateColorCodes(player_not_found_2
                    .replace(PLAYER_PLACEHOLDER, player.getName())));
        }
        return null;
    }

    public static PlayerTags getClanPlayerByBukkitOfflinePlayer(OfflinePlayer offlinePlayer){
        UUID uuid = offlinePlayer.getUniqueId();
        String player_not_found_1 = "&7[MyScoreboard]: &4Не удалось найти игрока по имени&6%PLAYER%&4!";
        String player_not_found_2 = "&7[MyScoreboard]: &4Убедитесь, что &6%PLAYER% &4присоединялся раньше!";
        if (usermap.containsKey(uuid)){
            PlayerTags playerTags = usermap.get(uuid);
            return playerTags;
        }else {
            logger.warning(ColorUtils.translateColorCodes(player_not_found_1
                    .replace(PLAYER_PLACEHOLDER, offlinePlayer.getName())));
            logger.warning(ColorUtils.translateColorCodes(player_not_found_2
                    .replace(PLAYER_PLACEHOLDER, offlinePlayer.getName())));
        }
        return null;
    }

    public static Player getBukkitPlayerByName(String name){
        String player_not_found_1 = "&7[MyScoreboard]: &4Не удалось найти игрока по имени&6%PLAYER%&4!";
        String player_not_found_2 = "&7[MyScoreboard]: &4Убедитесь, что &6%PLAYER% &4присоединялся раньше!";
        for (PlayerTags playerTags : usermap.values()){
            if (playerTags.getLastPlayerName().equalsIgnoreCase(name)){
                return Bukkit.getPlayer(playerTags.getLastPlayerName());
            }else {
                logger.warning(ColorUtils.translateColorCodes(player_not_found_1
                        .replace(PLAYER_PLACEHOLDER, name)));
                logger.warning(ColorUtils.translateColorCodes(player_not_found_2
                        .replace(PLAYER_PLACEHOLDER, name)));
            }
        }
        return null;
    }

    public static OfflinePlayer getBukkitOfflinePlayerByName(String name){
        String player_not_found_1 = "&7[MyScoreboard]: &4Не удалось найти игрока по имени&6%PLAYER%&4!";
        String player_not_found_2 = "&7[MyScoreboard]: &4Убедитесь, что &6%PLAYER% &4присоединялся раньше!";
        for (PlayerTags playerTags : usermap.values()){
            if (playerTags.getLastPlayerName().equalsIgnoreCase(name)){
                return Bukkit.getOfflinePlayer(UUID.fromString(playerTags.getJavaUUID()));
            }else {
                logger.warning(ColorUtils.translateColorCodes(player_not_found_1
                        .replace(PLAYER_PLACEHOLDER, name)));
                logger.warning(ColorUtils.translateColorCodes(player_not_found_2
                        .replace(PLAYER_PLACEHOLDER, name)));
            }
        }
        return null;
    }

    public static boolean hasPlayerNameChanged(Player player){
        for (PlayerTags playerTags : usermap.values()){
            if (!player.getName().equals(playerTags.getLastPlayerName())){
                return true;
            }
        }
        return false;
    }

    public static void updatePlayerName(Player player){
        UUID uuid = player.getUniqueId();
        String newPlayerName = player.getName();
        PlayerTags playerTags = usermap.get(uuid);
        playerTags.setLastPlayerName(newPlayerName);
        usermap.replace(uuid, playerTags);
    }

    public static Set<UUID> getRawUsermapList(){
        return usermap.keySet();
    }

    public static Map<UUID, PlayerTags> getUsermap() {
        return usermap;
    }

}
