package me.aviloo.myAdmins.Commands.SubCommands;

import me.aviloo.myAdmins.Models.Admin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class makeAdmin {

    public boolean execute(CommandSender sender,String[] args) {
        if(!sender.isOp()){
            sender.sendMessage(ChatColor.RED+"Вы должны быть администратором.");
            return true;
        }
        if(args.length < 1) {return false;}

        String PlayerName = args[1];
        Player target = Bukkit.getServer().getPlayer(PlayerName);
        if (target == null) {
            sender.sendMessage("Игрок не найден");
            return true;
        }
        if(Admin.getAdminByPlayer(target) != null){
            sender.sendMessage(ChatColor.RED+"Игрок уже администратор!");
            return true;
        }
        if(args[2] == null || args[2].equalsIgnoreCase(" ")) {
            new Admin(target.getName(),target.getUniqueId(),
            Admin.AdminType.valueOf("Хэлпер"),target.getAddress().getHostString());
            sender.sendMessage("Игрок повышен до администратора.");
            return true;
        }
        if(Admin.AdminType.valueOf(args[2]) == null){
            sender.sendMessage(ChatColor.RED+"Нет такого типа администратора.");
            return true;
        }
        new Admin(target.getName(),target.getUniqueId(),Admin.AdminType.valueOf(args[2]),target.getAddress().getHostString());
        sender.sendMessage("Игрок повышен до администратора.");

        return true;
    }

}
