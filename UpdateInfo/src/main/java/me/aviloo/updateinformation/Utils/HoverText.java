package me.aviloo.updateinformation.Utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class HoverText implements Listener {

    private static JavaPlugin plugin;

    public HoverText(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public static TextComponent UpdateLink(Player player){
        TextComponent link = new TextComponent(ChatColor.YELLOW+ plugin.getConfig().getString("server_name") +ChatColor.WHITE+"Чтобы получить полную информацию о обновлении , нажмите " + ChatColor.YELLOW+ "[СЮДА]");
        link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,plugin.getConfig().getString("link")));
        //link.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/updatebook"));

        return link;

    }

    public static void forStrings(Player player){
        for(String s : plugin.getConfig().getStringList("Strings")) {
            player.sendMessage(ChatColor.WHITE + s);
        }
    }
}
