package me.aviloo.myclans.api;

import me.aviloo.myclans.models.Clan;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClanEnemyRemoveEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player createdBy;
    private final Clan clan;
    private final Player exEnemyClanCreatedBy;
    private final Clan exEnemyClan;



    public ClanEnemyRemoveEvent(Player createdBy, Clan clan, Clan exEnemyClan, Player exEnemyClanCreatedBy) {
        this.createdBy = createdBy;
        this.clan = clan;
        this.exEnemyClanCreatedBy = exEnemyClanCreatedBy;
        this.exEnemyClan = exEnemyClan;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public Player getCreatedBy() {
        return createdBy;
    }

    public Clan getClan() {
        return clan;
    }

    public Player getExEnemyClanCreatedBy() {
        return exEnemyClanCreatedBy;
    }

    public Clan getExEnemyClan() {
        return exEnemyClan;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
