package com.aviloo.mytraderreloaded.Seller.Commands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.*;
import com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens.Screen6;
import com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens.Screen7;
import com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens.Screen8;
import com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens.Screen9;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class OpenTrader implements CommandExecutor {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    messagesConfig.getString("command_only_console_can_use")));
            return true;
        }

        if(command.getName().equalsIgnoreCase("secretsellercommand")){
            if(args.length < 1){return false;}
            if(!sender.isOp()){return true;}

            String PlayerName = args[0];
            Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
            if (argPlayer == null) {
                sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                        messagesConfig.getString("command_player_not_found")));
                return true;
            }

            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen1")){
                argPlayer.openInventory(Screen1.sellInventory(argPlayer));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen2")){
                argPlayer.openInventory(Screen2.sellInventory(argPlayer));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen3")){
                argPlayer.openInventory(Screen3.getInventory(argPlayer));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen4")){
                argPlayer.openInventory(Screen4.getInventory(argPlayer));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen5")){
                argPlayer.openInventory(Screen5.getInventory(argPlayer));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen6")){
                argPlayer.openInventory(Screen6.getInv(argPlayer));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen7")){
                argPlayer.openInventory(Screen7.getInv(argPlayer));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen8")){
                argPlayer.openInventory(Screen8.getInv(argPlayer));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen9")){
                argPlayer.openInventory(Screen9.getInv(argPlayer));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "ScreenE")){
                argPlayer.openInventory(ScreenE.getInventory(argPlayer));
                return true;
            }
            return true;
        }
        return true;
    }
}
