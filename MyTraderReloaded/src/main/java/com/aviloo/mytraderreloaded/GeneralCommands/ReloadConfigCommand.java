package com.aviloo.mytraderreloaded.GeneralCommands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReloadConfigCommand implements CommandExecutor, TabCompleter {
    private JavaPlugin plugin;

    public ReloadConfigCommand(JavaPlugin plugin){
        this.plugin = plugin;
    }

    //Command Path
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("You cannot use this command");
            return true;
        }
        if(command.getName().equalsIgnoreCase("mytrader")){
            if(args.length < 1){return false;}
            if(!sender.isOp()){return false;}

            if(Objects.equals(args[0], "reload")){
                plugin.reloadConfig();
                MyTraderReloaded.getPlugin().databaseFileManager.reloadDatabaseConfig();
                sender.sendMessage(ChatColor.GRAY+"[MyTrader] "+ChatColor.WHITE+"Конфиги успешно перезагружен!");
                return true;
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
            completions.add("reload");
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
