package me.aviloo.myAdmins.Commands.SubCommands;

import me.aviloo.myAdmins.Models.Admin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class getStats{

    public boolean execute(@NotNull CommandSender sender,@NotNull String[] args) {
        if(!sender.isOp()){
            sender.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
            return true;
        }
        if(args.length <2){return false;}
        String PlayerName = args[1];
        Player target = Bukkit.getServer().getPlayer(PlayerName);
        if (target == null) {
            sender.sendMessage("Игрок не найден");
            return true;
        }

        Admin admin = Admin.getAdminByPlayer(target);
        if (admin == null) {
            sender.sendMessage("Такого администратора нет!");
            return true;
        }
        sender.sendMessage("-------------");
        sender.sendMessage("Ник: " + admin.getName());
        sender.sendMessage("UUID: "+ admin.getUuid().toString());
        sender.sendMessage("Текущий ip: "+admin.getCurrent_ip());
        sender.sendMessage("Прошлый ip: "+admin.getLast_ip());
        sender.sendMessage("Дата постановки на пост: "+admin.getRegistration_date());
        sender.sendMessage("Последний заход: " + admin.getLast_connection_date());
        sender.sendMessage("Отыграл: "+admin.getLast_session_time());
        sender.sendMessage("Кол-во банов: "+admin.getBan_count());
        sender.sendMessage("Кол-во банов IP: "+admin.getBanip_count());
        sender.sendMessage("Кол-во киков: "+admin.getKick_count());
        sender.sendMessage("Кол-во мутов: "+admin.getMute_count());
        sender.sendMessage("--------------------");
        return true;
    }
}
