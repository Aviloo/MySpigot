package com.aviloo.serverutilsandtools.SmallServerFunc.DamageHolograms;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DamageHolograms implements Listener {

    private JavaPlugin plugin;

    public DamageHolograms(JavaPlugin plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event){
        if(!(event.getEntity() instanceof LivingEntity)){
            return;
        }
        if(!((event.getDamager()) instanceof Player)){
            return;
        }
        Location HologramLocation = event.getEntity().getLocation();

        ArmorStand Hologram = (ArmorStand) HologramLocation.getWorld().spawnEntity(HologramLocation, EntityType.ARMOR_STAND);
        Hologram.setVisible(false);
        Hologram.setGravity(false);
        Hologram.setInvisible(true);
        Hologram.setCustomNameVisible(true);
        Hologram.setCustomName(ChatColor.GRAY+String.valueOf(event.getDamage()));
        if(event.getEntity().getType().equals(EntityType.ARMOR_STAND)){
            Hologram.remove();
        }
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            Hologram.remove();
        },10);
    }
}
