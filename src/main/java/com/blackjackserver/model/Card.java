package com.blackjackserver.model;

public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        return suit + " " + rank;
    }

    public String getSuit() {
        return suit;
    }
    public String getRank() {
        return rank;
    }

    public int getValue() {
        switch (rank) {
            case "A":
                return 11;
            case "J":
            case "Q":
            case "K":
                return 10;
            default:
                return Integer.parseInt(rank);
        }
    }
}
