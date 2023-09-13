package com.aviloo.myscoreboard.Boards;

import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.entity.Player;

public class MainBoard {


    public static FastBoard getBoard(Player player){
        FastBoard board = new FastBoard(player);
        return board;
    }

}
