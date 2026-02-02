package me.aviloo.myAdmins.Commands;

import me.aviloo.myAdmins.Menu.PunishmentMenu;
import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Models.PluginPlayer;
import me.aviloo.myAdmins.Models.Punishment;
import me.aviloo.myAdmins.Utils.StorageUtils.PunishmentStorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class getPunishments implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Вы должны быть игроком!");
            return true;
        }
        if(!Admin.isPlayerAdmin((Player) sender)){
            sender.sendMessage(ChatColor.RED+"Вы должны быть администратором.");
            return true;
        }
        if(args.length <1){return false;}
        String PlayerName = args[0];
        Player target = Bukkit.getServer().getPlayer(PlayerName);
        if (target == null) {
            sender.sendMessage("Игрок не найден");
            return true;
        }
        Player player = (Player) sender;
        if(!PluginPlayer.playerIsPluginPlayer(target.getUniqueId())){
            player.sendMessage("Ошибка. Игрок не является PluginPlayer");
            return true;
        }

        if(!PunishmentStorageUtil.hasPunishment(target.getUniqueId())){
            player.sendMessage(ChatColor.YELLOW+"Список наказаний этого игрока пуст!");
            return true;
        }
        PunishmentMenu.openMenu(player,target);

        return true;
    }
}
