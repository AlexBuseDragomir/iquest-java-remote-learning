package com.iquest.java.problem2.utility;

import com.iquest.java.problem2.card.PlayCard;
import com.iquest.java.problem2.comparator.CardComparator;
import com.iquest.java.problem2.deck.CardDeck;

import java.util.*;

public class DeckUtility {

    public void printSimpleDeck(CardDeck cardDeck) {
        for (int i = 1; i <= 13; i ++) {
            for (int j = 1; j <= 4; j ++) {
                System.out.print(cardDeck.getDeck().get(4 * (i - 1) + j - 1));
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public boolean doDecksHaveCardsInSameOrder(CardDeck first, CardDeck second) {
        List<PlayCard> firstDeck = first.getDeck();
        List<PlayCard> secondDeck = second.getDeck();
        if (firstDeck.size() != secondDeck.size()) {
            return false;
        }
        int size = firstDeck.size();
        for (int i = 0; i < size; i ++) {
            if (firstDeck.get(i).getCardNumber() != secondDeck.get(i).getCardNumber()) {
                return false;
            }
        }
        return true;
    }

    // sorts the deck first by card number and then by suite
    public void sortDeck(CardDeck cardDeck) {
        List<PlayCard> deck = cardDeck.getDeck();
        deck.sort(new CardComparator());
    }

    public void shuffleDeck(CardDeck cardDeck) {
        List<PlayCard> shuffledDeck = new ArrayList<>();
        List<PlayCard> normalDeck = cardDeck.getDeck();
        boolean[] takenPositions = new boolean[cardDeck.getNumberOfCards()];
        Arrays.fill(takenPositions, false);
        while(isPositionAvailableInDeck(takenPositions)) {
            int randomPosition = getRandomAvailablePosition(takenPositions);
            PlayCard cardInRandomPosition = normalDeck.get(randomPosition);
            takenPositions[randomPosition] = true;
            shuffledDeck.add(cardInRandomPosition);
        }
        cardDeck.setDeck(shuffledDeck);
    }

    private boolean isPositionAvailableInDeck(boolean[] takenPositions) {
        for (boolean position: takenPositions) {
            if (! position) {
                return true;
            }
        }
        return false;
    }

    private int getRandomAvailablePosition(boolean[] takenPositions) {
        List<Integer> availablePositions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < takenPositions.length; i ++) {
            if (! takenPositions[i]) {
                availablePositions.add(i);
            }
        }
        int randomIndex = random.nextInt(availablePositions.size());
        return availablePositions.get(randomIndex);
    }
}
