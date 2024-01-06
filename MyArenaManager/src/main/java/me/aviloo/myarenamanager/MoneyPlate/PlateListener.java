package me.aviloo.myarenamanager.MoneyPlate;

import me.aviloo.myarenamanager.MoneyPlate.Utils.HologramPlateUtil;
import me.aviloo.myarenamanager.MoneyPlate.Utils.LocationPlateUtils;
import me.aviloo.myarenamanager.MyArenaManager;
import me.aviloo.myarenamanager.Utils.ColorUtils;
import me.aviloo.myarenamanager.Utils.EconomyManager;
import me.aviloo.myarenamanager.Utils.OnlineUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlateListener implements Listener {

    private static MyArenaManager plugin;
    public PlateListener(MyArenaManager plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlate(PlayerInteractEvent event){
        if(!event.getAction().equals(Action.PHYSICAL)){return;}
        if(!event.getClickedBlock().getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)){return;}

        Player player = event.getPlayer();
        if(!HologramPlateUtil.getPlateStatus()){return;}
        if(!LocationPlateUtils.isPlayerOnLocation(player)){
            return;
        }
        Bukkit.getScheduler().runTaskLater(plugin, (task) -> {
            if(!LocationPlateUtils.isPlayerOnLocation(player)){
                task.cancel();
            }
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,1,3);
            EconomyManager.giveMoney(player,calculatePlateReward());
            player.sendMessage(ColorUtils.translateColorCodes
                    ("&7✓ &fВы получили &e"+calculatePlateReward()+" &fмонет."));
        },21);
    }

    private double calculatePlateReward(){
        if(OnlineUtils.getOnlineCount() > 10){
            return 1.5;
        }
        if(OnlineUtils.getOnlineCount() > 25){
            return 3;
        }
        if(OnlineUtils.getOnlineCount() > 40){
            return 4;
        }
        if(OnlineUtils.getOnlineCount() > 69){
            return 5;
        }

        return 1;
    }

}
