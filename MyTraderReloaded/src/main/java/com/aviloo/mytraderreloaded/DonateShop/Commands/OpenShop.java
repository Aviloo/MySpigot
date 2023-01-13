package com.aviloo.mytraderreloaded.DonateShop.Commands;

import com.aviloo.mytraderreloaded.DonateShop.Inventories.MainInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class OpenShop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] &fВы не можете использовать эту команду."));
            return true;
        }
        if(command.getName().equalsIgnoreCase("secretdonatshopcommand")){
            if(args.length < 1){return false;}
            if(!sender.isOp()){return true;}

            String PlayerName = args[0];
            Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
            if (argPlayer == null) {
                sender.sendMessage("Данный игрок оффлайн.");
                return true;
            }
            argPlayer.openInventory(MainInventory.getInv(argPlayer));
        }
        return true;
    }
}
