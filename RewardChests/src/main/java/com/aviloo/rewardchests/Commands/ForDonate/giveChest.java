package com.aviloo.rewardchests.Commands.ForDonate;

import com.aviloo.rewardchests.ItemStack.Chests.fisherChest;
import com.aviloo.rewardchests.RewardChests;
import com.aviloo.rewardchests.Utils.getPlayerOnline;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class giveChest implements CommandExecutor {

    private static JavaPlugin plugin;

    public giveChest(JavaPlugin plugin){
        this.plugin = plugin;
    }

    private String getLink(){
        String link = plugin.getConfig().getString("online-shop-link");
        return link;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("This command can execute only ConsoleCommandSenders!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("givechest")){
            if(args.length < 2){
                return false;
            }

            String PlayerName = args[1];
            Player argPlayer = Bukkit.getServer().getPlayer(PlayerName);
            if (argPlayer == null) {
                sender.sendMessage("Данный игрок оффлайн.");
                return true;
            }
            if(Objects.equals(args[0], "fisher_chest")){
                argPlayer.getInventory().addItem(fisherChest.chestStack());
                for(Player ps :getPlayerOnline.getOnlinePlayers()){
                    ps.sendMessage(ChatColor.GRAY+"[Информация] " + ChatColor.WHITE+ argPlayer.getDisplayName() + " купил(а) ларец рыбака в нашем магазине.");

                    TextComponent link = new TextComponent(ChatColor.GRAY+"[Ссылка] "+ChatColor.GREEN+ getLink());
                    //link.setFont("minecraft:uniform");
                    link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, getLink()));

                    ps.spigot().sendMessage(link);
                }
            }
        }
        return true;
    }
}
