package com.aviloo.serverutilsandtools.AdminTools.AdminChat;

import com.aviloo.serverutilsandtools.AdminTools.AdminChat.Utils.AdminsList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChat implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("This command can execute ONLY players.");
            return true;
        }
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("adc")){
            if(player.hasPermission("SUAT.admin-chat")){
                if(args.length < 1){
                    return false;
                }
                String string_args = String.join(" ",args);
                for(Player as : AdminsList.getAdminsList()){
                    as.sendMessage(ChatColor.RED+"[AC] " + ChatColor.GRAY + player.getName() + ": " + ChatColor.WHITE +
                            string_args);
                }
                return true;
            }
        }
        return true;
    }
}
