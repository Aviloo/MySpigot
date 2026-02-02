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

public class PunishmentFileManager {

    private MyAdmins plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyAdmins.getPlugin().getLogger();

    public void PunishmentFileManager(MyAdmins plugin) {
        this.plugin = plugin;
        saveDefaultPunishmentConfig();
    }

    public void reloadPunishmentConfig() {
        if (this.configFile == null) {
            this.configFile = new File(plugin.getDataFolder(), "punishment.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("punishment.yml");
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getPunishmentConfig() {
        if (this.dataConfig == null) {
            this.reloadPunishmentConfig();
        }
        return this.dataConfig;
    }

    public void savePunishmentConfig() {
        if (this.dataConfig == null || this.configFile == null) {
            return;
        }
        try {
            this.getPunishmentConfig().save(this.configFile);
        } catch (IOException e) {
            logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Could not save punishment.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyAdmins: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultPunishmentConfig() {
        if (this.configFile == null) {
            this.configFile = new File(plugin.getDataFolder(), "punishment.yml");
        }
        if (!this.configFile.exists()) {
            this.plugin.saveResource("punishment.yml", false);
        }
    }
}
