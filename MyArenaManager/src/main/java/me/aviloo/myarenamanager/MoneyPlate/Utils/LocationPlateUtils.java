package me.aviloo.myarenamanager.MoneyPlate.Utils;

import me.aviloo.myarenamanager.MyArenaManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LocationPlateUtils {

    static FileConfiguration locationFile = MyArenaManager.getPlugin().locationFileManager.getLocationConfig();

    private static String locWorld = locationFile.getString("PlateWorld");
    private static int locX = locationFile.getInt("PlateX");
    private static int locY = locationFile.getInt("PlateY");
    private static int locZ = locationFile.getInt("PlateZ");

    private static final Location location = new Location(
            loadWorld(locWorld),locX,locY,locZ);

    public static World getWorld(){
        return location.getWorld();
    }

    public static double getX(){
        return location.getX();
    }

    public static double getY(){
        return location.getY();
    }

    public static double getZ(){
        return location.getZ();
    }

    protected static Location getLocation(){
        return location;
    }

    public static boolean isPlayerOnLocation(Player player){
        if(player.getLocation().distance(location) < 100){
            return true;
        }
        return false;
    }

    protected static void addOneMoreToY(){
        location.add(0,0.73,0);
    }

    private static final World loadWorld(final String WorldName){
        if(Bukkit.getServer().getWorld(WorldName) == null){
            return  WorldCreator.name(WorldName).environment(World.Environment.NORMAL).createWorld();
        }
        else return Bukkit.getServer().getWorld(WorldName);
    }

}
