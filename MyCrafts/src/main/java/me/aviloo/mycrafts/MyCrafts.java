package me.aviloo.mycrafts;

import me.aviloo.mycrafts.Commands.CraftsCommand;
import me.aviloo.mycrafts.Commands.TabCompleters.CraftCompleter;
import me.aviloo.mycrafts.Commands.subCommands.GetItemsSubCommand;
import me.aviloo.mycrafts.Events.SphereEvents;
import me.aviloo.mycrafts.Events.TNTEvent;
import me.aviloo.mycrafts.Events.TotemEvents;
import me.aviloo.mycrafts.Events.TrapEvents;
import me.aviloo.mycrafts.Files.ItemsFileManager;
import me.aviloo.mycrafts.Files.MessagesFileManager;
import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Items.Trap.TrapManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class MyCrafts extends JavaPlugin {

    //todo Сделать Меню
    //todo Реализовать систему крафтов

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

        TrapManager.init();
        TNTManager.init();
        // load items.yml
        this.itemsFileManager = new ItemsFileManager();
        itemsFileManager.ItemsFileManager(this);
        //Load messages.yml
        this.messagesFileManager = new MessagesFileManager();
        messagesFileManager.MessagesFileManager(this);

        getServer().getPluginManager().registerEvents(new SphereEvents(), this);
        getServer().getPluginManager().registerEvents(new TotemEvents(this), this);
        getServer().getPluginManager().registerEvents(new TrapEvents(),this);
        getServer().getPluginManager().registerEvents(new TNTEvent(),this);
        getCommand("mycrafts").setExecutor(new CraftsCommand());
        getCommand("mycrafts").setTabCompleter(new CraftCompleter());

    }

    @Override
    public void onDisable() {

        itemsFileManager = null;
        messagesFileManager = null;
    }
}
