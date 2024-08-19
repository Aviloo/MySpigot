package me.aviloo.mycrafts.Events;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import me.aviloo.mycrafts.Utils.ColorUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class SphereEvents implements Listener {

    @EventHandler
    public void onPlace(PlayerInteractEvent event) {
        if(event.getPlayer().getInventory()
                .getItemInMainHand().getType().equals(Material.PLAYER_HEAD) ||
            event.getPlayer().getInventory()
                    .getItemInOffHand().getType().equals(Material.PLAYER_HEAD)) {
            if(!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){return;}
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onSkullMove(PlayerArmorChangeEvent event) {
        if(!event.getSlotType().equals(PlayerArmorChangeEvent.SlotType.HEAD)){return;}
        if (event.getNewItem().getItemMeta() == null) {
            return;
        }

        if (event.getNewItem().getType() == Material.PLAYER_HEAD
                && event.getNewItem().getItemMeta().hasAttributeModifiers()) {
            event.getPlayer().sendMessage(ColorUtils.
                    translateColorCodes("&7[&6Система&7] &fНельзя надевать голову с атрибутами"));

            ItemStack head = event.getPlayer().getInventory().getItem(EquipmentSlot.HEAD).clone();
            event.getPlayer().getInventory().setHelmet(null);
            event.getPlayer().getInventory().addItem(head);
        }
    }

}
