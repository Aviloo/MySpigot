package me.aviloo.myAdmins.Commands.SubCommands;

import me.aviloo.myAdmins.Models.PluginPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class createPluginPlayer{

    public boolean execute(@NotNull CommandSender sender, @NotNull String[] args) {
        if(!sender.isOp()){
            sender.sendMessage(ChatColor.RED+"Вы должны быть администратором.");
            return true;
        }
        if(args.length < 2){return false;}
        String PlayerName = args[1];
        Player target = Bukkit.getServer().getPlayer(PlayerName);
        if (target == null) {
            sender.sendMessage("Игрок не найден");
            return true;
        }

        if(PluginPlayer.playerIsPluginPlayer(target.getUniqueId())){
            sender.sendMessage("Игрок уже есть в списке игроков плагина!");
            return true;
        }

        new PluginPlayer(target.getUniqueId(),
        target.getName(),target.getAddress().getHostString());
        return true;
    }
}
