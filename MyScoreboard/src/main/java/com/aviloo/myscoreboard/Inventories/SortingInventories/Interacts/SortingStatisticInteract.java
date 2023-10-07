package com.aviloo.myscoreboard.Inventories.SortingInventories.Interacts;

import com.aviloo.myscoreboard.Inventories.CustomInventory;
import com.aviloo.myscoreboard.Inventories.SortingInventories.SortingStatisticInventory;
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

public class SortingStatisticInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Тэги типа: «Статистика»")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.openInventory(StatisticInventory.getInv(player));
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case STRUCTURE_VOID:
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                    StatisticManager.resetSlot(player);
                    player.closeInventory();
                    player.openInventory(SortingStatisticInventory.getInv(player));
                    break;
                case TRAPPED_CHEST:
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                    player.openInventory(SortingInventory.getInv(player));
                    break;
                case CONDUIT:
                    switch (event.getCurrentItem().getAmount()){
                        case 1:
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"kills");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"kills");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"kills");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 2:
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"deaths");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"deaths");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"deaths");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 3:
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"hours");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"hours");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"hours");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 4:
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
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"mobs_killed");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"mobs_killed");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"mobs_killed");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 5:
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
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"blocks_break");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"blocks_break");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"blocks_break");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }else {
                                player.closeInventory();
                                player.playSound(player.getLocation(),Sound.ENTITY_VILLAGER_NO,3,0);
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 6:
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
                            if(!StatisticInteract.is_first_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_first_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setFirst_slot(player,"kills_deaths");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_second_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_second_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setSecond_slot(player,"kills_deaths");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
                                break;
                            }
                            if(!StatisticInteract.is_third_slot_select.get(player.getUniqueId())){
                                StatisticInteract.is_third_slot_select.put(player.getUniqueId(),true);
                                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK,3,0);
                                StatisticManager.setThird_slot(player,"kills_deaths");
                                StatisticInteract.updateInventory(player,SortingStatisticInventory.getInv(player));
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
