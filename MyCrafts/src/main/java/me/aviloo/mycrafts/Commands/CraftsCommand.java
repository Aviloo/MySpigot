package me.aviloo.mycrafts.Commands;

import me.aviloo.mycrafts.Commands.subCommands.GetItemsSubCommand;
import me.aviloo.mycrafts.Commands.subCommands.reloadSubCommand;
import me.aviloo.mycrafts.MyCrafts;
import me.aviloo.mycrafts.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CraftsCommand implements CommandExecutor {

    private static FileConfiguration messagesConfig =
            MyCrafts.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColorCodes(
                messagesConfig.getString("prefix.system") +
                    messagesConfig.getString("command.NotPlayer"))
            );
            return true;
        }
        if(!sender.isOp()){
            sender.sendMessage(ColorUtils.translateColorCodes(
                    messagesConfig.getString("prefix.system") +
                            messagesConfig.getString("command.NoPermission"))
            );
            return true;
        }
        if(args.length == 0) {
            return false;
        }

        switch (args[0]){
            case "getItem":
                return new GetItemsSubCommand().getItemSubCommand(sender,args);
            case "reload":
                return new reloadSubCommand().reloadSubCommand(sender);
            default:
                sender.sendMessage(ColorUtils.translateColorCodes(
                        messagesConfig.getString("prefix.system") +
                                messagesConfig.getString("command.IncorrectCommandUsage"))
                );
        }

        return true;
    }
}
