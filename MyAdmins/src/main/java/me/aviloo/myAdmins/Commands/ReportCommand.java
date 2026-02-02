package me.aviloo.myAdmins.Commands;

import me.aviloo.myAdmins.Menu.ReportsMenu;
import me.aviloo.myAdmins.Models.Report;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You must be a player to use this command!");
            return true;
        }
        if(args.length < 1){return false;}

        new Report(sender.getName(),args);
        sender.sendMessage(ChatColor.GRAY+"[Система] "
        +ChatColor.GREEN+ "Ваш репорт отправлен!");


        return true;
    }
}
