package me.aviloo.mypotionsystem;

import me.aviloo.mypotionsystem.Commands.GetTestPotion;
import me.aviloo.mypotionsystem.Commands.OpenMainMenu;
import me.aviloo.mypotionsystem.Commands.ReloadConfig;
import me.aviloo.mypotionsystem.Events.InfoInteract;
import me.aviloo.mypotionsystem.Events.MainInteract;
import me.aviloo.mypotionsystem.Events.MaterialsInteract;
import me.aviloo.mypotionsystem.Events.OtherEvents.GlobalEvents;
import me.aviloo.mypotionsystem.Inventories.CraftingInventory;
import me.aviloo.mypotionsystem.Utils.EconomyManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyPotionSystem extends JavaPlugin {

    public Economy eco;

    private boolean setupEconomy(){
        RegisteredServiceProvider<Economy> economy = getServer().getServicesManager()
                .getRegistration(net.milkbowl.vault.economy.Economy.class);
        if(economy != null) eco = economy.getProvider();

        return (eco != null);
    }

    @Override
    public void onEnable() {
        //Methods
        loadingMethods();
        //Implements Main Class
        getServer().getPluginManager().registerEvents(new EconomyManager(this),this);
        getServer().getPluginManager().registerEvents(new CraftingInventory(this),this);
        //Commands
        getCommand("gettestpotion").setExecutor(new GetTestPotion());
        getCommand("secretpotioncommand").setExecutor(new OpenMainMenu());
        getCommand("mypotion").setExecutor(new ReloadConfig(this));
        //Completer
        getCommand("mypotion").setTabCompleter(new ReloadConfig(this));
        //Events
        getServer().getPluginManager().registerEvents(new MainInteract(),this);
        getServer().getPluginManager().registerEvents(new GlobalEvents(),this);
        getServer().getPluginManager().registerEvents(new MaterialsInteract(),this);
        getServer().getPluginManager().registerEvents(new InfoInteract(this),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void loadingMethods(){
        loadConfig();
        if (!setupEconomy()){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&4[Ошибка] &fНеполадки в плагине Vault. " +
                            "&fПлагин &7(MyPotionSystem)&f будет отключен."));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }

}
