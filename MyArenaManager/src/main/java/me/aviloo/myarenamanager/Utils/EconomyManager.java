package me.aviloo.myarenamanager.Utils;

import me.aviloo.myarenamanager.MyArenaManager;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class EconomyManager implements Listener {

    private static MyArenaManager plugin;
    public EconomyManager(MyArenaManager plugin){
        this.plugin = plugin;
    }

    //Vault Part
    public static void giveMoney(Player player, Double amount){
        plugin.eco.depositPlayer(player,amount);
    }
}
