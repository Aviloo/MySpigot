package me.aviloo.myAdmins;

import me.aviloo.myAdmins.Commands.*;
import me.aviloo.myAdmins.Commands.PunishmentCommands.*;
import me.aviloo.myAdmins.Files.*;
import me.aviloo.myAdmins.Handler.AdminChatListener;
import me.aviloo.myAdmins.Handler.CommandListener;
import me.aviloo.myAdmins.Handler.PlayerHandler;
import me.aviloo.myAdmins.Handler.VanishListener;
import me.aviloo.myAdmins.Menu.PunishmentMenu;
import me.aviloo.myAdmins.Menu.ReportsMenu;
import me.aviloo.myAdmins.Utils.StorageUtils.AdminmapStorageUtil;
import me.aviloo.myAdmins.Utils.ColorUtils;
import me.aviloo.myAdmins.Utils.StorageUtils.PunishmentStorageUtil;
import me.aviloo.myAdmins.Utils.StorageUtils.RulesStorageUtil;
import me.aviloo.myAdmins.Utils.StorageUtils.UsermapStorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public final class MyAdmins extends JavaPlugin {

    private static MyAdmins plugin;
    public static MyAdmins getPlugin() {
        return plugin;
    }

    Logger logger = this.getLogger();

    private File logFile;

    public AdminmapFileManager adminmapFileManager;
    public UsermapFileManager usermapFileManager;
    public IconsFileManager iconsFileManager;
    public PunishmentFileManager punishmentFileManager;
    public RulesFileManager rulesFileManager;

    @Override
    public void onLoad(){
        plugin = this;
        loadConfigs();
    }

    @Override
    public void onEnable() {
        loadFile();
        ReportsMenu.init();
        // Plugin startup logic
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("ban").setExecutor(new BanCommand());
        getCommand("banip").setExecutor(new BanIPCommand());
        getCommand("tempban").setExecutor(new TempBanCommand());
        getCommand("mute").setExecutor(new MuteCommand());
        getCommand("myadmin").setExecutor(new AdminCommand());
        getCommand("getpunish").setExecutor(new getPunishments());
        getCommand("ac").setExecutor(new AdminChatCommand());
        getCommand("report").setExecutor(new ReportCommand());
        getCommand("reports").setExecutor(new ReportsCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerHandler(), this);
        getServer().getPluginManager().registerEvents(new PunishmentMenu(),this);
        getServer().getPluginManager().registerEvents(new ReportsMenu(),this);
        getServer().getPluginManager().registerEvents(new VanishListener(),this);
        getServer().getPluginManager().registerEvents(new AdminChatListener(logFile),this);
    }

    @Override
    public void onDisable() {
        //Saver adminmap to adminmap.yml
        if (!AdminmapStorageUtil.getRawUsermapList().isEmpty()) {
            try {
                AdminmapStorageUtil.saveUsermap();
                logger.info(ColorUtils.translateColorCodes("&6MyAdmins: &3All users saved to adminmap.yml successfully!"));
            } catch (IOException e) {
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Failed to save adminmap to adminmap.yml!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4See below error for reason!"));
                e.printStackTrace();
            }
        }
        //Saver usermap to usermap.yml
        if (!UsermapStorageUtil.getRawUsermapList().isEmpty()) {
            try {
                UsermapStorageUtil.saveUsermap();
                logger.info(ColorUtils.translateColorCodes("&6MyAdmins: &3All users saved to usermap.yml successfully!"));
            } catch (IOException e) {
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Failed to save usermap to usermap.yml!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4See below error for reason!"));
                e.printStackTrace();
            }
        }
        //Saver punishment to punishment.yml
        if (!PunishmentStorageUtil.getRawPunishmentList().isEmpty()) {
            try {
                PunishmentStorageUtil.saveUsermap();
                logger.info(ColorUtils.translateColorCodes("&6MyAdmins: &3All users saved to punishment.yml successfully!"));
            } catch (IOException e) {
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Failed to save punishment to punishment.yml!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4See below error for reason!"));
                e.printStackTrace();
            }
        }


        adminmapFileManager = null;
        usermapFileManager = null;
        punishmentFileManager = null;
    }

    private void loadConfigs(){
        //Load adminmap.yml
        this.adminmapFileManager = new AdminmapFileManager();
        adminmapFileManager.AdminmapFileManager(this);
        if (adminmapFileManager.getAdminmapConfig().contains("users.data")) {
            try {
                AdminmapStorageUtil.restoreUsermap();
            } catch (IOException e) {
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Failed to load data from adminmap.yml!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4See below for errors!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Disabling Plugin!"));
                e.printStackTrace();
                Bukkit.getPluginManager().disablePlugin(this);
                return;
            }
        }
        //Load usermap.yml
        this.usermapFileManager = new UsermapFileManager();
        usermapFileManager.UsermapFileManager(this);
        if (usermapFileManager.getUsermapConfig().contains("users.data")) {
            try {
                UsermapStorageUtil.restoreUsermap();
            } catch (IOException e) {
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Failed to load data from usermap.yml!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4See below for errors!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Disabling Plugin!"));
                e.printStackTrace();
                Bukkit.getPluginManager().disablePlugin(this);
                return;
            }
        }
        //Load punishment.yml
        this.punishmentFileManager = new PunishmentFileManager();
        punishmentFileManager.PunishmentFileManager(this);
        if (punishmentFileManager.getPunishmentConfig().contains("users.data")) {
            try {
                PunishmentStorageUtil.restorePunishment();
            } catch (IOException e) {
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Failed to load data from punishment.yml!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4See below for errors!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Disabling Plugin!"));
                e.printStackTrace();
                Bukkit.getPluginManager().disablePlugin(this);
                return;
            }
        }

        //Load icons.yml
        this.iconsFileManager = new IconsFileManager();
        iconsFileManager.IconsFileManager(this);
        //Load rules.yml
        this.rulesFileManager = new RulesFileManager();
        rulesFileManager.RulesFileManager(this);
        RulesStorageUtil.loadData();
    }

    public File getTodayLogFile() {
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        File dir = new File(getDataFolder(), "AdminChatLog");
        if (!dir.exists()) {
            dir.mkdirs(); // создаем папки, если их нет
        }
        return new File(dir, dateStr + ".txt");
    }

    private void loadFile(){
        // Создаем файл при запуске
        logFile = getTodayLogFile();
        try {
            if (!logFile.exists()) {
                logFile.createNewFile(); // создаст файл, если его еще нет
            }
        } catch (IOException e) {
            e.printStackTrace(); // обработка ошибок
        }
    }

}
