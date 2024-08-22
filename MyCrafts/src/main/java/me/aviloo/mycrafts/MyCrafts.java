package me.aviloo.mycrafts;

import me.aviloo.mycrafts.Commands.CraftsCommand;
import me.aviloo.mycrafts.Commands.TabCompleters.CraftCompleter;
import me.aviloo.mycrafts.Events.*;
import me.aviloo.mycrafts.Files.ItemsFileManager;
import me.aviloo.mycrafts.Files.MessagesFileManager;
import me.aviloo.mycrafts.Items.SphereManager;
import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Items.TotemsManager;
import me.aviloo.mycrafts.Items.Trap.TrapManager;
import me.aviloo.mycrafts.Menu.EnchantedMenus.*;
import me.aviloo.mycrafts.Menu.SpecialMenus.TrapMenu;
import me.aviloo.mycrafts.Menu.SphereMenus.EndMenu;
import me.aviloo.mycrafts.Menu.SphereMenus.NetherMenu;
import me.aviloo.mycrafts.Menu.SphereMenus.OceanMenu;
import me.aviloo.mycrafts.Menu.TNTMenus.BlackTNTMenu;
import me.aviloo.mycrafts.Menu.TNTMenus.RedTNTMenu;
import me.aviloo.mycrafts.Menu.TotemMenus.AgilityMenu;
import me.aviloo.mycrafts.Menu.TotemMenus.PowerMenu;
import me.aviloo.mycrafts.Menu.TotemMenus.StrengthMenu;
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
        TotemsManager.init();
        SphereManager.init();
        CraftUtils.init();

        getServer().getPluginManager().registerEvents(new SphereEvents(), this);
        getServer().getPluginManager().registerEvents(new TotemEvents(this), this);
        getServer().getPluginManager().registerEvents(new TrapEvents(),this);
        getServer().getPluginManager().registerEvents(new TNTEvent(),this);
        loadMenuListeners();

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

    public void loadMenuListeners(){
        Bukkit.getServer().getPluginManager().registerEvents(new MenuEvents(),this);

        Bukkit.getServer().getPluginManager().registerEvents(new OceanMenu(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new NetherMenu(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new EndMenu(),this);

        Bukkit.getServer().getPluginManager().registerEvents(new AgilityMenu(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new StrengthMenu(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new PowerMenu(),this);

        Bukkit.getServer().getPluginManager().registerEvents(new DamageMenu(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new DurabilityMenu(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new DigSpeedMenu(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new ProtectionMenu(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new ArrowDamageMenu(),this);

        Bukkit.getServer().getPluginManager().registerEvents(new TrapMenu(),this);

        Bukkit.getServer().getPluginManager().registerEvents(new RedTNTMenu(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlackTNTMenu(),this);
    }
}
