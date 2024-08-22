package me.aviloo.mycrafts.Menu.EnchantedMenus;

import me.aviloo.mycrafts.Items.EnchantedManager;
import me.aviloo.mycrafts.Menu.EnchantedMenu;
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

public class ArrowDamageMenu implements Listener {
    private static Inventory inventory;
    public static Inventory getInventory(Player player) {
        inventory = Bukkit.createInventory(player,
                54, ChatColor.GRAY+"Уникальные крафты");
        inventory.setItem(2, EnchantedManager.getDamageBook());
        inventory.setItem(3, EnchantedManager.getDigSpeedBook());
        inventory.setItem(4, EnchantedManager.getDurabilityBook());
        inventory.setItem(5, EnchantedManager.getProtectionBook());
        inventory.setItem(6, EnchantedManager.getPowerBook());
        inventory.setItem(50, MenuUtil.createItemStack());
        inventory.setItem(48, CraftUtils.createCraftItem(player));
        inventory.setItem(49, MenuUtil.createInfoItem());
        inventory.setItem(21,new ItemStack(Material.BOOKSHELF,3));
        inventory.setItem(22,new ItemStack(Material.EMERALD,2));
        inventory.setItem(23,new ItemStack(Material.LAPIS_LAZULI,7));
        inventory.setItem(30,new ItemStack(Material.ARROW,10));

        MenuUtil.createStroke(inventory,2,3,4,5,6,21,22,23,30,31,32,48,49,50);

        return inventory;
    }
    @EventHandler
    public void onEnchantClick(InventoryClickEvent event){
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
            case ENCHANTED_BOOK:
                Inventory inventory = event.getInventory();
                if(!event.getCurrentItem().getItemMeta().hasEnchants()){break;}
                if(event.getCurrentItem().getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)){
                    CraftUtils.setSelectedItem(player, EnchantedManager.getDamageBook());
                    player.openInventory(DamageMenu.getInventory(player));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(Enchantment.DIG_SPEED)){
                    CraftUtils.setSelectedItem(player, EnchantedManager.getDigSpeedBook());
                    player.openInventory(DigSpeedMenu.getInventory(player));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(Enchantment.DURABILITY)){
                    CraftUtils.setSelectedItem(player, EnchantedManager.getDurabilityBook());
                    player.openInventory(DurabilityMenu.getInventory(player));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.PROTECTION_ENVIRONMENTAL)){
                    CraftUtils.setSelectedItem(player, EnchantedManager.getProtectionBook());
                    player.openInventory(ProtectionMenu.getInventory(player));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.ARROW_DAMAGE)){
                    CraftUtils.setSelectedItem(player, EnchantedManager.getPowerBook());
                    player.openInventory(ArrowDamageMenu.getInventory(player));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
        }
    }

}
