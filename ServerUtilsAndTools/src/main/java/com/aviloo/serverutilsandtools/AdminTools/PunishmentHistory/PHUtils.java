package com.aviloo.serverutilsandtools.AdminTools.PunishmentHistory;

import org.bukkit.entity.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;

public class PHUtils {
    private static final LinkedHashMap<UUID, ArrayList<String>> playerPunishmentHistory = new LinkedHashMap<>();

    public static void addBan(Player player, LocalDate date){
        String punish = "Игрок " + player.getName() + "был забанен - " + date;
        ArrayList<String> CurrentPunishList = new ArrayList<>();
        ArrayList<String> OldPunishList = playerPunishmentHistory.get(player.getUniqueId());
        CurrentPunishList.addAll(OldPunishList);
        CurrentPunishList.add(punish);
        playerPunishmentHistory.put(player.getUniqueId(),CurrentPunishList);
    }

    public static void putPlayerHash(Player player,ArrayList<String> list){
        playerPunishmentHistory.put(player.getUniqueId(),list);
    }
}
