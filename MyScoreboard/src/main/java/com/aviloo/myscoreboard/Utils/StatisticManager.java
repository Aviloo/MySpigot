package com.aviloo.myscoreboard.Utils;

import com.aviloo.myscoreboard.Boards.BoardManager;
import com.aviloo.myscoreboard.Inventories.StatisticInteract;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.LinkedHashMap;
import java.util.UUID;

public class StatisticManager implements Listener {

    private static final LinkedHashMap<UUID,String> first_slot = new LinkedHashMap<>();

    public static void setFirst_slot(Player player, String value){
        first_slot.put(player.getUniqueId(),value);
    }
    public static String getFirst_slot(Player player){
        return first_slot.get(player.getUniqueId());
    }

    private static final LinkedHashMap<UUID,String> second_slot = new LinkedHashMap<>();

    public static void setSecond_slot(Player player, String value){
        second_slot.put(player.getUniqueId(),value);
    }
    public static String getSecond_slot(Player player){
        return second_slot.get(player.getUniqueId());
    }

    private static final LinkedHashMap<UUID,String> third_slot = new LinkedHashMap<>();

    public static void setThird_slot(Player player, String value){
        third_slot.put(player.getUniqueId(),value);
    }
    public static String getThird_slot(Player player){
        return third_slot.get(player.getUniqueId());
    }


    @EventHandler (priority = EventPriority.HIGHEST,ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        first_slot.put(player.getUniqueId(),"kills");
        second_slot.put(player.getUniqueId(),"deaths");
        third_slot.put(player.getUniqueId(),"hours");
        StatisticInteract.setSlotSelectionToDefault(player);
    }

    public static String getSlot(int slot, Player player){
        if(slot == 1){
            if(BoardManager.getColor(player).equals("gray")){
                if(first_slot.get(player.getUniqueId()).equals("kills")){
                    return " Убийств: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_player_kills%");
                }
                if(first_slot.get(player.getUniqueId()).equals("deaths")){
                    return " Смертей: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_deaths%");
                }
                if(first_slot.get(player.getUniqueId()).equals("hours")){
                    return " Отыграно: &n" + PlaceholderAPI.setPlaceholders(player,"%statistic_time_played:hours%") + " ч.";
                }
                if(first_slot.get(player.getUniqueId()).equals("ping")){
                    return " Пинг: &n" + PlaceholderAPI.setPlaceholders(player, "%player_ping%");
                }
                if(first_slot.get(player.getUniqueId()).equals("mobs_killed")){
                    return " Мобов: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_mob_kills%");
                }
                if(first_slot.get(player.getUniqueId()).equals("blocks_break")){
                    return " Добыто: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_mine_block%") +" бл.";
                }
                if(first_slot.get(player.getUniqueId()).equals("coords")){
                    return coordinatesHolder(player,true);
                }
                if(first_slot.get(player.getUniqueId()).equals("kills_deaths")){
                    return " KD: &n" + killDeathsHolder(player);
                }
                if(first_slot.get(player.getUniqueId()).equals("hand_durability")){
                    if(player.getInventory().getItemInMainHand().getType().isAir()){
                        return " Прочность: &n-";
                    }
                    return " Прочность: &n" + PlaceholderAPI.setPlaceholders(player,"%player_item_in_hand_durability%");
                }
                if(first_slot.get(player.getUniqueId()).equals("totem_count")){
                    return " Тотемов: &n" +PlaceholderAPI.setPlaceholders(player,"%checkitem_amount_mat:totem_of_undying%");
                }
                if(first_slot.get(player.getUniqueId()).equals("helmet_durability")){
                    if(player.getInventory().getHelmet() == null){
                        return " Шлем: &n-";
                    }
                    return " Шлем: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_helmet_durability%");
                }
                if(first_slot.get(player.getUniqueId()).equals("chestplate_durability")){
                    if(player.getInventory().getChestplate() == null){
                        return " Нагрудник: &n-";
                    }
                    return " Нагрудник: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_chestplate_durability%");
                }
                if(first_slot.get(player.getUniqueId()).equals("leggings_durability")){
                    if(player.getInventory().getLeggings() == null){
                        return " Поножи: &n-";
                    }
                    return " Поножи: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_leggings_durability%");
                }
                if(first_slot.get(player.getUniqueId()).equals("boots_durability")){
                    if(player.getInventory().getBoots() == null){
                        return " Тапки: &n-";
                    }
                    return " Тапки: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_boots_durability%");
                }


            }else {
                if(first_slot.get(player.getUniqueId()).equals("kills")){
                    return " Убийств: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_player_kills%");
                }
                if(first_slot.get(player.getUniqueId()).equals("deaths")){
                    return " Смертей: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_deaths%");
                }
                if(first_slot.get(player.getUniqueId()).equals("hours")){
                    return " Отыграно: &7" + PlaceholderAPI.setPlaceholders(player,"%statistic_time_played:hours%") + " ч.";
                }
                if(first_slot.get(player.getUniqueId()).equals("ping")){
                    return " Пинг: &7" + PlaceholderAPI.setPlaceholders(player, "%player_ping%");
                }
                if(first_slot.get(player.getUniqueId()).equals("mobs_killed")){
                    return " Мобов: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_mob_kills%");
                }
                if(first_slot.get(player.getUniqueId()).equals("blocks_break")){
                    return " Добыто: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_mine_block%") +" бл.";
                }
                if(first_slot.get(player.getUniqueId()).equals("coords")){
                    return coordinatesHolder(player,false);
                }
                if(first_slot.get(player.getUniqueId()).equals("kills_deaths")){
                    return " KD: &7" + killDeathsHolder(player);
                }
                if(first_slot.get(player.getUniqueId()).equals("hand_durability")){
                    if(player.getInventory().getItemInMainHand().getType().isAir()){
                        return " Прочность: &7-";
                    }
                    return " Прочность: &7" + PlaceholderAPI.setPlaceholders(player,"%player_item_in_hand_durability%");
                }
                if(first_slot.get(player.getUniqueId()).equals("totem_count")){
                    return " Тотемов: &7" +PlaceholderAPI.setPlaceholders(player,"%checkitem_amount_mat:totem_of_undying%");
                }
                if(first_slot.get(player.getUniqueId()).equals("helmet_durability")){
                    if(player.getInventory().getHelmet() == null){
                        return " Шлем: &7-";
                    }
                    return " Шлем: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_helmet_durability%");
                }
                if(first_slot.get(player.getUniqueId()).equals("chestplate_durability")){
                    if(player.getInventory().getChestplate() == null){
                        return " Нагрудник: &7-";
                    }
                    return " Нагрудник: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_chestplate_durability%");
                }
                if(first_slot.get(player.getUniqueId()).equals("leggings_durability")){
                    if(player.getInventory().getLeggings() == null){
                        return " Поножи: &7-";
                    }
                    return " Поножи: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_leggings_durability%");
                }
                if(first_slot.get(player.getUniqueId()).equals("boots_durability")){
                    if(player.getInventory().getBoots() == null){
                        return " Тапки: &7-";
                    }
                    return " Тапки: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_boots_durability%");
                }

            }


        }
        if(slot == 2){
            if(BoardManager.getColor(player).equals("gray")){
                if(second_slot.get(player.getUniqueId()).equals("kills")){
                    return " Убийств: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_player_kills%");
                }
                if(second_slot.get(player.getUniqueId()).equals("deaths")){
                    return " Смертей: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_deaths%");
                }
                if(second_slot.get(player.getUniqueId()).equals("hours")){
                    return " Отыграно: &n" + PlaceholderAPI.setPlaceholders(player,"%statistic_time_played:hours%") + " ч.";
                }
                if(second_slot.get(player.getUniqueId()).equals("ping")){
                    return " Пинг: &n" + PlaceholderAPI.setPlaceholders(player, "%player_ping%");
                }
                if(second_slot.get(player.getUniqueId()).equals("mobs_killed")){
                    return " Мобов: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_mob_kills%");
                }
                if(second_slot.get(player.getUniqueId()).equals("blocks_break")){
                    return " Добыто: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_mine_block%") +" бл.";
                }
                if(second_slot.get(player.getUniqueId()).equals("coords")){
                    return coordinatesHolder(player,true);
                }
                if(second_slot.get(player.getUniqueId()).equals("kills_deaths")){
                    return " KD: &n" + killDeathsHolder(player);
                }
                if(second_slot.get(player.getUniqueId()).equals("hand_durability")){
                    if(player.getInventory().getItemInMainHand().getType().isAir()){
                        return " Прочность: &n-";
                    }
                    return " Прочность: &n" + PlaceholderAPI.setPlaceholders(player,"%player_item_in_hand_durability%");
                }
                if(second_slot.get(player.getUniqueId()).equals("totem_count")){
                    return " Тотемов: &n" +PlaceholderAPI.setPlaceholders(player,"%checkitem_amount_mat:totem_of_undying%");
                }
                if(second_slot.get(player.getUniqueId()).equals("helmet_durability")){
                    if(player.getInventory().getHelmet() == null){
                        return " Шлем: &n-";
                    }
                    return " Шлем: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_helmet_durability%");
                }
                if(second_slot.get(player.getUniqueId()).equals("chestplate_durability")){
                    if(player.getInventory().getChestplate() == null){
                        return " Нагрудник: &n-";
                    }
                    return " Нагрудник: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_chestplate_durability%");
                }
                if(second_slot.get(player.getUniqueId()).equals("leggings_durability")){
                    if(player.getInventory().getLeggings() == null){
                        return " Поножи: &n-";
                    }
                    return " Поножи: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_leggings_durability%");
                }
                if(second_slot.get(player.getUniqueId()).equals("boots_durability")){
                    if(player.getInventory().getBoots() == null){
                        return " Тапки: &n-";
                    }
                    return " Тапки: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_boots_durability%");
                }


            }else {
                if(second_slot.get(player.getUniqueId()).equals("kills")){
                    return " Убийств: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_player_kills%");
                }
                if(second_slot.get(player.getUniqueId()).equals("deaths")){
                    return " Смертей: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_deaths%");
                }
                if(second_slot.get(player.getUniqueId()).equals("hours")){
                    return " Отыграно: &7" + PlaceholderAPI.setPlaceholders(player,"%statistic_time_played:hours%") + " ч.";
                }
                if(second_slot.get(player.getUniqueId()).equals("ping")){
                    return " Пинг: &7" + PlaceholderAPI.setPlaceholders(player, "%player_ping%");
                }
                if(second_slot.get(player.getUniqueId()).equals("mobs_killed")){
                    return " Мобов: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_mob_kills%");
                }
                if(second_slot.get(player.getUniqueId()).equals("blocks_break")){
                    return " Добыто: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_mine_block%") +" бл.";
                }
                if(second_slot.get(player.getUniqueId()).equals("coords")){
                    return coordinatesHolder(player,false);
                }
                if(second_slot.get(player.getUniqueId()).equals("kills_deaths")){
                    return " KD: &7" + killDeathsHolder(player);
                }
                if(second_slot.get(player.getUniqueId()).equals("hand_durability")){
                    if(player.getInventory().getItemInMainHand().getType().isAir()){
                        return " Прочность: &7-";
                    }
                    return " Прочность: &7" + PlaceholderAPI.setPlaceholders(player,"%player_item_in_hand_durability%");
                }
                if(second_slot.get(player.getUniqueId()).equals("totem_count")){
                    return " Тотемов: &7" +PlaceholderAPI.setPlaceholders(player,"%checkitem_amount_mat:totem_of_undying%");
                }
                if(second_slot.get(player.getUniqueId()).equals("helmet_durability")){
                    if(player.getInventory().getHelmet() == null){
                        return " Шлем: &7-";
                    }
                    return " Шлем: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_helmet_durability%");
                }
                if(second_slot.get(player.getUniqueId()).equals("chestplate_durability")){
                    if(player.getInventory().getChestplate() == null){
                        return " Нагрудник: &7-";
                    }
                    return " Нагрудник: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_chestplate_durability%");
                }
                if(second_slot.get(player.getUniqueId()).equals("leggings_durability")){
                    if(player.getInventory().getLeggings() == null){
                        return " Поножи: &7-";
                    }
                    return " Поножи: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_leggings_durability%");
                }
                if(second_slot.get(player.getUniqueId()).equals("boots_durability")){
                    if(player.getInventory().getBoots() == null){
                        return " Тапки: &7-";
                    }
                    return " Тапки: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_boots_durability%");
                }

            }

        }
        if(slot == 3){
            if(BoardManager.getColor(player).equals("gray")){
                if(third_slot.get(player.getUniqueId()).equals("kills")){
                    return " Убийств: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_player_kills%");
                }
                if(third_slot.get(player.getUniqueId()).equals("deaths")){
                    return " Смертей: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_deaths%");
                }
                if(third_slot.get(player.getUniqueId()).equals("hours")){
                    return " Отыграно: &n" + PlaceholderAPI.setPlaceholders(player,"%statistic_time_played:hours%") + " ч.";
                }
                if(third_slot.get(player.getUniqueId()).equals("ping")){
                    return " Пинг: &n" + PlaceholderAPI.setPlaceholders(player, "%player_ping%");
                }
                if(third_slot.get(player.getUniqueId()).equals("mobs_killed")){
                    return " Мобов: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_mob_kills%");
                }
                if(third_slot.get(player.getUniqueId()).equals("blocks_break")){
                    return " Добыто: &n" + PlaceholderAPI.setPlaceholders(player, "%statistic_mine_block%") +" бл.";
                }
                if(third_slot.get(player.getUniqueId()).equals("coords")){
                    return coordinatesHolder(player,true);
                }
                if(third_slot.get(player.getUniqueId()).equals("kills_deaths")){
                    return " KD: &n" + killDeathsHolder(player);
                }
                if(third_slot.get(player.getUniqueId()).equals("hand_durability")){
                    if(player.getInventory().getItemInMainHand().getType().isAir()){
                        return " Прочность: &n-";
                    }
                    return " Прочность: &n" + PlaceholderAPI.setPlaceholders(player,"%player_item_in_hand_durability%");
                }
                if(third_slot.get(player.getUniqueId()).equals("totem_count")){
                    return " Тотемов: &n" +PlaceholderAPI.setPlaceholders(player,"%checkitem_amount_mat:totem_of_undying%");
                }
                if(third_slot.get(player.getUniqueId()).equals("helmet_durability")){
                    if(player.getInventory().getHelmet() == null){
                        return " Шлем: &n-";
                    }
                    return " Шлем: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_helmet_durability%");
                }
                if(third_slot.get(player.getUniqueId()).equals("chestplate_durability")){
                    if(player.getInventory().getChestplate() == null){
                        return " Нагрудник: &n-";
                    }
                    return " Нагрудник: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_chestplate_durability%");
                }
                if(third_slot.get(player.getUniqueId()).equals("leggings_durability")){
                    if(player.getInventory().getLeggings() == null){
                        return " Поножи: &n-";
                    }
                    return " Поножи: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_leggings_durability%");
                }
                if(third_slot.get(player.getUniqueId()).equals("boots_durability")){
                    if(player.getInventory().getBoots() == null){
                        return " Тапки: &n-";
                    }
                    return " Тапки: &n" + PlaceholderAPI.setPlaceholders(player,"%player_armor_boots_durability%");
                }


            }else {
                if(third_slot.get(player.getUniqueId()).equals("kills")){
                    return " Убийств: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_player_kills%");
                }
                if(third_slot.get(player.getUniqueId()).equals("deaths")){
                    return " Смертей: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_deaths%");
                }
                if(third_slot.get(player.getUniqueId()).equals("hours")){
                    return " Отыграно: &7" + PlaceholderAPI.setPlaceholders(player,"%statistic_time_played:hours%") + " ч.";
                }
                if(third_slot.get(player.getUniqueId()).equals("ping")){
                    return " Пинг: &7" + PlaceholderAPI.setPlaceholders(player, "%player_ping%");
                }
                if(third_slot.get(player.getUniqueId()).equals("mobs_killed")){
                    return " Мобов: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_mob_kills%");
                }
                if(third_slot.get(player.getUniqueId()).equals("blocks_break")){
                    return " Добыто: &7" + PlaceholderAPI.setPlaceholders(player, "%statistic_mine_block%") +" бл.";
                }
                if(third_slot.get(player.getUniqueId()).equals("coords")){
                    return coordinatesHolder(player,false);
                }
                if(third_slot.get(player.getUniqueId()).equals("kills_deaths")){
                    return " KD: &7" + killDeathsHolder(player);
                }
                if(third_slot.get(player.getUniqueId()).equals("hand_durability")){
                    if(player.getInventory().getItemInMainHand().getType().isAir()){
                        return " Прочность: &7-";
                    }
                    return " Прочность: &7" + PlaceholderAPI.setPlaceholders(player,"%player_item_in_hand_durability%");
                }
                if(third_slot.get(player.getUniqueId()).equals("totem_count")){
                    return " Тотемов: &7" +PlaceholderAPI.setPlaceholders(player,"%checkitem_amount_mat:totem_of_undying%");
                }
                if(third_slot.get(player.getUniqueId()).equals("helmet_durability")){
                    if(player.getInventory().getHelmet() == null){
                        return " Шлем: &7-";
                    }
                    return " Шлем: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_helmet_durability%");
                }
                if(third_slot.get(player.getUniqueId()).equals("chestplate_durability")){
                    if(player.getInventory().getChestplate() == null){
                        return " Нагрудник: &7-";
                    }
                    return " Нагрудник: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_chestplate_durability%");
                }
                if(third_slot.get(player.getUniqueId()).equals("leggings_durability")){
                    if(player.getInventory().getLeggings() == null){
                        return " Поножи: &7-";
                    }
                    return " Поножи: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_leggings_durability%");
                }
                if(third_slot.get(player.getUniqueId()).equals("boots_durability")){
                    if(player.getInventory().getBoots() == null){
                        return " Тапки: &7-";
                    }
                    return " Тапки: &7" + PlaceholderAPI.setPlaceholders(player,"%player_armor_boots_durability%");
                }
            }

        }

        return "&7*Прочерк*";
    }

    public static void resetSlot(Player player){
        first_slot.put(player.getUniqueId(),"kills");
        second_slot.put(player.getUniqueId(),"deaths");
        third_slot.put(player.getUniqueId(),"hours");
        StatisticInteract.setSlotSelectionToDefault(player);
    }


    private static double killDeathsHolder(Player player){
        int kills = Integer.parseInt(PlaceholderAPI.setPlaceholders(player,"%statistic_player_kills%"));
        int deaths = Integer.parseInt(PlaceholderAPI.setPlaceholders(player,"%statistic_deaths%"));
        double kd = kills/deaths;

        return Math.round(kd * 3) / 3;
    }

    private static boolean isTagSelected(Player player,String tag){
        if(first_slot.get(player.getUniqueId()).equals(tag)){
            return true;
        }
        if(second_slot.get(player.getUniqueId()).equals(tag)){
            return true;
        }
        if(third_slot.get(player.getUniqueId()).equals(tag)){
            return true;
        }
        return false;
    }

    public static String getTopic(Player player){
        if(isTagSelected(player,"coords") || isTagSelected(player,"ping")
                || isTagSelected(player,"hand_durability") || isTagSelected(player,"totem_count")
                || isTagSelected(player,"helmet_durability") || isTagSelected(player,"chestplate_durability")
                || isTagSelected(player,"leggings_durability") || isTagSelected(player,"boots_durability")){
            return "ИНФОРМАЦИЯ:";
        }
        return "СТАТИСТИКА:";
    }

    private static String coordinatesHolder(Player player,boolean isGrayStyle){
        if(isGrayStyle){
            return " Координаты: &n"+PlaceholderAPI.setPlaceholders(player,"%player_x%")+
                    " &n"+PlaceholderAPI.setPlaceholders(player,"%player_y%")+
                    " &n"+PlaceholderAPI.setPlaceholders(player,"%player_z%");
        }
        return " Координаты: &7"+PlaceholderAPI.setPlaceholders(player,"%player_x%")+
                " &7"+PlaceholderAPI.setPlaceholders(player,"%player_y%")+
                " &7"+PlaceholderAPI.setPlaceholders(player,"%player_z%");
    }

}
