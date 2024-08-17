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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Material.CLAY_BALL;

public class SellerInteract implements Listener {

    private static void ProductBlocked(Player player, Inventory inventory,int slot) {
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY+"Недоступно");
        item.setItemMeta(meta);

        player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Торговец больше не" +
                " принимает данный товар. Приходите завтра.");
        inventory.setItem(slot,item);
    }

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    private void sellProduct(Player player,String ProductType, int amount){
        PriceManager.addSoldQuantity(ProductType,amount);
        PriceManager.priceChecker(ProductType);
        player.getInventory().removeItem(new ItemStack(Material.valueOf(ProductType), amount));
        PlayerStats.addEarnedPlayerStats(player.getUniqueId(),ProductType,amount);
        if(amount == 1) {
            EconomyManager.giveMoney(player, PriceManager.getCurrentPrice(ProductType));
        }
        if(amount == 64) {
            EconomyManager.giveMoney(player, PriceManager.getCurrentPriceFor64(ProductType));
        }
        SellerInventory.loadMetaForGeneratedDefaultItems();
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        if(event.getView().getTitle().equals(ChatColor.DARK_GRAY+"Скупщик")){
            Player player = (Player) event.getWhoClicked();
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                    break;
                case PAPER:
                    player.openInventory(InfoInventory.inventory);
                    player.playSound(player.getLocation(),Sound.BLOCK_ENCHANTMENT_TABLE_USE,3,0);
                    break;
                case CHEST_MINECART:
                    if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")) {
                        if (!MySQLManager.isConnected()) {
                            player.closeInventory();
                            LoadScreen.openLoadInventory(player);
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
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 1)) {
                            sellProduct(player,"REDSTONE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. красной пыли.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 64)) {
                            sellProduct(player,"REDSTONE",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. красной пыли.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
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
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.GUNPOWDER), 1)) {
                            sellProduct(player,"GUNPOWDER",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. пороха.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.GUNPOWDER), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.GUNPOWDER), 64)) {
                            sellProduct(player,"GUNPOWDER",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. пороха.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.GUNPOWDER), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case ROSE_BUSH:
                    if (PriceManager.isQuantityBlocked("ROSE_BUSH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.ROSE_BUSH), 1)) {
                            sellProduct(player,"ROSE_BUSH",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. розы.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.ROSE_BUSH), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.ROSE_BUSH), 64)) {
                            sellProduct(player, "ROSE_BUSH", 64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. розы.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.ROSE_BUSH), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                case CLAY_BALL:
                    if (PriceManager.isQuantityBlocked("CLAY_BALL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(CLAY_BALL), 1)) {
                            sellProduct(player,"CLAY_BALL",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. глины.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(CLAY_BALL), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(CLAY_BALL), 64)) {
                            sellProduct(player,"CLAY_BALL",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. глины.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(CLAY_BALL), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case QUARTZ:
                    if (PriceManager.isQuantityBlocked("QUARTZ")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.QUARTZ), 1)) {
                            sellProduct(player,"QUARTZ",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. квартца.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.QUARTZ), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.QUARTZ), 64)) {
                            sellProduct(player,"QUARTZ",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. квартца.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.QUARTZ), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case SUGAR_CANE:
                    if (PriceManager.isQuantityBlocked("SUGAR_CANE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 1)) {
                            sellProduct(player,"SUGAR_CANE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. тростника.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 64)) {
                            sellProduct(player,"SUGAR_CANE",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. тростника.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR_CANE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case DEAD_BUSH:
                    if (PriceManager.isQuantityBlocked("DEAD_BUSH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.DEAD_BUSH), 1)) {
                            sellProduct(player,"DEAD_BUSH",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. мёртвого куста.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DEAD_BUSH), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.DEAD_BUSH), 64)) {
                            sellProduct(player,"DEAD_BUSH",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. мёртвых кустов.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DEAD_BUSH), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case WHEAT:
                    if (PriceManager.isQuantityBlocked("WHEAT")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 1)) {
                            sellProduct(player,"WHEAT",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. пшеницы.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 64)) {
                            sellProduct(player,"WHEAT",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. пшеницы.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case BLAZE_POWDER:
                    if (PriceManager.isQuantityBlocked("BLAZE_POWDER")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_POWDER), 1)) {
                            sellProduct(player,"BLAZE_POWDER",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. порошка блейза.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_POWDER), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_POWDER), 64)) {
                            sellProduct(player,"BLAZE_POWDER",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. порошка блейза.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.BLAZE_POWDER), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case APPLE:
                    if (PriceManager.isQuantityBlocked("APPLE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 1)) {
                            sellProduct(player,"APPLE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. яблок.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 64)) {
                            sellProduct(player,"APPLE",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. яблок.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case SUGAR:
                    if (PriceManager.isQuantityBlocked("SUGAR")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR), 1)) {
                            sellProduct(player,"SUGAR",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. сахара.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR), 64)) {
                           sellProduct(player,"SUGAR",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. сахара.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SUGAR), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }

                    }
                    break;
                case DRAGON_BREATH:
                    if (PriceManager.isQuantityBlocked("DRAGON_BREATH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.DRAGON_BREATH), 1)) {
                           sellProduct(player,"DRAGON_BREATH",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. дыхания дракона.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DRAGON_BREATH), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.DRAGON_BREATH), 64)) {
                            sellProduct(player,"DRAGON_BREATH",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. дыхания дракона.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DRAGON_BREATH), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case PHANTOM_MEMBRANE:
                    if (PriceManager.isQuantityBlocked("PHANTOM_MEMBRANE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.PHANTOM_MEMBRANE), 1)) {
                            sellProduct(player,"PHANTOM_MEMBRANE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. мембраны фантома.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.PHANTOM_MEMBRANE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.PHANTOM_MEMBRANE), 64)) {
                            sellProduct(player,"PHANTOM_MEMBRANE",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. мембраны фантома.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.PHANTOM_MEMBRANE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case MELON_SLICE:
                    if (PriceManager.isQuantityBlocked("MELON_SLICE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.MELON_SLICE), 1)) {
                            sellProduct(player,"MELON_SLICE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. арбуза.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.MELON_SLICE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.MELON_SLICE), 64)) {
                            sellProduct(player,"MELON_SLICE",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. арбуза.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.MELON_SLICE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case GLASS_BOTTLE:
                    if (PriceManager.isQuantityBlocked("GLASS_BOTTLE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.GLASS_BOTTLE), 1)) {
                            sellProduct(player,"GLASS_BOTTLE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. пустого пузырька.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.GLASS_BOTTLE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.GLASS_BOTTLE), 64)) {
                            sellProduct(player,"GLASS_BOTTLE",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. пустого пузырька.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.GLASS_BOTTLE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case INK_SAC:
                    if (PriceManager.isQuantityBlocked("INK_SAC")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.INK_SAC), 1)) {
                            sellProduct(player,"INK_SAC",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. чернил.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.INK_SAC), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.INK_SAC), 64)) {
                            sellProduct(player,"INK_SAC",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. чернил.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.INK_SAC), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case SWEET_BERRIES:
                    if (PriceManager.isQuantityBlocked("SWEET_BERRIES")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SWEET_BERRIES), 1)) {
                            sellProduct(player,"SWEET_BERRIES",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. ягод.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SWEET_BERRIES), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SWEET_BERRIES), 64)) {
                            sellProduct(player,"SWEET_BERRIES",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. ягод.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SWEET_BERRIES), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case WHEAT_SEEDS:
                    if (PriceManager.isQuantityBlocked("WHEAT_SEEDS")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT_SEEDS), 1)) {
                            sellProduct(player,"WHEAT_SEEDS",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. семян пшеницы.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT_SEEDS), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT_SEEDS), 64)) {
                            sellProduct(player,"WHEAT_SEEDS",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. семян пшеницы.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WHEAT_SEEDS), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case COOKED_COD:
                    if (PriceManager.isQuantityBlocked("COOKED_COD")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.COOKED_COD), 1)) {
                            sellProduct(player,"COOKED_COD",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. COOKED_COD.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.COOKED_COD), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.COOKED_COD), 64)) {
                            sellProduct(player,"COOKED_COD",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. COOKED_COD.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.COOKED_COD), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case SPIDER_EYE:
                    if (PriceManager.isQuantityBlocked("SPIDER_EYE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if(event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SPIDER_EYE), 1)) {
                            sellProduct(player,"SPIDER_EYE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. SPIDER_EYE.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SPIDER_EYE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SPIDER_EYE), 64)) {
                            sellProduct(player,"SPIDER_EYE",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. SPIDER_EYE.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SPIDER_EYE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case COBBLESTONE:
                    if (PriceManager.isQuantityBlocked("COBBLESTONE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 1)) {
                            sellProduct(player,"COBBLESTONE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. булыжника.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (event.getClick().isLeftClick()) {
                            if (player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 64)) {
                                sellProduct(player,"COBBLESTONE",64);
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. булыжника.");
                            }
                            if (!player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 64)) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                    }
                    break;
                case MAGMA_BLOCK:
                    if (PriceManager.isQuantityBlocked("MAGMA_BLOCK")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.MAGMA_BLOCK), 1)) {
                            sellProduct(player,"MAGMA_BLOCK",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. магмы.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.MAGMA_BLOCK), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.MAGMA_BLOCK), 64)) {
                            sellProduct(player,"MAGMA_BLOCK",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. магмы.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.MAGMA_BLOCK), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case STRING:
                    if (PriceManager.isQuantityBlocked("STRING")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.STRING), 1)) {
                            sellProduct(player,"STRING",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. нити.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.STRING), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.STRING), 64)) {
                            sellProduct(player,"STRING",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. нити.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.STRING), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case SAND:
                    if (PriceManager.isQuantityBlocked("SAND")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SAND), 1)) {
                            sellProduct(player,"SAND",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. песка.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SAND), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SAND), 64)) {
                            sellProduct(player,"SAND",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. песка.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SAND), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case COAL:
                    if (PriceManager.isQuantityBlocked("COAL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.COAL), 1)) {
                           sellProduct(player,"COAL",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. угля.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.COAL), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.COAL), 64)) {
                            sellProduct(player,"COAL",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. угля.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.COAL), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case ARROW:
                    if (PriceManager.isQuantityBlocked("ARROW")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 1)) {
                            sellProduct(player,"ARROW",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 стрелу.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 64)) {
                           sellProduct(player,"ARROW",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 стрелы.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case ROTTEN_FLESH:
                    if (PriceManager.isQuantityBlocked("ROTTEN_FLESH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 1)) {
                            sellProduct(player,"ROTTEN_FLESH",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. ROTTEN_FLESH.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 64)) {
                            sellProduct(player,"ROTTEN_FLESH",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. ROTTEN_FLESH.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case DRIED_KELP:
                    if (PriceManager.isQuantityBlocked("DRIED_KELP")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.DRIED_KELP), 1)) {
                            sellProduct(player,"DRIED_KELP",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. DRIED_KELP.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DRIED_KELP), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.DRIED_KELP), 64)) {
                            sellProduct(player,"DRIED_KELP",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. DRIED_KELP.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DRIED_KELP), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case WARPED_PLANKS:
                    if (PriceManager.isQuantityBlocked("WARPED_PLANKS")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.WARPED_PLANKS), 1)) {
                            sellProduct(player,"WARPED_PLANKS",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. WARPED_PLANKS.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WARPED_PLANKS), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.WARPED_PLANKS), 64)) {
                            sellProduct(player,"WARPED_PLANKS",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. WARPED_PLANKS.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.WARPED_PLANKS), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case HONEY_BOTTLE:
                    if (PriceManager.isQuantityBlocked("HONEY_BOTTLE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.HONEY_BOTTLE), 1)) {
                            sellProduct(player,"HONEY_BOTTLE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. HONEY_BOTTLE.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.HONEY_BOTTLE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (event.getClick().isLeftClick()) {
                            if (player.getInventory().containsAtLeast(new ItemStack(Material.HONEY_BOTTLE), 64)) {
                                sellProduct(player,"HONEY_BOTTLE",64);
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. HONEY_BOTTLE.");
                            }
                            if (!player.getInventory().containsAtLeast(new ItemStack(Material.HONEY_BOTTLE), 64)) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                    }
                    break;
                case RAIL:
                    if (PriceManager.isQuantityBlocked("RAIL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.RAIL), 1)) {
                            sellProduct(player,"RAIL",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. RAIL.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.RAIL), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.RAIL), 64)) {
                            sellProduct(player,"RAIL",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. RAIL.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.RAIL), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case SHULKER_SHELL:
                    if (PriceManager.isQuantityBlocked("SHULKER_SHELL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 1)) {
                            sellProduct(player,"SHULKER_SHELL",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. SHULKER_SHELL.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (event.getClick().isLeftClick()) {
                            if (player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 64)) {
                                sellProduct(player,"SHULKER_SHELL",64);
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. SHULKER_SHELL.");
                            }
                            if (!player.getInventory().containsAtLeast(new ItemStack(Material.SHULKER_SHELL), 64)) {
                                player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                            }
                        }
                    }
                    break;
                case BONE:
                    if (PriceManager.isQuantityBlocked("BONE")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.BONE), 1)) {
                            sellProduct(player,"BONE",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. BONE.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.BONE), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.BONE), 64)) {
                            sellProduct(player,"BONE",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. BONE.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.BONE), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case COPPER_BLOCK:
                    if (PriceManager.isQuantityBlocked("COPPER_BLOCK")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.COPPER_BLOCK), 1)) {
                            sellProduct(player,"COPPER_BLOCK",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. COPPER_BLOCK.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.COPPER_BLOCK), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.COPPER_BLOCK), 64)) {
                            sellProduct(player,"COPPER_BLOCK",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. COPPER_BLOCK.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.COPPER_BLOCK), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case DIORITE_STAIRS:
                    if (PriceManager.isQuantityBlocked("DIORITE_STAIRS")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.DIORITE_STAIRS), 1)) {
                            sellProduct(player,"DIORITE_STAIRS",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. DIORITE_STAIRS.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIORITE_STAIRS), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.DIORITE_STAIRS), 64)) {
                            sellProduct(player,"DIORITE_STAIRS",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. DIORITE_STAIRS.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIORITE_STAIRS), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case SALMON:
                    if (PriceManager.isQuantityBlocked("SALMON")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SALMON), 1)) {
                            sellProduct(player,"SALMON",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. SALMON.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SALMON), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SALMON), 64)) {
                            sellProduct(player,"SALMON",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. SALMON.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.SALMON), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case PUFFERFISH:
                    if (PriceManager.isQuantityBlocked("PUFFERFISH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.PUFFERFISH), 1)) {
                            sellProduct(player,"PUFFERFISH",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. PUFFERFISH.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.PUFFERFISH), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.PUFFERFISH), 64)) {
                            sellProduct(player,"PUFFERFISH",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. PUFFERFISH.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.PUFFERFISH), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case TROPICAL_FISH:
                    if (PriceManager.isQuantityBlocked("TROPICAL_FISH")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.TROPICAL_FISH), 1)) {
                            sellProduct(player,"TROPICAL_FISH",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. TROPICAL_FISH.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.TROPICAL_FISH), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.TROPICAL_FISH), 64)) {
                            sellProduct(player,"TROPICAL_FISH",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. TROPICAL_FISH.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.TROPICAL_FISH), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case BOWL:
                    if (PriceManager.isQuantityBlocked("BOWL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.BOWL), 1)) {
                            sellProduct(player,"BOWL",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. BOWL.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.BOWL), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.BOWL), 64)) {
                            sellProduct(player,"BOWL",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. BOWL.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.BOWL), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case LEATHER:
                    if (PriceManager.isQuantityBlocked("LEATHER")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.LEATHER), 1)) {
                            sellProduct(player,"LEATHER",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. LEATHER.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.LEATHER), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.LEATHER), 64)) {
                            sellProduct(player,"LEATHER",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. LEATHER.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.LEATHER), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case MOSS_BLOCK:
                    if (PriceManager.isQuantityBlocked("MOSS_BLOCK")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.MOSS_BLOCK), 1)) {
                            sellProduct(player,"MOSS_BLOCK",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. MOSS_BLOCK.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.MOSS_BLOCK), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.MOSS_BLOCK), 64)) {
                            sellProduct(player,"MOSS_BLOCK",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. MOSS_BLOCK.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.MOSS_BLOCK), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
                case TUBE_CORAL:
                    if (PriceManager.isQuantityBlocked("TUBE_CORAL")){
                        ProductBlocked(player,event.getInventory(),event.getSlot());
                        break;
                    }
                    if (event.getClick().isRightClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.TUBE_CORAL), 1)) {
                            sellProduct(player,"TUBE_CORAL",1);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 1 шт. TUBE_CORAL.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.TUBE_CORAL), 1)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    if (event.getClick().isLeftClick()) {
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.TUBE_CORAL), 64)) {
                            sellProduct(player,"TUBE_CORAL",64);
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "Вы продали 64 шт. TUBE_CORAL.");
                        }
                        if (!player.getInventory().containsAtLeast(new ItemStack(Material.TUBE_CORAL), 64)) {
                            player.sendMessage(ChatColor.GRAY + "[Система] " + ChatColor.WHITE + "У вас нет данного предмета.");
                        }
                    }
                    break;
            }
            event.setCancelled(true);
        }

    }

}
