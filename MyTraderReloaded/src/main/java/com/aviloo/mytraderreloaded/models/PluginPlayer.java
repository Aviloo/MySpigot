package com.aviloo.mytraderreloaded.models;

public class PluginPlayer {

    private String name;
    private String javaUUID;
    private int reputation;

    public PluginPlayer(String name, String uuid) {
        reputation = 0;
    }

    public String getName() {
        return name;
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