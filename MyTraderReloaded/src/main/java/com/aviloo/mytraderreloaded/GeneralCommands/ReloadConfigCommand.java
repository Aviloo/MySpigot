package com.aviloo.mytraderreloaded.GeneralCommands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
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

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    //Command Path
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                    messagesConfig.getString("command_only_console_can_use")));
            return true;
        }
        if(command.getName().equalsIgnoreCase("mytrader")){
            if(args.length < 1){return false;}
            if(!sender.isOp()){return false;}

            if(Objects.equals(args[0], "reload")){
                plugin.reloadConfig();
                MyTraderReloaded.getPlugin().databaseFileManager.reloadDatabaseConfig();
                sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_plugin_with_brackets")+
                        messagesConfig.getString("command_config_has_been_reloaded")));
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
