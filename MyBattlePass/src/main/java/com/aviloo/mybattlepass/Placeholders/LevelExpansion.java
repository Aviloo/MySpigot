package com.aviloo.mybattlepass.Placeholders;

import com.aviloo.mybattlepass.Utils.BPLevel;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LevelExpansion extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "MyBattlePass";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Aviloo";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if(player == null){
            return "";
        }
        if(params.equals("level")){
            return String.valueOf(BPLevel.getLevel(player.getUniqueId()));
        }

        return null;
    }
}
