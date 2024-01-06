package me.aviloo.myarenamanager.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class MessagesUtils {

    public static void sendPlateMessage(){
        for(Player ps : OnlineUtils.online_player){
            ps.sendMessage(" ");
            ps.sendMessage(ColorUtils.translateColorCodes(
                    "&6Царь-Горы >>> &fНачался ивент «Царь-Горы»." +
                            "&f Чтобы принять участие, идете на PVP арену. " +
                            "&7(/pvparena)"));
            ps.sendMessage(" ");
            ps.playSound(ps.getLocation(), Sound.ENTITY_VILLAGER_YES,3,7);
        }

    }

    public static void sendChestActivateMessage(){
        for(Player ps : OnlineUtils.online_player){
            ps.sendMessage(" ");
            ps.sendMessage(ColorUtils.translateColorCodes(
                    "&6Сундук арены >>> &fСундук арены &aактивирован&f! " +
                    "&fНайти его можно на PVP арене." +
                    "&7(/pvparena)"));
            ps.sendMessage(" ");
            ps.playSound(ps.getLocation(),Sound.ITEM_GOAT_HORN_SOUND_0,3,-1);
        }

    }

}
