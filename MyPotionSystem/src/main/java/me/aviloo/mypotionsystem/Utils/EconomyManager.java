package me.aviloo.mypotionsystem.Utils;

import me.aviloo.mypotionsystem.MyPotionSystem;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class EconomyManager implements Listener {

    private static MyPotionSystem plugin;
    public EconomyManager(MyPotionSystem plugin){
        this.plugin = plugin;
    }

    //Vault Part
    public static void giveMoney(Player player, Double amount){
        plugin.eco.depositPlayer(player,amount);
    }

    public static void takeMoney(Player player,Double amount){
        plugin.eco.depositPlayer(player,-amount);
    }

    //Check part

    public static boolean hasPlayerMoney(Player player,Double amount){
        if(plugin.eco.getBalance(player) < amount){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[Система] &fУ вас недостаточно средств."));
            return false;
        }
        return true;
    }

}
