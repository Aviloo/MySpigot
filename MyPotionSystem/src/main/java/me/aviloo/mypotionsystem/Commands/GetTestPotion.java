package me.aviloo.mypotionsystem.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GetTestPotion implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[Система] &fВы не можете использовать эту команду."));
            return true;
        }
        if(command.getName().equalsIgnoreCase("gettestpotion")){
            Player player = (Player) sender;
            if(!player.isOp()){return true;}

            ItemStack item = new ItemStack(Material.POTION,1);
            PotionMeta meta = (PotionMeta) item.getItemMeta();
            meta.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION,999999999,100),true);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
        }
        return true;
    }
}
