package com.blackjackserver.service;

import com.blackjackserver.model.*;

public class GameService {
    private Player player1;
    private Player dealer;
    private Deck deck;

    public  GameService() {
        Deck deck = new Deck();
        player1 = new Player(false, deck);
        dealer = new Player(true, deck);


        System.out.println(player1.showHand());
    }

    public int comparePlayers() {
        if (player1.count(deck) > dealer.count(deck)) {
            System.out.println("Dealer:" + dealer.showHand());
            System.out.println("Player1:" + player1.showHand());
            System.out.println("Player Won !");
            return 1;
        } else if (player1.count(deck) < dealer.count(deck)) {
            System.out.println("Dealer:" + dealer.showHand());
            System.out.println("Player1:" + player1.showHand());
            System.out.println("Player Lost !");
            return 2;
        } else {
            System.out.println("Dealer:" + dealer.showHand());
            System.out.println("Player1:" + player1.showHand());
            System.out.println("draw");
            return 0;
        }
    }

    public void hit() {
        player1.draw(deck);
        System.out.println(player1.showHand());
    }

    public void stand() {
        comparePlayers();
    }
}
