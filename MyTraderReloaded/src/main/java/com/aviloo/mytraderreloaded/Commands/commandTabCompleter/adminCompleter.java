package com.aviloo.mytraderreloaded.Commands.commandTabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class adminCompleter implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> commandsFirst = new ArrayList<>();
        if(args.length == 1){
            List<String> completions = new ArrayList<>();
            completions.add("earned set");
            completions.add("earned get");
            completions.add("earned reset");
            completions.add("earned givereward");
            completions.add("expansions");
            completions.add("info");
            completions.add("reload all");
            completions.add("reload config");
            completions.add("reload menu");
            completions.add("reputation add");
            completions.add("reputation take");
            completions.add("reputation set");
            completions.add("reputation reset");
            completions.add("reputation get");
            completions.add("secrettrader");
            for(String s : completions){
                if(s.toLowerCase().startsWith(args[0].toLowerCase())){
                    commandsFirst.add(s);
                }
            }
            return commandsFirst;
        }
        return null;
    }
}
