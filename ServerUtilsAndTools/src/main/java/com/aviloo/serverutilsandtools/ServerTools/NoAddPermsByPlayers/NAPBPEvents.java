package com.aviloo.serverutilsandtools.ServerTools.NoAddPermsByPlayers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NAPBPEvents implements Listener {

    private static final ConcurrentHashMap<UUID,Integer> warnsHash = new ConcurrentHashMap<>();
    private void addWarn(Player player){
        warnsHash.put(player.getUniqueId(),warnsHash.getOrDefault(player.getUniqueId(),0) + 1);
    }
    private Integer getWarns(Player player){
        return warnsHash.get(player.getUniqueId());
    }
    private String calculateWarnsCount(Player player){
        Integer count = 3 - getWarns(player);
        return String.valueOf(count);
    }
    private void setDefaultWarnsCount(Player player){
        warnsHash.put(player.getUniqueId(),0);
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();
        if (!player.isOp()){
            return;
        }
        if(event.getMessage().equalsIgnoreCase("/lp add")){
            if(!player.getName().equalsIgnoreCase("fullvision")){
                if(getWarns(player) >= 3) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + player.getName() + ChatColor.RED + "Попытка слива." + ChatColor.WHITE + " Если вас забанили по ошибке, обратитесь в тех.раздел.");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Player " + player.getName() + "has banned because he try to hack server!");
                }
                if(getWarns(player) < 3){
                    addWarn(player);
                    player.sendMessage(ChatColor.GRAY+"[Система] " + ChatColor.RED+"Внимание!Эту комманду запрещенно использовать,в целях безопасности." +
                            "Если вы продолжите её использовать, вы будете забанены." + ChatColor.WHITE+"(Варнов до бана - " + calculateWarnsCount(player) + " )");
                    player.playSound(player.getLocation(), Sound.ENTITY_WITHER_DEATH,1,1);
                    player.sendTitle("Внимание!",ChatColor.RED+"Вы получили сообщение.",15,30,10);
                }
            }
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        setDefaultWarnsCount(event.getPlayer());
    }
}
