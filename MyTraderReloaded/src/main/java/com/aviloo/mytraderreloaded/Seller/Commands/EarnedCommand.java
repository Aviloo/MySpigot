package com.aviloo.mytraderreloaded.Seller.Commands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import com.aviloo.mytraderreloaded.Seller.Utils.EconomyManager;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerStats;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.ServerOperator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EarnedCommand implements CommandExecutor, TabCompleter {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    messagesConfig.getString("command_only_player_can_use")));
            return true;
        }
        if(command.getName().equalsIgnoreCase("earnedplayer")) {
            Player player = (Player) sender;
            if (!player.isOp()) {
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                        messagesConfig.getString("command_dont_have_perm")));
                return true;
            }
            if (args.length <= 2) {
                return false;
            }
            if (!NumberUtils.isNumber(args[2])) {
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                        messagesConfig.getString("command_args_is_not_num")));
                return true;
            }

            String PlayerName = args[1];
            Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
            if (argPlayer == null) {
                sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                        messagesConfig.getString("command_player_not_found")));
                return true;
            }

            if (args[0].equalsIgnoreCase("set")) {
                PlayerStats.setEarnedPlayerStats(argPlayer.getUniqueId(), Double.parseDouble(args[2]));
                return true;
            }
            if (args[0].equalsIgnoreCase("reset")) {
                PlayerStats.setEarnedPlayerStats(argPlayer.getUniqueId(), 0);
                return true;
            }
            if (args[0].equalsIgnoreCase("get")) {
                player.sendMessage(ColorUtils.translateColorCodes("Игрок " + argPlayer.getName()
                        + " заработал за сегодня -&6"
                        + PlayerStats.getEarnedPlayerStats(argPlayer.getUniqueId())));
                return true;
            }
            if (args[0].equalsIgnoreCase("givereward")) {
                PlayerStats.getBestTraderUUID();
                if(PlayerStats.bestTrader == null){
                    player.sendMessage("Лучший игрок невыявлен.");
                    return true;
                }

                if(Bukkit.getOfflinePlayer(PlayerStats.bestTrader).isOnline()){
                    EconomyManager.givePoints(Bukkit.getOfflinePlayer(PlayerStats.bestTrader).getUniqueId(),
                            45);
                    Bukkit.getOfflinePlayer(PlayerStats.bestTrader)
                            .getPlayer().sendMessage("Вы получили награду.");
                    player.sendMessage("Игроку выдана награда!");
                    return true;

                }
                if(!Bukkit.getOfflinePlayer(PlayerStats.bestTrader).isOnline()){
                    EconomyManager.givePoints(Bukkit.getOfflinePlayer(PlayerStats.bestTrader).getUniqueId(),
                            45);
                    player.sendMessage("Игроку выдана награда!");
                    return true;

                }
            }
        }

        return true;
    }

    //Completer Path
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> commandsFirst = new ArrayList<>();
        if(args.length == 1){
            List<String> completions = new ArrayList<>();
            completions.add("set");
            completions.add("reset");
            completions.add("get");
            completions.add("givereward");
            for(String s : completions){
                if(s.toLowerCase().startsWith(args[0].toLowerCase())){
                    commandsFirst.add(s);
                }
            }
            return commandsFirst;
        }
        return null;
    }

}
