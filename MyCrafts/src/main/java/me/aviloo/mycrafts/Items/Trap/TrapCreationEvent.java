package me.aviloo.mycrafts.Items.Trap;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TrapCreationEvent extends Event{

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player Player;

    public TrapCreationEvent(Player player) {
        this.Player = player;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public Player getPlayer() {
        return this.Player;
    }

}
