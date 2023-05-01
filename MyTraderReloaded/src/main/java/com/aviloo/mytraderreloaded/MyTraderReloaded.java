package com.aviloo.mytraderreloaded;

import com.aviloo.mytraderreloaded.DonateShop.Commands.OpenShop;
import com.aviloo.mytraderreloaded.DonateShop.Inventories.Events.*;
import com.aviloo.mytraderreloaded.DonateShop.Inventories.ShieldInventory;
import com.aviloo.mytraderreloaded.GeneralCommands.ReloadConfigCommand;
import com.aviloo.mytraderreloaded.Seller.Commands.*;
import com.aviloo.mytraderreloaded.Seller.Events.*;
import com.aviloo.mytraderreloaded.Seller.Events.EpicEvents.*;
import com.aviloo.mytraderreloaded.Seller.Utils.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.Objects;


public final class MyTraderReloaded extends JavaPlugin {

    //todo 1. Добавить подключение к бд (+)
    //todo 2. Настроить список лидеров
    //todo 3. Добавить товары за репутацию (Начал делать.)
    //todo 4. Добавить больше Инвентарей min- до 10 ,max- до 25 (+-)
    //todo 5. Оптимизировать Interact (Например: убрать бесполезные try and catch блоки)
    //todo 5.1 Можно объеденить все интеракты в один (+-)
    //todo 6. Настроить PriceManager корректно
    //todo 7. Добавить бонусы , если игрок продаёт сразу стак (+)
    //todo 8. Создать таблицу в бд, чтобы каждый день были новые Screen у скупщика.
    // (Например: Вчера был Screen1. Это записалось в бд, и исключило этот скрин из рандома.) (+)
    //todo 9. Оптимизировать экономику

    public MySQLManager sql;

    public Economy eco;

    private boolean setupEconomy(){
        RegisteredServiceProvider<Economy> economy = getServer().getServicesManager()
                .getRegistration(net.milkbowl.vault.economy.Economy.class);
        if(economy != null) eco = economy.getProvider();

        return (eco != null);
    }

    private void setSql(){
        this.sql = new MySQLManager();

        try {
            sql.connection();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyTraderReloaded] "+ChatColor.RED+
                    "Подключение к БД провалилось!");
        }

        if(sql.isConnected()){
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyTraderReloaded] "+ChatColor.GREEN+
                    "Подключение к БД - успешно!");
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

    public static void setTraderType(String type){
        if(Objects.equals(type, "Screen1")){
            TraderType = type;
        }
        if(Objects.equals(type, "Screen2")){
            TraderType = type;
        }
        if(Objects.equals(type, "Screen3")){
            TraderType = type;
        }
        if(Objects.equals(type, "Screen4")){
            TraderType = type;
        }
        if(Objects.equals(type, "Screen5")){
            TraderType = type;
        }
        if(Objects.equals(type, "ScreenE")){
            TraderType = type;
            isEpicType = true;
        }else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&4[Ошибка] &fВы не можете присвоить этот тип. &7(Возможно, его не существует или" +
                            "&7 вы ошиблись в написании!)"));
        }
    }

    private final String YesterdayScreen = getConfig().getString("YesterdayScreen");

    private void writeYesterdayScreen(String ScreenType){
        this.getConfig().set("YesterdayScreen",ScreenType);
        saveConfig();
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

        //General Events
        getServer().getPluginManager().registerEvents(new EconomyManager(this),this);

        if(this.getConfig().getBoolean("usePluginTradeSystem")) {
            //Methods(Seller)
            Bukkit.getServer().getPluginManager().registerEvents(new PlayersStats(this),this); // not move
            randomTraderType();
            PriceManager.allProductSetUp();
            PlayersStats.updateLeader();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyTraderReloaded]"+ChatColor.WHITE
                    +"Вчера был тип - "+YesterdayScreen);

            //Events (Seller)
                //Inventory Events (Seller)
            Bukkit.getServer().getPluginManager().registerEvents(new Interact1(this), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact2(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact3(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact4(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new Interact5(), this);

            //тестовый класс
            //Bukkit.getServer().getPluginManager().registerEvents(new GeneralInteract(this),this);
            Bukkit.getServer().getPluginManager().registerEvents(new ReputationInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new InteractE(), this);
                //General Events (Seller)
            Bukkit.getServer().getPluginManager().registerEvents(new GlobalEvents(this), this);
            Bukkit.getServer().getPluginManager().registerEvents(new PlayerReputation(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new LoadScreen(this),this);

            //Commands(Seller)
            getCommand("secretsellercommand").setExecutor(new OpenTrader());
            getCommand("seller").setExecutor(new TraderForDonate());
            getCommand("sellertype").setExecutor(new ReloadType(this));
            getCommand("traderreputation").setExecutor(new ReputationCommand());
            getCommand("sellersettype").setExecutor(new SetType());

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
        writeYesterdayScreen(TraderType);
    }

    public void randomTraderType(){
        double chance = Math.random();
        if(chance < 0.21){
            if(!(Objects.equals(YesterdayScreen, "Screen1"))) {
                TraderType = "Screen1";
                isEpicType = false;
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen1"));
                return;
            }
        }
        if(chance >= 0.21 && chance < 0.42){
            if(!(Objects.equals(YesterdayScreen, "Screen2"))) {
                TraderType = "Screen2";
                isEpicType = false;
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen2"));
                return;
            }
        }
        if(chance >= 0.42 && chance < 0.63){
            if(!(Objects.equals(YesterdayScreen, "Screen3"))) {
                TraderType = "Screen3";
                isEpicType = false;
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen3"));
                return;
            }
        }
        if(chance >= 0.63 && chance < 0.81){
            if(!(Objects.equals(YesterdayScreen, "Screen4"))) {
                TraderType = "Screen4";
                isEpicType = false;
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen4"));
                return;
            }
        }
        if(chance >= 0.81 && chance < 0.96){
            if(!(Objects.equals(YesterdayScreen, "Screen5"))) {
                TraderType = "Screen5";
                isEpicType = false;
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - Screen5"));
                return;
            }
        }
        if(chance >= 0.96){
            if(!(Objects.equals(YesterdayScreen, "ScreenE"))) {
                TraderType = "ScreenE";
                isEpicType = true;
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7[MyTraderReloaded] &fСегодня скупщик типа - &dScreenE"));
                return;
            }
        }
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void startingAlerts(){
        if (!setupEconomy()){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&4[Ошибка] &fНеполадки в плагине Vault. " +
                            "&fПлагин &7(MyTraderReloaded)&f будет отключен."));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
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
            getServer().getPluginManager().disablePlugin(this); // Останавливает плагин
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
