package com.aviloo.mybattlepass;

import com.aviloo.mybattlepass.Commands.*;
import com.aviloo.mybattlepass.Commands.TabCompleter.FreeBPCompleter;
import com.aviloo.mybattlepass.Events.MenuInteraction.*;
import com.aviloo.mybattlepass.Events.OtherEvents.FreeBattlePassBroadcast;
import com.aviloo.mybattlepass.Events.OtherEvents.NoNullPointExceptionFromHashMaps;
import com.aviloo.mybattlepass.Placeholders.ExpExpansion;
import com.aviloo.mybattlepass.Placeholders.LevelExpansion;
import com.aviloo.mybattlepass.Utils.BPExp;
import com.aviloo.mybattlepass.Utils.BPLevel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public final class MyBattlePass extends JavaPlugin {

    private String host, database, username, password, table;
    private int port;

    @Override
    public void onEnable() {

        //Plugins Methods
        loadConfig();
        BPLevel.saveBPLevel();
        Bukkit.getScheduler().runTaskLater(this, () -> {
            BPExp.saveBPExp();
        }, 40);


        if(!onConnect()){
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyBattlePass]"+ChatColor.RED + "You need create - mainContainer.db AND BattleExpContainer.db - files in plugin directory.");
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyBattlePass]"+ChatColor.RED + "Or you connection data was wrong, then check it");
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyBattlePass]"+ChatColor.RED + ",Or check Code. Good Luck :3");
            Bukkit.getConsoleSender().sendMessage(" ");
            if(Objects.equals(this.getConfig().getString("StopServerWithoutConnection"), "true")) {
                if(Objects.equals(this.getConfig().getString("SetEnableStopping"), "true") && Objects.equals(this.getConfig().getString("BukkitShutdownStopping"), "false")){
                    this.setEnabled(false); //Выключает сервер (Рекомендуеться включать , когда настроена бд!)
                }
                if(Objects.equals(this.getConfig().getString("BukkitShutdownStopping"), "true") && Objects.equals(this.getConfig().getString("SetEnableStopping"), "false")){
                    Bukkit.shutdown(); //- аналог метода выше
                }
                else return;

            }else Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyBattlePass]"+ChatColor.RED+"You can on " +
                    "shutdown server func. You need just to change"+ChatColor.WHITE+" StopServerWithoutConnection"
                    +ChatColor.RED +" to true in Plugin " + "Configuration. "+ChatColor.GRAY+"(plugins/MyBattlePass" +
                    "/config.yml) ");
        }
        if(onConnect()) {
            //Beauty Art For Enable
            BeautyArt();
            //Basic Methods
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY+"[MyBattlePass]"+ChatColor.GREEN + "Successfully connection to SQLite libraries.");

            // Events
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenFirstInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new NoNullPointExceptionFromHashMaps(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenTwoInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenThirdInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenFourthInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenFifthInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenSixthInteract(), this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenSeventhInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenEighthInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenNinthInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenTenthInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenSeventhForNoDonateInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new ScreenEleventhInteract(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new FreeBattlePassBroadcast(this),this);

            //Serialization Events
            Bukkit.getServer().getPluginManager().registerEvents(new BPLevel(),this);
            Bukkit.getServer().getPluginManager().registerEvents(new BPExp(this),this);

            //Commands
            Bukkit.getServer().getPluginCommand("bpaddexp").setExecutor(new AddExpCommand());
            Bukkit.getServer().getPluginCommand("battlepass").setExecutor(new BPOpen(this));
            Bukkit.getServer().getPluginCommand("bpreset").setExecutor(new ResetCommand());
            Bukkit.getServer().getPluginCommand("freebattlepass").setExecutor(new FreeBattlePass(this));
            Bukkit.getServer().getPluginCommand("reloadbattlepass").setExecutor(new ReloadConfiguration(this));

            //TabComplete
            Bukkit.getServer().getPluginCommand("freebattlepass").setTabCompleter(new FreeBPCompleter());

            //Placeholders
            new LevelExpansion().register();
            new ExpExpansion().register();

            //Leader Methods
            BPLevel.getLeaderLevel();
            BPExp.getLeaderExp();
        }
    }

    @Override
    public void onDisable() {
        //Methods
        BPLevel.saveBPLevel();
        BPExp.saveBPExp();
    }


    public Boolean onConnect(){
        //For SQL Lite
        String jdbsURL = "jdbc:sqlite:plugins/MyBattlePass/mainContainer.db";

        //For MySQL DB
        host = this.getConfig().getString("host");
        port = this.getConfig().getInt("port");
        database = this.getConfig().getString("database");
        username = this.getConfig().getString("username");
        password = this.getConfig().getString("password");

        try{
            if(this.getConfig().getBoolean("use_SQLite")) {
                Connection connectionLite = DriverManager.getConnection(jdbsURL);
                Statement statementLite = connectionLite.createStatement();
                connectionLite.close();
                return true;
            }
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":"
                    + this.port + "/" + this.database, this.username, this.password);
            Statement statement = connection.createStatement();
            connection.close();
            return true;
        }catch (SQLException sqlE){
            Bukkit.getServer().getLogger().warning("BattlePass sql Exception");
            sqlE.printStackTrace();
            return false;
        }
    }

    public  void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void BeautyArt(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+" .----------------.  .----------------.  .----------------.  .----------------. ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"| .--------------. || .--------------. || .--------------. || .--------------. |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"| | ____    ____ | || |  ____  ____  | || |   ______     | || |   ______     | |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"| ||_   \\  /   _|| || | |_  _||_  _| | || |  |_   _ \\    | || |  |_   __ \\   | |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"| |  |   \\/   |  | || |   \\ \\  / /   | || |    | |_) |   | || |    | |__) |  | |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"| |  | |\\  /| |  | || |    \\ \\/ /    | || |    |  __'.   | || |    |  ___/   | |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"| | _| |_\\/_| |_ | || |    _|  |_    | || |   _| |__) |  | || |   _| |_      | |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"| ||_____||_____|| || |   |______|   | || |  |_______/   | || |  |_____|     | |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"| |              | || |              | || |              | || |              | |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"| '--------------' || '--------------' || '--------------' || '--------------' |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+" '----------------'  '----------------'  '----------------'  '----------------' ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"                                                                                                        " +
                "by Aviloo");
    }
}
