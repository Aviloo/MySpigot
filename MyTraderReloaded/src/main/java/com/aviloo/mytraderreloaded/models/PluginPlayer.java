package com.aviloo.mytraderreloaded.models;

public class PluginPlayer {

    private String gameName;
    private String javaUUID;
    private int reputation;

    public PluginPlayer(String name, String uuid) {
        javaUUID = uuid;
        gameName = name;
        reputation = 0;
    }

    public String getName() {
        return gameName;
    }

    public String getJavaUUID() {
        return javaUUID;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}