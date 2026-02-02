package me.aviloo.myAdmins.Handler;

import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Models.PluginPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerHandler implements Listener {

    @EventHandler
    public void onAdminQuit(PlayerQuitEvent event) throws ParseException {
        if(!Admin.isPlayerAdmin(event.getPlayer())){return;}
        Admin.getAdminByPlayer(event.getPlayer()).setLast_session_time(
        calculatePlayedTime(Admin.getAdminByPlayer(event.getPlayer())));
        Admin.getAdminByPlayer(event.getPlayer()).
        setLast_connection_date(new SimpleDateFormat(
        "dd-MM-yyyy HH:mm").format(new Date()));
        Admin.getAdminByPlayer(event.getPlayer()).
        setLast_ip(Admin.getAdminByPlayer(event.getPlayer()).getCurrent_ip());

    }

    @EventHandler
    public void onPlayerFirstTimeJoin(PlayerJoinEvent event){
        if(!event.getPlayer().hasPlayedBefore()){return;}
        new PluginPlayer(event.getPlayer().getUniqueId(),event.getPlayer().getName(),
        event.getPlayer().getAddress().getHostString());
    }

    @EventHandler
    public void onAdminJoin(PlayerJoinEvent event){
        if(!Admin.isPlayerAdmin(event.getPlayer())){return;}
        Admin.getAdminByPlayer(event.getPlayer()).setCurrent_Connection(
        new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()));
    }

    private String calculatePlayedTime(Admin admin) throws ParseException {
        if(admin.getLast_connection_date() == null){return "null";}

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date1 = sdf.parse(admin.getCurrent_Connection());
        Date date2 = sdf.parse(sdf.format(new Date()));
        long differenceInMillis = date2.getTime() - date1.getTime();
        int minutes = (int) differenceInMillis / (1000 * 60);
        return minutes +" мин.";
    }

    public static List<org.bukkit.entity.Player> adminsOnline = new ArrayList<Player>();
    @EventHandler
    public void AdminsJoin(PlayerJoinEvent event){
        if(!Admin.isPlayerAdmin(event.getPlayer())){return;}
        adminsOnline.add(event.getPlayer());
    }

    @EventHandler
    public void AdminsLeave(PlayerQuitEvent event){
        if(!Admin.isPlayerAdmin(event.getPlayer())){return;}
        adminsOnline.remove(event.getPlayer());
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if(PluginPlayer.getPluginPlayerByPlayer(event.getPlayer())==null){return;}
        if(!PluginPlayer.getPluginPlayerByPlayer(event.getPlayer()).isMuted()){return;}
        event.setCancelled(true);
        event.getPlayer().sendMessage(ChatColor.DARK_GRAY+"[Мут] "
        +ChatColor.GOLD+"На вас наложили мут."+ChatColor.GRAY+
        " Дата: "+new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()));
    }

}
