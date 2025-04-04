package com.aviloo.mytraderreloaded;

import com.aviloo.mytraderreloaded.Commands.AdminCommand;
import com.aviloo.mytraderreloaded.Commands.PlayerCommand;
import com.aviloo.mytraderreloaded.Commands.commandTabCompleter.adminCompleter;
import com.aviloo.mytraderreloaded.Files.*;
import com.aviloo.mytraderreloaded.Seller.Events.*;
import com.aviloo.mytraderreloaded.Seller.Events.EpicEvents.*;
import com.aviloo.mytraderreloaded.Seller.Expansions.ReputationExpansion;
import com.aviloo.mytraderreloaded.Seller.Inventories.InfoInventory;
import com.aviloo.mytraderreloaded.Seller.Inventories.LoadScreen;
import com.aviloo.mytraderreloaded.Seller.Inventories.SellerInventory;
import com.aviloo.mytraderreloaded.Seller.Utils.*;
import net.milkbowl.vault.economy.Economy;
import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;


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

    //New ToDoings
    //todo 1. Доделать SellerInventory (+-)
    //todo 2. Создать Interact для SellerInventory
    //todo 3. Переделать LoadScreen (+)
    //todo 4. Создать удобное меню с информацией(+)
    //todo 5. Улучшить Товары за репутацию
    //todo 6. Добавить денежный бонус к товарам за репу , если на игроке эффект "герой деревни"(+)
    //todo 7. Добавить таблицу лидеров и в конце дня выдавать награду лучшему игроку
    //todo 8. Создать конфиг для базы данных (+)
    //todo 9. Оптимизировать (убрать устаревшие части кода)
    //todo 10. Побочное задание: Добавить больше товаров.
    //todo 11. Добавить возможность продать все предметы разом
    public ConfigManager CustomConfig;

    public MySQLManager sql;

    public Economy eco;

    private boolean setupEconomy(){
        RegisteredServiceProvider<Economy> economy = getServer().getServicesManager()
                .getRegistration(net.milkbowl.vault.economy.Economy.class);
        if(economy != null) eco = economy.getProvider();

        return (eco != null);
    }

    public PlayerPointsAPI ppAPI;

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

    private static Boolean isEpicType = false;

    public static Boolean getIsEpicType(){
        Boolean bool = isEpicType;
        return bool;
    }

    //Custom Config Part
    Logger logger = this.getLogger();

    private static MyTraderReloaded plugin;

    public static MyTraderReloaded getPlugin() {
        return plugin;
    }

    public DatabaseFileManager databaseFileManager;
    public UsermapFileManager usermapFileManager;
    public MessagesFileManager messagesFileManager;
    public SellerSettingsFileManager sellerSettingsFileManager;
    public MenuFileManager menuFileManager;
    public ErrorFileManager errorFileManager;

    @Override
    public void onEnable() {
        //General Methods
        plugin = this;

        // Other methods
        loadConfig();
        this.CustomConfig = new ConfigManager(this);
        //Load database.yml
        if(getConfig().getBoolean("useSQL")) {
            this.databaseFileManager = new DatabaseFileManager();
            databaseFileManager.DatabaseFileManager(this);

            setSql();
            MySQLManager.setUpTable();
        }
        //Load messages.yml
        this.messagesFileManager = new MessagesFileManager();
        messagesFileManager.MessagesFileManager(this);
        //Load settings.yml
        this.sellerSettingsFileManager = new SellerSettingsFileManager();
        sellerSettingsFileManager.SettingsSellerFileManager(this);
        //Load gui.yml
        this.menuFileManager = new MenuFileManager();
        menuFileManager.MenuFileManager(this);
        //Load error.yml
        this.errorFileManager = new ErrorFileManager();
        errorFileManager.ErrorFileManager(this);

        //Load usermap.yml
        if(!getConfig().getBoolean("useSQL")) {
            this.usermapFileManager = new UsermapFileManager();
            usermapFileManager.UsermapFileManager(this);
            if (usermapFileManager.getUsermapConfig().contains("users.data")) {
                try {
                    UsermapStorageUtil.restoreUsermap();
                } catch (IOException e) {
                    logger.severe(ColorUtils.translateColorCodes("&6MyTrader: &4Failed to load data from usermap.yml!"));
                    logger.severe(ColorUtils.translateColorCodes("&6MyTrader: &4See below for errors!"));
                    logger.severe(ColorUtils.translateColorCodes("&6MyTrader: &4Disabling Plugin!"));
                    e.printStackTrace();
                    Bukkit.getPluginManager().disablePlugin(this);
                    return;
                }
            }
        }
        if (Bukkit.getPluginManager().isPluginEnabled("PlayerPoints")) {
            this.ppAPI = PlayerPoints.getInstance().getAPI();
        }
        startingAlerts();
        //Leader Stats
        Bukkit.getScheduler().runTaskTimer(this, () ->{
            LeaderUtils.updateLeader();
        },1,6000);

        //Expansion
        if(getServer().getPluginManager().getPlugin("PlaceholderAPI") != null){
            new ReputationExpansion(this).register();
        }

        //General Events
        getServer().getPluginManager().registerEvents(new EconomyManager(this),this);

        //Methods(Seller)
        PriceManager.allProductSetUp();
        PriceManager.allReputationProductsSetUp();
        setSellerInventory();
        LoadScreen.setupLoadInventory();
        InfoInventory.setupInfoInventory();
        getServer().getPluginManager().registerEvents(new InfoInventory(),this);

        //Events (Seller)
            //Inventory Events (Seller)
        getServer().getPluginManager().registerEvents(new SellerInteract(),this);

        //тестовый класс
        Bukkit.getServer().getPluginManager().registerEvents(new ReputationInteract(),this);
            //General Events (Seller)
        Bukkit.getServer().getPluginManager().registerEvents(new GlobalEvents(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerReputation(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new LoadScreen(this),this);
        getServer().getPluginManager().registerEvents(new SellManager(),this);
        getServer().getPluginManager().registerEvents(new LeaderUtils(), this);

        //Commands(Seller)
        Bukkit.getServer().getPluginCommand("seller").setExecutor(new PlayerCommand());
        Bukkit.getServer().getPluginCommand("mytrader").setExecutor(new AdminCommand());


        //Completer`s (Seller)
        Bukkit.getServer().getPluginCommand("mytrader").setTabCompleter(new adminCompleter());

    }

    @Override
    public void onDisable(){
        //Saver usermap to usermap.yml
        if(!getConfig().getBoolean("useSQL")) {
            if (!UsermapStorageUtil.getRawUsermapList().isEmpty()) {
                try {
                    UsermapStorageUtil.saveUsermap();
                    logger.info(ColorUtils.translateColorCodes("&6MyTrader: &3All users saved to usermap.yml successfully!"));
                } catch (IOException e) {
                    logger.severe(ColorUtils.translateColorCodes("&6MyTrader: &4Failed to save usermap to usermap.yml!"));
                    logger.severe(ColorUtils.translateColorCodes("&6MyTrader: &4See below error for reason!"));
                    e.printStackTrace();
                }
            }
        }
        // Save DataBase
        if(getConfig().getBoolean("useSQL")) {
            try {
                MySQLManager.setDataReputation();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            sql.disconnection();
        }

        databaseFileManager = null;
        usermapFileManager = null;
        messagesFileManager = null;
        sellerSettingsFileManager = null;
        menuFileManager = null;
        errorFileManager = null;
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
         Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"" +
                 "&7[MyTraderReloaded] &aПлагин был успешо загружен."));
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

    public String StrokeMaterial(){
        if(menuFileManager == null){
            logger.severe("menuFileManager is null!");
            return "GRAY_STAINED_GLASS_PANE";
        }
        return menuFileManager.getMenuConfig().getString("strokeMaterial");
    }

    public void setSellerInventory(){
        SellerInventory.setInventoryButtonsList();
        if(Math.random() <= getConfig().getDouble("chanceOfEpicSeller") - 0.01){
            isEpicType = false;
            SellerInventory.setUpDefaultSellerItemsList();
        }
        if(Math.random() > getConfig().getDouble("chanceOfEpicSeller")){
            isEpicType = true;
            SellerInventory.setUpEpicSellerItemsList();
        }
        SellerInventory.generateSellerItems();
        SellerInventory.inventorySetUp();
        if(menuFileManager.getMenuConfig().getBoolean("useStrokeInGUI")){
            SellerInventory.setupStroke();
        }

    }

}
