package me.aviloo.myAdmins.Models;

import me.aviloo.myAdmins.Utils.StorageUtils.AdminmapStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Admin {

    private String name;
    private UUID uuid;
    private AdminType adminType;
    private String current_ip;
    private String last_ip;
    private String registration_date;
    private String current_Connection;

    private int ban_count;
    private int kick_count;
    private int mute_count;
    private int banip_count;
    private int tempban_count;
    private int tempmute_count;
    private String last_session_time;
    private String last_connection_date;

    private Set<Punishment> punishments = new HashSet<>();

    public Admin(String name, UUID uuid,AdminType adminType,String current_ip,String last_ip,
     String registration_date, int ban_count, int kick_count, int mute_count,int banip_count,
     int tempban_count,int tempmute_count,String last_session_time, String last_connection_date) {
        this.name = name;
        this.uuid = uuid;
        this.adminType = adminType;
        this.current_ip = current_ip;
        this.last_ip = last_ip;
        this.registration_date = registration_date;
        this.ban_count = ban_count;
        this.kick_count = kick_count;
        this.mute_count = mute_count;
        this.banip_count = banip_count;
        this.tempban_count = tempban_count;
        this.tempmute_count = tempmute_count;
        this.last_session_time = last_session_time;
        this.last_connection_date = last_connection_date;
        this.current_Connection = "null";
        admins.add(this);
    }

    public Admin(String name, UUID uuid, AdminType adminType, String current_ip) {
        this.name = name;
        this.uuid = uuid;
        this.adminType = adminType;
        this.current_ip = current_ip;
        this.last_ip = current_ip;
        this.registration_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        this.ban_count = 0;
        this.kick_count = 0;
        this.mute_count = 0;
        this.banip_count = 0;
        this.tempban_count = 0;
        this.tempmute_count = 0;
        this.last_session_time = "null";
        this.last_connection_date = "null";
        this.current_Connection = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        admins.add(this);
        AdminmapStorageUtil.addAdminToMap(uuid, this);
    }
    public static Set<Admin> admins = new HashSet<Admin>();

    public static Admin getAdminByPlayer(Player player){
        for(Admin admin : admins){
            if(admin.uuid.equals(player.getUniqueId())){
                return admin;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getUUIDString() {
        return uuid.toString();
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCurrent_ip() {
        return current_ip;
    }

    public void setCurrent_ip(String current_ip) {
        this.current_ip = current_ip;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public int getBan_count() {
        return ban_count;
    }

    public void setBan_count(int ban_count) {
        this.ban_count = ban_count;
    }

    public void addBan(){
        this.ban_count++;
    }

    public int getKick_count() {
        return kick_count;
    }

    public void setKick_count(int kick_count) {
        this.kick_count = kick_count;
    }

    public void addKick(){
        this.kick_count++;
    }

    public int getMute_count() {
        return mute_count;
    }

    public void setMute_count(int mute_count) {
        this.mute_count = mute_count;
    }

    public String getLast_session_time() {
        return last_session_time;
    }

    public void setLast_session_time(String last_session_time) {
        this.last_session_time = last_session_time;
    }

    public String getLast_connection_date() {
        return last_connection_date;
    }

    public void setLast_connection_date(String last_connection_date) {
        this.last_connection_date = last_connection_date;
    }


    public String getCurrent_Connection() {
        return current_Connection;
    }

    public void setCurrent_Connection(String current_Connection) {
        this.current_Connection = current_Connection;
    }

    public void addPunishment(Punishment punishment) {
        punishments.add(punishment);
    }


    public static boolean isPlayerAdmin(Player player){
        for(Admin admin : admins){
            if(admin.uuid.equals(player.getUniqueId())){
                return true;
            }
        }
        return false;
    }


    public int getBanip_count() {
        return banip_count;
    }

    public void setBanip_count(int banip_count) {
        this.banip_count = banip_count;
    }

    public void addBanIP(){
        this.banip_count++;
    }


    public int getTempban_count() {
        return tempban_count;
    }

    public void addTempban(){
        this.tempban_count++;
    }

    public int getTempmute_count() {
        return tempmute_count;
    }

    public void setTempmute_count(int tempmute_count) {
        this.tempmute_count = tempmute_count;
    }

    public void addTempmute(){
        this.tempmute_count++;
    }

    public AdminType getAdminType() {
        return adminType;
    }

    public void setAdminType(AdminType adminType) {
        this.adminType = adminType;
    }

    public static boolean isPlayerAdmin(PluginPlayer player){
        for(Admin admin : admins){
            if(player.getUuid().equals(admin.getUuid())){return true;}
        }
        return false;
    }

    public static Admin getAdminByUUID(UUID uuid){
        for(Admin admin : admins){
            if(admin.uuid.equals(uuid)){return admin;}
        }
        return null;
    }

    public static Admin getAdminByName(String name){
        for(Admin admin : admins){
            if(admin.getName().equalsIgnoreCase(name)){return admin;}
        }
        return null;
    }

    public void delete(){
        admins.remove(this);
    }

    public static class AdminType {
        public static AdminType HELPER = new AdminType("Хэлпер", ChatColor.GREEN+"Хэлпер",1);
        public static AdminType MODER = new AdminType("Модератор",ChatColor.AQUA+"Модератор",2);
        public static AdminType ADMIN = new AdminType("Админ",ChatColor.RED+"Админ",3);
        public static AdminType TECH = new AdminType("Тех. Админ",ChatColor.DARK_PURPLE+"Тех. Админ",4);
        public static AdminType SPECIAL = new AdminType("Спец. Админ",ChatColor.DARK_RED+"Спец. Админ",5);

        private final String name;
        private final String prefix;
        private final int priority;

        public AdminType(String name, String prefix, int priority) {
            this.name = name;
            this.prefix = prefix;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }
        public String getPrefix() {
            return prefix;
        }
        public int getPriority() {return priority;}


        public static AdminType valueOf(String name) {
            if(HELPER.getName().equalsIgnoreCase(name)){return HELPER;}
            if(MODER.getName().equalsIgnoreCase(name)){return MODER;}
            if(ADMIN.getName().equalsIgnoreCase(name)){return ADMIN;}
            if(TECH.getName().equalsIgnoreCase(name)){return TECH;}
            if(SPECIAL.getName().equalsIgnoreCase(name)){return SPECIAL;}
            return null;
        }
    }

}
