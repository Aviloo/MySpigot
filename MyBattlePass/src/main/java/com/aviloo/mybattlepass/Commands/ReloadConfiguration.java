package com.aviloo.mybattlepass.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadConfiguration implements CommandExecutor {
    //Plugin Path
    private static JavaPlugin plugin;

    public ReloadConfiguration(JavaPlugin plugin){
        this.plugin = plugin;
    }
    //Command Path
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("You cannot use this command!");
            return true;
        }

        if(command.getName().equalsIgnoreCase("reloadbattlepass")){
            if(!sender.isOp()){
                return true;
            }
            if(args.length <1){
                return false;
            }

            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GRAY+"[Система] " + ChatColor.WHITE+"Вы перезагрузили конфигурацию боевого пропуска.");
            return true;
        }
        return true;
    }
}
