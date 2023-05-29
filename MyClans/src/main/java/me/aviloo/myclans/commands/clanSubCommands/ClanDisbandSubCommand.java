package me.aviloo.myclans.commands.clanSubCommands;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.utils.ClansStorageUtil;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ClanDisbandSubCommand {

    FileConfiguration messagesConfig = MyClans.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean disbandClanSubCommand(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            try {
                if (ClansStorageUtil.deleteClan(player)) {
                    sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-successfully-disbanded")));
                } else {
                    sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-disband-failure")));
                }
            } catch (IOException e) {
                sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clans-update-error-1")));
                sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clans-update-error-2")));
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
