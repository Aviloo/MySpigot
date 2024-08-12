package com.aviloo.mytraderreloaded.Files;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class DatabaseFileManager {

    private MyTraderReloaded plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyTraderReloaded.getPlugin().getLogger();

    public void DatabaseFileManager(MyTraderReloaded plugin){
        this.plugin = plugin;
        saveDefaultDatabaseConfig();
    }

    public void reloadDatabaseConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "database.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("database.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getDatabaseConfig(){
        if (this.dataConfig == null){
            this.reloadDatabaseConfig();
        }
        return this.dataConfig;
    }

    public void saveDatabaseConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getDatabaseConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Could not save database.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultDatabaseConfig() {
        if (this.configFile == null) {
            this.configFile = new File(plugin.getDataFolder(), "database.yml");
        }
        if (!this.configFile.exists()) {
            this.plugin.saveResource("database.yml", false);
        }
    }
}

