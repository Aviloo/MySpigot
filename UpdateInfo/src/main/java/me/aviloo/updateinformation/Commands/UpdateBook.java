package me.aviloo.updateinformation.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class UpdateBook implements CommandExecutor {
    //Item Path
    private ItemStack updBook(){
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK,1);
        BookMeta bookMeta = (BookMeta) book.getItemMeta();
        bookMeta.setTitle(ChatColor.YELLOW+"Информация об обновлении");
        bookMeta.setAuthor("Администрация Orumii");
        //На одну строку вмещяется 19 символов . На страницу вмещяется 14 строк
        bookMeta.addPage(ChatColor.BLACK+"      Новости      "+
                ChatColor.GRAY+"["+ChatColor.GOLD+"+"+ChatColor.GRAY+"] "+ "Добавлен боевой" +
                " пропуск.          "+
                "Доступ к боевому пропуску получат игроки с статусом Miracle и выше.Боевой пропуск обновляется " +
                "каждую неделю.Боевой пропуск содержит в себе 7 уровней,а также 3 специальных уровня.Игрок который" +
                "зароботал больше всего опыта");
        bookMeta.addPage(ChatColor.GRAY+" за неделю получит приз(На усмотрение администрации.)"+
                "["+ChatColor.GOLD+"+"+ChatColor.GRAY+"] "+ "Ларцы          "+
                "Добавленна система ларцов.Теперь за рутинные действия вам может выпасть ларец с наградой."+
                "Ларцы различают на 3 уровня.Первый уровень - Обычные ларцы, особым лутом не отличаются,Второй уровень -" +
                "Эпический ларец,");
        bookMeta.addPage(ChatColor.GRAY+"уже более интересная награда, Третий уровень - Легендарый ларец,лут высшего класса." +
                "Ларцы можно приобрести за донат валюту в магазине." +
                "["+ChatColor.GOLD+"+"+ChatColor.GRAY+"] "+ "Квесты         "+
                "Обновленны квесты.В квесты для новичков был добавлен квест с ларцами.");
        bookMeta.addPage(ChatColor.GRAY+"["+ChatColor.GOLD+"+"+ChatColor.GRAY+"] "+"Баг-фикс     " +
                "-Исправлен баг с лодкой               " +
                "-Исправлен баг застревания на квестах " +
                "-Исправлен баг 'Уничтожение карт'     " +
                "-Исправлен баг индикатора урона       " +
                "-Исправлен баг бесконечных зол. яблок ");
        book.setItemMeta(bookMeta);
        return book;
    }

    //Command Path
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("This command can execute only Players");
            return true;
        }
        if(command.getName().equalsIgnoreCase("updatebook")){
            Player player = (Player) sender;
            if(hasAvaliableSlot(player)){
                player.getInventory().addItem(updBook());
                return true;
            }
            if(!hasAvaliableSlot(player)){
                player.sendMessage(ChatColor.GRAY+"[Система] "+"Ваш инвентарь переполнен! Освободите один слот.");
                return true;
            }
        }
        return true;
    }

    public boolean hasAvaliableSlot(Player player){
        Inventory inv = player.getInventory();
        for (ItemStack item: inv.getContents()) {
            if(item == null) {
                return true;
            }
        }
        return false;
    }
}
