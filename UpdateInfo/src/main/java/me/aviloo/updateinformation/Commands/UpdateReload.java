package me.aviloo.updateinformation.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class UpdateReload implements CommandExecutor {

    private static JavaPlugin plugin;

    public UpdateReload(JavaPlugin plugin){
        this.plugin = plugin;
    }

    private void reloadUpdatesConfig(){
        plugin.reloadConfig();
        plugin.saveConfig();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("This command can execute ONLY players");
            return true;
        }
        if(command.getName().equalsIgnoreCase("updates")){
            Player player = (Player) sender;
            if(player.isOp()){
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("reload")){
                        reloadUpdatesConfig();
                        player.sendMessage("Configuration has reloaded");
                        return true;
                    }
                }
                if(args.length == 0){
                    return false;
                }
            }
            if(!player.isOp()){
                player.sendMessage(ChatColor.GRAY + plugin.getConfig().getString("message_dont_have_perm"));
                return true;
            }
        }
        return true;
    }
}
