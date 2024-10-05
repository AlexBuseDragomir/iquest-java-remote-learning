package com.iquest.java.problem2.deck;

import com.iquest.java.problem2.card.PlayCard;
import com.iquest.java.problem2.suite.CardSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private static final int NUMBER_OF_CARDS = 52;
    private static final int NUMBER_OF_CARD_TYPES = 13;
    private static final int NUMBER_OF_SUITES = 4;
    private List<PlayCard> deck;

    public CardDeck() {
        this.deck = new ArrayList<>();
        this.populateDeckWithCards();
    }

    public CardDeck(CardDeck anotherCardDeck) {
        this.deck = new ArrayList<>();
        this.populateDeckWithCards();
        Collections.copy(this.deck, anotherCardDeck.getDeck());
    }

    public List<PlayCard> getDeck() {
        return this.deck;
    }

    public void setDeck(List<PlayCard> deck) {
        this.deck = deck;
    }

    public int getNumberOfCards() {
        return NUMBER_OF_CARDS;
    }

    private void populateDeckWithCards() {
        for (int i = 1; i <= NUMBER_OF_CARD_TYPES; i ++) {
            for (int j = 1; j <= NUMBER_OF_SUITES; j ++) {
                deck.add(new PlayCard(i, (CardSuite.values())[j - 1]));
            }
        }
    }
}
