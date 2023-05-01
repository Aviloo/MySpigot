package com.aviloo.mytraderreloaded.Seller.Commands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.jetbrains.annotations.NotNull;

public class SetType implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] &fВы не можете использовать эту команду."));
            return true;
        }
        if(command.getName().equalsIgnoreCase("sellersettype")){
            if(args.length <1){
                return false;
            }

            if(args[0].equals("Screen1")){
                MyTraderReloaded.setTraderType("Screen1");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen1"));
                return true;
            }
            if(args[0].equals("Screen2")){
                MyTraderReloaded.setTraderType("Screen2");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen2"));
                return true;
            }
            if(args[0].equals("Screen3")){
                MyTraderReloaded.setTraderType("Screen3");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen3"));
                return true;
            }
            if(args[0].equals("Screen4")){
                MyTraderReloaded.setTraderType("Screen4");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen4"));
                return true;
            }
            if(args[0].equals("Screen5")){
                MyTraderReloaded.setTraderType("Screen5");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen5"));
                return true;
            }
            if(args[0].equals("ScreenE")){
                MyTraderReloaded.setTraderType("ScreenE");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - ScreenE"));
                return true;
            }
        }else {
            MyTraderReloaded.setTraderType(args[0]);
            return true;
        }
        return true;
    }
}
