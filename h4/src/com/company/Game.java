package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    private int playerToPlay;
    private Board board;
    private int counterclockwise;

    Scanner scan;
    Random rand;

    public Game(ArrayList<Player> players, Board board) {
        this.players = players;
        this.board = board;
        playerToPlay = 0;
        counterclockwise = 1;
        scan = new Scanner(System.in);
        rand = new Random();
    }

    public void sevenDevils() throws InterruptedException {
        playerToPlay = board.startGame(players);
        System.out.println(players.get(playerToPlay).getName() + " you will  start.");

        while(!isEnd()){
            int mode = applyCard(players.get(playerToPlay), players.get(playerToPlay).choose(board)), ponish = 0;

            if(!isEnd() && (mode == 7 || mode == 77)){
                while (mode == 7 || mode == 77) {
                    ponish += mode == 7 ? 2 : 4;

                    playerToPlay = (playerToPlay + counterclockwise) % players.size();
                    Card card = players.get(playerToPlay).chooseSeven(board, this);

                    if(card == null){
                        for(int i = 0;i < ponish;i++)
                            players.get(playerToPlay).getCards().add(board.ponish());

                        mode = 0;
                    }
                    else if(card.getType().equals("7"))
                        mode = applyCard(players.get(playerToPlay), card);

                }
                ponish = 0;
            }
            else if(mode == 8){
                while (mode == 8)
                mode = applyCard(players.get(playerToPlay), players.get(playerToPlay).choose(board));
            }

            playerToPlay = (playerToPlay + counterclockwise) % players.size();
        }
    }

    public int applyCard(Player player, Card card){
        if(card == null){
            player.getCards().add((board.ponish()));

            System.out.println("You have gotten a new card, you can choose again.");
            Card chosenCard = player.choose(board);

            return 0;
        }
        else if(card.getType().equalsIgnoreCase("3") || card.getType().equalsIgnoreCase("4") || card.getType().equalsIgnoreCase("5") || card.getType().equalsIgnoreCase("6") || card.getType().equalsIgnoreCase("9") || card.getType().equalsIgnoreCase("C") || card.getType().equalsIgnoreCase("D")){
            board.applyCard(player, card);

            return 0;
        }
        else{
            int mode = board.applyCard(player, card);

            if(mode == 1) {
                playerToPlay++;
                return 0;
            }
            else if(mode == 2){
                System.out.println("Please enter the number of the person you wat to give one of your card to.");

                for(int i = 1;i <= players.size();i++)
                    System.out.println(i + ". " + players.get(i - 1).getName());

                int index = scan.nextInt() - 1;

                if(index >= 0 && index < players.size()){
                    Card cardToGive = player.getCards().get(rand.nextInt(player.getCards().size()));

                    players.get(index).getCards().add(cardToGive);
                    player.getCards().remove(card);

                    System.out.println(players.get(index).getName() + " has gotten a random cart from you.");
                }
                return 0;
            }
            else if(mode == 7){
                return (card.getColor() == Color.RED || card.getColor() == Color.BLUE) ? 2 : 4;
            }
            else if(mode == 8){
                return 8;
            }
            else if(mode == 10){
                counterclockwise *= -1;

                return 0;
            }
            else if(mode == 11){
                System.out.println(player.getName() + " please choose the board color:\n1. RED\n2. BLUE\n3. YELLOW\n4. GREEN");
                int color = scan.nextInt();

                if(color < 0 || color >= 5) {
                    System.out.println("Wrong input please try again.");
                    color = scan.nextInt();
                }
                board.setColor(color == 1 ? Color.RED : (color == 2 ? Color.BLUE : (color == 3 ? Color.YELLOW : Color.GREEN)));

                return 0;
            }
            return 0;
        }
    }

    private boolean isEnd(){
        for(Player player : players)
            if(player.getCards().size() == 0)
                return true;

            return false;
    }
}
