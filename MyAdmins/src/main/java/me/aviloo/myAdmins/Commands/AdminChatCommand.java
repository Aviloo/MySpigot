package me.aviloo.myAdmins.Commands;

import me.aviloo.myAdmins.Events.AdminChatMessageEvent;
import me.aviloo.myAdmins.Events.KickEvent;
import me.aviloo.myAdmins.Handler.PlayerHandler;
import me.aviloo.myAdmins.Models.Admin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class AdminChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You must be a player to use this command.");
            return true;
        }
        if(!Admin.isPlayerAdmin((Player) sender)) {
            sender.sendMessage(ChatColor.RED+"Вы должны быть администратором.");
            return true;
        }

        Player player = (Player) sender;
        for(Player ps : PlayerHandler.adminsOnline){
            ps.sendMessage(ChatColor.DARK_GRAY+"["+ChatColor.DARK_RED+"AC"
            +ChatColor.DARK_GRAY+"] "+ Admin.getAdminByPlayer(player).getAdminType().getPrefix()
            +" "+ChatColor.GRAY+sender.getName()+" "
            +ChatColor.WHITE+ Arrays.toString(args));
        }
        AdminChatMessageEvent event = new AdminChatMessageEvent(player,Arrays.toString(args));
        Bukkit.getPluginManager().callEvent(event);
        return true;
    }
}
