package me.aviloo.myAdmins.Commands.PunishmentCommands;

import me.aviloo.myAdmins.Events.BanEvent;
import me.aviloo.myAdmins.Events.TempBanEvent;
import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Utils.DateManager;
import me.aviloo.myAdmins.Utils.StorageUtils.RulesStorageUtil;
import me.aviloo.myAdmins.Utils.TextUtils;
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

public class TempBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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
        long duration = DateManager.parseDuration(args[1]);
        Date ban  = new Date(System.currentTimeMillis() + duration);
        String reason = ChatColor.RED+"Вас забанили по причине "
                +ChatColor.GOLD+args[2]+": "+ChatColor.WHITE+
                RulesStorageUtil.getValue(args[2])
                + "                                                      "
                +ChatColor.GRAY+"Администратор: "+sender.getName()+" Дата: "+
                new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())
                + " Вас разбанят: "+new SimpleDateFormat("dd-MM-yyyy HH:mm").format(ban);

        Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(target.getName(),
                reason, ban, sender.getName());
        // Можно также искать игрока, если он онлайн:
        if (target.isOnline()) {
            target.getPlayer().kickPlayer(reason);
        }
        TempBanEvent event = new TempBanEvent(target,sender,args[2]);
        Bukkit.getPluginManager().callEvent(event);
        TextUtils.sendTempBanMessages(target.getName(),sender.getName(),
        new SimpleDateFormat("dd-MM-yyyy HH:mm").format(ban),args[2]);

        return true;
    }
}
