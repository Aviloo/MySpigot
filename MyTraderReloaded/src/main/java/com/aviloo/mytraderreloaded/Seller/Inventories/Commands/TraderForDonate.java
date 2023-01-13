package com.aviloo.mytraderreloaded.Seller.Inventories.Commands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class TraderForDonate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot use this command");
            return true;
        }
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("seller")){
            if(!player.hasPermission("mytrader.seller")){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"" +
                        "&7[Система] &fУ вас недостаточно прав."));
                return true;
            }

            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen1")){
                player.openInventory(Screen1.sellInventory(player));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen2")){
                player.openInventory(Screen2.sellInventory(player));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen3")){
                player.openInventory(Screen3.getInventory(player));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen4")){
                player.openInventory(Screen4.getInventory(player));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen5")){
                player.openInventory(Screen5.getInventory(player));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "ScreenE")){
                player.openInventory(ScreenE.getInventory(player));
                return true;
            }
            return true;
        }
        return true;
    }
}
