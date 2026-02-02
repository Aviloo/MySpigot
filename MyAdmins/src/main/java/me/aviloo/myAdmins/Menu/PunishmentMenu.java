package me.aviloo.myAdmins.Menu;

import me.aviloo.myAdmins.Models.PluginPlayer;
import me.aviloo.myAdmins.Models.Punishment;
import me.aviloo.myAdmins.MyAdmins;
import me.aviloo.myAdmins.Utils.SkullUtils;
import me.aviloo.myAdmins.Utils.StorageUtils.PunishmentStorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class PunishmentMenu implements Listener {

    private static FileConfiguration iconConfig =
            MyAdmins.getPlugin().iconsFileManager.getIconsConfig();

    public static void open(Player admin, Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Последние наказания");
        ItemStack back = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("back"));
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW + "Назад");
        back.setItemMeta(backMeta);
        inv.setItem(49, back);
        ItemStack info = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("info"));
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.WHITE + "Наказания");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "Здесь содержится последние");
        lore.add(ChatColor.GREEN + "наказания игрока.");
        infoMeta.setLore(lore);
        info.setItemMeta(infoMeta);
        inv.setItem(4, info);

        PluginPlayer plPlayer = PluginPlayer.getPluginPlayerByPlayer(player);
        for (int x = 0; x < 7; x++) {
            for (Punishment p : plPlayer.getPunishments()) {
                ItemStack item = SkullUtils.getSkullByBase64EncodedTextureUrl(
                        Punishment.PunishmentType.valueOf(p.getType()).getIcon());
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(" ");
                ArrayList<String> list = new ArrayList<>();
                list.add(ChatColor.WHITE + "Тип: " + p.getType());
                list.add(ChatColor.WHITE + "Ник игрока: " + p.getSuspect_name());
                list.add(ChatColor.WHITE + "Ник админа: " + p.getAdmin_name());
                list.add(ChatColor.WHITE + "Причина: " + p.getReason());
                list.add(ChatColor.WHITE + "Дата выдачи: " + p.getDate());
                itemMeta.setLore(list);
                item.setItemMeta(itemMeta);
                inv.setItem(10 + x, item);
            }
        }

        admin.openInventory(inv);
    }

    public static void openMenu(Player admin, Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Последние наказания");
        ItemStack back = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("back"));
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW + "Назад");
        back.setItemMeta(backMeta);
        inv.setItem(49, back);
        ItemStack info = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("info"));
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.WHITE + "Наказания");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "Здесь находятся ");
        lore.add(ChatColor.GREEN + "наказания игрока.");
        infoMeta.setLore(lore);
        info.setItemMeta(infoMeta);
        inv.setItem(4, info);

        // Получаем список наказаний
        Set<Punishment> punishments = PunishmentStorageUtil.getPunishments(player.getUniqueId());

        // Слоты, в которые будем ставить предметы
        int[] slots = {10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34};

        int itemIndex = 0;

        for (Punishment p : punishments) {
            if (itemIndex >= slots.length) {
                break; // если наказаний больше чем слотов
            }

            int slot = slots[itemIndex];

            ItemStack item = SkullUtils.getSkullByBase64EncodedTextureUrl(
                    Punishment.PunishmentType.valueOf(p.getType()).getIcon());

            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(" ");
            ArrayList<String> loreList = new ArrayList<>();
            loreList.add(ChatColor.WHITE + "Тип: " + p.getType());
            loreList.add(ChatColor.WHITE + "Ник игрока: " + p.getSuspect_name());
            loreList.add(ChatColor.WHITE + "Ник админа: " + p.getAdmin_name());
            loreList.add(ChatColor.WHITE + "Причина: " + p.getReason());
            loreList.add(ChatColor.WHITE + "Дата выдачи: " + p.getDate());
            itemMeta.setLore(loreList);
            item.setItemMeta(itemMeta);

            inv.setItem(slot, item);
            itemIndex++;
        }

        // Открываем меню
        admin.openInventory(inv);

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getClickedInventory() == null) return;
        if(!event.getView().getTitle().equals("Последние наказания")) return;
        if(event.getCurrentItem() == null) return;
        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()){
            case 49:
                player.closeInventory();
                player.playSound(player.getLocation(),
                Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                break;
        }
        event.setCancelled(true);
    }
}
