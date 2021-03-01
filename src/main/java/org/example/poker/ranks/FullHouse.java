package org.example.poker.ranks;

import org.example.poker.PokerHand;

public class FullHouse extends AbstractRank {
    private static final Rank threeOfAKind = new OfAKind.ThreeOfAKind();
    private static final Rank pair = new OfAKind.Pair();

    public FullHouse() {
        super(7);
    }

    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        return threeOfAKind.isApplicable(pokerHand) && pair.isApplicable(pokerHand);
    }

    @Override
    public Integer getScore(PokerHand pokerHand) {
        return threeOfAKind.getScore(pokerHand);
    }
}
