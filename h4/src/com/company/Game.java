package com.company;

import java.util.*;
/**
 * manages the whole game process
 * @author mehranghaffarian
 * */
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

    /**
     * main game loop
     * */
    public void sevenDevils() throws InterruptedException {
        playerToPlay = board.startGame(players);
        System.out.println(players.get(playerToPlay).getName() + " you will  start.");

        while (!isEnd()) {
            int mode = applyCard(players.get(playerToPlay), players.get(playerToPlay).choose(board)), ponish = 0;//defining the effect of the card, ponish -> for case of seven

            if (!isEnd() && (mode == 7 || mode == 77)) {//77 -> yellow seven with 4 ponish, 7 -> not yellow sevens with 2 ponish
                while (mode == 7 || mode == 77) {
                    ponish += mode == 7 ? 2 : 4;

                    playerToPlay = (playerToPlay + counterclockwise + players.size()) % players.size();
                    Card card = players.get(playerToPlay).chooseSeven(board, this);

                    if (card == null) {
                        for (int i = 0; i < ponish; i++)
                            players.get(playerToPlay).getCards().add(board.ponish());

                        System.out.println(players.get(playerToPlay).getName() + " has gotten ponished.");

                        mode = 0;
                    } else if (card.getType().equals("7"))
                        mode = applyCard(players.get(playerToPlay), card);
                }
                ponish = 0;
            } else if (!isEnd() && mode == 8) {//the award for 8
                while (!isEnd() && mode == 8)
                    mode = applyCard(players.get(playerToPlay), players.get(playerToPlay).choose(board));
            }

            playerToPlay = (playerToPlay + counterclockwise + players.size()) % players.size();
        }
        calculateScores();
    }
    /**
     * the method would return the influence of the card for the rest of the game
     * @param card which has been chosen by the player(the validity of the card is checked in choose method in Player class)
     * @param player who has chose the card
     * @return the effect of the card as an integer
     * */
    public int applyCard(Player player, Card card) throws InterruptedException {
        if (card == null) {//the player should get a new card and can choose another card
            player.getCards().add((board.ponish()));

            if (player instanceof Bot)
                System.out.println(player.getName() + " has gotten a new card, it can choose again.");
            else
                System.out.println("You have gotten a new card, you can choose again.");

            Card chosenCard = player.choose(board);

            if (chosenCard == null) {
                System.out.println(player.getName() + " could not use the new card.");
                return 0;
            }
            else
                return applyCard(player, chosenCard);//the chosen card is going to be applied

            //the player has chosen usial card
        } else if (card.getType().equalsIgnoreCase("3") || card.getType().equalsIgnoreCase("4") || card.getType().equalsIgnoreCase("5") || card.getType().equalsIgnoreCase("6") || card.getType().equalsIgnoreCase("9") || card.getType().equalsIgnoreCase("C") || card.getType().equalsIgnoreCase("D")) {
            board.applyCard(player, card);

            return 0;
        }
        //the player has chosen special card
        else {
            int mode = board.applyCard(player, card);

            if (mode == 1) {//Ace
                playerToPlay++;
                return 0;
            }
            //another player is chosed to get a random card
            else if (!isEnd() && mode == 2) {
                if (!(player instanceof Bot)) {
                    System.out.println("Please enter the number of the person you want to give one of your card to.");
                    int currPlayer = 0;

                    for (int i = 0; i < players.size(); i++) {
                        System.out.println((i + 1) + ". " + players.get(i).getName());

                        if (players.get(i) == player)
                            currPlayer = i;
                    }

                    int index = scan.nextInt() - 1;

                    if (index >= 0 && index < players.size() && index != currPlayer) {
                        Card cardToGive = player.getCards().get(rand.nextInt(player.getCards().size()));

                        players.get(index).getCards().add(cardToGive);
                        player.getCards().remove(cardToGive);

                        System.out.println(players.get(index).getName() + " has gotten a random cart from you.");
                    } else {
                        boolean isCorrect = false;

                        while (!isCorrect) {
                            System.out.println("Wrong input try again.");

                            index = scan.nextInt() - 1;

                            if (index >= 0 && index < players.size() && index != currPlayer) {
                                Card cardToGive = player.getCards().get(rand.nextInt(player.getCards().size()));

                                players.get(index).getCards().add(cardToGive);
                                player.getCards().remove(cardToGive);

                                System.out.println(players.get(index).getName() + " has gotten a random cart from you.");

                                isCorrect = true;
                            } else
                                isCorrect = false;
                        }
                    }
                } else {
                    int minCards = 2000, indexBot = 0;

                    for (int i = 0; i < players.size(); i++)
                        if (players.get(i) != player && minCards > players.get(i).getCards().size()) {
                            minCards = players.get(i).getCards().size();
                            indexBot = i;
                        }
                    Card cardToGive = player.getCards().get(rand.nextInt(player.getCards().size()));

                    players.get(indexBot).getCards().add(cardToGive);
                    player.getCards().remove(cardToGive);

                    System.out.println(players.get(indexBot).getName() + " has gotten a random cart from " + player.getName());
                }
                return 0;
            } else if (mode == 7) {
                return (card.getColor() != Color.YELLOW) ? 7 : 77;
            } else if (mode == 8) {
                return 8;
            } else if (mode == 10) {
                counterclockwise *= -1;

                return 0;
            } else if (mode == 11) {//B(Jack)
                if (!(player instanceof Bot)) {
                    System.out.println(player.getName() + " please choose the board color:\n1. RED\n2. BLUE\n3. YELLOW\n4. GREEN");
                    int color = scan.nextInt();

                    if (color <= 0 || color >= 5) {
                        System.out.println("Wrong input please try again.");
                        color = scan.nextInt();
                    }
                    board.setColor(color == 1 ? Color.RED : (color == 2 ? Color.BLUE : (color == 3 ? Color.YELLOW : Color.GREEN)));
                } else {
                    int color = rand.nextInt(4) + 1;

                    board.setColor(color == 1 ? Color.RED : (color == 2 ? Color.BLUE : (color == 3 ? Color.YELLOW : Color.GREEN)));
                }
                return 0;
            }
            return 0;
        }
    }

    private Boolean isEnd() {
        for (Player player : players)
            if (player.getCards().size() == 0)
                return true;

        return false;
    }

    public void calculateScores() {
        HashMap<Player, Integer> scores = new HashMap<>();

        for (Player player : players) {
            int score = 0;

            if (player.getCards().size() != 0) {
                for (Card card : player.getCards()) {
                    if (card.getType().equals("2") || card.getType().equals("3") || card.getType().equals("4") || card.getType().equals("5") || card.getType().equals("6") || card.getType().equals("8") || card.getType().equals("9") || card.getType().equals("10"))
                        score += Integer.parseInt(card.getType());
                    else if (card.getType().equals("C"))
                        score += 12;
                    else if (card.getType().equals("D"))
                        score += 13;
                    else if (card.getType().equals("A"))
                        score += 11;
                    else if (card.getType().equals("B"))
                        score += 12;
                    else if (card.getType().equals("7") && card.getColor() == Color.YELLOW)
                        score += 15;
                    else
                        score += 10;
                }
            }
            scores.put(player, score);
        }
        ArrayList<Integer> scoresArray = new ArrayList<>();

        for (Player player : players) {
            scoresArray.add(scoresArray.size(), scores.get(player));
        }

        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size() - 1; j++) {
                if (scoresArray.get(j) > scoresArray.get(j + 1)) {
                    Integer temp = scoresArray.get(j);
                    scoresArray.set(j, scoresArray.get(j + 1));
                    scoresArray.set(j + 1, temp);

                    Player tempPlayer = players.get(j);
                    players.set(j, players.get(j + 1));
                    players.set(j + 1, tempPlayer);
                }
            }
        }
        int rank = 0;

        for (Player player : players) {
            System.out.println((++rank) + ". " + player.getName() + "\nScore: " + scores.get(player) + "\nCards:\n");

            if (player.getCards().size() != 0)
                player.getCards().get(0).displayCards(player.getCards());
        }
    }
}
