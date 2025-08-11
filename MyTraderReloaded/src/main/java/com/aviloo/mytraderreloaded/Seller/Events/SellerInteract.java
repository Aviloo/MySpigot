package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.InfoInventory;
import com.aviloo.mytraderreloaded.Seller.Inventories.ReputationProductInventory;
import com.aviloo.mytraderreloaded.Seller.Inventories.SellerInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class SellerInteract implements Listener {

    private int getItemCount(Player player, Material material) {
        int count = 0;
        for (ItemStack item : player.getInventory()) {
            if (item != null && item.getType() == material) {
                count += item.getAmount();
            }
        }
        return count;
    }

    private void removeItem(Player player,Material material, int amount) {
        PlayerInventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack item = inventory.getItem(i);
            if (item == null || item.getType() != material) continue;

            int itemAmount = item.getAmount();
            if (amount >= itemAmount) {
                inventory.clear(i);
                amount -= itemAmount;
            } else {
                item.setAmount(itemAmount - amount);
                break;
            }

            if (amount <= 0) break;
        }
    }

    private void removeItems(Player player, String ProductType, int tryToSell) {
        if(tryToSell > PriceManager.getProductAmountLeft(ProductType)) {
            removeItem(player,
                    Material.valueOf(ProductType),
                            PriceManager.getProductAmountLeft(ProductType));

            if(PriceManager.getProductAmountLeft(ProductType) >= 64){
                EconomyManager.giveMoney(player,PriceManager.getCurrentPrice(ProductType)
                        * PriceManager.getProductAmountLeft(ProductType) + (Math.ceil(
                        (double) PriceManager.getProductAmountLeft(ProductType) / 64) * 9));
            }
            if(PriceManager.getProductAmountLeft(ProductType) < 64){
                EconomyManager.giveMoney(player,PriceManager.getCurrentPrice(ProductType) *
                        PriceManager.getProductAmountLeft(ProductType));
            }
        }else {
            removeItem(player,Material.valueOf(ProductType),
                    tryToSell);
            if(tryToSell >= 64){
                EconomyManager.giveMoney(player,PriceManager.getCurrentPrice(ProductType) *
                        tryToSell + (Math.ceil((double) tryToSell / 64) * 9));
            }
            if(tryToSell < 64){
                EconomyManager.giveMoney(player,PriceManager.getCurrentPrice(ProductType)
                * tryToSell);
            }
        }

    }

    private static void ProductBlocked(Player player, Inventory inventory,int slot) {
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY+"Недоступно");
        item.setItemMeta(meta);

        player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Торговец больше не" +
                " принимает данный товар. Приходите завтра.");
        inventory.setItem(slot,item);
    }

    private String getProductName(String ProductType){
        return new ItemStack(Material.valueOf(ProductType)).getItemMeta().getLocalizedName();
    }

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    private void sellProduct(Player player,String ProductType, int amount){
        PriceManager.addSoldQuantity(ProductType,amount);
        PriceManager.priceChecker(ProductType);
        LeaderUtils.addPlayerEarned(player.getUniqueId(),
                PriceManager.getCurrentPrice(ProductType) * amount);
        removeItems(player,ProductType,amount);
        if(!MyTraderReloaded.getIsEpicType()) {
            SellerInventory.loadMetaForGeneratedDefaultItems();
        }
        if(MyTraderReloaded.getIsEpicType()){
            SellerInventory.loadMetaForGeneratedEpicItems();
        }
        player.updateInventory();
    }

    protected void sellProductController(ClickType click, Player player,
                                       String ProductType){
        if(!click.isShiftClick() && !click.isLeftClick() && !click.isRightClick()){return;}

        if (click.isRightClick() && !click.isShiftClick()) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.valueOf(ProductType)),
                    1)) {
                sellProduct(player,ProductType,1);
                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт."
                +getProductName(ProductType)+".");
            }
            if (!player.getInventory().containsAtLeast(new ItemStack(Material.valueOf(ProductType)),
                    1)) {
                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
            }
            return;
        }
        if (click.isLeftClick() && !click.isShiftClick()) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.valueOf(ProductType))
                    , 64)) {
                sellProduct(player,ProductType,64);
                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. "+
                        getProductName(ProductType)+".");
            }
            if (!player.getInventory().containsAtLeast(new ItemStack(Material.valueOf(ProductType)),
                    64)) {
                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
            }
            return;
        }
        if((click.isShiftClick() && click.isLeftClick()) ||(click.isShiftClick() &&
                click.isRightClick())){
            if(player.getInventory().containsAtLeast(new ItemStack(Material.valueOf(ProductType)),
                    getItemCount(player,Material.valueOf(ProductType)))) {
                sellProduct(player, ProductType, getItemCount(player,
                        Material.valueOf(ProductType)));
                player.sendMessage(ChatColor.GRAY+ "[Система] "+
                        ChatColor.WHITE+"Вы продали "+getItemCount(player,Material.valueOf(
                                ProductType))+" шт. " +getProductName(ProductType)+".");
            }
            if(!player.getInventory().containsAtLeast(new ItemStack(Material.valueOf(ProductType)),
                    getItemCount(player,Material.valueOf(ProductType)))) {
                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
            }
        }
    }


    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Скупщик")){
            Player player = (Player) event.getWhoClicked();
            switch (event.getCurrentItem().getType()){
                case PLAYER_HEAD:
                    if(event.getCurrentItem().containsEnchantment(Enchantment.ARROW_KNOCKBACK)){
                        player.closeInventory();
                        player.playSound(player.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                        break;
                    }
                    if(event.getCurrentItem().containsEnchantment(Enchantment.ARROW_FIRE)){
                        player.closeInventory();
                        player.playSound(player.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                        break;
                    }
                    if(event.getCurrentItem().containsEnchantment(Enchantment.ARROW_INFINITE)){
                        player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                        break;
                    }
                    if(event.getCurrentItem().containsEnchantment(Enchantment.ARROW_DAMAGE)){
                        if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")) {
                            if (!MySQLManager.isConnected()) {
                                player.closeInventory();
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 9, 1);
                                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                                        messagesConfig.getString("error_database_and_usermap_not_available")));
                                break;
                            }
                        }
                        player.openInventory(ReputationProductInventory.getInv(player));
                        break;
                    }
                    if(event.getCurrentItem().containsEnchantment(Enchantment.DURABILITY)){
                        player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                        break;
                    }
                    if(event.getCurrentItem().containsEnchantment(Enchantment.ARROW_FIRE)){
                        player.openInventory(InfoInventory.inventory);
                        player.playSound(player.getLocation(),Sound.BLOCK_ENCHANTMENT_TABLE_USE,3,0);
                        break;
                    }
                    if(event.getCurrentItem().containsEnchantment(Enchantment.DIG_SPEED)){
                        player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                        break;
                    }
                    break;
                case SPECTRAL_ARROW:
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                    break;
                case KNOWLEDGE_BOOK:
                    player.openInventory(InfoInventory.inventory);
                    player.playSound(player.getLocation(),Sound.BLOCK_ENCHANTMENT_TABLE_USE,3,0);
                    break;
                case CHEST_MINECART:
                    if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")) {
                        if (!MySQLManager.isConnected()) {
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 9, 1);
                            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_error") +
                                    messagesConfig.getString("error_database_and_usermap_not_available")));
                            break;
                        }
                    }
                    player.openInventory(ReputationProductInventory.getInv(player));
                    break;
                case REDSTONE:
                    if (PriceManager.isQuantityBlocked("REDSTONE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"REDSTONE");
                    break;
                case GUNPOWDER:
                    if (PriceManager.isQuantityBlocked("GUNPOWDER")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }                    if (PriceManager.isQuantityBlocked("GUNPOWDER")){
                        player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Торговец больше не" +
                                " принимает данный товар. Приходите завтра.");
                        break;
                    }
                    sellProductController(event.getClick(),player,"GUNPOWDER");
                    break;
                case ROSE_BUSH:
                    if (PriceManager.isQuantityBlocked("ROSE_BUSH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"ROSE_BUSH");
                    break;
                case CLAY_BALL:
                    if (PriceManager.isQuantityBlocked("CLAY_BALL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"CLAY_BALL");
                    break;
                case QUARTZ:
                    if (PriceManager.isQuantityBlocked("QUARTZ")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"QUARTZ");
                    break;
                case SUGAR_CANE:
                    if (PriceManager.isQuantityBlocked("SUGAR_CANE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"SUGAR_CANE");
                    break;
                case DEAD_BUSH:
                    if (PriceManager.isQuantityBlocked("DEAD_BUSH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"DEAD_BUSH");
                    break;
                case WHEAT:
                    if (PriceManager.isQuantityBlocked("WHEAT")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"WHEAT");
                    break;
                case BLAZE_POWDER:
                    if (PriceManager.isQuantityBlocked("BLAZE_POWDER")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"BLAZE_POWDER");
                    break;
                case APPLE:
                    if (PriceManager.isQuantityBlocked("APPLE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"APPLE");
                    break;
                case SUGAR:
                    if (PriceManager.isQuantityBlocked("SUGAR")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"SUGAR");
                    break;
                case DRAGON_BREATH:
                    if (PriceManager.isQuantityBlocked("DRAGON_BREATH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"DRAGON_BREATH");
                    break;
                case PHANTOM_MEMBRANE:
                    if (PriceManager.isQuantityBlocked("PHANTOM_MEMBRANE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"PHANTOM_MEMBRANE");
                    break;
                case MELON_SLICE:
                    if (PriceManager.isQuantityBlocked("MELON_SLICE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"MELON_SLICE");
                    break;
                case GLASS_BOTTLE:
                    if (PriceManager.isQuantityBlocked("GLASS_BOTTLE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"GLASS_BOTTLE");
                    break;
                case INK_SAC:
                    if (PriceManager.isQuantityBlocked("INK_SAC")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"INK_SAC");
                    break;
                case SWEET_BERRIES:
                    if (PriceManager.isQuantityBlocked("SWEET_BERRIES")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"SWEET_BERRIES");
                    break;
                case WHEAT_SEEDS:
                    if (PriceManager.isQuantityBlocked("WHEAT_SEEDS")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"WHEAT_SEEDS");
                    break;
                case COOKED_COD:
                    if (PriceManager.isQuantityBlocked("COOKED_COD")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"COOKED_COD");
                    break;
                case SPIDER_EYE:
                    if (PriceManager.isQuantityBlocked("SPIDER_EYE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"SPIDER_EYE");
                    break;
                case COBBLESTONE:
                    if (PriceManager.isQuantityBlocked("COBBLESTONE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"COBBLESTONE");
                    break;
                case MAGMA_BLOCK:
                    if (PriceManager.isQuantityBlocked("MAGMA_BLOCK")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"MAGMA_BLOCK");
                    break;
                case STRING:
                    if (PriceManager.isQuantityBlocked("STRING")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"STRING");
                    break;
                case SAND:
                    if (PriceManager.isQuantityBlocked("SAND")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"SAND");
                    break;
                case COAL:
                    if (PriceManager.isQuantityBlocked("COAL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"COAL");
                    break;
                case ARROW:
                    if (PriceManager.isQuantityBlocked("ARROW")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"ARROW");
                    break;
                case ROTTEN_FLESH:
                    if (PriceManager.isQuantityBlocked("ROTTEN_FLESH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"ROTTEN_FLESH");
                    break;
                case DRIED_KELP:
                    if (PriceManager.isQuantityBlocked("DRIED_KELP")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"DRIED_KELP");
                    break;
                case WARPED_PLANKS:
                    if (PriceManager.isQuantityBlocked("WARPED_PLANKS")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"WARPED_PLANKS");
                    break;
                case HONEY_BOTTLE:
                    if (PriceManager.isQuantityBlocked("HONEY_BOTTLE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"HONEY_BOTTLE");
                    break;
                case RAIL:
                    if (PriceManager.isQuantityBlocked("RAIL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"RAIL");
                    break;
                case SHULKER_SHELL:
                    if (PriceManager.isQuantityBlocked("SHULKER_SHELL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"SHULKER_SHELL");
                    break;
                case BONE:
                    if (PriceManager.isQuantityBlocked("BONE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"BONE");
                    break;
                case COPPER_BLOCK:
                    if (PriceManager.isQuantityBlocked("COPPER_BLOCK")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"COPPER_BLOCK");
                    break;
                case DIORITE_STAIRS:
                    if (PriceManager.isQuantityBlocked("DIORITE_STAIRS")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"DIORITE_STAIRS");
                    break;
                case SALMON:
                    if (PriceManager.isQuantityBlocked("SALMON")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"SALMON");
                    break;
                case PUFFERFISH:
                    if (PriceManager.isQuantityBlocked("PUFFERFISH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"PUFFERFISH");
                    break;
                case TROPICAL_FISH:
                    if (PriceManager.isQuantityBlocked("TROPICAL_FISH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"TROPICAL_FISH");
                    break;
                case BOWL:
                    if (PriceManager.isQuantityBlocked("BOWL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"BOWL");
                    break;
                case LEATHER:
                    if (PriceManager.isQuantityBlocked("LEATHER")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"LEATHER");
                    break;
                case MOSS_BLOCK:
                    if (PriceManager.isQuantityBlocked("MOSS_BLOCK")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"MOSS_BLOCK");
                    break;
                case TUBE_CORAL:
                    if (PriceManager.isQuantityBlocked("TUBE_CORAL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"TUBE_CORAL");
                    break;
                case DIAMOND:
                    if (PriceManager.isQuantityBlocked("DIAMOND")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"DIAMOND");
                    break;
                case BLAZE_ROD:
                    if (PriceManager.isQuantityBlocked("BLAZE_ROD")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"BLAZE_ROD");
                    break;
                case TNT:
                    if (PriceManager.isQuantityBlocked("TNT")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"TNT");
                    break;
                case BRICK:
                    if (PriceManager.isQuantityBlocked("BRICK")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"BRICK");
                    break;
                case GOLD_NUGGET:
                    if (PriceManager.isQuantityBlocked("GOLD_NUGGET")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"GOLD_NUGGET");
                    break;
                case ZOMBIE_HEAD:
                    if (PriceManager.isQuantityBlocked("ZOMBIE_HEAD")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"ZOMBIE_HEAD");
                    break;
                case HEART_OF_THE_SEA:
                    if (PriceManager.isQuantityBlocked("HEART_OF_THE_SEA")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"HEART_OF_THE_SEA");
                    break;
                case TOTEM_OF_UNDYING:
                    if (PriceManager.isQuantityBlocked("TOTEM_OF_UNDYING")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"TOTEM_OF_UNDYING");
                    break;
                case SCULK:
                    if (PriceManager.isQuantityBlocked("SCULK")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    sellProductController(event.getClick(),player,"SCULK");
            }
            event.setCancelled(true);
        }

    }

}
