package com.aviloo.mytraderreloaded.Commands.adminSubCommand;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

public class setSellerLocation {


    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean expansionSubCommand(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                    messagesConfig.getString("command_only_player_can_use")));
            return true;
        }

        Player player = (Player) sender;
        return true;
    }

    public Location getEntityPlayerIsLookingAt(Player player, double maxDistance) {
        Location eyeLocation = player.getEyeLocation(); // текущая позиция глаз
        Vector direction = eyeLocation.getDirection(); // направление взгляда

        RayTraceResult result = player.getWorld().rayTrace(
                eyeLocation, direction, maxDistance, FluidCollisionMode.NEVER,
                true, 20.0, null);

        if (result != null && result.getHitEntity() != null) {
            return result.getHitEntity().getLocation();
        }
        return null;
    }
}
