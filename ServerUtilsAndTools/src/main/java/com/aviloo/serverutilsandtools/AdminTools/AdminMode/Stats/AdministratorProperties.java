package com.aviloo.serverutilsandtools.AdminTools.AdminMode.Stats;

import javax.xml.stream.Location;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AdministratorProperties {

    private static final ConcurrentHashMap<UUID,Integer> BanCount = new ConcurrentHashMap<>();
    public static void addBan(UUID uuid){
        BanCount.put(uuid,BanCount.getOrDefault(uuid,0)+1);
    }
    public static Integer getBans(UUID uuid){
        return BanCount.get(uuid);
    }
    public static void setDefaultBan(UUID uuid){
        BanCount.put(uuid,0);
    }

    private static final ConcurrentHashMap<UUID,Integer> KickCount = new ConcurrentHashMap<>();
    public static void addKick(UUID uuid){
        KickCount.put(uuid,KickCount.getOrDefault(uuid,0)+1);
    }
    public static Integer getKicks(UUID uuid){
        return KickCount.get(uuid);
    }
    public static void setDefaultKick(UUID uuid){
        KickCount.put(uuid,0);
    }

    private static final ConcurrentHashMap<UUID,Integer> MuteCount = new ConcurrentHashMap<>();
    public static void addMute(UUID uuid){
        MuteCount.put(uuid,MuteCount.getOrDefault(uuid,0)+1);
    }
    public static Integer getMute(UUID uuid){
        return MuteCount.get(uuid);
    }
    public static void setDefaultMute(UUID uuid){
        MuteCount.put(uuid,0);
    }


    private static final ConcurrentHashMap<UUID,Long> TimeAdministrated = new ConcurrentHashMap<>();
    public static String getTime(UUID uuid){
        if(!getPlayedAdmin(uuid)){return "null";}
        if(StartTime.get(uuid) == 0 && StartTime.get(uuid) == null){return "null";}
        if(EndTime.get(uuid) == 0 && EndTime.get(uuid) == null){return "null";}
        Integer minutes = ((Math.toIntExact((EndTime.get(uuid) - StartTime.get(uuid)) + Math.toIntExact(TimeAdministrated.get(uuid))))/ 60000);
        return String.valueOf(minutes) ;
    }
    public static void setSession(UUID uuid){
        if(StartTime.get(uuid) == 0 && StartTime.get(uuid) == null){return;}
        if(EndTime.get(uuid) == 0 && EndTime.get(uuid) == null){return;}
        Long timePlayed = EndTime.get(uuid) - StartTime.get(uuid);
        TimeAdministrated.put(uuid,timePlayed);
    }
    private static final ConcurrentHashMap<UUID,Long> StartTime = new ConcurrentHashMap<>();
    public static void setStartTime(UUID uuid){
        StartTime.put(uuid,System.currentTimeMillis());
    }
    public static void setDefaultStartTime(UUID uuid){
        StartTime.put(uuid, 0L);
    }
    private static final ConcurrentHashMap<UUID,Long> EndTime = new ConcurrentHashMap<>();
    public static void setEndTime(UUID uuid){
        EndTime.put(uuid,System.currentTimeMillis());
    }
    public static void setDefaultEndTime(UUID uuid){
        EndTime.put(uuid,0L);
    }

    private static final ConcurrentHashMap<UUID,Boolean> PlayedToday = new ConcurrentHashMap<>();

    public static void setPlayed(UUID uuid){
        PlayedToday.put(uuid,true);
    }
    public static void setNotPlayed(UUID uuid){
        PlayedToday.put(uuid,false);
    }
    public static Boolean getPlayedToday(UUID uuid){
        if(PlayedToday.get(uuid) == null){return false;}
        return PlayedToday.get(uuid);
    }

    private static final ConcurrentHashMap<UUID,Boolean> BeingAdminToday = new ConcurrentHashMap<>();
    public static void setAdmin(UUID uuid){
        PlayedToday.put(uuid,true);
    }
    public static void setNotAdmin(UUID uuid){
        PlayedToday.put(uuid,false);
    }
    public static Boolean getPlayedAdmin(UUID uuid){
        if(BeingAdminToday.get(uuid) == null){return false;}
        return PlayedToday.get(uuid);
    }
}
