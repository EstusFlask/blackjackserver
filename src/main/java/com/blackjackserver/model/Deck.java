package com.blackjackserver.model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    public Deck() {
        deck = new ArrayList<>();
        String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds"};
        String[] ranks = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }
        Collections.shuffle(deck);
    }
    public Card getCardFromDeck() {
        return deck.remove(0);
    }

}
