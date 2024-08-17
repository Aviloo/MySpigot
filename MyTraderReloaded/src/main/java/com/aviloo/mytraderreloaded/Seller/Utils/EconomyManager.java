package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.UUID;

public class EconomyManager implements Listener {

    private static MyTraderReloaded plugin;
    public EconomyManager(MyTraderReloaded plugin){
        this.plugin = plugin;
    }

    //Vault Part
    public static void giveMoney(Player player, Double amount){
        plugin.eco.depositPlayer(player,amount);
    }
    //Player Points Part
    public static void givePoints(UUID uuid, int amount){
        plugin.ppAPI.give(uuid,amount);
    }
}
