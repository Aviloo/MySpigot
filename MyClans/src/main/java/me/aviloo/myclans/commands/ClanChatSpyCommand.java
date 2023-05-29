package me.aviloo.myclans.commands;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.utils.ColorUtils;
import me.aviloo.myclans.utils.UsermapStorageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ClanChatSpyCommand implements CommandExecutor {

    FileConfiguration clansConfig = MyClans.getPlugin().getConfig();
    FileConfiguration messagesConfig = MyClans.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (clansConfig.getBoolean("clan-chat.chat-spy.enabled")){
                if (player.hasPermission("clanslite.chat.spy")||player.hasPermission("clanslite.*")
                        ||player.hasPermission("clanslite.admin")||player.isOp()){
                    if (UsermapStorageUtil.toggleChatSpy(player)){
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("chatspy-toggle-on")));
                    }else {
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("chatspy-toggle-off")));
                    }
                }else {
                    player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("no-permission")));
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("function-disabled")));
            }
            return true;
        }
        return true;
    }
}
