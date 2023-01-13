package com.aviloo.serverutilsandtools.ServerTools.TntStuff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Objects;

public class TSCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot use this command");
            return true;
        }
        if(command.getName().equalsIgnoreCase("getcustomtnt")){
            if(!sender.isOp()){return true;}
            if(args.length < 1){return false;}

            if(Objects.equals(args[0], "black")){
                ((Player) sender).getInventory().addItem(TSEvents.blackStack());
                return true;
            }
        }
        return true;
    }
}
