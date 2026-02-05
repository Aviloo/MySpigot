package me.aviloo.myAdmins.Commands.SubCommands;

import me.aviloo.myAdmins.Models.Admin;
import me.aviloo.myAdmins.Utils.StorageUtils.AdminmapStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class DeleteAdminCommand {

    public boolean execute(CommandSender sender, String[] args) {
        if(!sender.isOp()){
            sender.sendMessage("Недостаточно прав");
            return true;
        }
        if(args.length <1){return false;}

        Admin target;
        try{
            target = Admin.getAdminByName(args[1]);
            if(target == null){
                sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Нет админа с таким ником.");
                return true;
            }
        }catch (NullPointerException e){
            sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Нет админа с таким ником.");
            return true;
        }

        AdminmapStorageUtil.deleteFromUsermap(target.getUuid());
        target.delete();
        sender.sendMessage(ChatColor.GREEN+"Администратор "+target.getName()+" был снят!");
        target = null;

        return true;
    }

}
