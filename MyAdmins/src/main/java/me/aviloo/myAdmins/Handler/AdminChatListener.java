package me.aviloo.myAdmins.Handler;

import me.aviloo.myAdmins.Events.AdminChatMessageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdminChatListener implements Listener {

    private File file;

    @EventHandler
    public void onChat(AdminChatMessageEvent event) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("[" + event.getTime() + "] " + event.getSender().getName() +
            ": " + event.getMessage().replace(",","").
            replace("[","").replace("]","").trim()
            + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AdminChatListener(File file){
        this.file = file;
    }

}
