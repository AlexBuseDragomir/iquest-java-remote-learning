package com.iquest.java.problem2.comparator;

import com.iquest.java.problem2.card.PlayCard;

import java.util.Comparator;

public class CardComparator implements Comparator<PlayCard> {

    @Override
    public int compare(PlayCard first, PlayCard second) {
        if (first.getCardNumber() > second.getCardNumber()) {
            return 1;
        } else if (first.getCardNumber() < second.getCardNumber()) {
            return -1;
        } else {
            return Integer.compare(first.getCardSuite().ordinal(), second.getCardSuite().ordinal());
        }
    }
}
