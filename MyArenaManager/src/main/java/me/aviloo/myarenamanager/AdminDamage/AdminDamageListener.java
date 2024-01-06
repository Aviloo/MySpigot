package me.aviloo.myarenamanager.AdminDamage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class AdminDamageListener implements Listener {

    private static HashMap<UUID,Integer> damageBuff = new HashMap<>();

    public static void setDamageBuff(Player player,Integer value){
        damageBuff.put(player.getUniqueId(),value);
    }

    public static Integer getDamageBuff(Player player){
        return damageBuff.get(player.getUniqueId());
    }



    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event){
        if(!(event.getDamager() instanceof Player)){return;}
        Player player = (Player) event.getDamager();
        if(!player.hasPermission("ArenaManager.damage")){return;}

        event.setDamage(event.getDamage() + getDamageBuff(player));
    }

    @EventHandler(priority = EventPriority.HIGH,ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        if(!event.getPlayer().hasPermission("ArenaManager.damage")){return;}
        setDamageBuff(event.getPlayer(), 0);
    }

}
