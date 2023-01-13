package com.aviloo.mybattlepass.Commands;

import com.aviloo.mybattlepass.Utils.BPExp;
import com.aviloo.mybattlepass.Utils.BPLevel;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ResetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("You cannot use this command!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("bpreset")){
            if(!sender.isOp()){
                return true;
            }
            BPLevel.reset();
            BPExp.reset();
            sender.sendMessage(ChatColor.GRAY+"[Сервер(MyBattlePass)] " + ChatColor.WHITE+"Уровень и опыт боевого пропуска "+ChatColor.RED+"ВСЕХ"+ChatColor.WHITE+" игроков был успешно сброшен!");
            return true;
        }
        return true;
    }
}
