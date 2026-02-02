package me.aviloo.myAdmins.Commands;

import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.MyAdmins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private static HashMap<UUID,Boolean> vanished = new HashMap<>();

    public static boolean getVanished(UUID uuid){
        return vanished.get(uuid);
    }

    public static boolean containsVanished(UUID uuid){
        return vanished.containsKey(uuid);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You must be a player to use this command.");
            return true;
        }
        if(!Admin.isPlayerAdmin((Player) sender)){
            sender.sendMessage(ChatColor.RED+"Вы должны быть администратором.");
            return true;
        }
        Player player = (Player) sender;
        if(!vanished.containsKey(player.getUniqueId())
        || !vanished.get(player.getUniqueId())){
            vanished.put(player.getUniqueId(),true);
            for(Player ps : Bukkit.getOnlinePlayers()){
                if(!ps.equals(player)) {
                    ps.hidePlayer(MyAdmins.getPlugin(), player);
                }
            }
            player.sendMessage(ChatColor.GRAY+"[Система] "
            +ChatColor.GREEN+"Вы вошли в режим ваниш.");
            return true;
        }
        if(vanished.get(player.getUniqueId())){
            vanished.put(player.getUniqueId(),false);
            for(Player ps : Bukkit.getOnlinePlayers()){
                if(!ps.equals(player)) {
                    ps.showPlayer(MyAdmins.getPlugin(), player);
                }
            }
            player.sendMessage(ChatColor.GRAY+"[Система] "
                    +ChatColor.GREEN+"Вы вышли из режима ваниш.");
        }
        return true;
    }
}
