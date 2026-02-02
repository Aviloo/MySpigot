package me.aviloo.myAdmins.Commands;

import me.aviloo.myAdmins.Commands.SubCommands.getStats;
import me.aviloo.myAdmins.Commands.SubCommands.makeAdmin;
import me.aviloo.myAdmins.Commands.SubCommands.createPluginPlayer;
import me.aviloo.myAdmins.Models.Admin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!Admin.isPlayerAdmin((Player) sender)) {
            sender.sendMessage(ChatColor.RED+"Вы должны быть администратором.");
            return true;
        }

        switch (args[0]){
            case "makeadmin":
                return new makeAdmin().execute(sender,args);
            case "createpluginplayer":
                return new createPluginPlayer().execute(sender,args);
            case "getstats":
                return new getStats().execute(sender,args);
        }
        return true;
    }
}
