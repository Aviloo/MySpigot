package me.aviloo.myAdmins.Commands.PunishmentCommands;

import me.aviloo.myAdmins.Events.KickEvent;
import me.aviloo.myAdmins.Events.TempMuteEvent;
import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Models.PluginPlayer;
import me.aviloo.myAdmins.Utils.DateManager;
import me.aviloo.myAdmins.Utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

import static me.aviloo.myAdmins.Commands.PunishmentCommands.KickCommand.isInteger;
import static me.aviloo.myAdmins.Commands.PunishmentCommands.KickCommand.isNumeric;

public class TempMuteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof ConsoleCommandSender)) {
            if (!Admin.isPlayerAdmin((Player) sender)) {
                sender.sendMessage(ChatColor.RED + "Вы должны быть администратором.");
                return true;
            }
        }
        if(args.length < 3){return false;}
        if(!isNumeric(args[2]) && !isInteger(args[2])){
            sender.sendMessage("Причина должна быть числом!");
            return true;
        }
        if ((Integer.parseInt(args[2]) == 22) && !sender.isOp()){
            sender.sendMessage(ChatColor.DARK_GRAY+"["
                    +ChatColor.RED+"Ошибка"+ChatColor.DARK_GRAY+"] "
                    +ChatColor.WHITE+"Вам не доступна эта причина!");
            return true;
        }

        String PlayerName = args[0];
        Player target = Bukkit.getServer().getPlayer(PlayerName);
        if (target == null) {
            sender.sendMessage("Игрок не найден");
            return true;
        }

        long duration = DateManager.parseDuration(args[1]) + System.currentTimeMillis();
        PluginPlayer.getPluginPlayerByPlayer(target).setMuted(true);
        PluginPlayer.getPluginPlayerByPlayer(target).setDuration(duration);
        TempMuteEvent event = new TempMuteEvent(target,sender,args[1],duration);
        Bukkit.getPluginManager().callEvent(event);
        TextUtils.sendTempMuteMessages(target.getName(),sender.getName(),args[2]);
        return true;
    }
}
