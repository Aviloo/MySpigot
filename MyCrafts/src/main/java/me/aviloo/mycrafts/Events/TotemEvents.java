package me.aviloo.mycrafts.Events;

import me.aviloo.mycrafts.MyCrafts;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class TotemEvents implements Listener {

    private static MyCrafts plugin;
    public TotemEvents(MyCrafts plugin){
        this.plugin = plugin;
    }

    private List<Player> getPlayerAround(Player player,int radius){
        List<Entity> entitylist = player.getNearbyEntities(radius, radius, radius);
        List<Player> playersAround =new ArrayList<>();
        for(int t=0;t<entitylist.size();t++){
            if(entitylist.get(t).getType()== EntityType.PLAYER){
                playersAround.add((Player) entitylist.get(t));

            }
        }
        return playersAround;
    }

    @EventHandler
    public void onTotem(EntityResurrectEvent event){
        if(!(event.getEntity() instanceof Player)){
            return;
        }
        Player player = (Player) event.getEntity();

        if(player.getInventory().getItemInOffHand() == null){return;}
        if(!player.getInventory().getItemInOffHand().getType().equals(Material.TOTEM_OF_UNDYING)){return;}
        if(!player.getInventory().getItemInOffHand().getItemMeta().hasEnchants()){return;}

        if(player.getInventory().getItemInOffHand().getItemMeta()
                .hasEnchant(Enchantment.DIG_SPEED)){
            Bukkit.getScheduler().runTaskLater(plugin,() -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,200,2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,200,2));
                for(Player ps: getPlayerAround(player, 10)){
                    ps.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS,300,15,true));
                    ps.getWorld().
                            spawnParticle(Particle.REDSTONE,
                                    player.getLocation().add(0,0.5,0),
                                    5,
                                    new Particle.DustOptions(Color.GRAY,20f)
                            );
                    ps.getWorld().
                            spawnParticle(Particle.REDSTONE,
                                    player.getLocation().add(0,1,0),
                                    5,
                                    new Particle.DustOptions(Color.GRAY,20f)
                            );
                    ps.getWorld().
                            spawnParticle(Particle.REDSTONE,
                                    player.getLocation().add(0,2,0),
                                    5,
                                    new Particle.DustOptions(Color.GRAY,20f)
                            );
                    ps.playSound(player.getLocation(),Sound.BLOCK_CAMPFIRE_CRACKLE,3,1);
                }
            },1);

        }
        if(player.getInventory().getItemInOffHand().getItemMeta()
                .hasEnchant(Enchantment.DAMAGE_UNDEAD)){
            Bukkit.getScheduler().runTaskLater(plugin,() -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,200,2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,200,2,true));
                for(Player ps: getPlayerAround(player, 10)){
                    ps.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,120,3));
                    ps.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,120,3));
                }
            },1);

        }
        if(player.getInventory().getItemInOffHand().getItemMeta()
                .hasEnchant(Enchantment.ARROW_KNOCKBACK)){
            Bukkit.getScheduler().runTaskLater(plugin,() -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,200,2));
                for(Player ps: getPlayerAround(player, 10)){
                    ps.setVelocity(ps.getLocation().getDirection().multiply(-1));
                }
            },1);

        }

    }

}
