package me.aviloo.myclans.commands.clanSubCommands;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.models.Clan;
import me.aviloo.myclans.utils.ClansStorageUtil;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ClanPvpSubCommand {

    FileConfiguration clansConfig = MyClans.getPlugin().getConfig();
    FileConfiguration messagesConfig = MyClans.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean clanPvpSubCommand(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (clansConfig.getBoolean("protections.pvp.pvp-command-enabled")){
                if (ClansStorageUtil.isClanOwner(player)){
                    if (ClansStorageUtil.findClanByOwner(player) != null){
                        Clan clan = ClansStorageUtil.findClanByOwner(player);
                        if (clan.isFriendlyFireAllowed()){
                            clan.setFriendlyFireAllowed(false);
                            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("disabled-friendly-fire")));
                        }else {
                            clan.setFriendlyFireAllowed(true);
                            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("enabled-friendly-fire")));
                        }
                    }else {
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("failed-not-in-clan")));
                    }
                }else {
                    player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-must-be-owner")));
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("function-disabled")));
            }
            return true;

        }
        return false;
    }
}
