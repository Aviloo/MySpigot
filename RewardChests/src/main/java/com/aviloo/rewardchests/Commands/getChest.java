package com.aviloo.rewardchests.Commands;

import com.aviloo.rewardchests.Commands.Inventory.getChestStack;
import com.aviloo.rewardchests.Commands.Inventory.getItemStack;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class getChest implements CommandExecutor {

    private static JavaPlugin plugin;

    public getChest(JavaPlugin plugin){
        this.plugin = plugin;
    }

    private void reloadUpdatesConfig(){
        plugin.reloadConfig();
        plugin.saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.GRAY+"[RewardChests] "+ChatColor.RED+"This command can execute only Players");
            return true;
        }

        Player player = (Player) sender;

        if(!player.isOp()){
            player.sendMessage(ChatColor.GRAY+"Вы не можете использовать эту команду!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("rewardchest")){

            if(args.length < 1){
                return false;
            }

            if(args[0].equalsIgnoreCase("get")){
                player.openInventory(getChestStack.getInventory(player));
                return true;
            }
            if(args[0].equalsIgnoreCase("items")){
                player.openInventory(getItemStack.getInv(player));
                return true;
            }
            if(args[0].equalsIgnoreCase("reload")){
                reloadUpdatesConfig();
                player.sendMessage(ChatColor.GRAY+"[Ларцы] "+ChatColor.WHITE+"Конфигурация была перезагруженна.");
                return true;
            }
            else return false;
        }
        return true;
    }
}
