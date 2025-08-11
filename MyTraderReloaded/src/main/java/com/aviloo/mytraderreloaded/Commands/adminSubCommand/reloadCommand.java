package com.aviloo.mytraderreloaded.Commands.adminSubCommand;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Inventories.InfoInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import com.aviloo.mytraderreloaded.Seller.Utils.PriceManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class reloadCommand {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean reloadSubCommand(CommandSender sender,String[] args) {
        switch (args[1]){
            case "reload config":
                MyTraderReloaded.getPlugin().reloadConfig();
                MyTraderReloaded.getPlugin().menuFileManager.reloadMenuConfig();
                MyTraderReloaded.getPlugin().messagesFileManager.reloadMessagesConfig();
                MyTraderReloaded.getPlugin().sellerSettingsFileManager.reloadSettingsSellerConfig();
                MyTraderReloaded.getPlugin().usermapFileManager.reloadUsermapConfig();
                if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                    MyTraderReloaded.getPlugin().databaseFileManager.reloadDatabaseConfig();
                }
                sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_plugin_with_brackets")+
                        messagesConfig.getString("command_config_has_been_reloaded")));
                break;
            case "reload menu":
                PriceManager.allProductSetUp();
                PriceManager.allReputationProductsSetUp();
                MyTraderReloaded.getPlugin().setSellerInventory();
                InfoInventory.setupInfoInventory();
                sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_plugin_with_brackets")+
                        messagesConfig.getString("command_menu_has_been_reloaded")));
                break;
            case "reload all":
                MyTraderReloaded.getPlugin().reloadConfig();
                MyTraderReloaded.getPlugin().menuFileManager.reloadMenuConfig();
                MyTraderReloaded.getPlugin().messagesFileManager.reloadMessagesConfig();
                MyTraderReloaded.getPlugin().sellerSettingsFileManager.reloadSettingsSellerConfig();
                MyTraderReloaded.getPlugin().usermapFileManager.reloadUsermapConfig();
                if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")){
                    MyTraderReloaded.getPlugin().databaseFileManager.reloadDatabaseConfig();
                }
                PriceManager.allProductSetUp();
                PriceManager.allReputationProductsSetUp();
                MyTraderReloaded.getPlugin().setSellerInventory();
                InfoInventory.setupInfoInventory();
                sender.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("prefix_plugin_with_brackets")+
                        messagesConfig.getString("command_plugin_has_been_reloaded")));
                break;
            default:
                sender.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"У данной команды есть аргументы:" +
                        " config|menu|all.");
        }

        return true;
    }

}
