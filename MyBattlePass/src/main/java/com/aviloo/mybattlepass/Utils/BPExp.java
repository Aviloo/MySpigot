package com.aviloo.mybattlepass.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BPExp implements Listener {
    //Timer Part
    private JavaPlugin plugin;

    public BPExp(JavaPlugin plugin){
        this.plugin = plugin;
    }
    private static final LinkedHashMap<UUID,Integer> BattleExp = new LinkedHashMap<>();

    public static void addExp(Player player,Integer count){
        BattleExp.put(player.getUniqueId(),BattleExp.getOrDefault(player.getUniqueId(),0) + count);
    }
    public static Integer getExp(Player player){
        return BattleExp.get(player.getUniqueId());
    }

    public static Integer getLack(Player player,Integer MaxPoints){
        return MaxPoints - getExp(player);
    }

    public static void setDefault(UUID uuid){
        BattleExp.put(uuid,0);
    }

    public static void reset(){
        for(UUID uuids : BattleExp.keySet()){
            setDefault(uuids);
        }
    }

    private static void insert(UUID uuid ,Integer exp){
        BattleExp.put(uuid, exp);
    }

    //DataBase Part
    public static void saveBPExp(){
        String jdbsURL = "jdbc:sqlite:plugins/MyBattlePass/BattleExpContainer.db";


        try{
            Connection connection = DriverManager.getConnection(jdbsURL);
            Statement statement = connection.createStatement();

            //Creating Tables
            try{
                String sql = "CREATE TABLE IF NOT EXISTS BattlePassExp" + "(uuid VARCHAR(36)," + " exp INTEGER)";
                statement.executeUpdate(sql);
                //Try to save HashMap key and value into SQL
                for(UUID uuid : BattleExp.keySet()){
                    String boolToStr = String.valueOf(getExp(Bukkit.getPlayer(uuid)));
                    String uuidToStr = String.valueOf(uuid);
                    //String nameToStr = Bukkit.getPlayer(uuid).getName();
                    //If uuid value already exist like value in table
                    String queryCheck = "SELECT uuid from BattlePassExp WHERE uuid = '" +uuid+"'";
                    PreparedStatement prepareStatement = connection.prepareStatement(queryCheck);
                    ResultSet rs = prepareStatement.executeQuery();
                    if(rs.next()) {
                        String updateValue = "UPDATE BattlePassExp SET exp = '" +boolToStr+"' WHERE uuid LIKE '" + uuidToStr+"'";
                        statement.executeUpdate(updateValue);
                        //connection.close();
                        return;
                    }

                    //If uuid value NOT already exist like value in table
                    String writeValues = "INSERT INTO BattlePassExp VALUES( '" + uuidToStr + "', '" + boolToStr + "')";
                    statement.executeUpdate(writeValues);

                }
                //Обязательно именно после цикла закрывать соединение
                connection.close();

            }catch (SQLException sqle){
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Can not create Table - BattlePassExp");
                sqle.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (SQLException sqlE){
            Bukkit.getServer().getLogger().warning("MyBattlePass sql Exception - from BattlePassExp Class.");
            sqlE.printStackTrace();
        }
    }

    public static void getBPExp(UUID uuid){
        String jdbsURL = "jdbc:sqlite:plugins/MyBattlePass/BattleExpContainer.db";

        try{
            //Connection
            Connection connection = DriverManager.getConnection(jdbsURL);
            Statement statement = connection.createStatement();
            String getExp = "SELECT exp from BattlePassExp WHERE uuid = '"+uuid+"'";
            PreparedStatement prepareStatement = connection.prepareStatement(getExp);
            ResultSet rs = prepareStatement.executeQuery();
            //Debugging
            Player player = Bukkit.getPlayer(uuid);
            player.sendMessage(String.valueOf(rs.getInt(1)));
            insert(uuid,rs.getInt(1));
            connection.close();


        }catch (SQLException sqlE){
            Bukkit.getServer().getLogger().warning("MyBattlePass sql Exception - from BattlePassExp Class.");
            sqlE.printStackTrace();
        }
    }

    //Leader Path

    public static void getLeaderExp(){
        String jdbsURL = "jdbc:sqlite:plugins/MyBattlePass/BattleExpContainer.db";
        String jdbsURL_second = "jdbc:sqlite:plugins/MyBattlePass/mainContainer.db";
        try{
            Connection connection = DriverManager.getConnection(jdbsURL);
            String getLeaderExp = "SELECT MAX(exp) from BattlePassExp";
            PreparedStatement preparedStatement = connection.prepareStatement(getLeaderExp);
            ResultSet rs = preparedStatement.executeQuery();
            String result_first = String.valueOf(rs.getInt(1));
            System.out.println(result_first);
            String getLeaderUUID = "SELECT uuid from BattlePassExp WHERE exp = '"+result_first+"'";
            PreparedStatement preparedStatement1 = connection.prepareStatement(getLeaderUUID);
            ResultSet rs1 = preparedStatement1.executeQuery();
            UUID leaderUUID = UUID.fromString(rs1.getString(1));
            System.out.println(rs1.getString(1));
            OfflinePlayer leader = Bukkit.getOfflinePlayer(leaderUUID);
            System.out.println(leader.getName()); //
            System.out.println(result_first); //
            addStats(leader, Integer.valueOf(result_first));
            connection.close();
            //Second Connect
            Connection connection2 = DriverManager.getConnection(jdbsURL_second);
            String getLeaderLevel = "SELECT level from BattlePassLevel WHERE uuid = '"+leaderUUID+"'";
            PreparedStatement preparedStatement2 = connection2.prepareStatement(getLeaderLevel);
            ResultSet rs2 = preparedStatement2.executeQuery();
            Integer LeaderLevel = rs2.getInt(1);
            addLevel(leader,LeaderLevel);

        }catch (SQLException sqlE){
            Bukkit.getServer().getLogger().warning("MyBattlePass sql Exception - from BattlePassExp Class.");
            sqlE.printStackTrace();
        }
    }

    private static final ConcurrentHashMap<OfflinePlayer,Integer> leaderStats = new ConcurrentHashMap<>();

    private static void addStats(OfflinePlayer leader, Integer exp){
        leaderStats.put(leader,exp);
    }

    public static String getLeaderName(){
        for(OfflinePlayer leader : leaderStats.keySet()){
            return leader.getName();
        }
        return "FullVision";
    }

    public static String getLeaderStats(){
        for(OfflinePlayer keyset : leaderStats.keySet()){
            return String.valueOf(leaderStats.get(keyset));
        }
        return "7";
    }
    public static OfflinePlayer getPlayerProfile(){
        for(OfflinePlayer keyset : leaderStats.keySet()){
            return keyset;
        }
        return null;
    }

    private static final ConcurrentHashMap<OfflinePlayer,Integer> leaderLevel = new ConcurrentHashMap<>();
    private static void addLevel(OfflinePlayer leader,Integer level){leaderLevel.put(leader,level);}
    public static String getLeaderLevel(){
        for(OfflinePlayer keyset : leaderLevel.keySet()){
            return String.valueOf(leaderLevel.get(keyset));
        }
        return "10";
    }

    @EventHandler(priority = EventPriority.HIGH,ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()){return;}
        getBPExp(player.getUniqueId());
    }
}
