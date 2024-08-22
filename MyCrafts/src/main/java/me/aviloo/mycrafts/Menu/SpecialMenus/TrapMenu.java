package me.aviloo.mycrafts.Menu.SpecialMenus;

import me.aviloo.mycrafts.Items.Trap.TrapManager;
import me.aviloo.mycrafts.Menu.Menu;
import me.aviloo.mycrafts.Utils.CraftUtils;
import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TrapMenu implements Listener {

    private static Inventory inventory;

    public static Inventory getInventory(Player player) {
        inventory = Bukkit.createInventory(player,
                54, ChatColor.GRAY+"Уникальные крафты");
        inventory.setItem(4, TrapManager.Trap);
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, CraftUtils.createCraftItem(player));
        inventory.setItem(21,new ItemStack(Material.OBSIDIAN,8));
        inventory.setItem(22,new ItemStack(Material.IRON_INGOT,5));
        inventory.setItem(23,new ItemStack(Material.ENDER_PEARL,2));
        inventory.setItem(30,new ItemStack(Material.BLAZE_ROD,1));
        inventory.setItem(49,MenuUtil.createInfoItem());

        MenuUtil.createStroke(inventory,4,21,22,23,30,31,32,48,49,50);
        return inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getInventory() != inventory){return;}
        if(event.getCurrentItem() == null){return;}
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        switch (event.getCurrentItem().getType()){
            case SPECTRAL_ARROW:
                player.playSound(player.getLocation(),
                        Sound.ENTITY_ENDERMAN_TELEPORT,5,0);
                player.openInventory(Menu.instance.inventory);
                break;
            case NETHERITE_SCRAP:
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                break;
            case CRAFTING_TABLE:
                CraftUtils.craft(player);
                break;
        }
    }

}
