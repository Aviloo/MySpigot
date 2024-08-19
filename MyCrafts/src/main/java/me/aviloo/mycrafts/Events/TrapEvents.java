package me.aviloo.mycrafts.Events;

import me.aviloo.mycrafts.Items.Trap.Buildings;
import me.aviloo.mycrafts.Items.Trap.TrapCreationEvent;
import me.aviloo.mycrafts.Items.Trap.TrapManager;
import me.aviloo.mycrafts.MyCrafts;
import me.aviloo.mycrafts.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TrapEvents implements Listener {

    private final Map<UUID,Long> cooldowns = new HashMap<>();
    private static final long cooldown_time = 10000;

    private boolean isCoolDownExpire(Player player, Long cooldown){
        final Long StartTime = cooldowns.get(player.getUniqueId());
        if(StartTime == null){
            return true;
        }
        final long elapsedtime = System.currentTimeMillis() - StartTime;
        return elapsedtime >= cooldown;
    }

    private void setCooldown(Player player){
        cooldowns.merge(player.getUniqueId(),System.currentTimeMillis(),
                (oldValue,newValue) -> newValue);
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() == null) return;

        if (e.getItem().getType().equals(Material.NETHERITE_SCRAP) && e.getItem().getItemMeta().equals(TrapManager.Trap.getItemMeta())) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if(!(isCoolDownExpire(e.getPlayer(), cooldown_time))){
                    e.getPlayer().sendMessage(ColorUtils.translateColorCodes(
                    "&7[&6Система&7] &fЛовушку можно использовать повторно спустя %cooldown% секунд.")
                            .replaceAll("%cooldown%", String.valueOf(cooldown_time/1000)));
                    e.setCancelled(true);
                    return;
                }
                e.setCancelled(true);
                Buildings.createBox(e.getPlayer());
                setCooldown(e.getPlayer());
                MyCrafts.getPlugin().getLogger().info(ColorUtils.translateColorCodes("&fPlayer &6%player% &fplaced the &6Trap&f on Location: &6X: %location_x% Y: %location_y% Z: %location_z%")
                        .replaceAll("%player%", e.getPlayer().getName())
                        .replaceAll("%location_x%", String.valueOf(e.getPlayer().getLocation().getX()))
                        .replaceAll("%location_y%", String.valueOf(e.getPlayer().getLocation().getY()))
                        .replaceAll("%location_z%", String.valueOf(e.getPlayer().getLocation().getZ())));
                if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(TrapManager.Trap)) {
                    e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() -1 );
                } else if(e.getPlayer().getInventory().getItemInOffHand().isSimilar(TrapManager.Trap)) {
                    e.getPlayer().getInventory().getItemInOffHand().setAmount(e.getPlayer().getInventory().getItemInOffHand().getAmount() -1 );
                }
            }
        }
    }


    private final int Timer = 7;

    @EventHandler
    public void onPlaced(TrapCreationEvent event){
        BossBar bar = Bukkit.createBossBar(ColorUtils.translateColorCodes(
                        "&fЛовушка исчезнет через %time% секунд.").replaceAll(
                        "%time%",String.valueOf(Timer)),
                BarColor.YELLOW, BarStyle.SOLID);
        bar.addPlayer(event.getPlayer());

        new BukkitRunnable() {
            int timer = Timer;

            @Override
            public void run() {
                timer-=1;
                bar.setTitle(ColorUtils.translateColorCodes(
                        "&fЛовушка исчезнет через %time% секунд.").replaceAll(
                        "%time%",String.valueOf(timer)));
                bar.setProgress(1 - (double) timer / Timer);

                if(timer == 0){
                    bar.removeAll();
                    cancel();
                }

            }
        }.runTaskTimer(MyCrafts.getPlugin(),0L, 20L);

    }

}
