package me.aviloo.mypotionsystem.Events.OtherEvents;

import me.aviloo.mypotionsystem.Inventories.UpgradesInventory;
import me.aviloo.mypotionsystem.Utils.InventoryUtils;
import me.aviloo.mypotionsystem.Utils.UpgradesManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class GlobalEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        InventoryUtils.cleanMaterial(player);
        InventoryUtils.cleanAbility(player);
        UpgradesManager.setUpgradesStatus(player,true);
    }

    @EventHandler //хз оставлять или нет
    public void close(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Создание зелья")){
            InventoryUtils.cleanAbility(player);
            InventoryUtils.cleanMaterial(player);
        }
    }

}
