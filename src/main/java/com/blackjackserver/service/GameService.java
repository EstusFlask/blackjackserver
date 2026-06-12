package com.blackjackserver.service;

import com.blackjackserver.model.*;

public class GameService {
    private Player player1;
    private Player dealer;
    private Deck deck;

    public  GameService() {
        deck = new Deck();
        player1 = new Player(false, deck);
        dealer = new Player(true, deck);


        System.out.println(player1.showHand());
    }

    private int comparePlayers() {
        if ((player1.count(deck) > dealer.count(deck)) || dealer.count(deck) > 21) {
            // player won
            return 1;
        } else if (player1.count(deck) < dealer.count(deck)) {
            // player lost
            return 2;
        } else {
            // draw
            return 0;
        }
    }

    public void hit() {
        player1.draw(deck);
        System.out.println(player1.showHand());
    }

    public int stand() {
        return comparePlayers();
    }

    public String getPlayerHand() {
        return player1.showHand();
    }

    public String getDealerHand() {
        return dealer.showHand();
    }

    public int getPlayerCount() {
        return player1.count(deck);
    }

    public int getDealerCount() {
        return dealer.count(deck);
    }
}
