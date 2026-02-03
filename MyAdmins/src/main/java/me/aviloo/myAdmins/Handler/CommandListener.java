package me.aviloo.myAdmins.Handler;

import me.aviloo.myAdmins.Events.BanEvent;
import me.aviloo.myAdmins.Events.KickEvent;
import me.aviloo.myAdmins.Events.TempBanEvent;
import me.aviloo.myAdmins.Events.TempMuteEvent;
import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Models.Punishment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CommandListener implements Listener {

    @EventHandler
    public void kickPlayer(KickEvent event){
        if(!(event.getSender() instanceof Player)){return;}
        Player admin = (Player) event.getSender();
        Admin.getAdminByPlayer(admin).addKick();
        new Punishment(Punishment.getPunishmentCount()+1,
        Punishment.PunishmentType.KICK,event.getPlayer().getName(),event.getPlayer().getUniqueId().toString(),
        event.getSender().getName(),((Player) event.getSender()).getUniqueId().toString(), event.getReason(), event.getPlayer().
        getAddress().getHostString());
    }

    @EventHandler
    public void banPlayer(BanEvent event){
        if(!(event.getSender() instanceof Player)){return;}
        Player admin = (Player) event.getSender();
        Admin.getAdminByPlayer(admin).addBan();
        new Punishment(Punishment.getPunishmentCount()+1,
        Punishment.PunishmentType.BAN,event.getPlayer().getName(),event.getPlayer().getUniqueId().toString(),
        event.getSender().getName(),((Player) event.getSender()).getUniqueId().toString(),event.getReason(),event.getPlayer().
        getAddress().getHostString());
    }

    @EventHandler
    public void banIPPlayer(BanEvent event){
        if(!(event.getSender() instanceof Player)){return;}
        Player admin = (Player) event.getSender();
        Admin.getAdminByPlayer(admin).addBanIP();
        new Punishment(Punishment.getPunishmentCount()+1,
                Punishment.PunishmentType.BANIP,event.getPlayer().getName(),event.getPlayer().getUniqueId().toString(),
                event.getSender().getName(),((Player) event.getSender()).getUniqueId().toString(),event.getReason(),event.getPlayer().
                getAddress().getHostString());
    }

    @EventHandler
    public void tempBan(TempBanEvent event){
        if(!(event.getSender() instanceof Player)){return;}
        Player admin = (Player) event.getSender();
        Admin.getAdminByPlayer(admin).addTempban();
        new Punishment(Punishment.getPunishmentCount()+1,
                Punishment.PunishmentType.TEMPBAN,event.getPlayer().getName(),event.getPlayer().getUniqueId().toString(),
                event.getSender().getName(),((Player) event.getSender()).getUniqueId().toString(),event.getReason(),event.getPlayer().
                getAddress().getHostString());
    }

    @EventHandler
    public void tempMute(TempMuteEvent event){
        if(!(event.getSender() instanceof Player)){return;}
        Player admin = (Player) event.getSender();
        Admin.getAdminByPlayer(admin).addTempmute();
        new Punishment(Punishment.getPunishmentCount()+1,
                Punishment.PunishmentType.TEMPMUTE,event.getPlayer().getName(),event.getPlayer().getUniqueId().toString(),
                event.getSender().getName(),((Player) event.getSender()).getUniqueId().toString(),event.getReason(),event.getPlayer().
                getAddress().getHostString());
    }


}
