package com.aviloo.mytraderreloaded.Seller.Utils;

import org.bukkit.entity.Player;

import java.util.LinkedHashMap;
import java.util.UUID;

public class MultiplierUtils {

    //На будующее обновление (Пока-что только наброски)

    public static int PromoMultiplier = 1; //Регулирует администрация
    private static LinkedHashMap<UUID,Double> DonateMultiplier = new LinkedHashMap<>(); //Множитель за донат
    private static LinkedHashMap<UUID,Double> DefaultMultiplier = new LinkedHashMap<>(); // Множитель за продажи скупщку

    private static LinkedHashMap<UUID,Double> GeneralMultiplier = new LinkedHashMap<>(); // Итоговый множитель

    public static double getMultiplier(Player player){
        if(!GeneralMultiplier.containsKey(player.getUniqueId())){return 1.0;}
        return GeneralMultiplier.get(player.getUniqueId());
    }

    public static void loadMultiplier(Player player){
        if(!DonateMultiplier.containsKey(player.getUniqueId())){
            DonateMultiplier.put(player.getUniqueId(),1.0);}
        if(!DefaultMultiplier.containsKey(player.getUniqueId())){
            DefaultMultiplier.put(player.getUniqueId(),1.0);}

        GeneralMultiplier.put(player.getUniqueId(),
                (PromoMultiplier+DonateMultiplier.get(player.getUniqueId())
                        + DefaultMultiplier.get(player.getUniqueId())/2));
    }

    public static double getDonateMultiplier(Player player){
        return DonateMultiplier.get(player.getUniqueId());
    }

    public static double getDefaultMultiplier(Player player){
        return DefaultMultiplier.get(player.getUniqueId());
    }

    public static void calculateMultiplier(Player player){
        DefaultMultiplier.put(player.getUniqueId(),
                ((Math.ceil(LeaderUtils.getPlayerEarned(player.getUniqueId()) / 1000)) / 100) + 1);
    }

}
