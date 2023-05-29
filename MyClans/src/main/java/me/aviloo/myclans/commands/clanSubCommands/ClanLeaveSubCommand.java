package me.aviloo.myclans.commands.clanSubCommands;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.models.Clan;
import me.aviloo.myclans.utils.ClansStorageUtil;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ClanLeaveSubCommand {

    FileConfiguration messagesConfig = MyClans.getPlugin().messagesFileManager.getMessagesConfig();
    private static final String CLAN_PLACEHOLDER = "%CLAN%";

    public boolean clanLeaveSubCommand(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (ClansStorageUtil.findClanByOwner(player) != null) {
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("failed-clan-owner")));
                return true;
            }
            Clan targetClan = ClansStorageUtil.findClanByPlayer(player);
            if (targetClan != null) {
                if (targetClan.removeClanMember(player.getUniqueId().toString())) {
                    String leaveMessage = ColorUtils.translateColorCodes(messagesConfig.getString("clan-leave-successful")).replace(CLAN_PLACEHOLDER, targetClan.getClanFinalName());
                    player.sendMessage(leaveMessage);
                } else {
                    player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-leave-failed")));
                }
            }
            return true;

        }
        return false;
    }
}
