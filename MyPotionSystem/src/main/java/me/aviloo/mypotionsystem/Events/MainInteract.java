package me.aviloo.mypotionsystem.Events;

import me.aviloo.mypotionsystem.Inventories.*;
import me.aviloo.mypotionsystem.Utils.InventoryUtils;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Создание зелья")){
            switch (event.getCurrentItem().getType()){
                case STRUCTURE_VOID:
                    InventoryUtils.cleanMaterial(player);
                    InventoryUtils.cleanAbility(player);
                    player.playSound(player.getLocation(),Sound.BLOCK_ANVIL_BREAK,3,0);
                    break;
                case SPECTRAL_ARROW:
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,9,1);
                    break;
                case BOOK:
                    player.openInventory(InfoInventory.getInv(player));
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,5,-5);
                    break;
                case RABBIT_FOOT:
                    player.openInventory(MaterialsInventory.getInv(player));
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,5,-5);
                    break;
                case BREWING_STAND:
                    player.openInventory(UpgradesInventory.getInv(player));
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,5,-5);
                    break;
                case WITCH_SPAWN_EGG:
                    player.openInventory(AbilitiesInventory.getInv(player));
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,5,-5);
                    break;
                case POTION:
                    player.openInventory(CraftingInventory.getInv(player));
                    break;
            }
            event.setCancelled(true);
        }
    }
}
