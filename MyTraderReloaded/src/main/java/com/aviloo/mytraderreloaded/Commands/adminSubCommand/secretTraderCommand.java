package com.aviloo.mytraderreloaded.Commands.adminSubCommand;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.SellerInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class secretTraderCommand {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean secretTraderSubCommand(CommandSender sender,String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    messagesConfig.getString("command_only_console_can_use")));
            return true;
        }

        String PlayerName = args[1];
        Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
        if (argPlayer == null) {
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error")+
                    messagesConfig.getString("command_player_not_found")));
            return true;
        }

        argPlayer.openInventory(SellerInventory.inventory);
        return true;
    }
}
