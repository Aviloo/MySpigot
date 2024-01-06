package me.aviloo.myarenamanager.MoneyPlate.Commands;

import me.aviloo.myarenamanager.MoneyPlate.Utils.HologramPlateUtil;
import me.aviloo.myarenamanager.Utils.MessagesUtils;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SetPlateCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player) && !(commandSender instanceof ConsoleCommandSender)){
            return true;
        }

        if(command.getName().equalsIgnoreCase("setplate")){
            if(!commandSender.isOp()){
                return true;
            }
            if(strings.length < 1){
                return false;
            }

            if (strings[0].equalsIgnoreCase("true")) {
                HologramPlateUtil.setPlateStatus(true);
                HologramPlateUtil.updateHologramPlate();
                MessagesUtils.sendPlateMessage();
                return true;
            }
            if(strings[0].equalsIgnoreCase("false")){
                HologramPlateUtil.setPlateStatus(false);
                HologramPlateUtil.updateHologramPlate();
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
            completions.add("true");
            completions.add("false");
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
