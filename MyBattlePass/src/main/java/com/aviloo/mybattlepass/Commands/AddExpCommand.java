package com.aviloo.mybattlepass.Commands;

import com.aviloo.mybattlepass.Utils.BPExp;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class AddExpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage(ChatColor.WHITE+"You cannot use this command!");
            return true;
        }

        if(command.getName().equalsIgnoreCase("bpaddexp")){
            if(!sender.isOp()){
                return true;
            }
            if(args.length < 2){
                return false;
            }
            String PlayerName = args[0];
            Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
            if (argPlayer == null) {
                sender.sendMessage("Данный игрок оффлайн.");
                return true;
            }

            try {
                BPExp.addExp(argPlayer, Integer.valueOf(args[1]));
                return true;
            }catch (NumberFormatException nfe){
                sender.sendMessage(ChatColor.WHITE+"Укажите количество опыта верно.(Это число)");
                return true;
            }

        }
        return true;
    }
}
