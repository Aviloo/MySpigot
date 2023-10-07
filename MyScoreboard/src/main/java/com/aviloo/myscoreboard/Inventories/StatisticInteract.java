package com.aviloo.myscoreboard.Inventories;

import com.aviloo.myscoreboard.Utils.ColorUtils;
import com.aviloo.myscoreboard.Utils.EconomyManager;
import com.aviloo.myscoreboard.Utils.ShoppingUtil;
import com.aviloo.myscoreboard.Utils.StatisticManager;
import com.aviloo.myscoreboard.models.PlayerTags;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class StatisticInteract implements Listener {

    public static void updateInventory(Player player,Inventory inv){
        player.closeInventory();
        player.openInventory(inv);
    }

    public final static ConcurrentHashMap<UUID,Boolean> is_first_slot_select = new ConcurrentHashMap<>();

    public final static ConcurrentHashMap<UUID,Boolean> is_second_slot_select = new ConcurrentHashMap<>();

    public final static ConcurrentHashMap<UUID,Boolean> is_third_slot_select = new ConcurrentHashMap<>();

    public static void setSlotSelectionToDefault(Player player){
        is_first_slot_select.put(player.getUniqueId(),false);
        is_second_slot_select.put(player.getUniqueId(),false);
        is_third_slot_select.put(player.getUniqueId(),false);
    }

    public static String getSlotName(int slot,Player player){
        if(slot == 1) {
            if (is_first_slot_select.get(player.getUniqueId())) {
                return ChatColor.DARK_GRAY + "[Выбранно]";
            }
            if(!is_first_slot_select.get(player.getUniqueId())){
                return ChatColor.DARK_GRAY+ "[Стандартный выбор]";
            }
        }
        if(slot == 2){
            if (is_second_slot_select.get(player.getUniqueId())) {
                return ChatColor.DARK_GRAY + "[Выбранно]";
            }
            if(!is_second_slot_select.get(player.getUniqueId())){
                return ChatColor.DARK_GRAY+ "[Стандартный выбор]";
            }
        }
        if(slot == 3){
            if (is_third_slot_select.get(player.getUniqueId())) {
                return ChatColor.DARK_GRAY + "[Выбранно]";
            }
            if(!is_third_slot_select.get(player.getUniqueId())){
                return ChatColor.DARK_GRAY+ "[Стандартный выбор]";
            }
        }

        return ChatColor.DARK_GRAY+"[Пусто]";
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Статистика")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                    player.openInventory(CustomInventory.getInv(player));
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case STRUCTURE_VOID:
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                    StatisticManager.resetSlot(player);
                    updateInventory(player,StatisticInventory.getInv(player));
                    break;
                case TRAPPED_CHEST:
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                    player.openInventory(SortingInventory.getInv(player));
                    break;
                case CONDUIT:
                    switch (event.getCurrentItem().getAmount()){
                        case 1:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"kills");
                                updateInventory(player,StatisticInventory.getInv(player));
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"kills");
                                updateInventory(player,StatisticInventory.getInv(player));
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"kills");
                                updateInventory(player,StatisticInventory.getInv(player));
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                break;
                            }else {
                               player.closeInventory();
                               player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                               player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                               break;
                            }
                        case 2:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"deaths");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"deaths");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"deaths");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 3:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"hours");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"hours");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"hours");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 4:
                            if(!PlayerTags.isPingTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 500.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"ping");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"ping");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"ping");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"ping");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 5:
                            if(!PlayerTags.isMobs_killedTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 700.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"mobs_killed");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"mobs_killed");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"mobs_killed");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"mobs_killed");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 6:
                            if(!PlayerTags.isBlocks_breakTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 700.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"blocks_break");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"blocks_break");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"blocks_break");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"blocks_break");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 7:
                            if(!PlayerTags.isCoordsTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 500.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"coords");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"coords");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"coords");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"coords");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 8:
                            if(!PlayerTags.isKills_deathsTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 700.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"kills_deaths");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"kills_deaths");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"kills_deaths");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"kills_deaths");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 9:
                            if(!PlayerTags.isHand_durabilityTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 900.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"hand_durability");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"hand_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"hand_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"hand_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 10:
                            if(!PlayerTags.isTotem_countTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 900.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"totem_count");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"totem_count");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"totem_count");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"totem_count");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 11:
                            if(!PlayerTags.isHelmet_durabilityTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 900.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"helmet_durability");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"helmet_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"helmet_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"helmet_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 12:
                            if(!PlayerTags.isChestplate_durabilityTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 900.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"chestplate_durability");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"chestplate_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"chestplate_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"chestplate_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 13:
                            if(!PlayerTags.isLeggings_durabilityTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 900.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"leggings_durability");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"leggings_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"leggings_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"leggings_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 14:
                            if(!PlayerTags.isBoots_durabilityTag()) {
                                if (EconomyManager.getPlayerMoney(player) < 900.0) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 0);
                                    player.closeInventory();
                                    player.sendMessage(ColorUtils.translateColorCodes(
                                            "&4[Ошибка] &fУ вас недостаточно средств."));
                                    break;
                                }
                                ShoppingUtil.addCurrentTag(player,"boots_durability");
                                ShoppingUtil.openShoppingInventory(player);
                                break;
                            }
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"boots_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"boots_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"boots_durability");
                                updateInventory(player,StatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                    }
            }
            event.setCancelled(true);
        }

    }

}
