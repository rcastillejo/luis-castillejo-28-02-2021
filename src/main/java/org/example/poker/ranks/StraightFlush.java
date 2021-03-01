package org.example.poker.ranks;

import org.example.poker.PokerHand;

public class StraightFlush extends AbstractRank {

    public StraightFlush() {
        super(9);
    }

    private static final Rank flush = new Flush();
    private static final Rank straight = new Straight();

    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        return flush.isApplicable(pokerHand) && straight.isApplicable(pokerHand);
    }

    @Override
    public Integer getScore(PokerHand pokerHand) {
        return straight.getScore(pokerHand);
    }
}
