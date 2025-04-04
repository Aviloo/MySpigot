package com.aviloo.mytraderreloaded.Commands.adminSubCommand;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class infoCommand {

    private static FileConfiguration messagesConfig =
            MyTraderReloaded.getPlugin().messagesFileManager.getMessagesConfig();

    public boolean infoSubCommand(CommandSender sender) {
        sender.sendMessage(" ");
        sender.sendMessage(ColorUtils.translateColorCodes("&fКоманды плагина &4MyTraderReloaded&f:"));
        sender.sendMessage(ColorUtils.translateColorCodes("&ereload &f-Перезагружает все конфиги."));
        sender.sendMessage(ColorUtils.translateColorCodes(
                "&eexpansions &f-Выводит в чат плейсхолдеры плагина."));
        sender.sendMessage(ColorUtils.translateColorCodes(
                "&ereputation &f- Позволяет редактировать репутацию игрока."));
        sender.sendMessage(ColorUtils.translateColorCodes(
                "&eearned &f-Позволяет редактировать счётчик заработанных игроком денег."));
        sender.sendMessage(ColorUtils.translateColorCodes(
                "&esecrettrader &f- Открывает меню скупщика, при клике на НПС &7(Доступно только из консоли)."));
        sender.sendMessage(ColorUtils.translateColorCodes("&einfo &f-Показывает описание всех команд."));
        sender.sendMessage(" ");
        return true;
    }

}
