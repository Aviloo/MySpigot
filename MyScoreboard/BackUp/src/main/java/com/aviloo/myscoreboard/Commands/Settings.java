package com.aviloo.myscoreboard.Commands;

import com.aviloo.myscoreboard.Inventories.MainInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Settings implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot use this command");
            return true;
        }
        if(command.getName().equalsIgnoreCase("myscoreboard")){
            Player player = (Player) sender;
            player.openInventory(MainInventory.getInv(player));
            return true;
        }
        return true;
    }
}
