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

public class SellerSettingsFileManager {

    private MyTraderReloaded plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyTraderReloaded.getPlugin().getLogger();

    public void SettingsSellerFileManager(MyTraderReloaded plugin){
        this.plugin = plugin;
        saveDefaultSettingsSellerConfig();
    }

    public void reloadSettingsSellerConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "settings.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("settings.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getSettingsSellerConfig(){
        if (this.dataConfig == null){
            this.reloadSettingsSellerConfig();
        }
        return this.dataConfig;
    }

    public void saveSettingsSellerConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getSettingsSellerConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Could not save settings.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultSettingsSellerConfig() {
        if (this.configFile == null) {
            this.configFile = new File(plugin.getDataFolder(), "settings.yml");
        }
        if (!this.configFile.exists()) {
            this.plugin.saveResource("settings.yml", false);
        }
    }
}
