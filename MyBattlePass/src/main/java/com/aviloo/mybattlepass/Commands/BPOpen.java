package com.aviloo.mybattlepass.Commands;

import com.aviloo.mybattlepass.Menu.*;
import com.aviloo.mybattlepass.Utils.BPLevel;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BPOpen implements CommandExecutor {
    private JavaPlugin plugin;

    public BPOpen(JavaPlugin plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("you cannot use this command!");
            return true;
        }

        if(command.getName().equalsIgnoreCase("battlepass")){
            Player player = (Player) sender;
            if(FreeBattlePass.getFreeStatus()){
                if(BPLevel.getLevel(player.getUniqueId()) == null){
                    BPLevel.setDefault(player.getUniqueId());
                    player.openInventory(Screen1.inv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 0) {
                    player.openInventory(Screen1.inv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 1) {
                    player.openInventory(Screen2.getInv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 2) {
                    player.openInventory(Screen3.getInv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 3) {
                    player.openInventory(Screen4.inv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 4) {
                    player.openInventory(Screen5.inv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 5) {
                    player.openInventory(Screen6.inv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 6) {
                    player.openInventory(Screen7.inv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 7) {
                    if (!player.hasPermission("BattlePass.lvl8")) {
                        player.openInventory(Screen7_ForNoDonate.inv(player));
                        player.sendMessage(ChatColor.GRAY + "[Боевой пропуск] " + ChatColor.GOLD + "Вы уже выполнили все задания! " + ChatColor.WHITE + "Ожидайте конца недели. Новая неделя - новый Боевой пропуск!");
                        return true;
                    }
                    if (player.hasPermission("BattlePass.lvl8")) {
                        player.openInventory(Screen8.inv(player));
                        return true;
                    }
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 8) {
                    player.openInventory(Screen9.inv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 9) {
                    player.openInventory(Screen10.inv(player));
                    return true;
                }
                if (BPLevel.getLevel(player.getUniqueId()) == 10) {
                    player.openInventory(Screen11.inv(player));
                    player.sendMessage(ChatColor.GRAY + "[Боевой пропуск] " + ChatColor.GOLD + "Вы уже выполнили все задания! " + ChatColor.WHITE + "Ожидайте конца недели. Новая неделя - новый Боевой пропуск!");
                    return true;
                }
            }



            if(!FreeBattlePass.getFreeStatus()) {
                if (player.isOp() || player.hasPermission("BattlePass.open")) {
                    if(BPLevel.getLevel(player.getUniqueId()) == null){
                        BPLevel.setDefault(player.getUniqueId());
                        player.openInventory(Screen1.inv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 0) {
                        player.openInventory(Screen1.inv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 1) {
                        player.openInventory(Screen2.getInv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 2) {
                        player.openInventory(Screen3.getInv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 3) {
                        player.openInventory(Screen4.inv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 4) {
                        player.openInventory(Screen5.inv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 5) {
                        player.openInventory(Screen6.inv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 6) {
                        player.openInventory(Screen7.inv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 7) {
                        if (!player.hasPermission("BattlePass.lvl8")) {
                            player.openInventory(Screen7_ForNoDonate.inv(player));
                            player.sendMessage(ChatColor.GRAY + "[Боевой пропуск] " + ChatColor.GOLD + "Вы уже выполнили все задания! " + ChatColor.WHITE + "Ожидайте конца недели. Новая неделя - новый Боевой пропуск!");
                            return true;
                        }
                        if (player.hasPermission("BattlePass.lvl8")) {
                            player.openInventory(Screen8.inv(player));
                            return true;
                        }
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 8) {
                        player.openInventory(Screen9.inv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 9) {
                        player.openInventory(Screen10.inv(player));
                        return true;
                    }
                    if (BPLevel.getLevel(player.getUniqueId()) == 10) {
                        player.openInventory(Screen11.inv(player));
                        player.sendMessage(ChatColor.GRAY + "[Боевой пропуск] " + ChatColor.GOLD + "Вы уже выполнили все задания! " + ChatColor.WHITE + "Ожидайте конца недели. Новая неделя - новый Боевой пропуск!");
                        return true;
                    }
                }else {
                    player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"У вас нет доступа к боевому пропуску. " +
                            ":("+ChatColor.GRAY+" (P.S:Он доступен игрокам с привилегией Chorus. Приобрести её можно " +
                            "здесь - "+plugin.getConfig().getString("ShopLink")+" )");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK,5,1);
                    return true;
                }
            }
        }
        return true;
    }
}
