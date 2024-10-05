package com.iquest.java.problem2.main;

import com.iquest.java.problem2.deck.CardDeck;
import com.iquest.java.problem2.utility.DeckUtility;

public class MainLauncher {

    public static void main(String[] args) {

        CardDeck cardDeck = new CardDeck();
        DeckUtility deckUtility = new DeckUtility();

        System.out.println("NORMAL DECK:");
        deckUtility.printSimpleDeck(cardDeck);

        System.out.println();
        System.out.println();
        deckUtility.shuffleDeck(cardDeck);
        System.out.println("SHUFFLED DECK:");
        deckUtility.printSimpleDeck(cardDeck);

        CardDeck shuffledCardDeck = new CardDeck(cardDeck);


        System.out.println();
        System.out.println();
        System.out.println("REORDERED DECK:");
        deckUtility.sortDeck(cardDeck);
        deckUtility.printSimpleDeck(cardDeck);

        CardDeck reorderedCardDeck = new CardDeck(cardDeck);

        System.out.println();
        System.out.println();
        System.out.print("Do normal and shuffled have elements in the same order? -> ");
        System.out.println(deckUtility.doDecksHaveCardsInSameOrder(cardDeck, shuffledCardDeck));
        System.out.print("Do normal and reordered have elements in the same order? -> ");
        System.out.print(deckUtility.doDecksHaveCardsInSameOrder(cardDeck, reorderedCardDeck));
        System.out.println();
        System.out.println();
    }
}
