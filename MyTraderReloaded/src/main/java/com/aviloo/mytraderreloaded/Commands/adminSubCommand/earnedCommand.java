package com.aviloo.mytraderreloaded.Commands.adminSubCommand;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import com.aviloo.mytraderreloaded.Seller.Utils.EconomyManager;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerStats;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class earnedCommand {
    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean earnedSubCommand(CommandSender sender,String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    messagesConfig.getString("command_only_player_can_use")));
            return true;
        }

        Player player = (Player) sender;
        if (!player.isOp()) {
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                    messagesConfig.getString("command_dont_have_perm")));
            return true;
        }

        if (!NumberUtils.isNumber(args[3])) {
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                    messagesConfig.getString("command_args_is_not_num")));
            return true;
        }

        String PlayerName = args[2];
        Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
        if (argPlayer == null) {
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                    messagesConfig.getString("command_player_not_found")));
            return true;
        }

        switch (args[1]){
            case "set":
                PlayerStats.setEarnedPlayerStats(argPlayer.getUniqueId(), Double.parseDouble(args[3]));
                break;
            case "reset":
                PlayerStats.setEarnedPlayerStats(argPlayer.getUniqueId(), 0);
                break;
            case "get":
                player.sendMessage(ColorUtils.translateColorCodes("Игрок " + argPlayer.getName()
                        + " заработал за сегодня -&6"
                        + PlayerStats.getEarnedPlayerStats(argPlayer.getUniqueId())));
                break;
            case "givereward":
                PlayerStats.getBestTraderUUID();
                if(PlayerStats.bestTrader == null){
                    player.sendMessage("Лучший игрок невыявлен.");
                    break;
                }

                if(Bukkit.getOfflinePlayer(PlayerStats.bestTrader).isOnline()){
                    EconomyManager.givePoints(Bukkit.getOfflinePlayer(PlayerStats.bestTrader).getUniqueId(),
                            45);
                    Bukkit.getOfflinePlayer(PlayerStats.bestTrader)
                            .getPlayer().sendMessage("Вы получили награду.");
                    player.sendMessage("Игроку выдана награда!");
                    break;

                }
                if(!Bukkit.getOfflinePlayer(PlayerStats.bestTrader).isOnline()){
                    EconomyManager.givePoints(Bukkit.getOfflinePlayer(PlayerStats.bestTrader).getUniqueId(),
                            45);
                    player.sendMessage("Игроку выдана награда!");
                    break;

                }
            default:
                sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"У данной команды есть аргументы:" +
                        " set|get|givereward|reset.");
        }

        return true;
    }
}
