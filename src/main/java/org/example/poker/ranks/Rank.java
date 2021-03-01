package org.example.poker.ranks;


import org.example.poker.PokerHand;

public interface Rank extends Comparable<Rank> {

    int SCORE_NA = -1;

    boolean isApplicable(PokerHand pokerHand);

    Integer getScore(PokerHand pokerHand);

    Integer getOrder();
}
