package me.aviloo.myAdmins.Commands;

import me.aviloo.myAdmins.Commands.SubCommands.DeleteAdminCommand;
import me.aviloo.myAdmins.Commands.SubCommands.getStats;
import me.aviloo.myAdmins.Commands.SubCommands.makeAdmin;
import me.aviloo.myAdmins.Commands.SubCommands.createPluginPlayer;
import me.aviloo.myAdmins.Models.Admin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AdminCommand implements CommandExecutor, TabCompleter {
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
            case "deleteAdmin":
                return new DeleteAdminCommand().execute(sender,args);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> commandsFirst = new ArrayList<>();
        if(args.length == 1){
            List<String> completions = new ArrayList<>();
            completions.add("makeadmin");
            completions.add("createpluginplayer");
            completions.add("getstats");
            completions.add("deleteAdmin");
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
