package com.aviloo.myscoreboard.Inventories.SortingInventories.Interacts;

import com.aviloo.myscoreboard.Inventories.CustomInventory;
import com.aviloo.myscoreboard.Inventories.SortingInventories.SortingPvpInventory;
import com.aviloo.myscoreboard.Inventories.SortingInventory;
import com.aviloo.myscoreboard.Inventories.StatisticInteract;
import com.aviloo.myscoreboard.Inventories.StatisticInventory;
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

public class SortingPvpInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Тэги типа: «ПВП»")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                    player.openInventory(StatisticInventory.getInv(player));
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case STRUCTURE_VOID:
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                    StatisticManager.resetSlot(player);
                    player.closeInventory();
                    player.openInventory(SortingPvpInventory.getInv(player));
                    break;
                case TRAPPED_CHEST:
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                    player.openInventory(SortingInventory.getInv(player));
                    break;
                case CONDUIT:
                    switch (event.getCurrentItem().getAmount()){
                        case 1:
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
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"hand_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"hand_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"hand_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 2:
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
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"totem_count");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"totem_count");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"totem_count");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 3:
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
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"helmet_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"helmet_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"helmet_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 4:
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
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"chestplate_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"chestplate_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"chestplate_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 5:
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
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"leggings_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"leggings_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"leggings_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 6:
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
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"boots_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"boots_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"boots_durability");
                                StatisticInteract.updateInventory(player,SortingPvpInventory.getInv(player));
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
