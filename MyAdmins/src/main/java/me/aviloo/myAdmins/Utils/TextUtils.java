package me.aviloo.myAdmins.Utils;

import me.aviloo.myAdmins.Utils.StorageUtils.RulesStorageUtil;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TextUtils {

    public static void sendKickMessages(String player_name, String admin_name, String number) {
        TextComponent message = new TextComponent(ChatColor.WHITE + "Игрок " + player_name + " был кикнут " + admin_name + " по причине: ");
        TextComponent hoverText = new TextComponent(ChatColor.GOLD + "[" + number + "]");

        String hoverMsg = RulesStorageUtil.getValue(number);
        if (hoverMsg == null || hoverMsg.isEmpty()) {
            hoverMsg = "Нет подсказки"; // Или оставить пустой
        }

        hoverText.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(hoverMsg).create()
        ));

        message.addExtra(hoverText);

        for (Player ps : Bukkit.getOnlinePlayers()) {
            ps.spigot().sendMessage(message);
        }
    }

    public static void sendBanMessages(String player_name, String admin_name, String number) {
        TextComponent message = new TextComponent(ChatColor.WHITE + "Игрок " + player_name + " был заблокирован " + admin_name + " по причине: ");
        TextComponent hoverText = new TextComponent(ChatColor.GOLD + "[" + number + "]");

        String hoverMsg = RulesStorageUtil.getValue(number);
        if (hoverMsg == null || hoverMsg.isEmpty()) {
            hoverMsg = "Нет подсказки"; // Или оставить пустой
        }

        hoverText.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(hoverMsg).create()
        ));

        message.addExtra(hoverText);

        for (Player ps : Bukkit.getOnlinePlayers()) {
            ps.spigot().sendMessage(message);
        }
    }

    public static void sendBanIPMessages(String player_name, String admin_name, String number) {
        TextComponent message = new TextComponent(ChatColor.WHITE + "Игрок " + player_name + " был заблокирован по IP" + admin_name + " по причине: ");
        TextComponent hoverText = new TextComponent(ChatColor.GOLD + "[" + number + "]");

        String hoverMsg = RulesStorageUtil.getValue(number);
        if (hoverMsg == null || hoverMsg.isEmpty()) {
            hoverMsg = "Нет подсказки"; // Или оставить пустой
        }

        hoverText.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(hoverMsg).create()
        ));

        message.addExtra(hoverText);

        for (Player ps : Bukkit.getOnlinePlayers()) {
            ps.spigot().sendMessage(message);
        }
    }

    public static void sendMuteMessages(String player_name, String admin_name, String number) {
        TextComponent message = new TextComponent(ChatColor.WHITE + "Игрок " + player_name + " был заглушен, администратором " + admin_name + " по причине: ");
        TextComponent hoverText = new TextComponent(ChatColor.GOLD + "[" + number + "]");

        String hoverMsg = RulesStorageUtil.getValue(number);
        if (hoverMsg == null || hoverMsg.isEmpty()) {
            hoverMsg = "Нет подсказки"; // Или оставить пустой
        }

        hoverText.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(hoverMsg).create()
        ));

        message.addExtra(hoverText);

        for (Player ps : Bukkit.getOnlinePlayers()) {
            ps.spigot().sendMessage(message);
        }
    }

    public static void sendTempBanMessages(String player_name, String admin_name,String date, String number) {
        TextComponent message = new TextComponent(ChatColor.WHITE + "Игрок " + player_name + " был заблокирован до: "+date +", администратором:"+ admin_name + " по причине: ");
        TextComponent hoverText = new TextComponent(ChatColor.GOLD + "[" + number + "]");

        String hoverMsg = RulesStorageUtil.getValue(number);
        if (hoverMsg == null || hoverMsg.isEmpty()) {
            hoverMsg = "Нет подсказки"; // Или оставить пустой
        }

        hoverText.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(hoverMsg).create()
        ));

        message.addExtra(hoverText);

        for (Player ps : Bukkit.getOnlinePlayers()) {
            ps.spigot().sendMessage(message);
        }
    }

}
