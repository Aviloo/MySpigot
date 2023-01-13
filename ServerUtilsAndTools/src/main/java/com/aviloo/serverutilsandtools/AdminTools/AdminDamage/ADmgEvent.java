package com.aviloo.serverutilsandtools.AdminTools.AdminDamage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ADmgEvent implements Listener {
    //Plugin Path
    private static JavaPlugin plugin;

    public ADmgEvent(JavaPlugin plugin){
        this.plugin = plugin;
    }
    //Event Path
    @EventHandler(priority = EventPriority.HIGH,ignoreCancelled = true)
    public void onAttack(EntityDamageByEntityEvent event){
        Player player = (Player) event.getDamager();
        if(!player.hasPermission("SUAT.admin-dmg") && !player.isOp()){
            return;
        }

        if(ADmgCommand.getValue(player)){
            //Double Damage Path
            if(ADmgCommand.getDamage(player) == 1.0){
                event.setDamage(event.getDamage() + 1.0);
            }
            if(ADmgCommand.getDamage(player) == 2.0){
                event.setDamage(event.getDamage() + 2.0);
            }
            if(ADmgCommand.getDamage(player) == 3.0){
                event.setDamage(event.getDamage() + 3.0);
            }
            if(ADmgCommand.getDamage(player) == 4.0){
                event.setDamage(event.getDamage() + 4.0);
            }
            if(ADmgCommand.getDamage(player) == 5.0){
                event.setDamage(event.getDamage() + 5.0);
            }
            if(ADmgCommand.getDamage(player) == 0.0){
                event.setDamage(event.getDamage() + 0.0);
            }
            //Shield Path
            if(ADmgCommand.getValueShield(player)){
                if(!(event.getEntity() instanceof Player)){
                    return;
                }
                Player target = (Player) event.getEntity();
                if(target.getInventory().getItemInOffHand().equals(new ItemStack(Material.SHIELD))){
                    ItemStack shield = target.getInventory().getItemInOffHand();
                    target.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        target.getInventory().setItemInOffHand(shield);
                    }, 10);
                }
            }
        }
    }
}
