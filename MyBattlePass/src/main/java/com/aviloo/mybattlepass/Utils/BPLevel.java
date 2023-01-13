package com.aviloo.mybattlepass.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BPLevel implements Listener {
    //HashMap Part
    private static final LinkedHashMap<UUID,Integer> BattleLevel = new LinkedHashMap<>();

    public static void addLevel(Player player){
        BattleLevel.put(player.getUniqueId(),BattleLevel.getOrDefault(player.getUniqueId(),0) + 1);
    }
    public static Integer getLevel(UUID uuid){
        return BattleLevel.get(uuid);
    }

    public static void setDefault(UUID uuid){
        BattleLevel.put(uuid,0);
    }

    public static void reset(){
        for(UUID uuids : BattleLevel.keySet()){
            setDefault(uuids);
        }
    }

    private static void insert(UUID uuid ,Integer level){
        BattleLevel.put(uuid, level);
    }

    //DataBase Part
    public static void saveBPLevel(){
        String jdbsURL = "jdbc:sqlite:plugins/MyBattlePass/mainContainer.db";


        try{
            Connection connection = DriverManager.getConnection(jdbsURL);
            Statement statement = connection.createStatement();

            //Creating Tables
            try{
                String sql = "CREATE TABLE IF NOT EXISTS BattlePassLevel" + "(uuid VARCHAR(36)," + " level INTEGER)";
                statement.executeUpdate(sql);
                //Try to save HashMap key and value into SQL
                for(UUID uuid : BattleLevel.keySet()){
                    String boolToStr = String.valueOf(getLevel(uuid));
                    String uuidToStr = String.valueOf(uuid);
                    //String nameToStr = Bukkit.getPlayer(uuid).getName();
                    //If uuid value already exist like value in table
                    String queryCheck = "SELECT uuid from BattlePassLevel WHERE uuid = '" +uuid+"'";
                    PreparedStatement prepareStatement = connection.prepareStatement(queryCheck);
                    ResultSet rs = prepareStatement.executeQuery();
                    if(rs.next()) {
                        String updateValue = "UPDATE BattlePassLevel SET level = '" +boolToStr+"' WHERE uuid LIKE '" + uuidToStr+"'";
                        statement.executeUpdate(updateValue);
                        //connection.close();
                        return;
                    }

                    //If uuid value NOT already exist like value in table
                    String writeValues = "INSERT INTO BattlePassLevel VALUES( '" + uuidToStr + "', '" + boolToStr + "')";
                    statement.executeUpdate(writeValues);

                }
                //Обязательно именно после цикла закрывать соединение
                connection.close();

            }catch (SQLException sqle){
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Can not create Table - BattlePassLevel");
                sqle.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (SQLException sqlE){
            Bukkit.getServer().getLogger().warning("MyBattlePass sql Exception - from BattlePassLevel Class.");
            sqlE.printStackTrace();
        }
    }

    public static void getBPLevel(UUID uuid){
        String jdbsURL = "jdbc:sqlite:plugins/MyBattlePass/mainContainer.db";

        try{
            //Connection
            Connection connection = DriverManager.getConnection(jdbsURL);
            Statement statement = connection.createStatement();
            String getLevel = "SELECT level from BattlePassLevel WHERE uuid = '"+uuid+"'";
            PreparedStatement prepareStatement = connection.prepareStatement(getLevel);
            ResultSet rs = prepareStatement.executeQuery();
            //Debugging
            Player player = Bukkit.getPlayer(uuid);
            player.sendMessage(String.valueOf(rs.getInt(1)));
            insert(uuid,rs.getInt(1));
            connection.close();


        }catch (SQLException sqlE){
            Bukkit.getServer().getLogger().warning("MyBattlePass sql Exception - from BattlePassLevel Class.");
            sqlE.printStackTrace();
        }
    }
    //Leader Path

    public static void getLeaderLevel(){
        String jdbsURL = "jdbc:sqlite:plugins/MyBattlePass/mainContainer.db";
        try{
            Connection connection = DriverManager.getConnection(jdbsURL);
            String getLeaderLevel = "SELECT MAX(level) from BattlePassLevel";
            PreparedStatement preparedStatement = connection.prepareStatement(getLeaderLevel);
            ResultSet rs = preparedStatement.executeQuery();
            String result_first = String.valueOf(rs.getInt(1));
            System.out.println(result_first);
            String getLeaderUUID = "SELECT uuid from BattlePassLevel WHERE level = '"+result_first+"'";
            PreparedStatement preparedStatement1 = connection.prepareStatement(getLeaderUUID);
            ResultSet rs1 = preparedStatement1.executeQuery();
            UUID leaderUUID = UUID.fromString(rs1.getString(1));
            System.out.println(rs1.getString(1));
            OfflinePlayer leader = Bukkit.getOfflinePlayer(leaderUUID);
            System.out.println(leader.getName()); //
            System.out.println(result_first); //
            addStats(leader, Integer.valueOf(result_first));
            connection.close();
        }catch (SQLException sqlE){
            Bukkit.getServer().getLogger().warning("MyBattlePass sql Exception - from BattlePassLevel Class.");
            sqlE.printStackTrace();
        }
    }

    private static final ConcurrentHashMap<OfflinePlayer,Integer> leaderStats = new ConcurrentHashMap<>();

    public static void addStats(OfflinePlayer leader ,Integer level){
        leaderStats.put(leader,level);
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

    //Event Path

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()){return;}
        getBPLevel(player.getUniqueId());
    }

}
