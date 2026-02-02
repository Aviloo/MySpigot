package me.aviloo.myAdmins.Utils.StorageUtils;

import me.aviloo.myAdmins.Models.PluginPlayer;
import me.aviloo.myAdmins.Models.Punishment;
import me.aviloo.myAdmins.MyAdmins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import static me.aviloo.myAdmins.Models.PluginPlayer.getPluginPlayerByUUID;

public class PunishmentStorageUtil {

    private static Logger logger = MyAdmins.getPlugin().getLogger();

    private static Map<Integer, Punishment> usermap = new HashMap<>();

    private static FileConfiguration punishmentConfig = MyAdmins.getPlugin().punishmentFileManager.getPunishmentConfig();

    public static void saveUsermap() throws IOException {
        for(Map.Entry<Integer, Punishment> entry : usermap.entrySet()){
            punishmentConfig.set("users.data."+entry.getKey() + ".id", entry.getValue().getId());
            punishmentConfig.set("users.data."+entry.getKey() + ".type", entry.getValue().getType());
            punishmentConfig.set("users.data."+entry.getKey() + ".suspect", entry.getValue().getSuspect_name());
            punishmentConfig.set("users.data."+entry.getKey() + ".suspectUUID", entry.getValue().getSuspect_uuid());
            punishmentConfig.set("users.data."+entry.getKey() + ".suspect_address", entry.getValue().getSuspect_ip());
            punishmentConfig.set("users.data."+entry.getKey() + ".admin", entry.getValue().getAdmin_name());
            punishmentConfig.set("users.data."+entry.getKey() + ".adminUUID", entry.getValue().getAdmin_uuid());
            punishmentConfig.set("users.data."+entry.getKey() + ".reason",entry.getValue().getReason());
            punishmentConfig.set("users.data."+entry.getKey() + ".date",entry.getValue().getDate());


        }
        MyAdmins.getPlugin().punishmentFileManager.savePunishmentConfig();

    }

    public static void restorePunishment() throws IOException {
        usermap.clear();
        punishmentConfig.getConfigurationSection("users.data").getKeys(false).forEach(key ->{
            int id = Integer.parseInt(key);

            int local_id = punishmentConfig.getInt("users.data."+ key +".id");
            String type = punishmentConfig.getString("users.data."+ key +".type");
            String suspect = punishmentConfig.getString("users.data."+ key +".suspect");
            String address = punishmentConfig.getString("users.data." + key + ".suspect_address");
            String admin = punishmentConfig.getString("users.data."+ key +".admin");
            String reason = punishmentConfig.getString("users.data."+ key +".reason");
            String date = punishmentConfig.getString("users.data."+ key +".date");
            String adminUUID = punishmentConfig.getString("users.data."+ key +".adminUUID");
            String suspectUUID = punishmentConfig.getString("users.data."+ key +".suspectUUID");

            Punishment punishment = new Punishment(local_id,type,suspect,suspectUUID,admin,
                    adminUUID,reason,address,date);
            usermap.put(id, punishment);
            addPunishmentToPlayer(punishment);
        });
    }


    public static Set<Integer> getRawPunishmentList(){
        return usermap.keySet();
    }

    public static void addPunishment(int id, Punishment punishment){
        usermap.put(id, punishment);
    }

    private static ConcurrentHashMap<UUID, List<Punishment>> playerPunishments = new ConcurrentHashMap<>();

    private static void loadPunishmentToPlayer(Punishment punishment){
        boolean found = false;
        for (PluginPlayer player : PluginPlayer.players){
            if (punishment.getSuspect_uuid().equals(player.getUuid().toString())) {
                if(playerPunishments.containsKey(player.getUuid())){
                    playerPunishments.get(player.getUuid()).add(punishment);
                }
                if(!playerPunishments.containsKey(player.getUuid())){
                    playerPunishments.put(player.getUuid(), new ArrayList<>());
                    playerPunishments.get(player.getUuid()).add(punishment);
                }
                Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "Нак. От " + punishment.getAdmin_name() +
                        " записано игроку " + player.getName());
                found = true;
            }
            Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "Игрок: " + player.getName() + " - " +
                    "П Punishments: " + player.getPunishments().size());
        }
        if (!found) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Игрок с UUID " + punishment.getSuspect_uuid() + " не найден");
        }
    }

    private static ConcurrentHashMap<UUID, Set<Punishment>> playerPunishmentMap = new ConcurrentHashMap<>();

    public static void addPunishmentToPlayer(Punishment punishment){
        if(!playerPunishmentMap.containsKey(UUID.fromString(punishment.getSuspect_uuid()))){
            Set<Punishment> list = new HashSet<>();
            list.add(punishment);
            playerPunishmentMap.put(UUID.fromString(punishment.getSuspect_uuid()),list);
            return;
        }
        Set<Punishment> list = playerPunishmentMap.get(UUID.fromString(punishment.getSuspect_uuid()));
        list.add(punishment);
        playerPunishmentMap.put(UUID.fromString(punishment.getSuspect_uuid()),list);
    }

    public static Set<Punishment> getPunishments(UUID uuid){
        if(!playerPunishmentMap.containsKey(uuid)){
            return new HashSet<>();
        }
        return playerPunishmentMap.get(uuid);
    }

    public static boolean hasPunishment(UUID uuid){
        return playerPunishmentMap.containsKey(uuid);
    }

}
