package com.aviloo.serverutilsandtools.SmallServerFunc.PotionDupe;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PotionDupeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("This command can execute ONLY players.");
            return true;
        }
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("ultrapotion")){
            player.openInventory(PotionDupeInventory.getInventory(player));
        }
        return true;
    }
}
