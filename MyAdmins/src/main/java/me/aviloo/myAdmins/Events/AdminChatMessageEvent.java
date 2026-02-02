package me.aviloo.myAdmins.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminChatMessageEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player sender;
    private final String message;
    private final String time;

    public AdminChatMessageEvent(Player sender, String message) {
        this.sender = sender;
        this.message = message;
        this.time = new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }


    public Player getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }


}
