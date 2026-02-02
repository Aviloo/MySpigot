package me.aviloo.myAdmins.Models;

import me.aviloo.myAdmins.Utils.StorageUtils.PunishmentStorageUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Punishment {

    private int id;
    private String type;
    private String suspect_name;
    private String suspect_uuid;
    private String suspect_ip;
    private String admin_name;
    private String admin_uuid;
    private String reason;
    private String date;

    public Punishment(int id,PunishmentType type, String suspect_name,
    String suspect_uuid, String admin_name,String admin_uuid, String reason,
    String suspect_ip) {
        this.id = id;
        this.type = type.getName();
        this.suspect_name = suspect_name;
        this.admin_name = admin_name;
        this.reason = reason;
        this.suspect_ip = suspect_ip;
        this.admin_uuid = admin_uuid;
        this.suspect_uuid = suspect_uuid;
        this.date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        PunishmentStorageUtil.addPunishment(id, this);
        punishments.add(this);
    }

    public Punishment(int id, String type, String suspect_name, String suspect_uuid, String admin_name, String admin_uuid, String reason,
                      String suspect_ip, String date) {
        this.id = id;
        this.type = type;
        this.suspect_name = suspect_name;
        this.admin_name = admin_name;
        this.reason = reason;
        this.suspect_ip = suspect_ip;
        this.date = date;
        this.admin_uuid = admin_uuid;
        this.suspect_uuid = suspect_uuid;
        punishments.add(this);
    }

    public static Set<Punishment> punishments = new HashSet<Punishment>();

    public static int getPunishmentCount() {
        return punishments.size();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public Date getDefaultDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return formatter.parse(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getSuspect_ip() {
        return suspect_ip;
    }

    public void setSuspect_ip(String suspect_ip) {
        this.suspect_ip = suspect_ip;
    }

    public String getSuspect_name() {
        return suspect_name;
    }

    public void setSuspect_name(String suspect_name) {
        this.suspect_name = suspect_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getSuspect_uuid() {
        return suspect_uuid;
    }

    public void setSuspect_uuid(String suspect_uuid) {
        this.suspect_uuid = suspect_uuid;
    }

    public String getAdmin_uuid() {
        return admin_uuid;
    }

    public void setAdmin_uuid(String admin_uuid) {
        this.admin_uuid = admin_uuid;
    }


    public static class PunishmentType{
        public static PunishmentType BAN = new PunishmentType("Бан",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjhkNDA5MzUyNzk3NzFhZGM2MzkzNmVkOWM4NDYzYWJkZjVjNWJhNzhkMmU4NmNiMWVjMTBiNGQxZDIyNWZiIn19fQ==");
        public static PunishmentType KICK = new PunishmentType("Кик",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWM4ZTBkZGYyNDMyZjQzMzJiODc2OTFiNTk1MmM3Njc5NzYzZWY0ZjI3NWI4NzRlOWJjZWI4ODhlZDViNWI5In19fQ==");
        public static PunishmentType MUTE = new PunishmentType("Мут",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTg5YjkzZmQ2MTZlZDM2NzBjY2Y2NDdhMGY5MzgwMzk4YzBkNDYxNTYzNGYyZGVmZjQ2YzZlZGJkYzcxMjg4NSJ9fX0=");
        public static PunishmentType TEMPBAN = new PunishmentType("Временный бан",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGYyOGUwMWJhNzNjZDg3OWQ5ZWJiZTQ1ZDEwM2Q3NmE4NmUxYjEyZWYyODZkNGZjODc1MjdlOTg1NDNhODliOSJ9fX0=");
        public static PunishmentType TEMPMUTE = new PunishmentType("Временный мут",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGJiNjk5MGIyYjFkZmZhYjVlNTM4NmUwODdkZTUwY2M4MmM3Yjc3NmM5MjBmOGQwZWU2NGY5MmFlNTYyNmE2ZCJ9fX0=");
        public static PunishmentType BANIP = new PunishmentType("БанIP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjEwZTM3NGNkYzJiYTk1YmI3MmYxYTAzNmM3N2RhMzUwOTkzNWExYWJkMjRiNjhjNmIzNTkxNjkwYjEwM2ZlZCJ9fX0=");

        private String name;
        private String icon;

        public PunishmentType(String name,String icon) {
            this.name = name;
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public String getIcon() {
            return icon;
        }

        public static PunishmentType valueOf(String name) {
            if(Objects.equals(name, BAN.getName())){
                return BAN;
            }
            if(Objects.equals(name, TEMPBAN.getName())){
                return TEMPBAN;
            }
            if(Objects.equals(name, TEMPMUTE.getName())){
                return TEMPMUTE;
            }
            if(Objects.equals(name, MUTE.getName())){
                return MUTE;
            }
            if(Objects.equals(name, KICK.getName())){
                return KICK;
            }
            if(Objects.equals(name, BANIP.getName())){
                return BANIP;
            }
            return null;
        }

    }
}
