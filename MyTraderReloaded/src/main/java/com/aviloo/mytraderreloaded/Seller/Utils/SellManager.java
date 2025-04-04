package com.aviloo.mytraderreloaded.Seller.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;

public class SellManager implements Listener {

    private static final LinkedHashMap<UUID,String> sellPatternMap = new LinkedHashMap<>();

    public static void setSellPattern(Player player,String pattern){
        sellPatternMap.put(player.getUniqueId(),pattern);
    }

    public static String getSellPattern(Player player){
        return sellPatternMap.get(player.getUniqueId());
    }

    public static String getPatternLore(@Nullable Player player){
        if(player == null) return ChatColor.WHITE+"Тип: "+ChatColor.GRAY+"Продать 1 шт.";
        if(sellPatternMap.get(player.getUniqueId()).equals("1")){
            return ChatColor.WHITE+"Тип: "+ChatColor.GRAY+"Продать 1 шт.";
        }
        if(sellPatternMap.get(player.getUniqueId()).equals("64")){
            return ChatColor.WHITE+"Тип: "+ChatColor.GRAY+"Продать 64 шт.";
        }
        if(sellPatternMap.get(player.getUniqueId()).equals("all")){
            return ChatColor.WHITE+"Тип: "+ChatColor.GRAY+"Продать всё.";
        }

        return "Тип: -";
    }


    @EventHandler(ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        setSellPattern(event.getPlayer(),"1");
    }


    public static void sellItems(Player player,Material material,int amount){
        if(amount == 64){
            EconomyManager.giveMoney(player,PriceManager.getCurrentPriceFor64(String.valueOf(material)));
            player.sendMessage(ChatColor.WHITE+"За продажу вы получили "
                    + (PriceManager.getCurrentPrice(String.valueOf(material)) * 64) + " монет.");
        }
        if(amount == 1){
            EconomyManager.giveMoney(player,PriceManager.getCurrentPrice(String.valueOf(material)));
            player.sendMessage(ChatColor.WHITE+"За продажу вы получили "
                    + (PriceManager.getCurrentPrice(String.valueOf(material))) + " монет.");
        }
        if(amount > 64 || (amount < 64 && amount > 1)){
            for(ItemStack items : player.getInventory().getContents()){
                if(items == null) continue;

                if(items.getType().equals(material)){
                    player.getInventory().removeItem(items);
                }
            }
            EconomyManager.giveMoney(player,PriceManager.getCurrentPrice(String.valueOf(material)) * amount);
            player.sendMessage(ChatColor.WHITE+"За продажу вы получили "
                    + (PriceManager.getCurrentPrice(String.valueOf(material)) * amount) + " монет.");
        }

    }


}
