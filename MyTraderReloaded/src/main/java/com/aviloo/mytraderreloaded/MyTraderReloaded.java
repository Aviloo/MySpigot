package com.aviloo.mytraderreloaded;

import com.aviloo.mytraderreloaded.DonateShop.Commands.OpenShop;
import com.aviloo.mytraderreloaded.DonateShop.Inventories.Events.*;
import com.aviloo.mytraderreloaded.DonateShop.Inventories.ShieldInventory;
import com.aviloo.mytraderreloaded.GeneralCommands.ReloadConfigCommand;
import com.aviloo.mytraderreloaded.Seller.Commands.OpenTrader;
import com.aviloo.mytraderreloaded.Seller.Commands.ReloadType;
import com.aviloo.mytraderreloaded.Seller.Commands.TraderForDonate;
import com.aviloo.mytraderreloaded.Seller.Events.*;
import com.aviloo.mytraderreloaded.Seller.Events.EpicEvents.GlobalEvents;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayersStats;
import com.aviloo.mytraderreloaded.Seller.Utils.PriceManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyTraderReloaded extends JavaPlugin {

    //todo 1. Добавить подключение к бд
    //todo 2. Настроить список лидеров
    //todo 3. Добавить товары за репутацию
    //todo 4. Добавить больше Инвентарей min- до 10 ,max- до 25
    //todo 5. Оптимизировать Interact (Например: убрать бесполезные try and catch блоки)
    //todo 5.1 Можно объеденить все интеракты в один
    //todo 6. Настроить PriceManager корректно

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
        //General Methods
        loadConfig();
        startingAlerts();
        //GeneralCommands
        getCommand("mytrader").setExecutor(new ReloadConfigCommand(this));
        getCommand("mytrader").setTabCompleter(new ReloadConfigCommand(this));

        if(this.getConfig().getBoolean("usePluginTradeSystem")) {
            //Methods(Seller)
            randomTraderType();
            PriceManager.allProductSetUp();

            //Events (Seller)
                //Inventory Events (Seller)
            Bukkit.getServer().getPluginManager().registerEvents(new Interact1(this), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact2(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact3(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact4(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact5(), this);

            //тестовый класс
            Bukkit.getServer().getPluginManager().registerEvents(new GeneralInteract(this),this);

            Bukkit.getServer().getPluginManager().registerEvents(new InteractE(), this);
                //General Events (Seller)
            Bukkit.getServer().getPluginManager().registerEvents(new GlobalEvents(this), this);
            Bukkit.getServer().getPluginManager().registerEvents(new PlayersStats(),this);

            //Commands(Seller)
            getCommand("secretsellercommand").setExecutor(new OpenTrader());
            getCommand("seller").setExecutor(new TraderForDonate());
            getCommand("sellertype").setExecutor(new ReloadType());
        }

        if(this.getConfig().getBoolean("usePluginShop")) {
            //Events(DonateShop)
            Bukkit.getServer().getPluginManager().registerEvents(new MainInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new ShieldInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new ShieldInventory(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new VaultInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new MushroomInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new EnchantedInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new EggsInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new AnotherInteract(), this);

            //Commands(DonateShop)
            getCommand("secretdonatshopcommand").setExecutor(new OpenShop());
        }

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

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void startingAlerts(){
        if(!this.getConfig().getBoolean("usePluginShop") && this.getConfig().getBoolean("usePluginTradeSystem")){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"" +
                    "&7[MyTraderReloaded] &4Внимание! В плагине отключена функция донат-магазина." +
                    " &7(Изменить это можно в конфиге плагина)"));
        }
        if(!this.getConfig().getBoolean("usePluginTradeSystem") && this.getConfig().getBoolean("usePluginShop")){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"" +
                    "&7[MyTraderReloaded] &4Внимание! В плагине отключена функция торговца." +
                    " &7(Изменить это можно в конфиге плагина)"));
        }
        if(!this.getConfig().getBoolean("usePluginTradeSystem") && !this.getConfig().getBoolean("usePluginShop")){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"" +
                    "&7[MyTraderReloaded] &4Внимание. В плагине отключены функции магазина и торговца." +
                    " &7(Изменить это можно в конфиге плагина)"));
        }else {
         Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"" +
                 "&7[MyTraderReloaded] &aПлагин был успешо загружен."));
        }
        startingArtImage();
    }

    private void startingArtImage(){
        Bukkit.getConsoleSender().sendMessage(" .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. ");
        Bukkit.getConsoleSender().sendMessage("| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |");
        Bukkit.getConsoleSender().sendMessage("| |  _________   | || |  _______     | || |      __      | || |  ________    | || |  _________   | || |  _______     | |");
        Bukkit.getConsoleSender().sendMessage("| | |  _   _  |  | || | |_   __ \\    | || |     /  \\     | || | |_   ___ `.  | || | |_   ___  |  | || | |_   __ \\    | |");
        Bukkit.getConsoleSender().sendMessage("| | |_/ | | \\_|  | || |   | |__) |   | || |    / /\\ \\    | || |   | |   `. \\ | || |   | |_  \\_|  | || |   | |__) |   | |");
        Bukkit.getConsoleSender().sendMessage("| |     | |      | || |   |  __ /    | || |   / ____ \\   | || |   | |    | | | || |   |  _|  _   | || |   |  __ /    | |");
        Bukkit.getConsoleSender().sendMessage("| |    _| |_     | || |  _| |  \\ \\_  | || | _/ /    \\ \\_ | || |  _| |___.' / | || |  _| |___/ |  | || |  _| |  \\ \\_  | |");
        Bukkit.getConsoleSender().sendMessage("| |   |_____|    | || | |____| |___| | || ||____|  |____|| || | |________.'  | || | |_________|  | || | |____| |___| | |");
        Bukkit.getConsoleSender().sendMessage("| |              | || |              | || |              | || |              | || |              | || |              | |");
        Bukkit.getConsoleSender().sendMessage("| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |");
        Bukkit.getConsoleSender().sendMessage(" '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"                                                                                                                by Aviloo");
    }
}
