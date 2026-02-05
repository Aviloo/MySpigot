package me.aviloo.myAdmins.Commands;

import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Models.PluginPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AltCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof ConsoleCommandSender)) {
            if (!Admin.isPlayerAdmin((Player) sender)) {
                sender.sendMessage(ChatColor.RED + "Вы должны быть администратором.");
                return true;
            }
        }
        if(args.length < 1) {return false;}

        String PlayerName = args[0];
        PluginPlayer target;
        try {
            target = PluginPlayer.getPluginPlayerByName(PlayerName);
            if(target == null){
                sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Нет игрока с таким ником.");
                return true;
            }
        }catch (NullPointerException e) {
            sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Нет игрока с таким ником.");
            return true;
        }
        sender.sendMessage(ChatColor.YELLOW+"Аккаунты на ip - "+target.getAddress()+" :");
        for(PluginPlayer ps: PluginPlayer.getSameAddressPluginPlayers(target)){
            if(Admin.isPlayerAdmin(ps)){
                if(!(sender instanceof ConsoleCommandSender) && Admin.getAdminByUUID(((
                Player) sender).getUniqueId()).getAdminType().getPriority()
                < Admin.AdminType.SPECIAL.getPriority()) {
                    if (Admin.getAdminByUUID(ps.getUuid()).getAdminType() == Admin.AdminType.TECH
                    || Admin.getAdminByUUID(ps.getUuid()).getAdminType() == Admin.AdminType.SPECIAL) {
                        continue;
                    }
                }
                if(Bukkit.getOfflinePlayer(ps.getUuid()).isOnline()){
                    sender.sendMessage(ChatColor.ITALIC+""+ChatColor.DARK_RED+ps.getName()+
                    ChatColor.RESET+""+ChatColor.GRAY+" - Админ, Онлайн");
                    continue;
                }
                if(!Bukkit.getOfflinePlayer(ps.getUuid()).isOnline()){
                    sender.sendMessage(ChatColor.ITALIC+""+ChatColor.DARK_RED+ps.getName()+
                    ChatColor.RESET+""+ChatColor.GRAY+" - Админ, Оффлайн");
                    continue;
                }
            }
            if(Bukkit.getOfflinePlayer(ps.getUuid()).isOnline()){
                sender.sendMessage(ChatColor.GREEN+ps.getName()+ChatColor.GRAY+" - Онлайн");
            }
            if(!Bukkit.getOfflinePlayer(ps.getUuid()).isOnline()){
                if(!Bukkit.getOfflinePlayer(ps.getUuid()).isBanned()){
                    sender.sendMessage(ChatColor.WHITE+ps.getName()+ChatColor.GRAY+" - Оффлайн");
                }
                if(Bukkit.getOfflinePlayer(ps.getUuid()).isBanned()){
                    sender.sendMessage(ChatColor.RED+ps.getName()+ChatColor.GRAY+" - Бан");
                }
            }

        }

        return true;
    }
}
