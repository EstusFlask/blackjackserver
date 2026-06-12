package com.blackjackserver.model;

import java.util.ArrayList;

public class Player {
    private Hand hand;
    public Player(boolean Dealer, Deck deck) {
        hand = new Hand();
        hand.drawCard(deck.getCardFromDeck());
        hand.drawCard(deck.getCardFromDeck());
        while (Dealer && this.count(deck) < 17) {
            hand.drawCard(deck.getCardFromDeck());
        }
    }

    // 算点数 包括防止因为A爆牌
    public int count(Deck deck) {


        int aCount = 0;
        int value = 0;
        for (Card c : hand.getCards()) {
            if (c.getRank().equals("A")) {
                aCount++;
            }
            value += c.getValue();
        }

        if (aCount == 0) {
            return value;
        } else if (value > 21) {
            while (value > 21 && aCount > 0) {
                aCount--;
                value -= 10;
            }

        }

        return value;
    }

    public String showHand() {
        return hand.getCards().toString();
    }

    public void draw(Deck deck) {
        hand.drawCard(deck.getCardFromDeck());
    }
}
