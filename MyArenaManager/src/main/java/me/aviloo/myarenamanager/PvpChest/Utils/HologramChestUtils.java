package me.aviloo.myarenamanager.PvpChest.Utils;

import me.aviloo.myarenamanager.PvpChest.ChestListener;
import me.aviloo.myarenamanager.Utils.ColorUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class HologramChestUtils {

    private static ArmorStand name;
    private static ArmorStand description;
    private static ArmorStand DescriptionSecond;
    private static ArmorStand status;

    public static void spawnChestHologram(){
        //name
        Location NameLocation = LocationChestUtils.getLocation().subtract(0,0.001,0);
        name = NameLocation.getWorld().spawn(NameLocation, ArmorStand.class);
        setUpHologram(name);
        name.setCustomName(ColorUtils.translateColorCodes("&6Сундук арены"));
        //description
        Location DiscriptionLocation = LocationChestUtils.getLocation().subtract(0,0.165,0);
        description = DiscriptionLocation.getWorld().spawn(DiscriptionLocation, ArmorStand.class);
        setUpHologram(description);
        description.setCustomName(ColorUtils.translateColorCodes("&fНажмите на сундук, "));
        //description second
        Location DiscriptionSecondLocation = LocationChestUtils.getLocation().subtract(0,0.26,0);
        DescriptionSecond = DiscriptionSecondLocation.getWorld().spawn(DiscriptionSecondLocation, ArmorStand.class);
        setUpHologram(DescriptionSecond);
        DescriptionSecond.setCustomName(ColorUtils.translateColorCodes("&fчтобы залутать его первым."));
        //status
        Location StatusLocation = LocationChestUtils.getLocation().subtract(0,0.3,0);
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
        if(!StatusChestUtils.CanBeActivatedStatus
                && !StatusChestUtils.ActivatingStatus
                && !StatusChestUtils.OpenStatus){
            return ColorUtils.translateColorCodes("&fСтатус: &8Не активна");
        }
        if(StatusChestUtils.CanBeActivatedStatus
                && !StatusChestUtils.ActivatingStatus
                && !StatusChestUtils.OpenStatus){
            return ColorUtils.translateColorCodes("&fСтатус: &bМожно активировать");
        }
        if(StatusChestUtils.ActivatingStatus
                && !StatusChestUtils.OpenStatus
                && !StatusChestUtils.CanBeActivatedStatus){
            return ColorUtils.translateColorCodes("&fСтатус: &2Активируется");
        }
        if(StatusChestUtils.OpenStatus
                && !StatusChestUtils.ActivatingStatus
                && !StatusChestUtils.CanBeActivatedStatus){
            return ColorUtils.translateColorCodes("&fСтатус: &aСундук открыт");
        }

        return ColorUtils.translateColorCodes("&cСтатус: &4Сундук сломан");
    }

    public static void updateChestHologram(){
        name.remove();
        description.remove();
        DescriptionSecond.remove();
        status.remove();

        LocationChestUtils.addOneMoreToY();

        spawnChestHologram();
    }

    public static void removeChestHologram(){
        name.remove();
        description.remove();
        DescriptionSecond.remove();
        status.remove();
    }

}
