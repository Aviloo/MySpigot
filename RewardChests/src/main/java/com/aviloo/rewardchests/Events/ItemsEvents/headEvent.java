package com.aviloo.rewardchests.Events.ItemsEvents;

import com.aviloo.rewardchests.ItemStack.Rewards.Special.headOfTroichkiy;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.potion.PotionEffectType.*;

public class headEvent implements Listener {

    private static JavaPlugin plugin;

    public headEvent(JavaPlugin plugin){
        this.plugin = plugin;
    }

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
    public void onUse(EntityDamageByEntityEvent event){
        if(event.getDamager().getType() == EntityType.PLAYER && event.getEntity().getType() == EntityType.PLAYER){
            Player player = (Player) event.getEntity();
            Player damager = (Player) event.getDamager();

            if(player.getInventory().getItemInOffHand().equals(headOfTroichkiy.head())){
                if(player.getHealth() == 0.0 || player.getHealth() == 1.0){
                    player.setHealth(12.0);
                    player.addPotionEffect(new PotionEffect(SPEED, 2500000, 10));
                    player.addPotionEffect(new PotionEffect(DOLPHINS_GRACE, 2500000, 10));
                    player.addPotionEffect(new PotionEffect(DARKNESS, 2500000, 10));
                    for(Player ps : getPlayersWithin(player, 25)){
                        ps.playSound(player.getLocation(), Sound.ENTITY_WITHER_DEATH,10,1);
                    }
                    Bukkit.getScheduler().runTaskLater(plugin, () ->
                    {
                        player.removePotionEffect(DARKNESS);
                    }, 60);
                }
            }
        }

    }
}
