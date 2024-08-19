package me.aviloo.mycrafts.Commands.subCommands;

import me.aviloo.mycrafts.MyCrafts;
import me.aviloo.mycrafts.Utils.ColorUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class reloadSubCommand {

    private static FileConfiguration messagesConfig =
            MyCrafts.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean reloadSubCommand(CommandSender sender) {
        MyCrafts.getPlugin().itemsFileManager.reloadItemsConfig();
        MyCrafts.getPlugin().messagesFileManager.reloadMessagesConfig();
        sender.sendMessage(ColorUtils.translateColorCodes(
                messagesConfig.getString("prefix.plugin") +
                        messagesConfig.getString("command.ConfigsReloaded"))
        );

        return true;
    }

}
