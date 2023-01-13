package com.aviloo.serverutilsandtools.AdminTools.AdminDamage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ADmgCommand implements CommandExecutor, Listener {

    //HashMap Path
    //AdminDamageStatus Path
    private static ConcurrentHashMap<Player,Boolean> AdminDamageStatus = new ConcurrentHashMap<>();

    public static void setTrueDamage(Player player){
        AdminDamageStatus.put(player,true);
    }

    public static void setFalseDamage(Player player){
        AdminDamageStatus.put(player,false);
    }

    public static Boolean getValue(Player player){
        return AdminDamageStatus.get(player);
    }

    //NullShieldStatus Path
    private static ConcurrentHashMap<Player,Boolean> NullShieldStatus = new ConcurrentHashMap<>();

    public static void setTrueShied(Player player){
        AdminDamageStatus.put(player,true);
    }

    public static void setFalseShield(Player player){
        AdminDamageStatus.put(player,false);
    }

    public static Boolean getValueShield(Player player){
        return AdminDamageStatus.get(player);
    }

    //DamageCountPath
    private static final ConcurrentHashMap<Player,Double> DamageCount = new ConcurrentHashMap<>();

    public static void setDamage (Player player,Double value){
        DamageCount.put(player,value);
    }
    public static Double getDamage(Player player){
        return DamageCount.get(player);
    }

    //Event Path
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("SUAT.admin-dmg") || player.isOp()){
            setFalseDamage(player);
            setFalseShield(player);
            setDamage(player,0.0);
        }
    }

    //Command Path
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("This command can execute only players.");
            return true;
        }
        if(command.getName().equalsIgnoreCase("admin-damage")){
            Player player = (Player) sender;
            if(!player.isOp()){
                return true;
            }
            if(args.length < 1){
                return false;
            }

            if(Objects.equals(args[0], "on")){
                setTrueDamage(player);
            }
            if(Objects.equals(args[0], "off")){
                setFalseDamage(player);
            }
            if(Objects.equals(args[0], "flag")){
                if(Objects.equals(args[1], "NullShield")){
                    if(Objects.equals(args[2], "true")){
                        setTrueShied(player);
                    }
                    if(Objects.equals(args[2], "false")){
                        setFalseShield(player);
                    }
                    else return false;
                }
                if(Objects.equals(args[1], "damage-count")){
                    if(Objects.equals(args[2], "1")){
                        setDamage(player,1.0);
                    }
                    if(Objects.equals(args[2], "2")){
                        setDamage(player,2.0);
                    }
                    if(Objects.equals(args[2], "3")){
                        setDamage(player,3.0);
                    }
                    if(Objects.equals(args[2], "4")){
                        setDamage(player,4.0);
                    }
                    if(Objects.equals(args[2], "5")){
                        setDamage(player,5.0);
                    }
                    else return false;
                }
                if(Objects.equals(args[1], "CriticalStrikeChance")){
                    if(Objects.equals(args[2], "50")){

                    }
                    if(Objects.equals(args[2], "100")){

                    }
                    if(Objects.equals(args[2], "0")){

                    }
                    else return false;
                }
            }
        }
        return true;
    }
}
