package com.aviloo.mydaily.Commands;

import com.aviloo.mydaily.Inventory.MainInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenMain implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] &fВы не можете использовать эту команду."));
            return true;
        }
        if(command.getName().equalsIgnoreCase("secretopendailycommand")){
            if(args.length < 1){return false;}
            if(!sender.isOp()){return true;}

            String PlayerName = args[0];
            Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
            if (argPlayer == null) {
                sender.sendMessage("Данный игрок оффлайн.");
                return true;
            }
            argPlayer.openInventory(MainInventory.getInv(argPlayer));
            return true;
        }
        return true;
    }
}
