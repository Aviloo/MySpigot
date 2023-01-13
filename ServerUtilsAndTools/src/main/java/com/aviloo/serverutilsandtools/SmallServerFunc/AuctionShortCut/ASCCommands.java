package com.aviloo.serverutilsandtools.SmallServerFunc.AuctionShortCut;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BookMeta;

public class ASCCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot use this command!");
            return true;
        }

        if(command.getName().equalsIgnoreCase("auc")){
            Player player = (Player) sender;
            if(Bukkit.getServer().getPluginManager().getPlugin("PlayerAuctions") == null){
                player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Уважаемый игрок, произошла ошибка." +
                        " Аукцион недоступен. Искренне просим вас сообщить о данной проблеме администрации.");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"[Ошибка] "+"Внимание! Вы забыли установить " +
                        "плагин Player Auctions. Как результат игрокам недоступен аукцион. " +ChatColor.GRAY+
                        "(P.S: https://www.spigotmc.org/resources/%E2%AD%90-player-auctions-%E2%AD%90-%E2%9E" +
                        "%A2-let-your-players-sell-items-1-7-1-19.83073/ )");
                return true;
            }
            Bukkit.dispatchCommand(player,"pa");
            return true;
        }
        return true;
    }
}
