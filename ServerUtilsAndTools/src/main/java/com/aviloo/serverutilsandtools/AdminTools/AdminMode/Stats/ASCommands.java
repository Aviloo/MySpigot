package com.aviloo.serverutilsandtools.AdminTools.AdminMode.Stats;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ASCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("You cannot use this command!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("getadminstats")){
            if(!sender.isOp()){return true;}
            if(args.length <1){return false;}

            String PlayerName = args[0];
            OfflinePlayer argPlayer = Bukkit.getServer().getOfflinePlayer(args[0]);
            if(!AdministratorProperties.getPlayedToday(argPlayer.getUniqueId())){
                sender.sendMessage("Игрок сегодня не заходил");
                return true;
            }
            if(!argPlayer.isOp()){
                sender.sendMessage("Игрок не оператор!");
                return true;
            }
            sender.sendMessage(ChatColor.WHITE+"-------------------------------------");
            sender.sendMessage(ChatColor.YELLOW+"Статистика "+ argPlayer.getName());
            sender.sendMessage(ChatColor.YELLOW+"Банов: "+AdministratorProperties.getBans(argPlayer.getUniqueId()));
            sender.sendMessage("Мутов: " + AdministratorProperties.getMute(argPlayer.getUniqueId()));
            sender.sendMessage("Киков "+AdministratorProperties.getKicks(argPlayer.getUniqueId()));
            sender.sendMessage("Времени в режиме админа: "+ AdministratorProperties.getTime(argPlayer.getUniqueId()));
            sender.sendMessage(ChatColor.WHITE+"-------------------------------------");
            return true;

        }
        return true;
    }
}
