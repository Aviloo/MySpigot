package com.aviloo.mytraderreloaded.Commands;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.SellerInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerCommand implements CommandExecutor {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    messagesConfig.getString("command_only_player_can_use")));
            return true;
        }

        if(command.getName().equalsIgnoreCase("seller")) {
            Player player = (Player) sender;
            if (!player.hasPermission("mytrader.seller")) {
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                        messagesConfig.getString("command_dont_have_perm")));
                return true;
            }
            player.openInventory(SellerInventory.inventory);
            return true;
        }
        return true;
    }
}
