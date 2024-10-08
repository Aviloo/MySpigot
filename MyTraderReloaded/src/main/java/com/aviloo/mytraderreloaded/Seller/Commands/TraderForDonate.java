package com.aviloo.mytraderreloaded.Seller.Commands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.*;
import com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens.Screen6;
import com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens.Screen7;
import com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens.Screen8;
import com.aviloo.mytraderreloaded.Seller.Inventories.NonOptimizedScreens.Screen9;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class TraderForDonate implements CommandExecutor {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    messagesConfig.getString("command_only_console_can_use")));
            return true;
        }
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("seller")){
            if(!player.hasPermission("mytrader.seller")){
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                        messagesConfig.getString("command_dont_have_perm")));
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
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen6")){
                player.openInventory(Screen6.getInv(player));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen7")){
                player.openInventory(Screen7.getInv(player));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen8")){
                player.openInventory(Screen8.getInv(player));
                return true;
            }
            if(Objects.equals(MyTraderReloaded.getTraderType(), "Screen9")){
                player.openInventory(Screen9.getInv(player));
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
