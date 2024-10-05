package com.iquest.java.problem2.utility;

import com.iquest.java.problem2.deck.CardDeck;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DeckUtilityTest {

    private final static int NUMBER_OF_SHUFFLES = 1000;
    private CardDeck normalCardDeck;
    private CardDeck shuffledCardDeck;
    private DeckUtility deckUtility;

    @Before
    public void setUp() {
        this.normalCardDeck = new CardDeck();
        this.shuffledCardDeck = new CardDeck();
        this.deckUtility = new DeckUtility();
    }

    @Test
    public void testCardShuffling() {
        for (int i = 0; i < NUMBER_OF_SHUFFLES; i ++) {
            deckUtility.shuffleDeck(shuffledCardDeck);
            boolean sameOrderFlag = deckUtility.doDecksHaveCardsInSameOrder(normalCardDeck, shuffledCardDeck);
            assertThat(sameOrderFlag, is(false));
        }
    }
}