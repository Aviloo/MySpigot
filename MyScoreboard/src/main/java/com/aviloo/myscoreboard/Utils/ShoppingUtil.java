package com.aviloo.myscoreboard.Utils;

import com.aviloo.myscoreboard.Inventories.ShoppingInventories.FiveHundredInventory;
import com.aviloo.myscoreboard.Inventories.ShoppingInventories.NineHundredInventory;
import com.aviloo.myscoreboard.Inventories.ShoppingInventories.SevenHundredInventory;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;
import java.util.UUID;

public class ShoppingUtil {

    public static void openShoppingInventory(Player player){
        //500
        if(currentTag.get(player.getUniqueId()).equals("ping")){
            player.openInventory(FiveHundredInventory.getInv(player));
            return;
        }
        if(currentTag.get(player.getUniqueId()).equals("coords")){
            player.openInventory(FiveHundredInventory.getInv(player));
            return;
        }
        //700
        if(currentTag.get(player.getUniqueId()).equals("mobs_killed")){
            player.openInventory(SevenHundredInventory.getInv(player));
            return;
        }
        if(currentTag.get(player.getUniqueId()).equals("blocks_break")){
            player.openInventory(SevenHundredInventory.getInv(player));
            return;
        }
        if(currentTag.get(player.getUniqueId()).equals("kills_deaths")){
            player.openInventory(SevenHundredInventory.getInv(player));
            return;
        }
        //900
        if(currentTag.get(player.getUniqueId()).equals("hand_durability")){
            player.openInventory(NineHundredInventory.getInv(player));
            return;
        }
        if(currentTag.get(player.getUniqueId()).equals("totem_count")){
            player.openInventory(NineHundredInventory.getInv(player));
            return;
        }
        if(currentTag.get(player.getUniqueId()).equals("helmet_durability")){
            player.openInventory(NineHundredInventory.getInv(player));
            return;
        }
        if(currentTag.get(player.getUniqueId()).equals("chestplate_durability")){
            player.openInventory(NineHundredInventory.getInv(player));
            return;
        }
        if(currentTag.get(player.getUniqueId()).equals("leggings_durability")){
            player.openInventory(NineHundredInventory.getInv(player));
            return;
        }
        if(currentTag.get(player.getUniqueId()).equals("boots_durability")){
            player.openInventory(NineHundredInventory.getInv(player));
            return;
        }else {
            player.sendMessage(ColorUtils.translateColorCodes("&4[Ошибка] &fПроизошла ошибка! Пожалуйста," +
                    "&fсообщите администрации."));
        }

    }

    private static final LinkedHashMap<UUID,String> currentTag = new LinkedHashMap<>();

    public static void addCurrentTag(Player player, String tag){
        currentTag.put(player.getUniqueId(),tag);
    }

    public static String getCurrentTag(Player player){
        return currentTag.get(player.getUniqueId());
    }

    public static void deleteCurrentTag(Player player){
        currentTag.remove(player.getUniqueId());
    }

}
