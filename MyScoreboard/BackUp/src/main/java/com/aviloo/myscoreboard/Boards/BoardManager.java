package com.aviloo.myscoreboard.Boards;

import com.aviloo.myscoreboard.Inventories.MainInventory;
import com.aviloo.myscoreboard.MyScoreboard;
import fr.mrmicky.fastboard.FastBoard;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class BoardManager implements Listener {

    private String getPrefix(Player player){
        String holder = PlaceholderAPI.setPlaceholders(player,"%luckperms_suffix%");
        if(holder.equals("")){
            return "Отсутствует";
        }else return holder;
    }

    private String getGroup(Player player){
        String holder = PlaceholderAPI.setPlaceholders(player,"%luckperms_primary_group_name%");
        if(holder.equals("default")){return "Player";}
        else return holder;
    }

    public static String EventBoardsStatus = "none";

    private static JavaPlugin plugin;

    public BoardManager(JavaPlugin plugin){
        this.plugin = plugin;
    }

    private static final Map<UUID,String> boardsColors = new HashMap<>();

    public static void setColor(Player player,String color){
        boardsColors.put(player.getUniqueId(),color);
    }
    public static String getColor(Player player){
        return boardsColors.get(player.getUniqueId());
    }

    private static final Map<UUID, FastBoard> boards = new HashMap<>();

    public static void setBoards(Player player){
        boards.put(player.getUniqueId(),MainBoard.getBoard(player));
    }
    public static void removeScoreboard(Player player){
        boards.get(player.getUniqueId()).delete();
        boards.remove(player.getUniqueId());
        MainInventory.setDisable(player.getUniqueId());
    }

    public void Scoreboard(MyScoreboard plugin){
        Bukkit.getPluginManager().registerEvents(this,plugin);
        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (FastBoard board : boards.values()) {
                if(Objects.equals(EventBoardsStatus, "airdrops")){
                    board.updateTitle(ChatColor.translateAlternateColorCodes('&',"&6&lИвент"));
                    updateBoards(board," ",
                            "Где-то в мире упал груз",
                            "Успей забрать уникальный лут.",
                            "&7(Используй - /rtp)",
                            " ");
                    plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
                        EventBoardsStatus = "none";
                    },140);
                }
                if(Objects.equals(EventBoardsStatus, "pvp")){
                    board.updateTitle(ChatColor.translateAlternateColorCodes('&',"&6&lИвент"));
                    updateBoards(board," ",
                            "На пвп арене проходит",
                            "ивент. Успей поучаствовать.",
                            "&7(Используй - /warp pvp)",
                            " ");
                    plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
                        EventBoardsStatus = "none";
                    },140);
                }else {
                    if (getColor(board.getPlayer()).equalsIgnoreCase("original")) {
                        board.updateTitle(ChatColor.translateAlternateColorCodes('&', "&6&lOrumii"));
                        updateBoards(board, "",
                                "&f♦&e&lИНФОРМАЦИЯ: ",
                                " Ник: &7" + board.getPlayer().getName(),
                                " Статус: &7" + getGroup(board.getPlayer()),
                                " Титул: &7" + getPrefix(board.getPlayer()),
                                " ",
                                "&f♦&e&lСТАТИСТИКА: ",
                                " Убийств: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_player_kills%"),
                                " Смертей: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_deaths%"),
                                " Отыграно: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(),"%statistic_time_played:hours%") + " ч.",
                                " ",
                                "&f♦&e&lПРОГРЕСС: ",
                                " Монет: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%vault_eco_balance_formatted%"),
                                " Орури: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%playerpoints_points%"),
                                " ",
                                "&7     www.Orumii.su   ");
                    }
                    if (getColor(board.getPlayer()).equalsIgnoreCase("red")) {
                        board.updateTitle(ChatColor.translateAlternateColorCodes('&', "&4&lOrumii"));
                        updateBoards(board, "",
                                "&f♦&c&lИНФОРМАЦИЯ: ",
                                " Ник: &7" + board.getPlayer().getName(),
                                " Статус: &7" + getGroup(board.getPlayer()),
                                " Титул: &7" + getPrefix(board.getPlayer()),
                                " ",
                                "&f♦&c&lСТАТИСТИКА: ",
                                " Убийств: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_player_kills%"),
                                " Смертей: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_deaths%"),
                                " Отыграно: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(),"%statistic_time_played:hours%") + " ч.",
                                " ",
                                "&f♦&c&lПРОГРЕСС: ",
                                " Монет: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%vault_eco_balance_formatted%"),
                                " Орури: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%playerpoints_points%"),
                                " ",
                                "&7     www.Orumii.su   ");
                    }
                    if (getColor(board.getPlayer()).equalsIgnoreCase("blue")) {
                        board.updateTitle(ChatColor.translateAlternateColorCodes('&', "&3&lOrumii"));
                        updateBoards(board, "",
                                "&f♦&b&lИНФОРМАЦИЯ: ",
                                " Ник: &7" + board.getPlayer().getName(),
                                " Статус: &7" + getGroup(board.getPlayer()),
                                " Титул: &7" + getPrefix(board.getPlayer()),
                                " ",
                                "&f♦&b&lСТАТИСТИКА: ",
                                " Убийств: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_player_kills%"),
                                " Смертей: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_deaths%"),
                                " Отыграно: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(),"%statistic_time_played:hours%") + " ч.",
                                " ",
                                "&f♦&b&lПРОГРЕСС: ",
                                " Монет: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%vault_eco_balance_formatted%"),
                                " Орури: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%playerpoints_points%"),
                                " ",
                                "&7     www.Orumii.su   ");
                    }
                    if (getColor(board.getPlayer()).equalsIgnoreCase("pink")) {
                        board.updateTitle(ChatColor.translateAlternateColorCodes('&', "&5&lOrumii"));
                        updateBoards(board, "",
                                "&f♦&d&lИНФОРМАЦИЯ: ",
                                " Ник: &7" + board.getPlayer().getName(),
                                " Статус: &7" + getGroup(board.getPlayer()),
                                " Титул: &7" + getPrefix(board.getPlayer()),
                                " ",
                                "&f♦&d&lСТАТИСТИКА: ",
                                " Убийств: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_player_kills%"),
                                " Смертей: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_deaths%"),
                                " Отыграно: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(),"%statistic_time_played:hours%") + " ч.",
                                " ",
                                "&f♦&d&lПРОГРЕСС: ",
                                " Монет: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%vault_eco_balance_formatted%"),
                                " Орури: &7" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%playerpoints_points%"),
                                " ",
                                "&7     www.Orumii.su   ");
                    }
                    if (getColor(board.getPlayer()).equalsIgnoreCase("gray")) {
                        board.updateTitle(ChatColor.translateAlternateColorCodes('&', "&8&lOrumii"));
                        updateBoards(board, "",
                                "&f♦&7&lИНФОРМАЦИЯ: ",
                                " Ник: &n" + board.getPlayer().getName(),
                                " Статус: &n" + getGroup(board.getPlayer()),
                                " Титул: &n" + getPrefix(board.getPlayer()),
                                " ",
                                "&f♦&7&lСТАТИСТИКА: ",
                                " Убийств: &n" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_player_kills%"),
                                " Смертей: &n" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%statistic_deaths%"),
                                " Отыграно: &n" + PlaceholderAPI.setPlaceholders(board.getPlayer(),"%statistic_time_played:hours%") + " ч.",
                                " ",
                                "&f♦&7&lПРОГРЕСС: ",
                                " Монет: &n" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%vault_eco_balance_formatted%"),
                                " Орури: &n" + PlaceholderAPI.setPlaceholders(board.getPlayer(), "%playerpoints_points%"),
                                " ",
                                "&8     www.Orumii.su   ");
                    }
                }
            }
        },0L,10L);
    }

    @EventHandler(priority = EventPriority.NORMAL,ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        setColor(player,"original");
        boards.put(player.getUniqueId(),MainBoard.getBoard(player));
        MainInventory.setEnable(player.getUniqueId());
    }

    @EventHandler(ignoreCancelled = true)
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        FastBoard board = boards.remove(player.getUniqueId());

        if(board != null){
            board.delete();
        }
    }

    private void updateBoards(FastBoard board,String ... lines){
        for(int a = 0; a < lines.length; ++a){
            lines[a] = ChatColor.translateAlternateColorCodes('&', lines[a]);
        }
        board.updateLines(lines);
    }
}
