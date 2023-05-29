package me.aviloo.myclans.commands.clanSubCommands;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.models.Clan;
import me.aviloo.myclans.utils.ClansStorageUtil;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ClanListSubCommand {

    FileConfiguration messagesConfig = MyClans.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean clanListSubCommand(CommandSender sender) {
        if (sender instanceof Player) {
            Set<Map.Entry<UUID, Clan>> clans = ClansStorageUtil.getClans();
            StringBuilder clansString = new StringBuilder();
            if (clans.size() == 0) {
                sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("no-clans-to-list")));
            } else {
                clansString.append(ColorUtils.translateColorCodes(messagesConfig.getString("clans-list-header") + "\n"));
                clans.forEach((clan) ->
                        clansString.append(ColorUtils.translateColorCodes(clan.getValue().getClanFinalName() + "\n")));
                clansString.append(" ");
                clansString.append(ColorUtils.translateColorCodes(messagesConfig.getString("clans-list-footer")));
                sender.sendMessage(clansString.toString());
            }
            return true;

        }
        return false;
    }
}
