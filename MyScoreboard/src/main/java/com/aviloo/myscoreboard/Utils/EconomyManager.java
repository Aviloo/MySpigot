package com.aviloo.myscoreboard.Utils;

import com.aviloo.myscoreboard.MyScoreboard;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class EconomyManager implements Listener {
    private static MyScoreboard plugin;
    public EconomyManager(MyScoreboard plugin){
        this.plugin = plugin;
    }

    //Vault Part
    public static void takeMoney(Player player, Double amount){
        plugin.eco.withdrawPlayer(player,amount);
    }

    public static double getPlayerMoney(Player player){
        return plugin.eco.getBalance(player);
    }

}
