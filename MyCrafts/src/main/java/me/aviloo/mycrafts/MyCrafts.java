package me.aviloo.mycrafts;

import me.aviloo.mycrafts.Commands.CraftsCommand;
import me.aviloo.mycrafts.Commands.TabCompleters.CraftCompleter;
import me.aviloo.mycrafts.Events.*;
import me.aviloo.mycrafts.Files.ItemsFileManager;
import me.aviloo.mycrafts.Files.MessagesFileManager;
import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Items.Trap.TrapManager;
import me.aviloo.mycrafts.Utils.CraftUtils;
import me.aviloo.mycrafts.Utils.MenuUtil;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class MyCrafts extends JavaPlugin {

    //todo Пофиксить меню
    //todo Пофиксить систему крафтов

    public Economy eco;

    private boolean setupEconomy(){
        RegisteredServiceProvider<Economy> economy = getServer().getServicesManager()
                .getRegistration(net.milkbowl.vault.economy.Economy.class);
        if(economy != null) eco = economy.getProvider();

        return (eco != null);
    }

    Logger logger = this.getLogger();

    private static MyCrafts plugin;

    public static MyCrafts getPlugin() {
        return plugin;
    }

    public ItemsFileManager itemsFileManager;
    public MessagesFileManager messagesFileManager;

    @Override
    public void onEnable() {
        plugin = this;

        if (!setupEconomy()){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&4[Ошибка] &fНеполадки в плагине Vault. " +
                            "&fПлагин &7(MyCrafts)&f будет отключен."));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        // load items.yml
        this.itemsFileManager = new ItemsFileManager();
        itemsFileManager.ItemsFileManager(this);
        //Load messages.yml
        this.messagesFileManager = new MessagesFileManager();
        messagesFileManager.MessagesFileManager(this);

        TrapManager.init();
        TNTManager.init();
        CraftUtils.init();

        getServer().getPluginManager().registerEvents(new SphereEvents(), this);
        getServer().getPluginManager().registerEvents(new TotemEvents(this), this);
        getServer().getPluginManager().registerEvents(new TrapEvents(),this);
        getServer().getPluginManager().registerEvents(new TNTEvent(),this);
        getServer().getPluginManager().registerEvents(new MenuEvents(),this);

        getCommand("mycrafts").setExecutor(new CraftsCommand());
        getCommand("uc").setExecutor(new CraftsCommand());
        getCommand("mycrafts").setTabCompleter(new CraftCompleter());

    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTask(MenuUtil.menuTaskId);

        itemsFileManager = null;
        messagesFileManager = null;
    }
}
