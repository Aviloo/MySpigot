package me.aviloo.myAdmins.Files;

import me.aviloo.myAdmins.MyAdmins;
import me.aviloo.myAdmins.Utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class RulesFileManager {
    private MyAdmins plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyAdmins.getPlugin().getLogger();

    public void RulesFileManager(MyAdmins plugin){
        this.plugin = plugin;
        saveDefaultRulesConfig();
    }

    public void reloadRulesConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "rules.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("rules.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getRulesConfig(){
        if (this.dataConfig == null){
            this.reloadRulesConfig();
        }
        return this.dataConfig;
    }

    public void saveRulesConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getRulesConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Could not save rules.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultRulesConfig() {
        if (this.configFile == null) {
            this.configFile = new File(plugin.getDataFolder(), "rules.yml");
        }
        if (!this.configFile.exists()) {
            this.plugin.saveResource("rules.yml", false);
        }
    }
}
