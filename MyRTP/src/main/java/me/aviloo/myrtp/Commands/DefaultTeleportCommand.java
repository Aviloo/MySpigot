package me.aviloo.myrtp.Commands;

import me.aviloo.myrtp.MyRTP;
import me.aviloo.myrtp.Utils.ColorUtils;
import me.aviloo.myrtp.Utils.TeleportUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DefaultTeleportCommand implements CommandExecutor {

    private final Map<UUID,Long> cooldowns = new HashMap<>();
    private static final long cooldown_time =
            MyRTP.getPlugin().getConfig().getLong("cooldown");

    private boolean isCoolDownExpire(Player player, Long cooldown){
        final Long StartTime = cooldowns.get(player.getUniqueId());
        if(StartTime == null){
            return true;
        }
        final long elapsedtime = System.currentTimeMillis() - StartTime;
        return elapsedtime >= cooldown;
    }

    private void setCooldown(Player player){
        cooldowns.merge(player.getUniqueId(),System.currentTimeMillis(),
                (oldValue,newValue) -> newValue);
    }


    private static FileConfiguration messagesConfig =
            MyRTP.getPlugin().messagesFileManager.getMessagesConfig();

    private int range = MyRTP.getPlugin().getConfig().getInt("range");
    private World world = Bukkit.getWorld(MyRTP.getPlugin().getConfig().getString("world"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColorCodes(
                    messagesConfig.getString("Prefix.Plugin") +
                    messagesConfig.getString("Command.NotPlayer")));
           return true;
        }

        Player player = (Player) sender;
        if (!isCoolDownExpire(player, cooldown_time)) {
            player.sendMessage(ColorUtils.translateColorCodes(
                    messagesConfig.getString("Prefix.System") +
                            messagesConfig.getString("Command.Cooldown")
            ).replaceAll("%cooldown%",
                    String.valueOf(cooldown_time/1000)));
            return true;
        }

        new TeleportUtils(player, -range, range,
                -range, range, world);
        setCooldown(player);

        return true;
    }
}
