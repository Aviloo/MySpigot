package com.aviloo.mytraderreloaded.Commands.adminSubCommand;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerReputation;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class reputationCommand {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean reputationSubCommand(CommandSender sender, String[] args) {
        if(!sender.isOp()){return true;}

        String PlayerName = args[2];
        Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
        if (argPlayer == null) {
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    messagesConfig.getString("command_player_not_found")));
            return true;
        }

        switch (args[1]){
            case "set":
                reputationOperationManager(argPlayer,"set",args[3],sender);
                break;
            case "add":
                reputationOperationManager(argPlayer,"add",args[3],sender);
                break;
            case "take":
                reputationOperationManager(argPlayer,"take",args[3],sender);
                break;
            case "reset":
                reputationOperationManager(argPlayer,"reset","0",sender);
                break;
            case "get":
                if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                    sender.sendMessage(ColorUtils.translateColorCodes("&fУровень репутации "
                            +argPlayer.getName()+" &4"+ PlayerReputation.getReputation(argPlayer)));
                }
                if(!MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                    sender.sendMessage(ColorUtils.translateColorCodes("&fУровень репутации "
                            +argPlayer.getName()+" &4"+ PlayerReputation.getReputationFromUsermap(argPlayer)));
                }
                break;
            default:
                sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"У данной команды есть аргументы:" +
                        " set|take|add|reset.");
        }

        return true;
    }

    private void reputationOperationManager(Player player, String OperationType, String value, CommandSender sender){
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
