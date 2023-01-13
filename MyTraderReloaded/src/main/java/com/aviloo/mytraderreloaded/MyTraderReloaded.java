package com.aviloo.mytraderreloaded;

import com.aviloo.mytraderreloaded.DonateShop.Commands.OpenShop;
import com.aviloo.mytraderreloaded.DonateShop.Inventories.Events.*;
import com.aviloo.mytraderreloaded.DonateShop.Inventories.ShieldInventory;
import com.aviloo.mytraderreloaded.Seller.Inventories.Commands.OpenTrader;
import com.aviloo.mytraderreloaded.Seller.Inventories.Commands.ReloadType;
import com.aviloo.mytraderreloaded.Seller.Inventories.Commands.TraderForDonate;
import com.aviloo.mytraderreloaded.Seller.Inventories.Events.*;
import com.aviloo.mytraderreloaded.Seller.Inventories.Events.EpicEvents.GlobalEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyTraderReloaded extends JavaPlugin {

    private static String TraderType = "Screen1";

    private static Boolean isEpicType = false;

    public static Boolean getIsEpicType(){
        Boolean bool = isEpicType;
        return bool;
    }

    public static String getTraderType(){
        String string = TraderType;
        return string;
    }

    @Override
    public void onEnable() {
        //Methods(Seller)
        randomTraderType();

        //Events (Seller)
        Bukkit.getServer().getPluginManager().registerEvents(new Interact1(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new Interact2(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new Interact3(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new Interact4(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new Interact5(),this);

        Bukkit.getServer().getPluginManager().registerEvents(new GlobalEvents(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new InteractE(),this);

        //Commands(Seller)
        getCommand("secretsellercommand").setExecutor(new OpenTrader());
        getCommand("seller").setExecutor(new TraderForDonate());
        getCommand("sellertype").setExecutor(new ReloadType());

        //Events(DonateShop)
        Bukkit.getServer().getPluginManager().registerEvents(new MainInteract(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new ShieldInteract(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new ShieldInventory(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new VaultInteract(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new MushroomInteract(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new EnchantedInteract(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new EggsInteract(),this);

        //Commands(DonateShop)
        getCommand("secretdonatshopcommand").setExecutor(new OpenShop());

    }

    public static void randomTraderType(){
        if(Math.random() < 0.2){
            TraderType = "Screen1";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen1"));
            return;
        }
        if(Math.random() >= 0.2 && Math.random() < 0.4){
            TraderType = "Screen2";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen2"));
            return;
        }
        if(Math.random() >= 0.4 && Math.random() < 0.6){
            TraderType = "Screen3";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen3"));
            return;
        }
        if(Math.random() >= 0.6 && Math.random() < 0.8){
            TraderType = "Screen4";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen4"));
            return;
        }
        if(Math.random() >= 0.8 && Math.random() < 0.91){
            TraderType = "Screen5";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen5"));
            return;
        }
        if(Math.random() >= 0.91){
            TraderType = "ScreenE";
            isEpicType = true;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - &dScreenE"));
            return;
        }
    }
}
