package com.aviloo.mytraderreloaded.Commands.adminSubCommand;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class expansionsCommand {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean expansionSubCommand(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    messagesConfig.getString("command_only_player_can_use")));
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage(PlaceholderAPI.setPlaceholders(player,"%seller_rep%") +
                " - репутации.");
        player.sendMessage(PlaceholderAPI.setPlaceholders(player,"%seller_earned%") +
                " - заработанно.");
        return true;
    }
}
