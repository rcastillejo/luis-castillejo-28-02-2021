package org.example.poker.ranks;

import org.example.poker.PokerHand;

public class HighCard extends AbstractRank {
    public HighCard() {
        super(1);
    }

    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        return true;
    }

    @Override
    public Integer getScore(PokerHand pokerHand) {
        return pokerHand.getCards().get(0).getValue().getActualValue();
    }
}
