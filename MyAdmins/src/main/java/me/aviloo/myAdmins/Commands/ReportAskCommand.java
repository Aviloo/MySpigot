package me.aviloo.myAdmins.Commands;

import me.aviloo.myAdmins.Commands.PunishmentCommands.KickCommand;
import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Models.Report;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class ReportAskCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof ConsoleCommandSender)) {
            if (!Admin.isPlayerAdmin((Player) sender)) {
                sender.sendMessage(ChatColor.RED + "Вы должны быть администратором.");
                return true;
            }
        }
        if(args.length < 2){return false;}
        if(!isInteger(args[0])){
            sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Аргумент должен быть числом!");
            return true;
        }

        for(Report report: Report.reports){
            if(args[0].equalsIgnoreCase(String.valueOf(report.getId()))){
                Bukkit.getPlayer(report.getPlayer_name()).sendMessage(ChatColor.DARK_GRAY+"[Репорт] "
                +ChatColor.GRAY+sender.getName()+ChatColor.WHITE+  String.join(" ",
                java.util.Arrays.copyOfRange(args, 1, args.length)).replace("[",
                "").replace(",","").replace("]","")
                .trim());
                sender.sendMessage(ChatColor.DARK_GRAY+"[Репорт] "
                +ChatColor.GRAY+sender.getName()+ChatColor.WHITE+ Arrays.toString(args));
                return true;
            }
        }
        sender.sendMessage(ChatColor.RED+"Нет репорта с таким id!");

        return true;
    }

    protected static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
