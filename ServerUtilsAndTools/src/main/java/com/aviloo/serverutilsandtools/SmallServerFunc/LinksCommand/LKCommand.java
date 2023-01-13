package com.aviloo.serverutilsandtools.SmallServerFunc.LinksCommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LKCommand implements CommandExecutor {

    private void send(Player player,String ... lines){
        for(String str : lines){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',str));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot use this command");
            return true;
        }
        if(command.getName().equalsIgnoreCase("links")){
            Player player = (Player) sender;
            send(player,"&f--------&6Соц.сети&f--------",
                    " ",
                    "&eНаш сайт: &7www.Orumii.su",
                    "&eГруппа вк: &7vk.com/orumii",
                    " ",
                    "&f------------------------");
            return true;
        }
        return true;
    }
}
