package me.aviloo.mycrafts.Events;

import me.aviloo.mycrafts.Items.EnchantedManager;
import me.aviloo.mycrafts.Items.SphereManager;
import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Items.TotemsManager;
import me.aviloo.mycrafts.Items.Trap.TrapManager;
import me.aviloo.mycrafts.Menu.*;
import me.aviloo.mycrafts.Utils.CraftUtils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MenuEvents implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if(event.getInventory() != Menu.instance.inventory){return;}
        if(event.getCurrentItem() == null){return;}

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        switch (event.getCurrentItem().getType()){
            case TOTEM_OF_UNDYING:
                CraftUtils.setSelectedItem(player, TotemsManager.getTotemOfAgility());
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(TotemMenu.instance.inventory);
                break;
            case PLAYER_HEAD:
                CraftUtils.setSelectedItem(player, SphereManager.getSphereOcean());
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(SphereMenu.instance.inventory);
                break;
            case ENCHANTED_BOOK:
                CraftUtils.setSelectedItem(player, EnchantedManager.getDamageBook());
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(EnchantedMenu.instance.inventory);
                break;
            case NETHERITE_SCRAP:
                CraftUtils.setSelectedItem(player, TrapManager.Trap);
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(SpecialMenu.instance.inventory);
                break;
            case TNT:
                CraftUtils.setSelectedItem(player, TNTManager.itemRed);
                player.playSound(player.getLocation(),
                        Sound.UI_BUTTON_CLICK,5,0);
                player.openInventory(TNTMenu.instance.inventory);
                break;
            case SPECTRAL_ARROW:
                player.playSound(player.getLocation(),
                        Sound.ENTITY_ENDERMAN_TELEPORT,5,0);
                player.closeInventory();
                break;
        }

    }

    @EventHandler
    public void onTotemClick(InventoryClickEvent event) {
        if(event.getInventory() != TotemMenu.instance.inventory){return;}
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
                    CraftUtils.setSelectedItem(player, TotemsManager.getTotemOfAgility());
                    event.getInventory().setItem(21,new ItemStack(
                            Material.TOTEM_OF_UNDYING,1));
                    event.getInventory().setItem(22,new ItemStack(
                            Material.RABBIT_FOOT,5));
                    event.getInventory().setItem(23,new ItemStack(
                            Material.SUGAR,16));
                    event.getInventory().setItem(30,new ItemStack(
                            Material.ECHO_SHARD,3));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().
                        hasEnchant(Enchantment.DAMAGE_UNDEAD)){
                    CraftUtils.setSelectedItem(player, TotemsManager.getTotemOfStrength());
                    event.getInventory().setItem(21,new ItemStack(
                            Material.TOTEM_OF_UNDYING,1));
                    event.getInventory().setItem(22,new ItemStack(
                            Material.REDSTONE,21));
                    event.getInventory().setItem(23,new ItemStack(
                            Material.IRON_INGOT,7));
                    event.getInventory().setItem(30,new ItemStack(
                            Material.FERMENTED_SPIDER_EYE,2));
                    event.getInventory().setItem(31,new ItemStack(
                            Material.SUGAR,8));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().
                        hasEnchant(Enchantment.ARROW_KNOCKBACK)){
                    CraftUtils.setSelectedItem(player, TotemsManager.getTotemOfPower());
                    event.getInventory().setItem(21,new ItemStack(
                            Material.TOTEM_OF_UNDYING,1));
                    event.getInventory().setItem(22,new ItemStack(
                            Material.IRON_INGOT,7));
                    event.getInventory().setItem(23,new ItemStack(
                            Material.SLIME_BALL,3));
                    event.getInventory().setItem(30,new ItemStack(
                            Material.EGG,6));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                break;
        }

    }

    @EventHandler
    public void onSpecialClick(InventoryClickEvent event){
        if(event.getInventory() != SpecialMenu.instance.inventory){return;}
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

    @EventHandler
    public void onSphereClick(InventoryClickEvent event){
        if(event.getInventory() != SphereMenu.instance.inventory){return;}
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
                    CraftUtils.setSelectedItem(player, SphereManager.getSphereOcean());
                    event.getInventory().setItem(21,new ItemStack(
                            Material.HEART_OF_THE_SEA,1));
                    event.getInventory().setItem(22,new ItemStack(
                            Material.IRON_BLOCK,3));
                    event.getInventory().setItem(23,new ItemStack(
                            Material.GLISTERING_MELON_SLICE,4));
                    event.getInventory().setItem(30,new ItemStack(
                            Material.FERMENTED_SPIDER_EYE,5));
                    event.getInventory().setItem(31,new ItemStack(
                            Material.SLIME_BALL,7));
                    event.getInventory().setItem(32,new ItemStack(
                            Material.GLOW_INK_SAC,4));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.ARROW_FIRE)) {
                    CraftUtils.setSelectedItem(player, SphereManager.getSphereNether());
                    event.getInventory().setItem(21,new ItemStack(
                            Material.NETHERITE_INGOT,1));
                    event.getInventory().setItem(22,new ItemStack(
                            Material.BLAZE_POWDER,9));
                    event.getInventory().setItem(23,new ItemStack(
                            Material.SLIME_BALL,3));
                    event.getInventory().setItem(30,new ItemStack(
                            Material.GHAST_TEAR,1));
                    event.getInventory().setItem(31,new ItemStack(
                            Material.SUGAR,3));
                    event.getInventory().setItem(32,new ItemStack(
                            Material.RABBIT_FOOT,1));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.DIG_SPEED)) {
                    CraftUtils.setSelectedItem(player, SphereManager.getSphereEnd());
                    event.getInventory().setItem(21,new ItemStack(
                            Material.ENDER_EYE,3));
                    event.getInventory().setItem(22,new ItemStack(
                            Material.CHORUS_FRUIT,6));
                    event.getInventory().setItem(23,new ItemStack(
                            Material.AMETHYST_SHARD,7));
                    event.getInventory().setItem(30,new ItemStack(
                            Material.GLOWSTONE_DUST,6));
                    event.getInventory().setItem(31,new ItemStack(
                            Material.SUGAR,15));
                    event.getInventory().setItem(32,new ItemStack(
                            Material.FERMENTED_SPIDER_EYE,3));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
        }
    }

    @EventHandler
    public void onEnchantClick(InventoryClickEvent event){
        if(event.getInventory() != EnchantedMenu.instance.inventory){return;}
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
                    inventory.setItem(49,new ItemStack(Material.PAPER));
                    inventory.setItem(21,new ItemStack(Material.BOOKSHELF,3));
                    inventory.setItem(22,new ItemStack(Material.EMERALD,2));
                    inventory.setItem(23,new ItemStack(Material.LAPIS_LAZULI,7));
                    inventory.setItem(30,new ItemStack(Material.DIAMOND,8));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(Enchantment.DIG_SPEED)){
                    CraftUtils.setSelectedItem(player, EnchantedManager.getDigSpeedBook());
                    inventory.setItem(49,new ItemStack(Material.PAPER));
                    inventory.setItem(21,new ItemStack(Material.BOOKSHELF,3));
                    inventory.setItem(22,new ItemStack(Material.EMERALD,2));
                    inventory.setItem(23,new ItemStack(Material.LAPIS_LAZULI,7));
                    inventory.setItem(30,new ItemStack(Material.REDSTONE_BLOCK,5));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(Enchantment.DURABILITY)){
                    CraftUtils.setSelectedItem(player, EnchantedManager.getDurabilityBook());
                    inventory.setItem(49,new ItemStack(Material.PAPER));
                    inventory.setItem(21,new ItemStack(Material.BOOKSHELF,3));
                    inventory.setItem(22,new ItemStack(Material.EMERALD,2));
                    inventory.setItem(23,new ItemStack(Material.LAPIS_LAZULI,7));
                    inventory.setItem(30,new ItemStack(Material.OBSIDIAN,6));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.PROTECTION_ENVIRONMENTAL)){
                    CraftUtils.setSelectedItem(player, EnchantedManager.getProtectionBook());
                    inventory.setItem(49,new ItemStack(Material.PAPER));
                    inventory.setItem(21,new ItemStack(Material.BOOKSHELF,3));
                    inventory.setItem(22,new ItemStack(Material.EMERALD,2));
                    inventory.setItem(23,new ItemStack(Material.LAPIS_LAZULI,7));
                    inventory.setItem(30,new ItemStack(Material.IRON_BLOCK,3));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.ARROW_DAMAGE)){
                    CraftUtils.setSelectedItem(player, EnchantedManager.getPowerBook());
                    inventory.setItem(49,new ItemStack(Material.PAPER));
                    inventory.setItem(21,new ItemStack(Material.BOOKSHELF,3));
                    inventory.setItem(22,new ItemStack(Material.EMERALD,2));
                    inventory.setItem(23,new ItemStack(Material.LAPIS_LAZULI,7));
                    inventory.setItem(30,new ItemStack(Material.ARROW,10));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
        }
    }

    @EventHandler
    public void onTNTClick(InventoryClickEvent event){
        if(event.getInventory() != TNTMenu.instance.inventory){return;}
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
                Inventory inventory = event.getInventory();
                if(!event.getCurrentItem().getItemMeta().hasEnchants()){break;}
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.ARROW_DAMAGE)){
                    CraftUtils.setSelectedItem(player, TNTManager.itemRed);
                    inventory.setItem(21,new ItemStack(Material.TNT,10));
                    inventory.setItem(22,new ItemStack(Material.FLINT_AND_STEEL,1));
                    inventory.setItem(23,new ItemStack(Material.GUNPOWDER,3));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
                if(event.getCurrentItem().getItemMeta().hasEnchant(
                        Enchantment.ARROW_FIRE)){
                    CraftUtils.setSelectedItem(player, TNTManager.itemBlack);
                    inventory.setItem(21,new ItemStack(Material.TNT,5));
                    inventory.setItem(22,new ItemStack(Material.OBSIDIAN,1));
                    inventory.setItem(23,new ItemStack(Material.GUNPOWDER,10));
                    player.playSound(player.getLocation(),
                            Sound.UI_BUTTON_CLICK,5,0);
                }
        }

    }

}
