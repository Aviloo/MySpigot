package me.aviloo.updateinformation.Commands;

import me.aviloo.updateinformation.Utils.HoverText;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Information implements CommandExecutor {

    private final Map<UUID,Long> cooldownsFirst = new HashMap<>();
    private static final long cooldown_timeFirst = 10000;

    private boolean isCoolDownExpireFirst(Player player,Long cooldown){
        final Long StartTime = cooldownsFirst.get(player.getUniqueId());
        if(StartTime == null){
            return true;
        }
        final long elapsedtime = System.currentTimeMillis() - StartTime;
        return elapsedtime >= cooldown;
    }

    private void setCooldownFirst(Player player){
        cooldownsFirst.merge(player.getUniqueId(),System.currentTimeMillis(),
                (oldValue,newValue) -> newValue);
    }

    private static JavaPlugin plugin;

    public Information(JavaPlugin plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("This command can execute ONLY players");
            return true;
        }
        if(command.getName().equalsIgnoreCase("update")){
            Player player = (Player) sender;
            if(!isCoolDownExpireFirst(player,cooldown_timeFirst)){
                player.sendMessage(String.format("Эту команду можно повторно использовать через %d секунд", cooldown_timeFirst/1000));
            }
            if(isCoolDownExpireFirst(player,cooldown_timeFirst)) {
                if (plugin.getConfig().getString("show_shorts").equalsIgnoreCase("false")) {
                    player.sendMessage(ChatColor.GRAY + "-------------------------------");
                    player.spigot().sendMessage(HoverText.UpdateLink(player));
                    player.sendMessage(ChatColor.GRAY + "-------------------------------");
                    setCooldownFirst(player);
                    return true;
                }
                if (plugin.getConfig().getString("show_shorts").equalsIgnoreCase("true")) {
                        player.sendMessage(ChatColor.GRAY + "-------------------------------");
                        HoverText.forStrings(player);
                        player.spigot().sendMessage(HoverText.UpdateLink(player));
                        player.sendMessage(ChatColor.GRAY + "-------------------------------");
                        setCooldownFirst(player);
                        return true;
                }
            }

            return true;
        }
        return true;
    }
}
