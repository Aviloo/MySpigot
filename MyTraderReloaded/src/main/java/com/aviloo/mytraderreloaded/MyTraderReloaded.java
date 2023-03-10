package com.aviloo.mytraderreloaded;

import com.aviloo.mytraderreloaded.DonateShop.Commands.OpenShop;
import com.aviloo.mytraderreloaded.DonateShop.Inventories.Events.*;
import com.aviloo.mytraderreloaded.DonateShop.Inventories.ShieldInventory;
import com.aviloo.mytraderreloaded.GeneralCommands.ReloadConfigCommand;
import com.aviloo.mytraderreloaded.Seller.Commands.OpenTrader;
import com.aviloo.mytraderreloaded.Seller.Commands.ReloadType;
import com.aviloo.mytraderreloaded.Seller.Commands.ReputationCommand;
import com.aviloo.mytraderreloaded.Seller.Commands.TraderForDonate;
import com.aviloo.mytraderreloaded.Seller.Events.*;
import com.aviloo.mytraderreloaded.Seller.Events.EpicEvents.GlobalEvents;
import com.aviloo.mytraderreloaded.Seller.Utils.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;


public final class MyTraderReloaded extends JavaPlugin {

    //todo 1. Добавить подключение к бд
    //todo 2. Настроить список лидеров
    //todo 3. Добавить товары за репутацию (Начал делать.)
    //todo 4. Добавить больше Инвентарей min- до 10 ,max- до 25
    //todo 5. Оптимизировать Interact (Например: убрать бесполезные try and catch блоки)
    //todo 5.1 Можно объеденить все интеракты в один (+-)
    //todo 6. Настроить PriceManager корректно
    //todo 7. Добавить бонусы , если игрок продаёт сразу стак
    //todo 8. Создать таблицу в бд, чтобы каждый день были новые Screen у скупщика.
    // (Например: Вчера был Screen1. Это записалось в бд, и исключило этот скрин из рандома.)

    public MySQLManager sql;

    private void setSql(){
        this.sql = new MySQLManager();

        try {
            sql.connection();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyTraderReloaded] "+ChatColor.RED+
                    "Connection to database failed!");
        }

        if(sql.isConnected()){
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyTraderReloaded] "+ChatColor.GREEN+
                    "Connection to database complete successful!");
        }
    }

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
        setSql();
        MySQLManager.setUpTable();

        //GeneralCommands
        getCommand("mytrader").setExecutor(new ReloadConfigCommand(this));
        getCommand("mytrader").setTabCompleter(new ReloadConfigCommand(this));

        if(this.getConfig().getBoolean("usePluginTradeSystem")) {
            //Methods(Seller)
            Bukkit.getServer().getPluginManager().registerEvents(new PlayersStats(this),this); // not move
            randomTraderType();
            PriceManager.allProductSetUp();
            PlayersStats.updateLeader();

            //Events (Seller)
                //Inventory Events (Seller)
            Bukkit.getServer().getPluginManager().registerEvents(new Interact1(this), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact2(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact3(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact4(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact5(), this);

            //тестовый класс
            Bukkit.getServer().getPluginManager().registerEvents(new GeneralInteract(this),this);
            Bukkit.getServer().getPluginManager().registerEvents(new ReputationInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new InteractE(), this);
                //General Events (Seller)
            Bukkit.getServer().getPluginManager().registerEvents(new GlobalEvents(this), this);
            Bukkit.getServer().getPluginManager().registerEvents(new PlayerReputation(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new LoadScreen(this),this);

            //Commands(Seller)
            getCommand("secretsellercommand").setExecutor(new OpenTrader());
            getCommand("seller").setExecutor(new TraderForDonate());
            getCommand("sellertype").setExecutor(new ReloadType());
            getCommand("traderreputation").setExecutor(new ReputationCommand());

            //Completer`s (Seller)
            getCommand("traderreputation").setTabCompleter(new ReputationCommand());
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

    @Override
    public void onDisable(){
        try {
            MySQLManager.setDataReputation();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        sql.disconnection();
    }

    public static void randomTraderType(){
        if(Math.random() < 0.12){
            TraderType = "Screen1";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen1"));
            return;
        }
        if(Math.random() >= 0.12 && Math.random() < 0.24){
            TraderType = "Screen2";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen2"));
            return;
        }
        if(Math.random() >= 0.24 && Math.random() < 0.36){
            TraderType = "Screen3";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen3"));
            return;
        }
        if(Math.random() >= 0.36 && Math.random() < 0.48){
            TraderType = "Screen4";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen4"));
            return;
        }
        if(Math.random() >= 0.48 && Math.random() < 0.6){
            TraderType = "Screen5";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen5"));
            return;
        }
        if(Math.random() >= 0.6 && Math.random() < 0.72){
            TraderType = "Screen6";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen6"));
            return;
        }
        if(Math.random() >= 0.72 && Math.random() < 0.84){
            TraderType = "Screen7";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen7"));
            return;
        }
        if(Math.random() >= 0.84 && Math.random() < 0.90){
            TraderType = "Screen8";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen8"));
            return;
        }
        if(Math.random() >= 0.9 && Math.random() < 0.96){
            TraderType = "Screen9";
            isEpicType = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTrader] &fСегодня скупщик типа - Screen9"));
            return;
        }
        if(Math.random() >= 0.96){
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
        startingArtImage();
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
