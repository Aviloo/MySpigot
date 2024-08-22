package me.aviloo.myrtp;

import me.aviloo.myrtp.Commands.DefaultTeleportCommand;
import me.aviloo.myrtp.Files.MessagesFileManager;
import me.aviloo.myrtp.Utils.TeleportUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyRTP extends JavaPlugin {

    private static MyRTP plugin;

    public static MyRTP getPlugin() {
        return plugin;
    }

    public MessagesFileManager messagesFileManager;

    @Override
    public void onEnable() {
        plugin = this;
        loadConfig();

        //Load messages.yml
        this.messagesFileManager = new MessagesFileManager();
        messagesFileManager.MessagesFileManager(this);

        getCommand("rtp").setExecutor(new DefaultTeleportCommand());

    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTask(TeleportUtils.taskId);

        messagesFileManager = null;
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
