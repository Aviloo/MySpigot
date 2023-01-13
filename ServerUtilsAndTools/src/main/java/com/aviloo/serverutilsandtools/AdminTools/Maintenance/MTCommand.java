package com.aviloo.serverutilsandtools.AdminTools.Maintenance;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class MTCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("You cannot execute this command!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("maintenance")){
            if(!sender.isOp()){
                return true;
            }
            if(args.length < 1){
                return false;
            }

            if(Objects.equals(args[0], "on")){
                MTUtils.setTrue();
                sender.sendMessage(ChatColor.RED+"Вы включили режим тех.работ!");
                Bukkit.getServer().broadcastMessage(ChatColor.GRAY+"[Система] "+"Уведомляем вас о начале тех.работ!");
                for(Player ps : MTUtils.getOnlinePlayers()){
                    if(ps.isOp()){
                       break;
                    }
                    if (ps.hasPermission("SUAT.admin-chat")){
                        break;
                    }
                    ps.kickPlayer("Сейчас на сервере проходят тех.работы. Приносим свои извинения за неудобства. " +
                            "С любовью администрация Orumii.");
                }
                return true;
            }
            if(Objects.equals(args[0], "off")){
                MTUtils.setFalse();
                sender.sendMessage(ChatColor.RED+"Вы выключили режим тех.работ!");
                return true;
            }
            else return false;

        }
        return true;
    }
}
