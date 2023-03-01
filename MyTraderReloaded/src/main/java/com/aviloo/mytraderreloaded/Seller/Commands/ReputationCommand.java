package com.aviloo.mytraderreloaded.Seller.Commands;

import com.aviloo.mytraderreloaded.Seller.Utils.PlayerReputation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ReputationCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)){
            sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Вы не можете сделать это!");
            return true;
        }

        if(command.getName().equalsIgnoreCase("traderreputation")){
            if(args.length <1){return false;}
            if(!sender.isOp()){return true;}

            String PlayerName = args[1];
            Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
            if (argPlayer == null) {
                sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Данный игрок оффлайн.");
                return true;
            }

            if(args[0].equals("set")){
                PlayerReputation.setReputation(argPlayer, Integer.valueOf(args[2]));
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы установили для "+
                argPlayer.getName()+" баланс, равный "+args[2]+" очков.");
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        argPlayer.getName()+",равна "+PlayerReputation.getReputation(argPlayer)+" очков.");
                return true;
            }
            if(args[0].equals("add")){
                PlayerReputation.addReputation(argPlayer, Integer.valueOf(args[2]));
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы добавили к балансу "+
                        argPlayer.getName()+" "+args[2]+" очков.");
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        argPlayer.getName()+",равна "+PlayerReputation.getReputation(argPlayer)+" очков.");
                return true;
            }
            if(args[0].equals("take")){
                PlayerReputation.takeReputation(argPlayer, Integer.valueOf(args[2]));
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы забрали у "+
                        argPlayer.getName()+" сумму очков, равную "+args[2]+".");
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        argPlayer.getName()+",равна "+PlayerReputation.getReputation(argPlayer)+" очков.");
                return true;
            }
            if(args[0].equals("reset")){
                PlayerReputation.setReputation(argPlayer,0);
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы сбросили репутацию для "+
                        argPlayer.getName());
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        argPlayer.getName()+",равна "+PlayerReputation.getReputation(argPlayer)+" очков.");
                return true;
            }
            else {
                sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"У данной команды есть аргументы:" +
                        " set|take|add|reset.");
                return true;
            }
        }
        return true;
    }

    //Completer Path
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> commandsFirst = new ArrayList<>();
        if(args.length == 1){
            List<String> completions = new ArrayList<>();
            completions.add("add");
            completions.add("set");
            completions.add("take");
            completions.add("reset");
            for(String s : completions){
                if(s.toLowerCase().startsWith(args[0].toLowerCase())){
                    commandsFirst.add(s);
                }
            }
            return commandsFirst;
        }
        return null;
    }
}
