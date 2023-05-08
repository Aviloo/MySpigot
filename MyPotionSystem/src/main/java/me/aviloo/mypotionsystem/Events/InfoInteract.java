package me.aviloo.mypotionsystem.Events;

import me.aviloo.mypotionsystem.Inventories.MainInventory;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class InfoInteract implements Listener {

    private static JavaPlugin plugin;

    public InfoInteract(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public static void sendLink(Player player){
        player.sendMessage(" ");
        TextComponent link = new TextComponent(ChatColor.translateAlternateColorCodes('&'
                ,"&7[Сервер] &fЧтобы скачать файл, нажмите &e{Здесь}"));
        link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,plugin.getConfig().getString("pdf_link")));
        player.spigot().sendMessage(link);
        player.sendMessage(" ");
        player.playSound(player.getLocation(),Sound.ENTITY_PLAYER_LEVELUP,5,0);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Информация о зельях")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.openInventory(MainInventory.getInv(player));
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,9,1);
                    break;
                case KNOWLEDGE_BOOK:
                    sendLink(player);
                    break;
            }
            event.setCancelled(true);
        }
    }
}
