package com.aviloo.mytraderreloaded.Seller.Commands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class ReloadType implements CommandExecutor {

    private MyTraderReloaded plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("You cannot use this command!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("sellertype")){
            if(args.length <1){return false;}
            if(!sender.isOp()){return true;}
            if(!(Objects.equals(args[0], "reload"))){return false;}

            plugin.randomTraderType();
            //MyTraderReloaded.randomTraderType();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] &fСкупщик перезагружен."));
            return true;
        }
        return true;
    }
}
