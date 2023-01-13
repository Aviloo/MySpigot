package com.aviloo.serverutilsandtools.AdminTools.AdminMode;

import com.aviloo.serverutilsandtools.AdminTools.AdminMode.Stats.AdministratorProperties;
import com.sun.tools.javac.util.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedHashMap;

public class AMEvents implements Listener {
    //Plugin Path
    private JavaPlugin plugin;

    public AMEvents(JavaPlugin plugin){
        this.plugin = plugin;
    }

    //Admin Events
    @EventHandler(priority = EventPriority.HIGH,ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("SUAT.adminmode") && !player.isOp()){return;}
        AMCommands.setFalse(player);
    }

    @EventHandler
    public void onBannedCommands(PlayerCommandPreprocessEvent event){
        if(!event.getPlayer().hasPermission("SUAT.adminmode")){return;}
        if(event.getPlayer().isOp()){return;}
        if(AMCommands.getStatus(event.getPlayer())){return;}

        if(event.getMessage().contains("/tp") || event.getMessage().contains("/ban")
        || event.getMessage().contains("/tempban") || event.getMessage().contains("/mute")
        || event.getMessage().contains("/kick") || event.getMessage().contains("/suspect")
        || event.getMessage().contains("/teleport") || event.getMessage().contains("/tempmute")
        || event.getMessage().contains("/gm") || event.getMessage().contains("v")
        || event.getMessage().contains("/vanish")){
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED+"[Админ-Панель] "+ChatColor.WHITE+"Чтобы использовать" +
                    " эту комманду, вам необходимо включить режим администратора. (P.S: /adminemode on)");
        }
    }
    //For NullPointException
    @EventHandler(priority = EventPriority.HIGH,ignoreCancelled = true)
    public void onOp(PlayerCommandPreprocessEvent event){
        CommandSender sender = event.getPlayer();
        if(!event.getMessage().contains("/op")){return;}
            String name = event.getMessage().substring(4);
            try{
                Player player = Bukkit.getPlayer(name);
                AMCommands.setTrue(player);
            }catch (NullPointerException npe){
                sender.sendMessage(ChatColor.RED+"[Системная Ошибка] "+ChatColor.WHITE+"Данного игрока нет онлайн!");
                event.setCancelled(true);
            }
    }

    //Regular Events
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Выбор режима")){
            try{
                switch (event.getCurrentItem().getType()){
                    case GREEN_DYE:
                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        break;
                    case RED_DYE:
                        player.setGameMode(GameMode.CREATIVE);
                        player.closeInventory();
                        break;
                }
            }catch (NullPointerException e){}
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("SUAT.adminmode") && !player.isOp()){return;}
        if(!AMCommands.getStatus(player)){return;}

        AMCommands.setFalse(player);
        player.getInventory().clear();
        player.getInventory().setContents(AMCommands.returnInventory(player));
        //Timer Path
        AdministratorProperties.setEndTime(player.getUniqueId());
        AdministratorProperties.setSession(player.getUniqueId());
        AdministratorProperties.setAdmin(player.getUniqueId());
        AdministratorProperties.setDefaultStartTime(player.getUniqueId());
    }

    //Events for Utils
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        AMUtils.addPlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        AMUtils.removePlayer(event.getPlayer());
    }

    //Items Events
    @EventHandler
    public void onInventoryMove(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(!AMCommands.getStatus(player)){return;}

        event.setCancelled(true);
    }

    @EventHandler
    public void pickUp(EntityPickupItemEvent event){
        if(!(event.getEntity() instanceof Player)){return;}
        Player player = (Player) event.getEntity();
        if(!AMCommands.getStatus(player)){return;}

        event.setCancelled(true);
    }
    //Custom Admin Events
    @EventHandler
    public void onAdminJoin(PlayerJoinEvent event){
        if(!event.getPlayer().hasPermission("SUAT.adminmode") && !event.getPlayer().isOp()){return;}
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            event.getPlayer().sendMessage(ChatColor.GRAY+"[Админ-Панель] "+ChatColor.WHITE+"Чтобы войти в " +
                    "режим администратора используйте - /adminmode on");
        },30);
    }
    //Fourth Item Events
    @EventHandler
    public void onBook(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(!player.getInventory().getItemInMainHand().equals(AMCommands.fourthItem())){return;}
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            player.sendMessage("-----------------");
            player.sendMessage("/ban - забанить игрока навсегда");
            player.sendMessage("/tempban - забанить игрока навремя");
            player.sendMessage("/kick - кикнуть игрока");
            player.sendMessage("/adminmode on/off - включить/выключить режим администратора");
            player.sendMessage("/adc {ваше сообщение} - чат только для модераторов/стаффа");
            player.sendMessage("/suspect on/off {ник игрока} - включает/выключает режим подозреваемого для игрока" +
                    "(P.S: Обязательно использовать при проверке на читы и прочих нарушений.)");
            player.sendMessage("/mute - запретить игроку писать в чат.");
            player.sendMessage("-----------------");
        }else return;
    }

    @EventHandler
    public void onBookTryDrop(PlayerDropItemEvent event){
        if(!event.getItemDrop().getItemStack().equals(AMCommands.fourthItem())){return;}
        event.setCancelled(true);
    }

    //Events for first item
    @EventHandler
    public void onVanish(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(!player.getInventory().getItemInMainHand().equals(AMCommands.firstItem())){return;}
        if(event.getAction().equals(Action.PHYSICAL)){return;}
        Bukkit.dispatchCommand(player,"vanish");
    }
    @EventHandler
    public void onVanishTryDrop(PlayerDropItemEvent event){
        if(!event.getItemDrop().getItemStack().equals(AMCommands.firstItem())){return;}
        if(AMCommands.getStatus(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
    //Events for third item
    @EventHandler
    public void onKick(EntityDamageByEntityEvent event){
        if(!(event.getDamager() instanceof Player)){return;}
        if(!(event.getEntity() instanceof Player)){return;}
        Player player = (Player) event.getEntity();
        Player admin = (Player) event.getDamager();
        if(!admin.getInventory().getItemInMainHand().equals(AMCommands.thirdItem())){return;}
        player.kickPlayer("Помеха. :3");
    }
    @EventHandler
    public void onKickTryDrop(PlayerDropItemEvent event){
        if(!event.getItemDrop().getItemStack().equals(AMCommands.thirdItem())){return;}
        if(AMCommands.getStatus(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
}
