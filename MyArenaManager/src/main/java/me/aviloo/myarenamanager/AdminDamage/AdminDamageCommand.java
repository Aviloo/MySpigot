package me.aviloo.myarenamanager.AdminDamage;

import me.aviloo.myarenamanager.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminDamageCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage(ColorUtils.translateColorCodes(
                    "&4[Ошибка(MyArenaManager)] &fЭту команду может использовать только игрок!"));
            return true;
        }

        if(command.getName().equalsIgnoreCase("admindamage")){
            Player player = (Player) commandSender;
            if(!player.hasPermission("ArenaManager.damage")){
                player.sendMessage(ColorUtils.translateColorCodes(
                        "&4Ошибка >>> &fУ вас недостаточно прав."));
                return true;
            }
            if(strings.length < 1){return false;}

            if(Objects.equals(strings[0], "default")){
                AdminDamageListener.setDamageBuff(player,0);
                player.sendMessage(ColorUtils.translateColorCodes(
                        "&eУрон >>> &fУвеличитель вашего урона отключен."));
                return true;
            }
            if(Objects.equals(strings[0], "set")){
                if(strings.length < 2){return false;}
                if(!isNumber(strings[1])){
                    player.sendMessage(ColorUtils.translateColorCodes(
                            "&4Ошибка >>> &fИспользуйте цифры 2-м аргументом."));
                    return true;
                }
                if(isNegative(Integer.parseInt(strings[1]))){
                    player.sendMessage(ColorUtils.translateColorCodes(
                            "&4Ошибка >>> &fИспользуйте положительные числа."));
                    return true;
                }
                if(isNumberOverBillion(Integer.parseInt(strings[1]))){
                    player.sendMessage(ColorUtils.translateColorCodes(
                            "&4Ошибка >>> &fПредел увеличения урона -" +
                                    "&f это один миллиард."));
                    return true;
                }

                AdminDamageListener.setDamageBuff(player, Integer.valueOf(strings[1]));
                player.sendMessage(ColorUtils.translateColorCodes(
                        "&eУрон >>> &fУвеличитель вашего урона включен." +
                                " &7(Ваш урон увеличен на "+strings[1]+"&7 е.д урона)"));
                return true;
            }

        }

        return true;
    }

    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    public boolean isNegative(int num){
        if(num<0) {
            return true;
        }
        return false;
    }

    public boolean isNumberOverBillion(int num){
        if(num>1000000000){
            return true;
        }
        return false;
    }

    //Completer Path
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> commandsFirst = new ArrayList<>();
        if(args.length == 1){
            List<String> completions = new ArrayList<>();
            completions.add("default");
            completions.add("set");
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
