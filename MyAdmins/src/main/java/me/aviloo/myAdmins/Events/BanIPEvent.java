package me.aviloo.myAdmins.Events;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class BanIPEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final CommandSender sender;
    private final String reason;

    public BanIPEvent(Player player, CommandSender sender, String reason)
    {
        this.player = player;
        this.sender = sender;
        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public Player getPlayer() {
        return this.player;
    }

    public CommandSender getSender() {
        return this.sender;
    }

    public String getReason() {
        return this.reason;
    }

}
