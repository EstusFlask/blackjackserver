package com.blackjackserver.model;

import java.util.ArrayList;
import java.util.Random;

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
        shuffle();
    }
    public Card getCardFromDeck() {
        return deck.remove(deck.size() - 1);
    }

    private void shuffle() {
        Random rand = new Random();
        for (int i = deck.size() - 1; i >= 1; i--) {
            swap (i, rand.nextInt(i + 1));
        }
    }

    private void swap (int i, int j) {
        Card temp = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, temp);
    }

}
