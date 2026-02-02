package me.aviloo.myAdmins.Commands;

import me.aviloo.myAdmins.Menu.ReportsMenu;
import me.aviloo.myAdmins.Models.Admin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReportsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.GOLD+"Вы должны быть игроком");
            return true;
        }
        if (!Admin.isPlayerAdmin((Player) sender)) {
            sender.sendMessage(ChatColor.RED + "Вы должны быть администратором.");
            return true;
        }
        Player player = (Player) sender;
        ReportsMenu.update();
        player.openInventory(ReportsMenu.inventory);

        return true;
    }
}
