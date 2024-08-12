package com.aviloo.mytraderreloaded.Seller.Expansions;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ExpansionsTestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("-");
            return true;
        }
        if(command.getName().equalsIgnoreCase("ExpansionsTestCommand")){
            if(!sender.isOp()){return true;}

            Player player = (Player) sender;
            player.sendMessage(PlaceholderAPI.setPlaceholders(player,"%seller_reputation%"));
            return true;
        }
        return true;
    }
}
