package me.aviloo.myrtp.Utils;

import io.papermc.lib.PaperLib;
import me.aviloo.myrtp.MyRTP;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TeleportUtils {

    private static FileConfiguration messagesConfig =
            MyRTP.getPlugin().messagesFileManager.getMessagesConfig();

    public static int taskId;

    public TeleportUtils(Player player, int minX,
                         int maxX, int minZ, int maxZ, World world){
        defaultTeleport(player, minX, maxX, minZ, maxZ, world);
    }

    private int randomBetween(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private Location getTeleportLocation(int minX,
                                            int maxX, int minZ, int maxZ, World world) {

        int x = randomBetween(minX, maxX);
        int z = randomBetween(minZ, maxZ);
        int y = world.getHighestBlockAt(x, z).getY() + 1;
        Location loc = new Location(world, x, y, z);

        return loc;
    }


    private void defaultTeleport(Player player, int minX,
                                       int maxX, int minZ, int maxZ, World world) {

        taskId = new BukkitRunnable() {
            @Override
            public void run() {
                boolean isSafeToTeleport = false;
                while (!isSafeToTeleport) {
                    Location loc = getTeleportLocation(minX, maxX, minZ, maxZ, world);
                    if (isSafeCondition(loc.clone())) {
                        PaperLib.getChunkAtAsync(loc.clone());
                        PaperLib.teleportAsync(player,loc.clone());
                        player.sendMessage(ColorUtils.translateColorCodes(
                                messagesConfig.getString("Prefix.System") +
                                     messagesConfig.getString("Command.Teleported") +
                                     loc.getX()+", "+
                                     loc.getY()+
                                     ", "+
                                     loc.getZ()
                        ));
                        isSafeToTeleport = true;
                        break;
                    }
                }

                    cancel();

                }

        }.runTaskAsynchronously(MyRTP.getPlugin()).getTaskId();

    }

    private boolean isSafeCondition(Location location){
        if(location.getBlock().isLiquid()){return false;}
        if(location.add(0,-1,0).getBlock().isLiquid()){return false;}
        if(location.getBlock().getType().equals(Material.MAGMA_BLOCK)){return false;}

        return true;
    }

}