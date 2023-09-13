package com.aviloo.myscoreboard.Inventories;

import com.aviloo.myscoreboard.Utils.StatisticManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class StatisticInteract implements Listener {

    private final static ConcurrentHashMap<UUID,Boolean> is_first_slot_select = new ConcurrentHashMap<>();

    private final static ConcurrentHashMap<UUID,Boolean> is_second_slot_select = new ConcurrentHashMap<>();

    private final static ConcurrentHashMap<UUID,Boolean> is_third_slot_select = new ConcurrentHashMap<>();

    public static void setSlotSelectionToDefault(Player player){
        is_first_slot_select.put(player.getUniqueId(),false);
        is_second_slot_select.put(player.getUniqueId(),false);
        is_third_slot_select.put(player.getUniqueId(),false);
    }

    public static String getSlotName(int slot,Player player){
        if(slot == 1) {
            if (is_first_slot_select.get(player.getUniqueId())) {
                return ChatColor.GRAY + "[Выбранно]";
            }
            if(!is_first_slot_select.get(player.getUniqueId())){
                return ChatColor.GRAY+ "[Стандартный выбор]";
            }
        }
        if(slot == 2){
            if (is_second_slot_select.get(player.getUniqueId())) {
                return ChatColor.GRAY + "[Выбранно]";
            }
            if(!is_second_slot_select.get(player.getUniqueId())){
                return ChatColor.GRAY+ "[Стандартный выбор]";
            }
        }
        if(slot == 3){
            if (is_third_slot_select.get(player.getUniqueId())) {
                return ChatColor.GRAY + "[Выбранно]";
            }
            if(!is_third_slot_select.get(player.getUniqueId())){
                return ChatColor.GRAY+ "[Стандартный выбор]";
            }
        }

        return ChatColor.GRAY+"[Пусто]";
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
                    player.closeInventory();
                    player.openInventory(StatisticInventory.getInv(player));
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
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"kills");
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"kills");
                                break;
                            }else {
                               player.closeInventory();
                               player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                               break;
                            }
                        case 2:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"deaths");
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"deaths");
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"deaths");
                                break;
                            }else {
                                player.closeInventory();
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 3:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"hours");
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"hours");
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"hours");
                                break;
                            }else {
                                player.closeInventory();
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 4:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"ping");
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"ping");
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"ping");
                                break;
                            }else {
                                player.closeInventory();
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 5:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"mobs_killed");
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"mobs_killed");
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"mobs_killed");
                                break;
                            }else {
                                player.closeInventory();
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 6:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"blocks_break");
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"blocks_break");
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"blocks_break");
                                break;
                            }else {
                                player.closeInventory();
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 7:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"clan_name");
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"clan_name");
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"clan_name");
                                break;
                            }else {
                                player.closeInventory();
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 8:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"kills_deaths");
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"kills_deaths");
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"kills_deaths");
                                break;
                            }else {
                                player.closeInventory();
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                        case 9:
                            if(!is_first_slot_select.get(player.getUniqueId())){
                                is_first_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setFirst_slot(player,"movement_speed");
                                break;
                            }
                            if(!is_second_slot_select.get(player.getUniqueId())){
                                is_second_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setSecond_slot(player,"movement_speed");
                                break;
                            }
                            if(!is_third_slot_select.get(player.getUniqueId())){
                                is_third_slot_select.put(player.getUniqueId(),true);
                                StatisticManager.setThird_slot(player,"movement_speed");
                                break;
                            }else {
                                player.closeInventory();
                                player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Все слоты заняты.");
                                break;
                            }
                    }
            }
            event.setCancelled(true);
        }

    }

}
