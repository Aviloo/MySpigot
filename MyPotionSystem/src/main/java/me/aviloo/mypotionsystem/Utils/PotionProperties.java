package me.aviloo.mypotionsystem.Utils;

import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PotionProperties {
    //Общее атрибуты
    private static final ConcurrentHashMap<UUID,String> PotionQuality = new ConcurrentHashMap<>();

    public static void setPotionQuality(Player player, String Quality){
        PotionQuality.put(player.getUniqueId(),Quality);
    }

    public static String getPotionQuality(Player player){
        return PotionQuality.get(player.getUniqueId());
    }

    //Положительные атрибуты
    private static final ConcurrentHashMap<UUID,Integer> WitchLuck = new ConcurrentHashMap<>();
    // Если 100, то  Добавится положительный эффект на зелье
    public static void addWitchLuck(Player player, Integer amount){
        WitchLuck.put(player.getUniqueId(),WitchLuck.getOrDefault(player.getUniqueId(),0)+amount);
    }
    public static Integer getWitchLuck(Player player){
        return WitchLuck.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID,Integer> FullCauldron = new ConcurrentHashMap<>();
    // Если 100, то скрафтиться еще одна копия зелья
    public static void addFullCauldron(Player player, Integer amount){
        FullCauldron.put(player.getUniqueId(),FullCauldron.getOrDefault(player.getUniqueId(),0)+amount);
    }
    public static Integer getFullCauldron(Player player){
        return FullCauldron.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID,Integer> EnvironmentalInfluence = new ConcurrentHashMap<>();
    // Если 100, то Повышение уровня зелья (amplifier), на кол-во кратное количеству очков, т.е 100 - 1 ур. , 300 - 3 ур.
    public static void addEnvironmentalInfluence(Player player, Integer amount){
        EnvironmentalInfluence.put(player.getUniqueId(),EnvironmentalInfluence.getOrDefault(player.getUniqueId(),0)+amount);
    }
    public static Integer getEnvironmentalInfluence(Player player){
        return EnvironmentalInfluence.get(player.getUniqueId());
    }

    //Негативные атрибуты
    private static final ConcurrentHashMap<UUID,Integer> Feculence = new ConcurrentHashMap<>();
    // Если 100, то на зелье наложиться случайный негативный эффект
    public static void addFeculence(Player player, Integer amount){
        Feculence.put(player.getUniqueId(),Feculence.getOrDefault(player.getUniqueId(),0)+amount);
    }
    public static Integer getFeculence(Player player){
        return Feculence.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID,Integer> Burn = new ConcurrentHashMap<>();
    // Если 100, накладывает эффект моментального урона
    public static void addBurn(Player player, Integer amount){
        Burn.put(player.getUniqueId(),Burn.getOrDefault(player.getUniqueId(),0)+amount);
    }
    public static Integer getBurn(Player player){
        return Burn.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID,Integer> Stench = new ConcurrentHashMap<>();
    // Если 100, то накладываеться тошноту на пару секунд
    public static void addStench(Player player, Integer amount){
        Stench.put(player.getUniqueId(),Stench.getOrDefault(player.getUniqueId(),0)+amount);
    }
    public static Integer getStench(Player player){
        return Stench.get(player.getUniqueId());
    }

    //Атрибуты от окружения

    private static final ConcurrentHashMap<UUID,Integer> Time = new ConcurrentHashMap<>();

    public static void addTime(Player player,Integer amount){
        Time.put(player.getUniqueId(),Time.getOrDefault(player.getUniqueId(),0)+amount);
    }
    public static Integer getTime(Player player){
        return Time.get(player.getUniqueId());
    }

}
