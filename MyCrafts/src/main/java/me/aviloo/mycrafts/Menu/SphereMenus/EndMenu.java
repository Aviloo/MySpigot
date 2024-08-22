package me.aviloo.mycrafts.Menu.SphereMenus;

import me.aviloo.mycrafts.Items.SphereManager;
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

public class EndMenu implements Listener {

    private static Inventory inventory;
    public static Inventory getInventory(Player player) {
        inventory = Bukkit.createInventory(player,54,
                ChatColor.GRAY+"Уникальные крафты");
        inventory.setItem(3, SphereManager.SphereOcean);
        inventory.setItem(4, SphereManager.SphereNether);
        inventory.setItem(5, SphereManager.SphereEnd);
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, CraftUtils.createCraftItem(player));
        inventory.setItem(21,new ItemStack(
                Material.ENDER_EYE,3));
        inventory.setItem(22,new ItemStack(
                Material.CHORUS_FRUIT,6));
        inventory.setItem(23,new ItemStack(
                Material.AMETHYST_SHARD,7));
        inventory.setItem(30,new ItemStack(
                Material.GLOWSTONE_DUST,6));
        inventory.setItem(31,new ItemStack(
                Material.SUGAR,15));
        inventory.setItem(32,new ItemStack(
                Material.FERMENTED_SPIDER_EYE,3));
        inventory.setItem(49,MenuUtil.createInfoItem());


        MenuUtil.createStroke(inventory,3,4,5,21,22,23,30,31,32,48,49,50);

        return inventory;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getInventory() != inventory){return;}
        if(event.getCurrentItem() == null){return;}
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        switch (event.getCurrentItem().getType()){
            case SPECTRAL_ARROW:
                player.openInventory(Menu.instance.inventory);
                player.playSound(player.getLocation(),
                        Sound.ENTITY_ENDERMAN_TELEPORT,5,0);
                break;
            case CRAFTING_TABLE:
                CraftUtils.craft(player);
                break;
            case PLAYER_HEAD:
                if(!event.getCurrentItem().getItemMeta().hasEnchants()){break;}
                if(event.getCurrentItem().getItemMeta().hasEnchant(Enchantment.FROST_WALKER)){
                    CraftUtils.setSelectedItem(player, SphereManager.SphereOcean);
                    player.openInventory(OceanMenu.getInventory(player));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.ARROW_FIRE)) {
                    CraftUtils.setSelectedItem(player, SphereManager.SphereNether);
                    player.openInventory(NetherMenu.getInventory(player));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.DIG_SPEED)) {
                    CraftUtils.setSelectedItem(player, SphereManager.SphereEnd);
                    player.openInventory(EndMenu.getInventory(player));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
        }
    }
}
