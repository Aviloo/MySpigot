package com.aviloo.serverutilsandtools.SmallServerFunc.RewardSwords;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class SwordEvent implements Listener {

    @EventHandler
    public void onBite(EntityDamageByEntityEvent event){
        if(!(event.getDamager() instanceof Player)){return;}
        Player player = (Player) event.getDamager();
        if(!player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE+"Клинок любви " + ChatColor.WHITE+ "♥")){
            return;
        }
        Location entityLocation = event.getEntity().getLocation();
        player.spawnParticle(Particle.HEART, entityLocation.add(0,1,0),1);
        player.spawnParticle(Particle.HEART, entityLocation.add(1,1,0),1);
        player.spawnParticle(Particle.HEART, entityLocation.add(0,1,1),1);
        player.spawnParticle(Particle.HEART, entityLocation.add(1,1,1),1);
        player.spawnParticle(Particle.HEART, entityLocation.add(1,0,1),1);
    }
}
