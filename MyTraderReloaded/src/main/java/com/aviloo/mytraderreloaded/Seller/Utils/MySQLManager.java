package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.UUID;

public class MySQLManager {

    private static Boolean DataBaseConnectionStatus = false;

    public static Boolean getDataBaseConnectionStatus(){
        Boolean bool = DataBaseConnectionStatus;
        return bool;
    }


    private static Connection connection;

    public static   Boolean isConnected(){
        return (connection == null ? false : true);
    }

    public Connection getConnection(){
        return connection;
    }

    private String host = "localhost";
    private Integer port = 3307;
    private String username = "root";
    private String password = "";
    private String database = "mytrader";

    public void connection() throws ClassNotFoundException, SQLException{
        if(!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" +
                            host + ":" + port + "/" + database + "?useSSL=false",
                    username, password);
        }
    }

    public void disconnection(){
        if(isConnected()){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void setUpTable(){
        if(!isConnected()){
            return;
        }
        try {
            //Reputation DataBase
            String reputation = "CREATE TABLE IF NOT EXISTS Reputation "+ "(uuid VARCHAR(36)," + " value INTEGER)";
            Statement ReputationStatement = connection.createStatement();
            ReputationStatement.executeUpdate(reputation);
            //Leader DataBase
            String leader = "CREATE TABLE IF NOT EXISTS Leader "+ "(uuid VARCHAR(36)," + " quantity INTEGER,"
                    + " earned INTEGER)";
            Statement LeaderStatement = connection.createStatement();
            LeaderStatement.executeUpdate(leader);
        }catch (SQLException sql){
            sql.printStackTrace();
        }
    }


    //Reputation Part
    protected static void getDataReputation(Player player) throws SQLException {
        if(!isConnected()){
            return;
        }
        String request = "SELECT value from Reputation WHERE uuid = '"+player.getUniqueId()+"'";
        PreparedStatement statement = connection.prepareStatement(request);
        ResultSet result = statement.executeQuery();
        //For debugging
        String ResultString = String.valueOf(result.getInt(1));
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GRAY+"Репутация " +player.getName()+
                " равна"+ResultString);
        //End of Debugging
        PlayerReputation.setReputation(player,result.getInt(1));
    }

    public static void setDataReputation() throws SQLException {
        if(!isConnected()){
            return;
        }
        Statement statement = connection.createStatement();
        for(UUID uuid : PlayerReputation.Reputation.keySet()){
            String valueToStr = String.valueOf(PlayerReputation.Reputation.get(uuid));
            String uuidToStr = String.valueOf(uuid);

            String queryCheck = "SELECT uuid from Reputation WHERE uuid = '" +uuid+"'";
            PreparedStatement prepareStatement = connection.prepareStatement(queryCheck);
            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next()) {
                String updateValue = "UPDATE Reputation SET value = '" +valueToStr+"' WHERE uuid LIKE '" + uuidToStr+"'";
                statement.executeUpdate(updateValue);
                //connection.close();
                return;
            }

            String writeValues = "INSERT INTO Reputation VALUES( '" + uuidToStr + "', '" + valueToStr + "')";
            statement.executeUpdate(writeValues);
        }
    }
}
