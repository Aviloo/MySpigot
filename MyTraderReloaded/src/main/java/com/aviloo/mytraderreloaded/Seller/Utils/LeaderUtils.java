package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.Seller.Inventories.SellerInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class LeaderUtils implements Listener {
    //Event
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(playersEarned.containsKey(event.getPlayer().getUniqueId())) {return;}
        playersEarned.put(event.getPlayer().getUniqueId(),0.0);
    }

    private static LinkedHashMap<UUID,Double> playersEarned = new LinkedHashMap<>();

    public static void addPlayerEarned(UUID uuid, double amount) {
        playersEarned.put(uuid, playersEarned.getOrDefault(uuid,0.0) + amount);
    }

    // Переменные для хранения ключа с наибольшим значением
    private static UUID maxKey = null;
    private static double maxEarned = Double.MIN_VALUE;

    public static void updateLeader(){
        for(Map.Entry<UUID,Double> entry : playersEarned.entrySet()){
            if(entry.getValue() > maxEarned){
                maxEarned = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        SellerInventory.inventory.setItem(45,traderItem());
    }

    //ItemStack
    public static ItemStack traderItem(){
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN+"Лучший торговец сегодня");
        ArrayList<String> lore = new ArrayList<>();
        if(maxKey != null) {
            meta.setOwningPlayer(Bukkit.getOfflinePlayer(maxKey));
            lore.add(" ");
            lore.add(ChatColor.WHITE+"Ник: " +ChatColor.GRAY+
                    Bukkit.getOfflinePlayer(maxKey).getName());
            lore.add(ChatColor.WHITE+"Заработал: "+ChatColor.GRAY+
                    Math.ceil(playersEarned.get(maxKey)));
            lore.add(" ");
        }if(maxKey == null) {
            lore.add(" ");
            lore.add(ChatColor.WHITE+"Ник: "+ChatColor.GRAY+"-");
            lore.add(ChatColor.WHITE+"Заработал: "+ChatColor.GRAY+"-");
            lore.add(" ");
        }
        lore.add(ChatColor.DARK_GRAY+"Статистика обновляется ");
        lore.add(ChatColor.DARK_GRAY+"раз в 5 минут");
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

}
