package me.aviloo.myarenamanager.PvpChest.Utils;

import me.aviloo.myarenamanager.MyArenaManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;

public class LocationChestUtils {

    static FileConfiguration locationFile = MyArenaManager.getPlugin().locationFileManager.getLocationConfig();

    private static String locWorld = locationFile.getString("ChestWorld");
    private static int locX = locationFile.getInt("ChestX");
    private static int locY = locationFile.getInt("ChestY");
    private static int locZ = locationFile.getInt("ChestZ");

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

    public static Location getLocation(){
        return location;
    }

    protected static void addOneMoreToY(){
        location.add(0,0.73,0);
    }

    public static boolean isThatPvpChest(Location clickedLocation){
        if((clickedLocation.getX() == locX)
                && (clickedLocation.getY() == locY)
                && (clickedLocation.getZ() == locZ)
                && (clickedLocation.getWorld() == Bukkit.getWorld(locWorld))){
            return true;
        }
        return false;
    }

    public static final World loadWorld(final String WorldName){
        if(Bukkit.getServer().getWorld(WorldName) == null){
            return  WorldCreator.name(WorldName).environment(World.Environment.NORMAL).createWorld();
        }
        else return Bukkit.getServer().getWorld(WorldName);
    }


}
