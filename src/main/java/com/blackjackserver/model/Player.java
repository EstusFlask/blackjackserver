package com.blackjackserver.model;



public class Player {
    private Hand hand;
    public Player(boolean Dealer, Deck deck) {
        hand = new Hand();
        hand.drawCard(deck.getCardFromDeck());
        hand.drawCard(deck.getCardFromDeck());
        while (Dealer && this.count() < 17) {
            hand.drawCard(deck.getCardFromDeck());
        }
    }

    // 算点数 包括防止因为A爆牌
    public int count() {
        // 目前目标21点
        int goal = 21;

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
        } else if (value > goal) {
            while (value > goal && aCount > 0) {
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
