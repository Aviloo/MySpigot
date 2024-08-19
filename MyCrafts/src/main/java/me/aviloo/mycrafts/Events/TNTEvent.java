package me.aviloo.mycrafts.Events;

import me.aviloo.mycrafts.Items.TNTManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class TNTEvent implements Listener {

    @EventHandler
    public void onPlace(PlayerInteractEvent event){
        if(!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){return;}
        if(event.getItem() == null){return;}
        if(!event.getItem().getType().equals(Material.TNT)){return;}
        if(!event.getItem().getItemMeta().hasEnchants()){return;}
        Player player = event.getPlayer();

        if(event.getItem().getItemMeta().hasEnchant(Enchantment.ARROW_DAMAGE)){
            event.setCancelled(true);
            TNTManager.spawnRed(event.getClickedBlock().getLocation().add(0,1,0));
            player.getInventory().getItemInMainHand().setAmount(
                            player.getInventory().getItemInMainHand().getAmount() - 1);
        }

        if(event.getItem().getItemMeta().hasEnchant(Enchantment.ARROW_FIRE)){
            event.setCancelled(true);
            TNTManager.spawnBlack(event.getClickedBlock().getLocation().add(0,1,0));
            player.getInventory().getItemInMainHand().setAmount(
                    player.getInventory().getItemInMainHand().getAmount() - 1);

        }
    }

    @EventHandler
    public void onExplosion(EntityExplodeEvent event) {

        if(!event.getEntityType().getEntityClass().equals(TNTPrimed.class)){return;}
        if(event.getEntity().getFireTicks() != 85){return;}

        List<Location> locationList = new ArrayList<>();
        locationList.add(event.getEntity().getLocation().clone().add(0,-1,0));
        locationList.add(event.getEntity().getLocation().clone().add(0,-1,1));
        locationList.add(event.getEntity().getLocation().clone().add(1,-1,0));
        locationList.add(event.getEntity().getLocation().clone().add(1,-1,1));
        locationList.add(event.getEntity().getLocation().clone().add(1,0,0));
        locationList.add(event.getEntity().getLocation().clone().add(0,0,1));
        locationList.add(event.getEntity().getLocation().clone().add(1,0,1));

        for(Location loc : locationList){
            if(!loc.getBlock().getType().equals(Material.BEDROCK)){
                loc.getBlock().setType(Material.AIR);
            }

        }

    }

}
