package me.aviloo.mypotionsystem.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReloadConfig implements CommandExecutor, TabCompleter {

    private JavaPlugin plugin;

    public ReloadConfig(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[Система] &fВы не можете использовать эту команду."));
            return true;
        }
        if(command.getName().equalsIgnoreCase("mypotion")){
            if(args.length < 1){return false;}
            if(!sender.isOp()){return false;}

            if(Objects.equals(args[0], "reload")){
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GRAY+"[MyTrader] "+ChatColor.WHITE+"Конфиг успешно перезагружен!");
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
