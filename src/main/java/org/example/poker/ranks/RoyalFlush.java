package org.example.poker.ranks;

import org.example.poker.PokerHand;

public class RoyalFlush extends AbstractRank {
    private static final Rank flush = new Flush();

    public RoyalFlush() {
        super(10);
    }

    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        return flush.isApplicable(pokerHand) && checkIfAllMoreThanTen(pokerHand);
    }

    private static boolean checkIfAllMoreThanTen(PokerHand pokerHand) {
        return pokerHand.getCards().
                stream()
                .map(card -> card.getValue().getActualValue())
                .reduce(0, Integer::sum) == 60;
    }

}
