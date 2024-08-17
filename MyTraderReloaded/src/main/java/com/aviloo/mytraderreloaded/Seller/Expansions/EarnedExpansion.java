package com.aviloo.mytraderreloaded.Seller.Expansions;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerReputation;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerStats;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EarnedExpansion extends PlaceholderExpansion {

    private final MyTraderReloaded plugin;

    public EarnedExpansion(MyTraderReloaded plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "EarnedBySeller";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Aviloo";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String params) {
        if(params.equalsIgnoreCase("earned")){
           return String.valueOf(PlayerStats.getEarnedPlayerStats(player.getUniqueId()));
        }

        return null; // Placeholder is unknown by the Expansion
    }

}
