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

public class ErrorFileManager {


    private MyTraderReloaded plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyTraderReloaded.getPlugin().getLogger();

    public void ErrorFileManager(MyTraderReloaded plugin){
        this.plugin = plugin;
        saveDefaultErrorConfig();
    }

    public void reloadErrorConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "error-logs.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("error-logs.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getErrorConfig(){
        if (this.dataConfig == null){
            this.reloadErrorConfig();
        }
        return this.dataConfig;
    }

    public void saveErrorConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getErrorConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Could not save error-logs.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultErrorConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "error-logs.yml");
        }
        if (!this.configFile.exists()){
            this.plugin.saveResource("error-logs.yml", false);
        }
    }

}
