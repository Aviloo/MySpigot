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

public class MenuFileManager {


    private MyTraderReloaded plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyTraderReloaded.getPlugin().getLogger();

    public void MenuFileManager(MyTraderReloaded plugin){
        this.plugin = plugin;
        saveDefaultMenuConfig();
    }

    public void reloadMenuConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "gui.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("gui.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getMenuConfig(){
        if (this.dataConfig == null){
            this.reloadMenuConfig();
        }
        return this.dataConfig;
    }

    public void saveMenuConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getMenuConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Could not save gui.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyTraderReloaded: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultMenuConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "gui.yml");
        }
        if (!this.configFile.exists()){
            this.plugin.saveResource("gui.yml", false);
        }
    }

}
