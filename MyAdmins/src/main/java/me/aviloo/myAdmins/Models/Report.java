package me.aviloo.myAdmins.Models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Report {

    private int id;
    private String player_name;
    private String[] description;
    private String Date;

    private static int maxID = 0;

    public Report(String player_name, String[] description ){
        this.id = maxID+1;
        maxID++;
        this.player_name = player_name;
        this.description = description;
        this.Date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        reports.add(this);

    }

    public static Set<Report> reports = new HashSet();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }
}
