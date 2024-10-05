package com.iquest.java.problem2.card;

import com.iquest.java.problem2.suite.CardSuite;

public class PlayCard {

    private int cardNumber;
    private CardSuite cardSuite;

    public PlayCard(int cardNumber, CardSuite cardSuite) {
        this.cardNumber = cardNumber;
        this.cardSuite = cardSuite;
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public CardSuite getCardSuite() {
        return this.cardSuite;
    }

    @Override
    public String toString() {
        String result;
        switch(this.cardNumber) {
            case 1:
                result = "Ace - " + this.cardSuite;
                break;
            case 11:
                result = "Jack - " + this.cardSuite;
                break;
            case 12:
                result = "Queen - " + this.cardSuite;
                break;
            case 13:
                result = "King - " + this.cardSuite;
                break;
            default:
                result = this.cardNumber + " - " + this.cardSuite;
        }
        return result;
    }
}
