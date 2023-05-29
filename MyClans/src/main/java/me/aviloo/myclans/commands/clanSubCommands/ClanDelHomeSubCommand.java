package me.aviloo.myclans.commands.clanSubCommands;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.api.ClanHomeDeleteEvent;
import me.aviloo.myclans.models.Clan;
import me.aviloo.myclans.utils.ClansStorageUtil;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class ClanDelHomeSubCommand {

    FileConfiguration clansConfig = MyClans.getPlugin().getConfig();
    FileConfiguration messagesConfig = MyClans.getPlugin().messagesFileManager.getMessagesConfig();
    Logger logger = MyClans.getPlugin().getLogger();

    public boolean deleteClanHomeSubCommand(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (clansConfig.getBoolean("clan-home.enabled")){
                if (ClansStorageUtil.findClanByOwner(player) != null){
                    Clan clanByOwner = ClansStorageUtil.findClanByOwner(player);
                    if (ClansStorageUtil.isHomeSet(clanByOwner)){
                        fireClanHomeDeleteEvent(player, clanByOwner);
                        if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                            logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aFired ClanHomeDeleteEvent"));
                        }
                        ClansStorageUtil.deleteHome(clanByOwner);
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("successfully-deleted-clan-home")));
                    }else {
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("failed-no-home-set")));
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

    private static void fireClanHomeDeleteEvent(Player player, Clan clan) {
        ClanHomeDeleteEvent clanHomeDeleteEvent = new ClanHomeDeleteEvent(player, clan);
        Bukkit.getPluginManager().callEvent(clanHomeDeleteEvent);
    }
}
