package me.aviloo.myarenamanager;

import com.rylinaux.plugman.api.PlugManAPI;
import me.aviloo.myarenamanager.AdminDamage.AdminDamageCommand;
import me.aviloo.myarenamanager.AdminDamage.AdminDamageListener;
import me.aviloo.myarenamanager.Commands.ArenaManagerCommand;
import me.aviloo.myarenamanager.Commands.GetWorldInfoCommand;
import me.aviloo.myarenamanager.Files.LocationFileManager;
import me.aviloo.myarenamanager.MoneyPlate.Commands.SetPlateCommand;
import me.aviloo.myarenamanager.MoneyPlate.PlateListener;
import me.aviloo.myarenamanager.MoneyPlate.Utils.HologramPlateUtil;
import me.aviloo.myarenamanager.PvpChest.ChestListener;
import me.aviloo.myarenamanager.PvpChest.Commands.ChestStatusCommand;
import me.aviloo.myarenamanager.PvpChest.Inventory.ChestInventory;
import me.aviloo.myarenamanager.PvpChest.Utils.HologramChestUtils;
import me.aviloo.myarenamanager.PvpChest.Utils.StatusChestUtils;
import me.aviloo.myarenamanager.Utils.ColorUtils;
import me.aviloo.myarenamanager.Utils.EconomyManager;
import me.aviloo.myarenamanager.Utils.MessagesUtils;
import me.aviloo.myarenamanager.Utils.OnlineUtils;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class MyArenaManager extends JavaPlugin {

    public Economy eco;

    private boolean setupEconomy(){
        RegisteredServiceProvider<Economy> economy = getServer().getServicesManager()
                .getRegistration(net.milkbowl.vault.economy.Economy.class);
        if(economy != null) eco = economy.getProvider();

        return (eco != null);
    }

    Logger logger = this.getLogger();

    private static MyArenaManager plugin;

    public LocationFileManager locationFileManager;

    private int min_limit_players_for_plate = this.getConfig().getInt("min_limit_players_for_plate");
    private int min_limit_players_for_chest = this.getConfig().getInt("min_limit_players_for_chest");

    @Override
    public void onEnable() {
        //Methods
        plugin = this;
        //Load the plugin configs
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //Load location.yml
        this.locationFileManager = new LocationFileManager();
        locationFileManager.LocationFileManager(this);
        //Other methods
        checkPlugManX();
        setupEconomy();
        if(getConfig().getBoolean("EnableMoneyPlate")){
            HologramPlateUtil.spawnHologramPlate();
            plateTimer();
        }
        if(getConfig().getBoolean("EnablePvpChest")) {
            HologramChestUtils.spawnChestHologram();
            chestTimer();
        }
        ChestInventory.addLootInStaticList();

        //Events
        if(getConfig().getBoolean("EnableMoneyPlate")){
            getServer().getPluginManager().registerEvents(new PlateListener(this),this);
        }
        if(getConfig().getBoolean("EnablePvpChest")) {
            getServer().getPluginManager().registerEvents(new ChestListener(this),this);
        }
        if(getConfig().getBoolean("EnableAdminDamage")){
            getServer().getPluginManager().registerEvents(new AdminDamageListener(),this);
        }
        getServer().getPluginManager().registerEvents(new EconomyManager(this),this);
        getServer().getPluginManager().registerEvents(new OnlineUtils(),this);
        //Command
        getCommand("arenamanager").setExecutor(new ArenaManagerCommand(this));
        getCommand("admindamage").setExecutor(new AdminDamageCommand());
        if(getConfig().getBoolean("EnableDebugCommands")) {
            getCommand("arenachest").setExecutor(new ChestStatusCommand());
            getCommand("setplate").setExecutor(new SetPlateCommand());
            getCommand("getcurrentworldinfo").setExecutor(new GetWorldInfoCommand());
        }
        //Tab Completer
        getCommand("arenamanager").setTabCompleter(new ArenaManagerCommand(this));
        getCommand("admindamage").setTabCompleter(new AdminDamageCommand());
        if(getConfig().getBoolean("EnableDebugCommands")) {
            getCommand("setplate").setTabCompleter(new SetPlateCommand());
            getCommand("arenachest").setTabCompleter(new ChestStatusCommand());
        }

    }

    @Override
    public void onDisable() {
        //
        HologramPlateUtil.removeHologramPlate();
        HologramChestUtils.removeChestHologram();

        locationFileManager = null;
    }

    private void plateTimer(){
        Bukkit.getScheduler().runTaskLater(this, (start_task) ->{
            if(OnlineUtils.getOnlineCount() < min_limit_players_for_plate){
                start_task.cancel();
            }
            HologramPlateUtil.setPlateStatus(true);
            HologramPlateUtil.updateHologramPlate();
            MessagesUtils.sendPlateMessage();
        }, 21600 * 20); // через  6 часов после старта сервера

        Bukkit.getScheduler().runTaskLater(this, () ->{
            HologramPlateUtil.setPlateStatus(false);
            HologramPlateUtil.updateHologramPlate();
        }, 21900 * 20); // завершение через 5 минут

        //

        Bukkit.getScheduler().runTaskLater(this, (start_task1) ->{
            if(OnlineUtils.getOnlineCount() < min_limit_players_for_plate){
                start_task1.cancel();
            }
            HologramPlateUtil.setPlateStatus(true);
            HologramPlateUtil.updateHologramPlate();
            MessagesUtils.sendPlateMessage();
        }, 43200 * 20); // через  12 часов после старта сервера

        Bukkit.getScheduler().runTaskLater(this, () ->{
            HologramPlateUtil.setPlateStatus(false);
            HologramPlateUtil.updateHologramPlate();
        }, 43500 * 20); // завершение через 5 минут

    }

    public static MyArenaManager getPlugin() {
        return plugin;
    }

    private void chestTimer(){
        Bukkit.getScheduler().runTaskTimer(this, (task) -> {
            if(OnlineUtils.getOnlineCount() < min_limit_players_for_chest){
                logger.severe(ColorUtils.translateColorCodes(
                        "&6MyArenaManager >>> &fСундук арены НЕ был доступен."));
                logger.severe(ColorUtils.translateColorCodes(
                        "&6MyArenaManager >>> &fт.к игроков недостаточно."));
            }
            if(!StatusChestUtils.chestIsNotDisable()
                    && OnlineUtils.getOnlineCount() < min_limit_players_for_chest){
                StatusChestUtils.setCanBeActivatedStatus();
                HologramChestUtils.updateChestHologram();
                logger.severe(ColorUtils.translateColorCodes(
                        "&6MyArenaManager >>> &fСундук арены стал доступен."));
            }
            logger.severe(ColorUtils.translateColorCodes(
                    "&6MyArenaManager >>> &fСундук арены НЕ был доступен."));
        },0L,72000L); // 72000 тики = 1 час

    }


    //PlugmanX
    private void checkPlugManX(){
        //Check if PlugManX is enabled
        if (isPlugManXEnabled()){
            if (!PlugManAPI.iDoNotWantToBeUnOrReloaded("MyArenaManager")){
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&4ВНИМАНИЕ ВНИМАНИЕ ВНИМАНИЕ ВНИМАНИЕ!"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &4You appear to be using an unsupported version of &d&lPlugManX"));
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &4Please &4&lDO NOT USE PLUGMANX TO LOAD/UNLOAD/RELOAD THIS PLUGIN!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &4Please &4&lFULLY RESTART YOUR SERVER!"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &4This plugin &4&lHAS NOT &4been validated to use this version of PlugManX!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &4&lNo official support will be given to you if you use this!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &4&lUnless Loving11ish has explicitly agreed to help!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &4Please add ClansLite to the ignored-plugins list in PlugManX's config.yml"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &6Continuing plugin startup"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
            }else {
                logger.info(ColorUtils.translateColorCodes("&a-------------------------------------------"));
                logger.info(ColorUtils.translateColorCodes("&6MyArenaManager: &aSuccessfully hooked into PlugManX"));
                logger.info(ColorUtils.translateColorCodes("&6MyArenaManager: &aSuccessfully added ClansLite to ignoredPlugins list."));
                logger.info(ColorUtils.translateColorCodes("&6MyArenaManager: &6Continuing plugin startup"));
                logger.info(ColorUtils.translateColorCodes("&a-------------------------------------------"));
            }
        }else {
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
            logger.info(ColorUtils.translateColorCodes("&6MyArenaManager: &cPlugManX не найден!"));
            logger.info(ColorUtils.translateColorCodes("&6MyArenaManager: &cDisabling PlugManX hook loader"));
            logger.info(ColorUtils.translateColorCodes("&6MyArenaManager: &6Continuing plugin startup"));
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
        }
    }

    public boolean isPlugManXEnabled() {
        try {
            Class.forName("com.rylinaux.plugman.PlugMan");
            if (getConfig().getBoolean("general.developer-debug-mode.enabled")){
                logger.info(ColorUtils.translateColorCodes("&6MyArenaManager-Debug: &aFound PlugManX main class at:"));
                logger.info(ColorUtils.translateColorCodes("&6MyArenaManager-Debug: &dcom.rylinaux.plugman.PlugMan"));
            }
            return true;
        }catch (ClassNotFoundException e){
            if (getConfig().getBoolean("general.developer-debug-mode.enabled")){
                logger.info(ColorUtils.translateColorCodes("&6MyArenaManager-Debug: &aCould not find PlugManX main class at:"));
                logger.info(ColorUtils.translateColorCodes("&6MyArenaManager-Debug: &dcom.rylinaux.plugman.PlugMan"));
            }
            return false;
        }
    }

}
