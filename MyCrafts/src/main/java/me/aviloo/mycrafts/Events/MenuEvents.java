package me.aviloo.mycrafts.Events;

import me.aviloo.mycrafts.Items.EnchantedManager;
import me.aviloo.mycrafts.Items.SphereManager;
import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Items.TotemsManager;
import me.aviloo.mycrafts.Items.Trap.TrapManager;
import me.aviloo.mycrafts.Menu.*;
import me.aviloo.mycrafts.Menu.EnchantedMenu;
import me.aviloo.mycrafts.Menu.EnchantedMenus.DamageMenu;
import me.aviloo.mycrafts.Menu.SpecialMenu;
import me.aviloo.mycrafts.Menu.SpecialMenus.TrapMenu;
import me.aviloo.mycrafts.Menu.SphereMenu;
import me.aviloo.mycrafts.Menu.BlackMenu;
import me.aviloo.mycrafts.Menu.RedMenu;
import me.aviloo.mycrafts.Menu.SphereMenus.OceanMenu;
import me.aviloo.mycrafts.Menu.TNTMenus.RedTNTMenu;
import me.aviloo.mycrafts.Menu.TotemMenu;
import me.aviloo.mycrafts.Menu.TotemMenus.AgilityMenu;
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

    private void setCraftItem(Player player,Inventory inventory) {
        inventory.setItem(48,CraftUtils.createCraftItem(player));
    }

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
                    CraftUtils.setSelectedItem(player, TotemsManager.TotemOfAgility);
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
                    CraftUtils.setSelectedItem(player, TotemsManager.TotemOfStrength);
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
                    CraftUtils.setSelectedItem(player, TotemsManager.TotemOfPower);
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
                    CraftUtils.setSelectedItem(player, SphereManager.SphereOcean);
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
                    CraftUtils.setSelectedItem(player, SphereManager.SphereNether);
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
                    CraftUtils.setSelectedItem(player, SphereManager.SphereEnd);
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
        if(event.getInventory() != RedMenu.instance.inventory &&
        event.getInventory() != BlackMenu.instance.inventory){return;}
        if(event.getCurrentItem() == null){return;}
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        if(event.getInventory() == RedMenu.instance.inventory) {
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
                    if (!event.getCurrentItem().getItemMeta().hasEnchants()) {
                        break;
                    }
                    if (event.getCurrentItem().getItemMeta().hasEnchant(
                            Enchantment.ARROW_FIRE)) {
                        CraftUtils.setSelectedItem(player, TNTManager.itemBlack);
                        player.openInventory(BlackMenu.instance.inventory);
                        setCraftItem(player,BlackMenu.instance.inventory);
                        player.playSound(player.getLocation(),
                                Sound.UI_BUTTON_CLICK, 5, 0);
                        break;
                    }
            }
        }
        if(event.getInventory() == BlackMenu.instance.inventory) {
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
                    if (!event.getCurrentItem().getItemMeta().hasEnchants()) {
                        break;
                    }
                    if (event.getCurrentItem().getItemMeta().hasEnchant(
                            Enchantment.ARROW_DAMAGE)) {
                        CraftUtils.setSelectedItem(player, TNTManager.itemRed);
                        player.openInventory(RedMenu.instance.inventory);
                        setCraftItem(player,RedMenu.instance.inventory);
                        player.playSound(player.getLocation(),
                                Sound.UI_BUTTON_CLICK, 5, 0);
                        break;
                    }
            }
        }

    }

}
