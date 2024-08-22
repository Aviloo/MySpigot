package me.aviloo.mycrafts.Utils;

import me.aviloo.mycrafts.MyCrafts;
import org.bukkit.entity.Player;

public class EconomyManager {
    //Vault Part
    public static void takeMoney(Player player, Double amount){
        MyCrafts.getPlugin().eco.withdrawPlayer(player,amount);
    }

    public static double getMoney(Player player){
        return MyCrafts.getPlugin().eco.getBalance(player);
    }

}
