package com.aviloo.rewardchests.Commands.ForQuest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class giveQuestChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("This command can execute ONLY ConsoleCommandSender`s!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("givequestchestsecretcommand")){
            if(args.length < 1){
                return false;
            }

            String PlayerName = args[0];
            Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
            if (argPlayer == null) {
                sender.sendMessage("Данный игрок оффлайн.");
                return true;
            }
            argPlayer.getInventory().addItem(com.aviloo.rewardchests.ItemStack.Chests.fisherChest.chestStack());
            argPlayer.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпал сундук рыбака.");
            return true;
        }
        return true;
    }
}
