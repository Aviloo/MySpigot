package me.aviloo.myarenamanager.Commands;

import me.aviloo.myarenamanager.Utils.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetWorldInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage(ColorUtils.translateColorCodes(
                    "&4[Ошибка(MyArenaManager)] &fЭту команду может использовать только игрок!"));
            return true;
        }

        if(command.getName().equalsIgnoreCase("getcurrentworldinfo")){
            Player player = (Player) commandSender;
            if(!player.isOp()){return true;}

            player.sendMessage(ChatColor.DARK_GRAY+"--------------------");
            player.sendMessage(ChatColor.YELLOW+"Информация о этом мире:");
            player.sendMessage(ChatColor.YELLOW+"Имя:"+player.getWorld().getName());
            player.sendMessage(ChatColor.YELLOW+"UUID:"+player.getWorld().getUID());
            player.sendMessage(ChatColor.DARK_GRAY+"--------------------");
        }

        return true;
    }
}
