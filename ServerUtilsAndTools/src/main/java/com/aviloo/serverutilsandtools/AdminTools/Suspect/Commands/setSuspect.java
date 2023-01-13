package com.aviloo.serverutilsandtools.AdminTools.Suspect.Commands;

import com.aviloo.serverutilsandtools.AdminTools.Suspect.Suspect;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class setSuspect implements CommandExecutor {

    private JavaPlugin plugin;

    public setSuspect(JavaPlugin plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("This command can execute ONLY player.");
            return true;
        }
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("suspect")){
            if(player.hasPermission("SUAT.suspect")){
                if(args.length < 2){
                    return false;
                }

                String PlayerName = args[1];
                Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
                if (argPlayer == null) {
                    sender.sendMessage("Данный игрок оффлайн.");
                    return true;
                }

                if(Objects.equals(args[0], "on")){
                    //Timer Settings
                    Server server = plugin.getServer();
                    int seconds = 1;
                    int period = 5;
                    //Continue
                    Suspect.setTrue(argPlayer.getUniqueId());
                    argPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,999999999,250000));
                    argPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,999999999,250000));
                    argPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,999999999,250000));
                    server.getScheduler().runTaskTimer(plugin, (task) -> {
                        argPlayer.sendMessage(" ");
                        argPlayer.sendMessage(ChatColor.AQUA+"Внимание! Вы заподозрены в нарушении правил проекта. Напишите свой дискорд в чат, чтобы" +
                                " администрация могла проверить вас. Если вы покините игру , вам будет выданно наказание - бан на 20 дней" +
                                " за уход от проверки." + "Чтобы скинуть дискорд , у вас 5 минут!");
                        argPlayer.sendMessage(ChatColor.RED+"Если у вас есть мут, не переживайте, в рамках данной проверки " +
                                "вы можете писать в чат!");
                        argPlayer.sendMessage(" ");

                        if(!Suspect.getValue(argPlayer.getUniqueId())){
                            task.cancel();
                        }
                    }, seconds * 20L, period * 20L);
                    return true;
                }
                if(Objects.equals(args[0], "off")){
                    Suspect.setFalse(argPlayer.getUniqueId());
                    argPlayer.removePotionEffect(PotionEffectType.SLOW);
                    argPlayer.removePotionEffect(PotionEffectType.BLINDNESS);
                    argPlayer.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                    player.sendMessage(ChatColor.GRAY+"[Система] " + ChatColor.GREEN + "Вы сняли обвинения с игрока " + argPlayer.getName());
                }
            }
        }
        return true;
    }
}
