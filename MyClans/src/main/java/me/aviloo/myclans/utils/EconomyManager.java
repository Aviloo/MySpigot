package me.aviloo.myclans.utils;

import me.aviloo.myclans.MyClans;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class EconomyManager implements Listener {

    private static MyClans plugin;
    public EconomyManager(MyClans plugin){
        this.plugin = plugin;
    }

    //Vault Part
    public static void giveMoney(Player player, Double amount){
        plugin.eco.depositPlayer(player,amount);
    }

    public static void takeMoney(Player player,Double amount){
        plugin.eco.withdrawPlayer(player,amount);
    }

    //Check part

    public static boolean hasPlayerMoney(Player player,Double amount){
        if(plugin.eco.getBalance(player) < amount){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[Система] &fУ вас недостаточно средств. Чтобы создать клан, необходимо" +
                            " &fиметь на балансе не менее 7000 коинов."));
            return false;
        }
        return true;
    }

}
