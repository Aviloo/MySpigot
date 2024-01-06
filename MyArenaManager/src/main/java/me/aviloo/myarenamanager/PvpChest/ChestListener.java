package me.aviloo.myarenamanager.PvpChest;

import me.aviloo.myarenamanager.MyArenaManager;
import me.aviloo.myarenamanager.PvpChest.Inventory.ChestInventory;
import me.aviloo.myarenamanager.PvpChest.Utils.HologramChestUtils;
import me.aviloo.myarenamanager.PvpChest.Utils.LocationChestUtils;
import me.aviloo.myarenamanager.PvpChest.Utils.StatusChestUtils;
import me.aviloo.myarenamanager.Utils.ColorUtils;
import me.aviloo.myarenamanager.Utils.MessagesUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashSet;
import java.util.Set;

public class ChestListener implements Listener {

    private Set<Player> playersWhichOpenChest = new HashSet<>();

    private static MyArenaManager plugin;
    public ChestListener(MyArenaManager plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onOpen(PlayerInteractEvent event){
        if(!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){return;}
        if(!event.getClickedBlock().getType().equals(Material.TRAPPED_CHEST)){return;}
        if(!LocationChestUtils.isThatPvpChest(event.getClickedBlock().getLocation())){return;}

        Player player = event.getPlayer();

        if(StatusChestUtils.CanBeActivatedStatus
                && !StatusChestUtils.ActivatingStatus
                && !StatusChestUtils.OpenStatus){
            player.sendMessage(ColorUtils.translateColorCodes(
                    "&6Сундук Арены >>> &fВы активировали сундук." +
                            " Он откроется через 60 секунд."));
            StatusChestUtils.setActivatingStatus();
            HologramChestUtils.updateChestHologram();
            MessagesUtils.sendChestActivateMessage();
            openChestTimer();
            event.setCancelled(true);
        }
        if(!StatusChestUtils.ActivatingStatus
                && !StatusChestUtils.OpenStatus
                && !StatusChestUtils.CanBeActivatedStatus){
            player.sendMessage(ColorUtils.translateColorCodes(
                    "&6Сундук Арены >>> &fСундук недоступен. " +
                            "&fВозможность открыть сундук появляется каждый час."));
            player.playSound(player.getLocation(),
                    Sound.ENTITY_VILLAGER_NO,9,-1);
            event.setCancelled(true);
        }
        if(StatusChestUtils.ActivatingStatus
                && !StatusChestUtils.OpenStatus
                && !StatusChestUtils.CanBeActivatedStatus){
            player.sendMessage(ColorUtils.translateColorCodes(
                    "&6Сундук Арены >>> &fСундук откроется через  " +
                            "&e"+secondsToOpenChest+"&f секунд."));
            event.setCancelled(true);
            ChestInventory.generateLootForInventory();
            ChestInventory.addLootInChest(ChestInventory.inv);

            Bukkit.getScheduler().runTaskLater(plugin, (task) -> {
                StatusChestUtils.setChestOpen();
                HologramChestUtils.updateChestHologram();
                player.spawnParticle(Particle.FIREWORKS_SPARK,
                        LocationChestUtils.getLocation(),50);
            },1200); // Через минуту откроется (после нажатия)
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                StatusChestUtils.setInactiveStatus();
                HologramChestUtils.updateChestHologram();
                for(Player ps : playersWhichOpenChest){
                    ps.closeInventory();
                    ps.playSound(LocationChestUtils.getLocation(),
                            Sound.BLOCK_CHEST_CLOSE,15,0);
                    playersWhichOpenChest.remove(ps);
                    ChestInventory.clearGeneratedLoot();
                }

            }, 2400);//Еще через минуту закроется
            //todo Отправлять сообщение о времени до открытия
            // или о том что не хватает игроков
        }
        if(!StatusChestUtils.ActivatingStatus
                && StatusChestUtils.OpenStatus
                && !StatusChestUtils.CanBeActivatedStatus){
            event.setCancelled(true);
            player.openInventory(ChestInventory.inv);
            addPlayerToOpenChestSet(player);
            player.playSound(player.getLocation(),
                    Sound.BLOCK_CHEST_OPEN,15,0);

        }

    }

    private void addPlayerToOpenChestSet(Player player){
        if(playersWhichOpenChest.contains(player)){return;}

        playersWhichOpenChest.add(player);
    }

    private static int secondsToOpenChest = 60;

    public static void openChestTimer(){
        Bukkit.getScheduler().runTaskTimer(plugin, (task) -> {
            if(secondsToOpenChest < 0){
                secondsToOpenChest = 60;
                task.cancel();
                return;
            }
            secondsToOpenChest--;
        },0L,20L);
    }


    @EventHandler
    public void onClickInChest(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.DARK_GRAY+"Сундук арены")){
            if(!event.getCurrentItem().getType().equals(Material.GOLD_NUGGET)){return;}
            if(!event.getCurrentItem().getItemMeta().getDisplayName().equals(
                    ChatColor.GOLD+"+3 донат-валюты")){return;}
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                    "playerpoints:points give *player_name* 3");
            player.getInventory().removeItem(event.getCurrentItem());
            player.playSound(player.getLocation(),Sound.ENTITY_PLAYER_LEVELUP,3,3);
        }

    }

}
