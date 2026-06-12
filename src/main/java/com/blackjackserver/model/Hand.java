package com.blackjackserver.model;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> handCards = new ArrayList<>();

    public ArrayList<Card> getHandCards() {
        return handCards;
    }
    public void drawCard(Card card) {
        handCards.add(card);
    }
    public ArrayList<Card> getCards() {
        return handCards;
    }
}
