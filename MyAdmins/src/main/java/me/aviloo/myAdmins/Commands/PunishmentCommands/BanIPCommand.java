package me.aviloo.myAdmins.Commands.PunishmentCommands;

import me.aviloo.myAdmins.Events.BanIPEvent;
import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Utils.StorageUtils.RulesStorageUtil;
import me.aviloo.myAdmins.Utils.TextUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

import static me.aviloo.myAdmins.Commands.PunishmentCommands.KickCommand.isInteger;
import static me.aviloo.myAdmins.Commands.PunishmentCommands.KickCommand.isNumeric;

public class BanIPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof ConsoleCommandSender)) {
            if (!Admin.isPlayerAdmin((Player) sender)) {
                sender.sendMessage(ChatColor.RED + "Вы должны быть администратором.");
                return true;
            }
        }
        if(args.length < 2){return false;}
        if(!isNumeric(args[1]) && !isInteger(args[1])){
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
        String reason = ChatColor.RED+"Вас забанили навсегда по причине "
                +ChatColor.GOLD+args[1]+": "+ChatColor.WHITE+
                RulesStorageUtil.getValue(args[1])
                + "                                                      "
                +ChatColor.GRAY+"Администратор: "+sender.getName()+" Дата: "+
                new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());

        Bukkit.getBanList(BanList.Type.IP).addBan(target.getName(),
                reason, null, sender.getName());
        // Можно также искать игрока, если он онлайн:
        if (target.isOnline()) {
            target.getPlayer().kickPlayer(reason);
        }
        BanIPEvent event = new BanIPEvent(target,sender,args[1]);
        Bukkit.getPluginManager().callEvent(event);
        TextUtils.sendBanIPMessages(target.getName(),sender.getName(),args[1]);

        return true;
    }
}
