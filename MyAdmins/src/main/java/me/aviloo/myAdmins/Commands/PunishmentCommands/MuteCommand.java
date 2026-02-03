package me.aviloo.myAdmins.Commands.PunishmentCommands;

import me.aviloo.myAdmins.Events.MuteEvent;
import me.aviloo.myAdmins.Events.TempBanEvent;
import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Models.PluginPlayer;
import me.aviloo.myAdmins.Utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MuteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(!(sender instanceof ConsoleCommandSender)) {
            if (!Admin.isPlayerAdmin((Player) sender)) {
                sender.sendMessage(ChatColor.RED + "Вы должны быть администратором.");
                return true;
            }
        }
        if(args.length < 2){return false;}
        if(!KickCommand.isNumeric(args[1]) && !KickCommand.isInteger(args[1])){
            sender.sendMessage("Причина должна быть числом!");
            return true;
        }
        if ((Integer.parseInt(args[1]) == 22) && !sender.isOp()){
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
        if(!PluginPlayer.playerIsPluginPlayer(target.getUniqueId())){
            player.sendMessage("Ошибка. Игрок не является PluginPlayer");
            return true;
        }

        if(!PluginPlayer.getPluginPlayerByUUID(target.getUniqueId()).isMuted()) {
            PluginPlayer.getPluginPlayerByPlayer(target).setMuted(true);
            sender.sendMessage(ChatColor.GREEN + "Вы наложили на "
                    + target.getName() + " мут.");
            target.sendMessage(ChatColor.GOLD + "На вас наложили перманентный мут.");
            MuteEvent event = new MuteEvent(target, sender, args[1]);
            Bukkit.getPluginManager().callEvent(event);
            TextUtils.sendMuteMessages(target.getName(), player.getName(), args[1]);
            return true;
        }
        if(PluginPlayer.getPluginPlayerByUUID(target.getUniqueId()).isMuted()){
            PluginPlayer.getPluginPlayerByPlayer(target).setMuted(false);
            PluginPlayer.getPluginPlayerByUUID(target.getUniqueId()).setDuration(0);
            sender.sendMessage(ChatColor.GREEN + "Вы сняли с игрока "
                    + target.getName() + " мут.");
            target.sendMessage(ChatColor.GOLD + "С вас сняли перманентный мут.");
            return true;
        }
        return true;
    }
}
