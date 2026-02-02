package me.aviloo.myAdmins.Menu;

import me.aviloo.myAdmins.Models.Report;
import me.aviloo.myAdmins.MyAdmins;
import me.aviloo.myAdmins.Utils.SkullUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReportsMenu implements Listener {

    private static FileConfiguration iconConfig =
            MyAdmins.getPlugin().iconsFileManager.getIconsConfig();

    public static Inventory inventory = Bukkit.createInventory(
    null,54, ChatColor.WHITE+"Репорты");

    public static ItemStack reportItem = SkullUtils.
    getSkullByBase64EncodedTextureUrl(iconConfig.getString("report"));

    private static Queue<Report> queue = new LinkedList<Report>();

    public static void init(){
        ItemStack back = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("back"));
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW + "Назад");
        back.setItemMeta(backMeta);
        inventory.setItem(49, back);
        ItemStack info = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("info"));
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.WHITE + "Репорты");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "Здесь находятся последние");
        lore.add(ChatColor.GREEN + "жалобы и вопросы игроков.");
        infoMeta.setLore(lore);
        info.setItemMeta(infoMeta);
        inventory.setItem(4, info);
    }

    public static void update(){
        queue.clear();
        queue.addAll(Report.reports);

        for (int i = 0; i < inventory.getSize(); i++) {
            if (i != 4 && i != 49) {
                inventory.setItem(i, null);
            }
        }

        int[] slots = {10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34};

        int itemIndex = 0;

        for (Report rep : queue) {
            if (itemIndex >= slots.length) {
                break; // если наказаний больше чем слотов
            }

            int slot = slots[itemIndex];

            ItemStack item = reportItem.clone();

            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(" ");
            ArrayList<String> loreList = new ArrayList<>();
            loreList.add(ChatColor.WHITE + "id: " + rep.getId());
            loreList.add(ChatColor.WHITE + "Ник игрока: " + rep.getPlayer_name());
            loreList.add(ChatColor.WHITE + "Дата: "+ rep.getDate());
            loreList.add(ChatColor.WHITE + "Описание: " +
                    Arrays.toString(rep.getDescription()));
            loreList.add(" ");
            loreList.add(ChatColor.GRAY+"Нажмите ПКМ, чтобы завершить репорт.");
            loreList.add(ChatColor.GRAY+"Нажмите ЛКМ, чтобы телепортироваться к игроку");
            itemMeta.setLore(loreList);
            item.setItemMeta(itemMeta);

            inventory.setItem(slot, item);
            itemIndex++;
        }
        queue.clear();

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getClickedInventory() == null){return;}
        if(event.getClickedInventory() != inventory){return;}
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()){
            case 49:
                player.closeInventory();
                player.playSound(player.getLocation(),
                        Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                break;
            case 4:
                event.setCancelled(true);
                break;
            case 10,11,12,13,14,15,16,19,20,21,22,23,24,25,28,29,30,31,32,33,34:
                switch(event.getCurrentItem().getType()){
                    case PLAYER_HEAD:
                        if(event.getClick().isLeftClick()){
                            player.closeInventory();
                            if(Bukkit.getPlayer(event.getCurrentItem().getItemMeta().getLore().get(1).substring("Ник игрока: ".length()).replace(":","").replace(" ","").trim()) == null){
                                player.sendMessage(ChatColor.RED+"Игрок не онлайн!");
                                break;
                            }
                            player.teleport(Bukkit.getPlayer(event.getCurrentItem().
                            getItemMeta().getLore().get(1).substring("Ник игрока: ".length()).replace(":","").replace(" ","").trim()),
                            PlayerTeleportEvent.TeleportCause.COMMAND);
                            player.sendMessage(ChatColor.GREEN+"Телепортируем...");
                            break;
                        }
                        if(event.getClick().isRightClick()){
                            int id = Integer.parseInt(event.getCurrentItem().getItemMeta().getLore().
                            get(0).substring("id: ".length()).replace(":","")
                            .replace(" ","").trim());
                            Report.reports.removeIf(rep -> id == rep.getId());
                            queue.removeIf(rep -> id == rep.getId());
                            update();
                            player.updateInventory();
                            break;
                        }
                }
        }
        event.setCancelled(true);
    }

}
