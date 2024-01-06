package me.aviloo.myarenamanager.MoneyPlate.Utils;

import me.aviloo.myarenamanager.Utils.ColorUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class HologramPlateUtil {

    private static ArmorStand name;
    private static ArmorStand description;
    private static ArmorStand DescriptionSecond;
    private static ArmorStand status;

    public static void spawnHologramPlate(){
        //name
        Location NameLocation = LocationPlateUtils.getLocation().subtract(0,0.001,0);
        name = NameLocation.getWorld().spawn(NameLocation, ArmorStand.class);
        setUpHologram(name);
        name.setCustomName(ColorUtils.translateColorCodes("&6Царь горы"));
        //description
        Location DiscriptionLocation = LocationPlateUtils.getLocation().subtract(0,0.165,0);
        description = DiscriptionLocation.getWorld().spawn(DiscriptionLocation, ArmorStand.class);
        setUpHologram(description);
        description.setCustomName(ColorUtils.translateColorCodes("&fВстаньте на нажимную плиту, "));
        //description second
        Location DiscriptionSecondLocation = LocationPlateUtils.getLocation().subtract(0,0.26,0);
        DescriptionSecond = DiscriptionSecondLocation.getWorld().spawn(DiscriptionSecondLocation, ArmorStand.class);
        setUpHologram(DescriptionSecond);
        DescriptionSecond.setCustomName(ColorUtils.translateColorCodes("&fчтобы получать монеты."));
        //status
        Location StatusLocation = LocationPlateUtils.getLocation().subtract(0,0.3,0);
        status = StatusLocation.getWorld().spawn(StatusLocation, ArmorStand.class);
        setUpHologram(status);
        status.setCustomName(getStatusString());
    }

    private static void setUpHologram(ArmorStand hologram){
        hologram.setVisible(false);
        hologram.setGravity(false);
        hologram.setInvisible(true);
        hologram.setCustomNameVisible(true);
    }

    private static String getStatusString(){
        if(!PlateStatus){
            return ColorUtils.translateColorCodes("&fСтатус: &8Не активна");
        }
        return ColorUtils.translateColorCodes("&fСтатус: &aАктивна");

    }

    private static boolean PlateStatus = false;

    public static boolean getPlateStatus(){
        return PlateStatus;
    }

    public static void setPlateStatus(boolean status){
        PlateStatus = status;
    }

    public static void updateHologramPlate(){
        name.remove();
        description.remove();
        DescriptionSecond.remove();
        status.remove();

        LocationPlateUtils.addOneMoreToY();

        spawnHologramPlate();
    }

    public static void removeHologramPlate(){
        name.remove();
        description.remove();
        DescriptionSecond.remove();
        status.remove();
    }

}
