package me.aviloo.myAdmins.Models;

import me.aviloo.myAdmins.Utils.StorageUtils.UsermapStorageUtil;
import org.bukkit.entity.Player;

import java.util.*;

public class PluginPlayer {

    private UUID uuid;
    private String name;
    private String address;
    private List<Punishment> punishments;
    private boolean banned;
    private boolean muted;
    private long duration;

    public PluginPlayer(UUID uuid, String name, String address) {
        this.uuid = uuid;
        this.name = name;
        this.address = address;
        this.punishments = new ArrayList<>();
        this.banned = false;
        this.muted = false;
        this.duration = 0;
        players.add(this);
        UsermapStorageUtil.addPluginPlayer(uuid, this);
    }

    public PluginPlayer(UUID uuid, String name, String address, boolean banned, boolean muted, long duration) {
        this.uuid = uuid;
        this.name = name;
        this.address = address;
        this.punishments = new ArrayList<>();
        this.banned = banned;
        this.muted = muted;
        this.duration = duration;
        players.add(this);
    }

    public static Set<PluginPlayer> players = new HashSet<PluginPlayer>();

    public static boolean playerIsPluginPlayer(UUID uuid) {
        for (PluginPlayer p : players) {
            if (p.getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public static Set<PluginPlayer> getPlayers() {
        return players;
    }

    public static void setPlayers(Set<PluginPlayer> players) {
        PluginPlayer.players = players;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public List<Punishment> getPunishments() {
        return punishments;
    }

    public void setPunishments(List<Punishment> punishments) {
        this.punishments = punishments;
    }

    public void addPunishment(Punishment punishment) {
        this.punishments.add(punishment);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static PluginPlayer getPluginPlayerByPlayer(Player player) {
        for(PluginPlayer p : players){
            if(p.getUuid().equals(player.getUniqueId())){return p;}
        }
        return null;
    }

    public static boolean isPunishmentsEmpty(Player player) {
        return getPluginPlayerByPlayer(player).getPunishments().isEmpty();
    }

    public static PluginPlayer getPluginPlayerByUUID(UUID uuid) {
        for(PluginPlayer p : players){
            if(p.getUuid().equals(uuid)){return p;}
        }
        return null;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public static PluginPlayer getPluginPlayerByName(String name) {
        for(PluginPlayer p : players){
            if(p.getName().equalsIgnoreCase(name)){return p;}
        }
        return null;
    }

    public static List<PluginPlayer> getSameAddressPluginPlayers(PluginPlayer player){
        List<PluginPlayer> pluginPlayers = new ArrayList<>();
        for(PluginPlayer p : players){
            if(p.getAddress().equalsIgnoreCase(player.getAddress())){pluginPlayers.add(p);}
        }
        return pluginPlayers;
    }

}
