package com.aviloo.mytraderreloaded.Seller.Expansions;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.LeaderUtils;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerReputation;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReputationExpansion extends PlaceholderExpansion {

    private final MyTraderReloaded plugin;

    public ReputationExpansion(MyTraderReloaded plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "seller";
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

        if(params.equalsIgnoreCase("rep")){
            if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")) {
                return String.valueOf(PlayerReputation.getReputation(player));
            }
            if(!MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")) {
                return String.valueOf(PlayerReputation.getReputationFromUsermap(player));
            }
        }
        if(params.equalsIgnoreCase("earned")){
            return String.valueOf(LeaderUtils.getPlayerEarned(player.getUniqueId()));
        }

        return null; // Placeholder is unknown by the Expansion
    }

}
