package me.aviloo.myarenamanager.PvpChest.Utils;

public class StatusChestUtils {

    public static boolean ActivatingStatus = false;
    public static boolean OpenStatus = false;

    public static boolean CanBeActivatedStatus = false;

    public static void statusManager(){

    }

    public static void setChestOpen(){
        OpenStatus = true;
        ActivatingStatus = false;
        CanBeActivatedStatus = false;
    }

    public static void setActivatingStatus(){
        ActivatingStatus = true;
        OpenStatus = false;
        CanBeActivatedStatus = false;
    }

    public static void setCanBeActivatedStatus(){
        CanBeActivatedStatus = true;
        OpenStatus = false;
        ActivatingStatus = false;
    }

    public static void setInactiveStatus(){
        CanBeActivatedStatus = false;
        OpenStatus = false;
        ActivatingStatus = false;
    }

    public static void setBrokenStatus(){
        CanBeActivatedStatus = true;
        OpenStatus = true;
        ActivatingStatus = true;
    }


    public static boolean chestIsNotDisable(){
        if(!ActivatingStatus && !OpenStatus && !CanBeActivatedStatus){return false;}

        return true;
    }

}
