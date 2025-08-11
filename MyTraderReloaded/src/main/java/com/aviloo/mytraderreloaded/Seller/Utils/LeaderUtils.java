package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.SellerInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class LeaderUtils implements Listener {

    private static FileConfiguration iconConfig =
            MyTraderReloaded.getPlugin().iconsFileManager.getIconsConfig();

    //Event
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(playersEarned.containsKey(event.getPlayer().getUniqueId())) {return;}
        playersEarned.put(event.getPlayer().getUniqueId(),0.0);
    }

    private static LinkedHashMap<UUID,Double> playersEarned = new LinkedHashMap<>();

    public static void addPlayerEarned(UUID uuid, double amount) {
        playersEarned.put(uuid, playersEarned.getOrDefault(uuid,0.0) + amount);
    }

    // Переменные для хранения ключа с наибольшим значением
    public static UUID maxKey = null;
    private static double maxEarned = Double.MIN_VALUE;

    public static void updateLeader(){
        for(Map.Entry<UUID,Double> entry : playersEarned.entrySet()){
            if(entry.getValue() > maxEarned){
                maxEarned = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        SellerInventory.inventory.setItem(48,traderItem());
    }

    public static void setPlayerEarned(UUID uuid, double amount){
        playersEarned.put(uuid,amount);
    }

    public static double getPlayerEarned(UUID uuid){
        return playersEarned.get(uuid);
    }

    //ItemStack
    public static ItemStack traderItem(){
        ItemStack item = SkullUtils.getSkullByBase64EncodedTextureUrl(
                iconConfig.getString("leader"));
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN+"Лучший торговец сегодня");
        ArrayList<String> lore = new ArrayList<>();
        if(maxKey != null) {
            lore.add(" ");
            lore.add(ChatColor.WHITE+"Ник: " +ChatColor.GRAY+
                    Bukkit.getOfflinePlayer(maxKey).getName());
            lore.add(ChatColor.WHITE+"Заработал: "+ChatColor.GRAY+
                    Math.ceil(playersEarned.get(maxKey)));
            lore.add(" ");
        }if(maxKey == null) {
            lore.add(" ");
            lore.add(ChatColor.WHITE+"Ник: "+ChatColor.GRAY+"-");
            lore.add(ChatColor.WHITE+"Заработал: "+ChatColor.GRAY+"-");
            lore.add(" ");
        }
        lore.add(ChatColor.DARK_GRAY+"Статистика обновляется ");
        lore.add(ChatColor.DARK_GRAY+"раз в 5 минут");
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    //ItemStack
    // Используется для отоброжения головы игрока
    public static ItemStack traderItemHead(){
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN+"Лучший торговец сегодня");
        ArrayList<String> lore = new ArrayList<>();
        if(maxKey != null) {
            meta.setOwningPlayer(Bukkit.getOfflinePlayer(maxKey));
            lore.add(" ");
            lore.add(ChatColor.WHITE+"Ник: " +ChatColor.GRAY+
                    Bukkit.getOfflinePlayer(maxKey).getName());
            lore.add(ChatColor.WHITE+"Заработал: "+ChatColor.GRAY+
                    Math.ceil(playersEarned.get(maxKey)));
            lore.add(" ");
        }if(maxKey == null) {
            lore.add(" ");
            lore.add(ChatColor.WHITE+"Ник: "+ChatColor.GRAY+"-");
            lore.add(ChatColor.WHITE+"Заработал: "+ChatColor.GRAY+"-");
            lore.add(" ");
        }
        lore.add(ChatColor.DARK_GRAY+"Статистика обновляется ");
        lore.add(ChatColor.DARK_GRAY+"раз в 5 минут");
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    //Reward

    public static  void giveLeaderReward(){
        int reward = MyTraderReloaded.getPlugin().getConfig().getInt("reward");
        int hours = MyTraderReloaded.getPlugin().getConfig().getInt("rewardHours");
        int minutes = MyTraderReloaded.getPlugin().getConfig().getInt("rewardMinutes");
        // Запускаем задачу, которая будет проверять время каждую минуту
        new BukkitRunnable() {
            @Override
            public void run() {
                // Получаем текущее время в московском часовом поясе
                LocalTime currentTime = LocalTime.now(ZoneId.of("Europe/Moscow"));

                // Проверяем, равно ли текущее время 21:00
                if (currentTime.getHour() == hours && currentTime.getMinute() == minutes) {
                    // Выдаем награду
                    if(maxKey == null) {
                        Bukkit.getConsoleSender().sendMessage(ColorUtils.translateColorCodes(
                    "&f[MyTraderReloaded] &4Награда невыданна! Так как лучший игрок не выявлен."));
                        return;
                    }

                    if(Bukkit.getServer().getPlayer(maxKey) == null) {
                        EconomyManager.givePoints(maxKey,reward);
                        Bukkit.getConsoleSender().sendMessage(ColorUtils.translateColorCodes(
                    "&f[MyTraderReloaded] &eИгроку "+Bukkit.getOfflinePlayer(maxKey).getName()
                         + " выданна награда!"));
                    }
                    if(Bukkit.getServer().getPlayer(maxKey) != null) {
                        EconomyManager.givePoints(maxKey,reward);
                        Bukkit.getConsoleSender().sendMessage(ColorUtils.translateColorCodes(
                                "&f[MyTraderReloaded] &eИгроку "+Bukkit.getPlayer(maxKey).getName()
                                        + " выданна награда!"));
                        Bukkit.getPlayer(maxKey).sendMessage(ColorUtils.translateColorCodes(
                                "&f[Скупщик] &aВы стали лучшим торговцем сегодня!" +
                                        " Вам была выданна награда в размере - "+reward
                                        +" донат-валюты."));
                    }
                }
            }
        }.runTaskTimer(MyTraderReloaded.getPlugin(), 0L, 1200L); // Проверяем каждую минуту (1200 тиков = 60 секунд)
    }
}
