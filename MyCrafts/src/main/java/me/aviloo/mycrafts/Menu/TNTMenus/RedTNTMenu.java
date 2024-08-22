package me.aviloo.mycrafts.Menu.TNTMenus;

import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Menu.Menu;
import me.aviloo.mycrafts.Utils.CraftUtils;
import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RedTNTMenu implements Listener {

    private static Inventory inventory;

    public static Inventory getInventory(Player player) {
        inventory = Bukkit.createInventory(player,54,"Уникальные крафты");
        inventory.setItem(3, TNTManager.itemRed);
        inventory.setItem(5, TNTManager.itemBlack);
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, CraftUtils.createCraftItem(player));
        inventory.setItem(49,MenuUtil.createInfoItem());
        inventory.setItem(21,new ItemStack(Material.TNT,10));
        inventory.setItem(22,new ItemStack(Material.FLINT_AND_STEEL,1));
        inventory.setItem(23,new ItemStack(Material.GUNPOWDER,3));

        MenuUtil.createStroke(inventory,3,5,21,22,23,30,31,32,48,49,50);

        return inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getInventory() != inventory){return;}
        if(event.getCurrentItem() == null){return;}
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        switch (event.getCurrentItem().getType()) {
            case SPECTRAL_ARROW:
                player.openInventory(Menu.instance.inventory);
                player.playSound(player.getLocation(),
                        Sound.ENTITY_ENDERMAN_TELEPORT, 5, 0);
                break;
            case CRAFTING_TABLE:
                CraftUtils.craft(player);
                break;
            case TNT:
                if (!event.getCurrentItem().getItemMeta().hasEnchants()) {
                    break;
                }
                if (event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.ARROW_FIRE)) {
                    CraftUtils.setSelectedItem(player, TNTManager.itemBlack);
                    player.openInventory(BlackTNTMenu.getInventory(player));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK, 5, 0);
                    break;
                }else {
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK, 5, 0);
                }
        }
    }

}
