package me.aviloo.mycrafts.Menu.TotemMenus;

import me.aviloo.mycrafts.Items.TotemsManager;
import me.aviloo.mycrafts.Menu.Menu;
import me.aviloo.mycrafts.Utils.CraftUtils;
import me.aviloo.mycrafts.Utils.MenuUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PowerMenu implements Listener {

    private static Inventory inventory;
    public static Inventory getInventory(Player player) {
        inventory = Bukkit.createInventory(player,54, ChatColor.GRAY+
                "Уникальные крафты");
        inventory.setItem(3, TotemsManager.TotemOfAgility);
        inventory.setItem(4, TotemsManager.TotemOfStrength);
        inventory.setItem(5, TotemsManager.TotemOfPower);
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, CraftUtils.createCraftItem(player));
        inventory.setItem(49, MenuUtil.createInfoItem());
        inventory.setItem(21,new ItemStack(
                Material.TOTEM_OF_UNDYING,1));
        inventory.setItem(22,new ItemStack(
                Material.IRON_INGOT,7));
        inventory.setItem(23,new ItemStack(
                Material.SLIME_BALL,3));
        inventory.setItem(30,new ItemStack(
                Material.EGG,6));


        MenuUtil.createStroke(inventory,3,4,5,21,22,23,30,31,32,48,49,50);


        return inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
        {
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
                case CRAFTING_TABLE:
                    CraftUtils.craft(player);
                    break;
                case TOTEM_OF_UNDYING:
                    if(!event.getCurrentItem().getItemMeta().hasEnchants()){break;}
                    if(event.getCurrentItem().getItemMeta().
                            hasEnchant(Enchantment.DIG_SPEED)){
                        CraftUtils.setSelectedItem(player, TotemsManager.TotemOfAgility);
                        player.openInventory(inventory);
                        player.playSound(player.getLocation(),
                                Sound.UI_BUTTON_CLICK,5,0);
                    }
                    if(event.getCurrentItem().getItemMeta().
                            hasEnchant(Enchantment.DAMAGE_UNDEAD)){
                        CraftUtils.setSelectedItem(player, TotemsManager.TotemOfStrength);
                        player.openInventory(StrengthMenu.getInventory(player));
                        player.playSound(player.getLocation(),
                                Sound.UI_BUTTON_CLICK,5,0);
                    }
                    if(event.getCurrentItem().getItemMeta().
                            hasEnchant(Enchantment.ARROW_KNOCKBACK)){
                        CraftUtils.setSelectedItem(player, TotemsManager.TotemOfPower);
                        player.openInventory(getInventory(player));
                        player.playSound(player.getLocation(),
                                Sound.UI_BUTTON_CLICK,5,0);
                    }
                    break;
            }

        }
}
