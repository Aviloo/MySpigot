package com.aviloo.serverutilsandtools.ServerTools.NoBanWord;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;

public class NBW implements Listener {

    String[] BanWord = {"негр","пидор","пидр","чурка","хохол","москаль","нацист","фашист"};

    private String[] split(String str){
        return str.split(" ");
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        String message = event.getMessage();
        String[] massage_words = split(message);
        if (Arrays.equals(BanWord,massage_words)){
            event.setMessage(ChatColor.YELLOW+"*Осуждаю*");
        }
    }
}
