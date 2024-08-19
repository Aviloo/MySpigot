package me.aviloo.mycrafts.Commands.subCommands;

import me.aviloo.mycrafts.Items.SphereManager;
import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Items.TotemsManager;
import me.aviloo.mycrafts.Items.Trap.TrapManager;
import me.aviloo.mycrafts.MyCrafts;
import me.aviloo.mycrafts.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GetItemsSubCommand {

    private static FileConfiguration items =
            MyCrafts.getPlugin().itemsFileManager.getItemsConfig();

    private static FileConfiguration messagesConfig =
            MyCrafts.getPlugin().messagesFileManager.getMessagesConfig();


    public boolean getItemSubCommand(CommandSender sender, String[] args) {

        switch (args[1]){
            case "head":
                ((Player) sender).getInventory().addItem(SphereManager.getSphereEnd());
                ((Player) sender).getInventory().addItem(SphereManager.getSphereNether());
                ((Player) sender).getInventory().addItem(SphereManager.getSphereOcean());
                break;
            case "totem":
                ((Player) sender).getInventory().addItem(TotemsManager.getTotemOfAgility());
                ((Player) sender).getInventory().addItem(TotemsManager.getTotemOfPower());
                ((Player) sender).getInventory().addItem(TotemsManager.getTotemOfStrength());
                break;
            case "trap":
                ((Player) sender).getInventory().addItem(TrapManager.Trap);
                break;
            case "tnt":
                ((Player) sender).getInventory().addItem(TNTManager.itemRed);
                ((Player) sender).getInventory().addItem(TNTManager.itemBlack);
                break;
            default:
                sender.sendMessage(ColorUtils.translateColorCodes(
                        messagesConfig.getString("prefix.system") +
                                messagesConfig.getString("command.IncorrectCommandUsage"))
                );
        }

        return true;
    }
}
