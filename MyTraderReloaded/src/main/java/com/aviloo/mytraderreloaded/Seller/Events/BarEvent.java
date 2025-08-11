package com.aviloo.mytraderreloaded.Seller.Events;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerReputation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BarEvent implements Listener {

    private Location sellerLocation = new Location(Bukkit.getWorld(
            MyTraderReloaded.getPlugin().getConfig().getString("NPCLocationWorld")),
            MyTraderReloaded.getPlugin().getConfig().getDouble("NPCLocationX"),
            MyTraderReloaded.getPlugin().getConfig().getDouble("NPCLocationY"),
            MyTraderReloaded.getPlugin().getConfig().getDouble("NPCLocationZ"));

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        BossBar bar = Bukkit.createBossBar(ColorUtils.translateColorCodes(
                        "&fВаша репутация скупщика: %rep% ").replaceAll(
                        "%rep%",String.valueOf(PlayerReputation.getReputation(
                                event.getPlayer()))),
                BarColor.YELLOW, BarStyle.SOLID);
        if(event.getPlayer().getLocation().distance(sellerLocation) > 5) {
            for(Player player : bar.getPlayers()) {
                if(event.getPlayer().equals(player)) {
                    bar.removePlayer(event.getPlayer());
                }
            }
            return;
        }

        bar.addPlayer(event.getPlayer());
    }

}
