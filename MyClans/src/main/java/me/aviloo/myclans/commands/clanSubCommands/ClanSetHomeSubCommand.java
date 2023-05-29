package me.aviloo.myclans.commands.clanSubCommands;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.api.ClanHomeCreateEvent;
import me.aviloo.myclans.models.Clan;
import me.aviloo.myclans.utils.ClansStorageUtil;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class ClanSetHomeSubCommand {

    FileConfiguration clansConfig = MyClans.getPlugin().getConfig();
    FileConfiguration messagesConfig = MyClans.getPlugin().messagesFileManager.getMessagesConfig();
    Logger logger = MyClans.getPlugin().getLogger();

    public boolean setClanHomeSubCommand(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (clansConfig.getBoolean("clan-home.enabled")){
                if (ClansStorageUtil.isClanOwner(player)){
                    if (ClansStorageUtil.findClanByOwner(player) != null){
                        Clan clan = ClansStorageUtil.findClanByOwner(player);
                        Location location = player.getLocation();
                        fireClanHomeSetEvent(player, clan, location);
                        if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                            logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aFired ClanHomeSetEvent"));
                        }
                        clan.setClanHomeWorld(player.getLocation().getWorld().getName());
                        clan.setClanHomeX(player.getLocation().getX());
                        clan.setClanHomeY(player.getLocation().getY());
                        clan.setClanHomeZ(player.getLocation().getZ());
                        clan.setClanHomeYaw(player.getLocation().getYaw());
                        clan.setClanHomePitch(player.getLocation().getPitch());
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("successfully-set-clan-home")));
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

    private static void fireClanHomeSetEvent(Player player, Clan clan, Location homeLocation) {
        ClanHomeCreateEvent clanHomeCreateEvent = new ClanHomeCreateEvent(player, clan, homeLocation);
        Bukkit.getPluginManager().callEvent(clanHomeCreateEvent);
    }
}
