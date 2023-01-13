package com.aviloo.serverutilsandtools.SmallServerFunc.RewardSwords;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SwordsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("This command can execute ONLY players.");
            return true;
        }

        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("giverewardsword")){
            if(!player.isOp()){
                player.sendMessage("У вас недостаточно прав.");
                return true;
            }
            if(args.length < 2) return false;

            String PlayerName = args[1];
            Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
            if (argPlayer == null) {
                sender.sendMessage("Данный игрок оффлайн.");
                return true;
            }

            if(args[0].equalsIgnoreCase("love")){
                argPlayer.getInventory().addItem(SwordsStacks.getLoveSword(player));
            }
        }
        return true;
    }
}
