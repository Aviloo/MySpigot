package com.aviloo.serverutilsandtools.AdminTools.Suspect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Suspect implements Listener {

    //Variables
    private final static ConcurrentHashMap<UUID,Boolean> isPlayerSuspect = new ConcurrentHashMap<>();

    public static void setTrue(UUID uuid){
        isPlayerSuspect.put(uuid,true);
    }

    public static void setFalse(UUID uuid){
        isPlayerSuspect.put(uuid,false);
    }

    public static Boolean getValue(UUID uuid){
        return isPlayerSuspect.get(uuid);
    }
    //Events

    @EventHandler (ignoreCancelled = true,priority = EventPriority.HIGH) //Важная хуйня . Расставляет приоритет ивента , главное не запутаться и не выставить на один ивент несколько высших приоритетов. Ведь тогда нам пизда.
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(getValue(player.getUniqueId())){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+player.getName()+" 20d Отказ от проверки.");
        }
    }


    //Метод  проверки игроков рядом С добавлением игрока вызвавшого метод в список
    public List<Player> getPlayersWithin(Player player, int distance) {
        List<Player> res = new ArrayList<Player>();
        int d2 = distance * distance;
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            if (p.getWorld() == player.getWorld() && p.getLocation().distanceSquared(player.getLocation()) <= d2) {
                res.add(p);
            }
        }
        return res;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if(getValue(player.getUniqueId())){
            event.setCancelled(true);
            for(Player ps: getPlayersWithin(player,1000)){
                if(ps.isOp()){
                    ps.sendMessage(ChatColor.GRAY+player.getName()+" -> "+ChatColor.AQUA +event.getMessage());
                    player.sendMessage(ChatColor.GRAY+player.getName()+" -> "+ChatColor.AQUA +event.getMessage());
                }
            }
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();
        if(getValue(player.getUniqueId())){
            event.setCancelled(true);
            player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.YELLOW+"Вы не можете это сделать сейчас!");
        }
    }

    /*
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player) {
            if(getValue(event.getEntity().getUniqueId())){
                double damage = event.getDamage();
                ((Player) event.getEntity()).setHealth(((Player) event.getEntity()).getHealth() + damage);
            }
        }
    }
     */

}
