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

public class AdminmapFileManager {

    private MyAdmins plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyAdmins.getPlugin().getLogger();

    public void AdminmapFileManager(MyAdmins plugin) {
        this.plugin = plugin;
        saveDefaultAdminmapConfig();
    }

    public void reloadAdminmapConfig() {
        if (this.configFile == null) {
            this.configFile = new File(plugin.getDataFolder(), "adminmap.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("adminmap.yml");
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getAdminmapConfig() {
        if (this.dataConfig == null) {
            this.reloadAdminmapConfig();
        }
        return this.dataConfig;
    }

    public void saveAdminmapConfig() {
        if (this.dataConfig == null || this.configFile == null) {
            return;
        }
        try {
            this.getAdminmapConfig().save(this.configFile);
        } catch (IOException e) {
            logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Could not save adminmap.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultAdminmapConfig() {
        if (this.configFile == null) {
            this.configFile = new File(plugin.getDataFolder(), "adminmap.yml");
        }
        if (!this.configFile.exists()) {
            this.plugin.saveResource("adminmap.yml", false);
        }
    }
}
