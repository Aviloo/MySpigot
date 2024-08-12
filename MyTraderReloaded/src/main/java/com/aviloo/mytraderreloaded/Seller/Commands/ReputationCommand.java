package com.aviloo.mytraderreloaded.Seller.Commands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerReputation;
import com.aviloo.mytraderreloaded.Seller.Utils.UsermapStorageUtil;
import org.apache.commons.lang.math.NumberUtils;
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
                reputationOperationManager(argPlayer,"set", args[2],sender);
                return true;
            }
            if(args[0].equals("add")){
                reputationOperationManager(argPlayer,"add", args[2],sender);
                return true;
            }
            if(args[0].equals("take")){
                reputationOperationManager(argPlayer,"take", args[2],sender);
                return true;
            }
            if(args[0].equals("reset")){
                reputationOperationManager(argPlayer,"reset","0",sender);
                return true;
            }
            if(args[0].equals("get")){
                if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                    sender.sendMessage(ColorUtils.translateColorCodes("&fУровень репутации "
                            +argPlayer.getName()+" &4"+ PlayerReputation.getReputation(argPlayer)));
                }
                if(!MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                    sender.sendMessage(ColorUtils.translateColorCodes("&fУровень репутации "
                            +argPlayer.getName()+" &4"+ PlayerReputation.getReputationFromUsermap(argPlayer)));
                }
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
            completions.add("get");
            for(String s : completions){
                if(s.toLowerCase().startsWith(args[0].toLowerCase())){
                    commandsFirst.add(s);
                }
            }
            return commandsFirst;
        }
        return null;
    }

    private void reputationOperationManager(Player player,String OperationType,String value,CommandSender sender){
        if (!NumberUtils.isNumber(value)){
            sender.sendMessage(ColorUtils.translateColorCodes("&4[Ошибка] &fАргумент не является числом!"));
            return;
        }
        int amount = Integer.parseInt(value);
        if(OperationType.equalsIgnoreCase("add")){
            if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                PlayerReputation.addReputation(player, amount);
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы добавили к балансу "+
                        player.getName()+" "+amount+" очков.");
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        player.getName()+",равна "+PlayerReputation.getReputation(player)+" очков.");
                return;
            }
            if(!MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                PlayerReputation.addReputationToUsermap(player,amount);
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы добавили к балансу "+
                        player.getName()+" "+amount+" очков.");
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        player.getName()+",равна "+PlayerReputation.getReputationFromUsermap(player)+" очков.");
                return;
            }

        }
        if(OperationType.equalsIgnoreCase("take")){
            if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                PlayerReputation.addReputation(player, -amount);
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы забрали у "+
                        player.getName()+" сумму очков, равную "+amount+".");
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        player.getName()+",равна "+PlayerReputation.getReputation(player)+" очков.");
                return;
            }
            if(!MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                PlayerReputation.takeReputationFromUsermap(player,amount);
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы забрали у "+
                        player.getName()+" сумму очков, равную "+amount+".");
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        player.getName()+",равна "+PlayerReputation.getReputationFromUsermap(player)+" очков.");
                return;
            }
        }
        if(OperationType.equalsIgnoreCase("reset")){
            if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                PlayerReputation.setReputation(player,0);
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы сбросили репутацию для "+
                        player.getName());
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        player.getName()+",равна "+PlayerReputation.getReputation(player)+" очков.");
                return;
            }
            if(!MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                PlayerReputation.resetReputationToUsermap(player);
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы сбросили репутацию для "+
                        player.getName());
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        player.getName()+",равна "+PlayerReputation.getReputationFromUsermap(player)+" очков.");
            }
        }
        if(OperationType.equalsIgnoreCase("set")){
            if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                PlayerReputation.setReputation(player,amount);
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы установили для "+
                        player.getName()+" баланс, равный "+amount+" очков.");
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        player.getName()+",равна "+PlayerReputation.getReputation(player)+" очков.");
                return;
            }
            if(!MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                PlayerReputation.setReputationToUsermap(player,amount);
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы установили для "+
                        player.getName()+" баланс, равный "+amount+" очков.");
                sender.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Сейчас репутация "+
                        player.getName()+",равна "+PlayerReputation.getReputationFromUsermap(player)+" очков.");
            }
        }

    }

}

