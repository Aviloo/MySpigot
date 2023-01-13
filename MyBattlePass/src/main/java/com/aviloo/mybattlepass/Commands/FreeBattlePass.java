package com.aviloo.mybattlepass.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class FreeBattlePass implements CommandExecutor {
    //Plugin Path
    private static JavaPlugin plugin;

    public FreeBattlePass(JavaPlugin plugin){
        this.plugin = plugin;
    }
    //Methods Path
    private void setTrue(){
        plugin.getConfig().set("FreeBattlePassStatus","true");
        plugin.saveConfig();
        plugin.reloadConfig();
    }
    private void setFalse(){
        plugin.getConfig().set("FreeBattlePassStatus","false");
        plugin.saveConfig();
        plugin.reloadConfig();
    }
    public static boolean getFreeStatus(){
        if(Objects.equals(plugin.getConfig().getString("FreeBattlePassStatus"), "true")){
            return true;
        }
        if(Objects.equals(plugin.getConfig().getString("FreeBattlePassStatus"), "false")){
            return false;
        }
        return false;
    }
    //Command Path
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("You cannot use this command");
            return true;
        }
        if(command.getName().equalsIgnoreCase("freebattlepass")){
            if(!sender.isOp()){
                return true;
            }
            if(args.length < 1){
                return false;
            }

            if(Objects.equals(args[0], "on")){
                setTrue();
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы установили бесплатный боевой пропуск.P.S: Не забудьте его выключить.");
                return true;
            }
            if(Objects.equals(args[0], "off")){
                setFalse();
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы отключили бесплатный боевой пропуск.");
                return true;
            }
        }
        return true;
    }
}
