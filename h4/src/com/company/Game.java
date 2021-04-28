package com.company;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Board board;

    public Game(ArrayList<Player> players, Board board) {
        this.players = players;
        this.board = board;
    }

    public void game() throws InterruptedException {
        int playerToStart = board.startGame(players.size());
        System.out.println(players.get(playerToStart).getName() + "you will  start.");

        while(!isEnd()){
            players.get(playerToStart).choose(board);

        }
    }

    private boolean isEnd(){
        for(Player player : players)
            if(player.cardsNumber() == 0)
                return true;

            return false;
    }
}
