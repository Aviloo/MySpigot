package me.aviloo.myarenamanager.PvpChest.Commands;

import me.aviloo.myarenamanager.PvpChest.ChestListener;
import me.aviloo.myarenamanager.PvpChest.Utils.HologramChestUtils;
import me.aviloo.myarenamanager.PvpChest.Utils.StatusChestUtils;
import me.aviloo.myarenamanager.Utils.ColorUtils;
import me.aviloo.myarenamanager.Utils.MessagesUtils;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChestStatusCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player) && !(commandSender instanceof ConsoleCommandSender)){
            commandSender.sendMessage(ColorUtils.translateColorCodes(
                    "&4[Ошибка(MyArenaManager)] &fЭту команду может использовать только игрок или консоль!"));
            return true;
        }

        if(command.getName().equalsIgnoreCase("arenachest")){
            if(!commandSender.isOp()){
                return true;
            }
            if(strings.length < 1){
                return false;
            }

            if(Objects.equals(strings[0], "canbeactivate")){
                StatusChestUtils.setCanBeActivatedStatus();
                HologramChestUtils.updateChestHologram();
                commandSender.sendMessage(ColorUtils.translateColorCodes(
                        "&6ArenaManager >>> &fВы сменили статус сундука."));
                return true;
            }
            if(Objects.equals(strings[0], "activated")){
                StatusChestUtils.setActivatingStatus();
                HologramChestUtils.updateChestHologram();
                ChestListener.openChestTimer();
                commandSender.sendMessage(ColorUtils.translateColorCodes(
                        "&6ArenaManager >>> &fВы сменили статус сундука."));
                MessagesUtils.sendChestActivateMessage();
                return true;
            }
            if(Objects.equals(strings[0], "open")){
                StatusChestUtils.setChestOpen();
                HologramChestUtils.updateChestHologram();
                commandSender.sendMessage(ColorUtils.translateColorCodes(
                        "&6ArenaManager >>> &fВы сменили статус сундука."));
                return true;
            }
            if(Objects.equals(strings[0], "inactive")){
                StatusChestUtils.setInactiveStatus();
                HologramChestUtils.updateChestHologram();
                commandSender.sendMessage(ColorUtils.translateColorCodes(
                        "&6ArenaManager >>> &fВы сменили статус сундука."));
                return true;
            }
            if(Objects.equals(strings[0], "broken")){
                StatusChestUtils.setBrokenStatus();
                HologramChestUtils.updateChestHologram();
                commandSender.sendMessage(ColorUtils.translateColorCodes(
                        "&6ArenaManager >>> &fВы сменили статус сундука."));
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
            completions.add("canbeactivate");
            completions.add("activated");
            completions.add("open");
            completions.add("inactive");
            completions.add("broken");
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
