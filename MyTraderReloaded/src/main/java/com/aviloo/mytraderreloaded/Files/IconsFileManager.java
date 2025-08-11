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

public class IconsFileManager {
    private MyTraderReloaded plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyTraderReloaded.getPlugin().getLogger();

    public void IconsFileManager(MyTraderReloaded plugin){
        this.plugin = plugin;
        saveDefaultIconsConfig();
    }

    public void reloadIconsConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "icons.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("icons.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getIconsConfig(){
        if (this.dataConfig == null){
            this.reloadIconsConfig();
        }
        return this.dataConfig;
    }

    public void saveIconsConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getIconsConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Could not save icons.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultIconsConfig() {
        if (this.configFile == null) {
            this.configFile = new File(plugin.getDataFolder(), "icons.yml");
        }
        if (!this.configFile.exists()) {
            this.plugin.saveResource("icons.yml", false);
        }
    }
}
