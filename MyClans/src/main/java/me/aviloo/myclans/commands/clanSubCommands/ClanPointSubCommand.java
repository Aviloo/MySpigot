package me.aviloo.myclans.commands.clanSubCommands;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.api.ClanPointsAddedEvent;
import me.aviloo.myclans.api.ClanPointsRemovedEvent;
import me.aviloo.myclans.models.Clan;
import me.aviloo.myclans.models.ClanPlayer;
import me.aviloo.myclans.utils.ClansStorageUtil;
import me.aviloo.myclans.utils.ColorUtils;
import me.aviloo.myclans.utils.UsermapStorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class ClanPointSubCommand {

    Logger logger = MyClans.getPlugin().getLogger();
    FileConfiguration clansConfig = MyClans.getPlugin().getConfig();
    FileConfiguration messagesConfig = MyClans.getPlugin().messagesFileManager.getMessagesConfig();

    private static final String CLAN_PLACEHOLDER = "%CLAN%";
    private static final String POINT_PLACEHOLDER = "%POINTS%";

    public boolean clanPointSubCommand(CommandSender sender, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (clansConfig.getBoolean("points.player-points.enabled")){
                if (args.length > 2){
                    if (args[1].equalsIgnoreCase("deposit")){
                        if (args[2] != null){
                            int depositValue = Integer.parseInt(args[2]);
                            if (depositValue != 0){
                                Clan clan = ClansStorageUtil.findClanByPlayer(player);
                                ClanPlayer clanPlayer = UsermapStorageUtil.getClanPlayerByBukkitPlayer(player);
                                int previousClanPlayerPointValue = clanPlayer.getPointBalance();
                                if (clan != null){
                                    int previousClanPointValue = clan.getClanPoints();
                                    if (UsermapStorageUtil.withdrawPoints(player, depositValue)){
                                        ClansStorageUtil.addPoints(clan, depositValue);
                                        int newClanPlayerPointValue = clanPlayer.getPointBalance();
                                        int newClanPointValue = clan.getClanPoints();
                                        fireClanPointsAddedEvent(player, clan, clanPlayer, previousClanPlayerPointValue, newClanPlayerPointValue, depositValue, previousClanPointValue, newClanPointValue);
                                        if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                                            logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aFired ClanPointsAddedEvent"));
                                        }
                                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-deposit-points-success")
                                                .replace(CLAN_PLACEHOLDER, clan.getClanFinalName()).replace(POINT_PLACEHOLDER, String.valueOf(depositValue))));
                                    }else {
                                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-deposit-points-failed")
                                                .replace(CLAN_PLACEHOLDER, clan.getClanFinalName()).replace(POINT_PLACEHOLDER, String.valueOf(depositValue))));
                                    }
                                    return true;
                                }else {
                                    player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-points-failed-not-in-clan")));
                                    return true;
                                }
                            }else {
                                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-deposit-points-invalid-point-amount")));
                                return true;
                            }
                        }else {
                            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-deposit-points-incorrect-command")));
                            return true;
                        }
                    }else if (args[1].equalsIgnoreCase("withdraw")){
                        if (args[2] != null){
                            int withdrawValue = Integer.parseInt(args[2]);
                            if (withdrawValue != 0){
                                Clan clan = ClansStorageUtil.findClanByPlayer(player);
                                ClanPlayer clanPlayer = UsermapStorageUtil.getClanPlayerByBukkitPlayer(player);
                                int previousClanPlayerPointValue = clanPlayer.getPointBalance();
                                if (clan != null){
                                    int previousClanPointValue = clan.getClanPoints();
                                    if (ClansStorageUtil.withdrawPoints(clan, withdrawValue)){
                                        UsermapStorageUtil.addPointsToOnlinePlayer(player, withdrawValue);
                                        int newClanPlayerPointValue = clanPlayer.getPointBalance();
                                        int newClanPointValue = clan.getClanPoints();
                                        fireClanPointsRemovedEvent(player, clan, clanPlayer, previousClanPlayerPointValue, newClanPlayerPointValue, withdrawValue, previousClanPointValue, newClanPointValue);
                                        if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                                            logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aFired ClanPointsRemovedEvent"));
                                        }
                                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-withdraw-points-success")
                                                .replace(CLAN_PLACEHOLDER, clan.getClanFinalName()).replace(POINT_PLACEHOLDER, String.valueOf(withdrawValue))));
                                    }else {
                                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-withdraw-points-failed")
                                                .replace(CLAN_PLACEHOLDER, clan.getClanFinalName()).replace(POINT_PLACEHOLDER, String.valueOf(withdrawValue))));
                                    }
                                    return true;
                                }else {
                                    player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-points-failed-not-in-clan")));
                                    return true;
                                }
                            }else {
                                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-withdraw-points-invalid-point-amount")));
                                return true;
                            }
                        }else {
                            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("clan-withdraw-points-incorrect-command")));
                            return true;
                        }
                    }
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("function-disabled")));
            }
        }
        return true;
    }

    private static void fireClanPointsAddedEvent(Player createdBy, Clan playerClan, ClanPlayer clanPlayer, int previousClanPlayerPointBalance, int newClanPlayerPointBalance, int depositPointValue, int previousClanPointBalance, int newClanPointBalance){
        ClanPointsAddedEvent clanPointsAddedEvent = new ClanPointsAddedEvent(createdBy, playerClan, clanPlayer, previousClanPlayerPointBalance, newClanPlayerPointBalance, depositPointValue, previousClanPointBalance, newClanPointBalance);
        Bukkit.getPluginManager().callEvent(clanPointsAddedEvent);
    }

    private static void fireClanPointsRemovedEvent(Player createdBy, Clan playerClan, ClanPlayer clanPlayer, int previousClanPlayerPointBalance, int newClanPlayerPointBalance, int withdrawPointValue, int previousClanPointBalance, int newClanPointBalance){
        ClanPointsRemovedEvent clanPointsRemovedEvent = new ClanPointsRemovedEvent(createdBy, playerClan, clanPlayer, previousClanPlayerPointBalance, newClanPlayerPointBalance, withdrawPointValue, previousClanPointBalance, newClanPointBalance);
        Bukkit.getPluginManager().callEvent(clanPointsRemovedEvent);
    }

}
