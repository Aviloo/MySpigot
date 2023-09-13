package com.aviloo.myscoreboard.Commands;

import com.aviloo.myscoreboard.Boards.BoardManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EventBoardsEnable implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("You cannot use this command!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("seteventboard")){
            if(!sender.isOp()){return true;}
            if(args.length < 1){return false;}

            if(args[0].equals("pvp")){
                BoardManager.EventBoardsStatus = "pvp";
                return true;
            }
            if(args[0].equals("airdrops")){
                BoardManager.EventBoardsStatus = "airdrops";
                return true;
            }else {return false;}
        }
        return true;
    }
}
