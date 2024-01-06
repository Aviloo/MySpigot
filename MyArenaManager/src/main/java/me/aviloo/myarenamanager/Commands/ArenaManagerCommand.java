package me.aviloo.myarenamanager.Commands;

import me.aviloo.myarenamanager.MoneyPlate.Utils.HologramPlateUtil;
import me.aviloo.myarenamanager.MyArenaManager;
import me.aviloo.myarenamanager.PvpChest.Utils.HologramChestUtils;
import me.aviloo.myarenamanager.Utils.ColorUtils;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArenaManagerCommand implements CommandExecutor, TabCompleter {

    private static MyArenaManager plugin;
    public ArenaManagerCommand(MyArenaManager plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player) && !(commandSender instanceof ConsoleCommandSender)){
            commandSender.sendMessage(ColorUtils.translateColorCodes(
                    "&4[Ошибка(MyArenaManager)] &fЭту команду может использовать только игрок или консоль!"));
            return true;
        }

        if(command.getName().equalsIgnoreCase("arenamanager")){
            if(!commandSender.isOp()){
                return true;
            }
            if(strings.length < 1){
                return false;
            }

            if(strings[0].equalsIgnoreCase("reload")){
                MyArenaManager.getPlugin().locationFileManager.reloadLocationConfig();
                plugin.reloadConfig();
                commandSender.sendMessage(ColorUtils.translateColorCodes(
                      "&7[Система] &fВсе конфиги перезагружены."));
                HologramPlateUtil.updateHologramPlate();
                HologramChestUtils.updateChestHologram();
                commandSender.sendMessage(ColorUtils.translateColorCodes(
                        "&7[Система] &fВсе голограммы перезагружены."));
                return true;
            }

        }
        return true;
    }

    //Completer Path
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> commandsFirst = new ArrayList<>();
        if(args.length == 1){
            List<String> completions = new ArrayList<>();
            completions.add("reload");
            for(String s : completions){
                if(s.toLowerCase().startsWith(args[0].toLowerCase())){
                    commandsFirst.add(s);
                }
            }
            return commandsFirst;
        }
        return null;
    }

}
