package com.aviloo.mytraderreloaded.Commands;

import com.aviloo.mytraderreloaded.Commands.adminSubCommand.*;
import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class AdminCommand implements CommandExecutor {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!sender.isOp()){
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    "command_dont_have_perm"));
            return true;
        }
        if(args.length == 0){
            return false;
        }

        if(command.getName().equalsIgnoreCase("mytrader")) {
            switch (args[0]) {
                case "reload":
                    return new reloadCommand().reloadSubCommand(sender,args);
                case "reputation":
                    return new reputationCommand().reputationSubCommand(sender,args);
                case "earned":
                    return new earnedCommand().earnedSubCommand(sender,args);
                case "expansions":
                    return new expansionsCommand().expansionSubCommand(sender);
                case "info":
                    return new infoCommand().infoSubCommand(sender);
                case "secrettrader":
                    return new secretTraderCommand().secretTraderSubCommand(sender,args);
                default:
                    sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                            messagesConfig.getString("command_incorrect_command_usage")));

            }
        }

        return true;
    }
}
