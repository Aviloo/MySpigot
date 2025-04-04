package com.aviloo.mytraderreloaded.models;

public class PluginPlayer {

    private String javaUUID;
    private int reputation;

    public PluginPlayer(String uuid) {
        javaUUID = uuid;
        reputation = 0;
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