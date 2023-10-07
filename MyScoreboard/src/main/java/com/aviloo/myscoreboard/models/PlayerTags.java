package com.aviloo.myscoreboard.models;

import com.aviloo.myscoreboard.Utils.ShoppingUtil;
import org.bukkit.entity.Player;

public class PlayerTags {

    private String javaUUID;
    private String lastPlayerName;

    private static boolean killsTag;
    private static boolean deathsTag;
    private static boolean hoursTag;
    private static boolean pingTag;
    private static boolean mobs_killedTag;
    private static boolean blocks_breakTag;
    private static boolean coordsTag;
    private static boolean kills_deathsTag;
    private static boolean hand_durabilityTag;
    private static boolean totem_countTag;
    private static boolean helmet_durabilityTag;
    private static boolean chestplate_durabilityTag;
    private static boolean leggings_durabilityTag;
    private static boolean boots_durabilityTag;

    public PlayerTags(String uuid, String playerName){
        javaUUID = uuid;
        lastPlayerName = playerName;
        killsTag = true;
        deathsTag = true;
        hoursTag = true;
        pingTag = false;
        mobs_killedTag = false;
        blocks_breakTag = false;
        coordsTag = false;
        kills_deathsTag = false;
        hand_durabilityTag = false;
        totem_countTag = false;
        helmet_durabilityTag = false;
        chestplate_durabilityTag = false;
        leggings_durabilityTag = false;
        boots_durabilityTag = false;
    }

    public String getJavaUUID() {
        return javaUUID;
    }

    public void setJavaUUID(String javaUUID) {
        this.javaUUID = javaUUID;
    }

    public String getLastPlayerName() {
        return lastPlayerName;
    }

    public void setLastPlayerName(String lastPlayerName) {
        this.lastPlayerName = lastPlayerName;
    }

    public static boolean isKillsTag() {
        return killsTag;
    }

    public void setKillsTag(boolean killsTag) {
        this.killsTag = killsTag;
    }

    public static boolean isDeathsTag() {
        return deathsTag;
    }

    public void setDeathsTag(boolean deathsTag) {
        this.deathsTag = deathsTag;
    }

    public static boolean isHoursTag() {
        return hoursTag;
    }

    public void setHoursTag(boolean hoursTag) {
        this.hoursTag = hoursTag;
    }

    public static boolean isPingTag() {
        return pingTag;
    }

    public void setPingTag(boolean pingTag) {
        this.pingTag = pingTag;
    }

    public static boolean isMobs_killedTag() {
        return mobs_killedTag;
    }

    public void setMobs_killedTag(boolean mobs_killedTag) {
        this.mobs_killedTag = mobs_killedTag;
    }

    public static boolean isBlocks_breakTag() {
        return blocks_breakTag;
    }

    public void setBlocks_breakTag(boolean blocks_breakTag) {
        this.blocks_breakTag = blocks_breakTag;
    }

    public static boolean isCoordsTag() {
        return coordsTag;
    }

    public void setCoordsTag(boolean coordsTag) {
        this.coordsTag = coordsTag;
    }

    public static boolean isKills_deathsTag() {
        return kills_deathsTag;
    }

    public void setKills_deathsTag(boolean kills_deathsTag) {
        this.kills_deathsTag = kills_deathsTag;
    }

    public static boolean isHand_durabilityTag() {
        return hand_durabilityTag;
    }

    public void setHand_durabilityTag(boolean hand_durabilityTag) {
        this.hand_durabilityTag = hand_durabilityTag;
    }

    public static boolean isTotem_countTag() {
        return totem_countTag;
    }

    public void setTotem_countTag(boolean totem_countTag) {
        this.totem_countTag = totem_countTag;
    }

    public static boolean isHelmet_durabilityTag() {
        return helmet_durabilityTag;
    }

    public void setHelmet_durabilityTag(boolean helmet_durabilityTag) {
        this.helmet_durabilityTag = helmet_durabilityTag;
    }

    public static boolean isChestplate_durabilityTag() {
        return chestplate_durabilityTag;
    }

    public void setChestplate_durabilityTag(boolean chestplate_durabilityTag) {
        this.chestplate_durabilityTag = chestplate_durabilityTag;
    }

    public static boolean isLeggings_durabilityTag() {
        return leggings_durabilityTag;
    }

    public void setLeggings_durabilityTag(boolean leggings_durabilityTag) {
        this.leggings_durabilityTag = leggings_durabilityTag;
    }

    public static boolean isBoots_durabilityTag() {
        return boots_durabilityTag;
    }

    public void setBoots_durabilityTag(boolean boots_durabilityTag) {
        this.boots_durabilityTag = boots_durabilityTag;
    }

    public static void setBoughtTag(Player player){
        if(ShoppingUtil.getCurrentTag(player).equals("ping")){
            pingTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("mobs_killed")){
            mobs_killedTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("blocks_break")){
            blocks_breakTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("coords")){
            coordsTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("kills_deaths")){
            kills_deathsTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("hand_durability")){
            hand_durabilityTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("totem_count")){
            totem_countTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("helmet_durability")){
            helmet_durabilityTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("chestplate_durability")){
            chestplate_durabilityTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("leggings_durability")){
            leggings_durabilityTag = true;
        }
        if(ShoppingUtil.getCurrentTag(player).equals("boots_durability")){
            boots_durabilityTag = true;
        }

    }

}
