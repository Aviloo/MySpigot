package com.aviloo.myscoreboard.Utils;

import com.aviloo.myscoreboard.MyScoreboard;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class UsermapFileManager {

    private MyScoreboard plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyScoreboard.getPlugin().getLogger();

    public void UsermapFileManager(MyScoreboard plugin){
        this.plugin = plugin;
        saveDefaultUsermapConfig();
    }

    public void reloadUsermapConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "usermap.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("usermap.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getUsermapConfig(){
        if (this.dataConfig == null){
            this.reloadUsermapConfig();
        }
        return this.dataConfig;
    }

    public void saveUsermapConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getUsermapConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&6MyScoreboard: &4Could not save usermap.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyScoreboard: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultUsermapConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "usermap.yml");
        }
        if (!this.configFile.exists()){
            this.plugin.saveResource("usermap.yml", false);
        }
    }
}
