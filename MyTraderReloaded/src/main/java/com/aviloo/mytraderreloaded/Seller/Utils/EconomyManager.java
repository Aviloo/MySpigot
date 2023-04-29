package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class EconomyManager implements Listener {

    private static MyTraderReloaded plugin;
    public EconomyManager(MyTraderReloaded plugin){
        this.plugin = plugin;
    }

    //Vault Part
    public static void giveMoney(Player player, Double amount){
        plugin.eco.depositPlayer(player,amount);
    }
}
