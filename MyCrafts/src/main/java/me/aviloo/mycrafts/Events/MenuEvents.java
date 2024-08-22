package me.aviloo.mycrafts.Events;

import me.aviloo.mycrafts.Items.EnchantedManager;
import me.aviloo.mycrafts.Items.SphereManager;
import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Items.TotemsManager;
import me.aviloo.mycrafts.Items.Trap.TrapManager;
import me.aviloo.mycrafts.Menu.*;
import me.aviloo.mycrafts.Menu.EnchantedMenus.DamageMenu;
import me.aviloo.mycrafts.Menu.SpecialMenus.TrapMenu;
import me.aviloo.mycrafts.Menu.SphereMenus.OceanMenu;
import me.aviloo.mycrafts.Menu.TNTMenus.RedTNTMenu;
import me.aviloo.mycrafts.Menu.TotemMenus.AgilityMenu;
import me.aviloo.mycrafts.Utils.CraftUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuEvents implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if(event.getInventory() != Menu.instance.inventory){return;}
        if(event.getCurrentItem() == null){return;}

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        switch (event.getCurrentItem().getType()){
            case TOTEM_OF_UNDYING:
                CraftUtils.setSelectedItem(player, TotemsManager.TotemOfAgility);
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(AgilityMenu.getInventory(player));
                break;
            case PLAYER_HEAD:
                CraftUtils.setSelectedItem(player, SphereManager.SphereOcean);
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(OceanMenu.getInventory(player));
                break;
            case ENCHANTED_BOOK:
                CraftUtils.setSelectedItem(player, EnchantedManager.getDamageBook());
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(DamageMenu.getInventory(player));
                break;
            case NETHERITE_SCRAP:
                CraftUtils.setSelectedItem(player, TrapManager.Trap);
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(TrapMenu.getInventory(player));
                break;
            case TNT:
                CraftUtils.setSelectedItem(player, TNTManager.itemRed);
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(RedTNTMenu.getInventory(player));
                break;
            case SPECTRAL_ARROW:
                player.playSound(player.getLocation(),
                        Sound.ENTITY_ENDERMAN_TELEPORT,5,0);
                player.closeInventory();
                break;
        }

    }
}
