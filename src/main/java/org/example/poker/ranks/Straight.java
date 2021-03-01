package org.example.poker.ranks;

import org.example.poker.PokerHand;

import java.util.List;

public class Straight extends AbstractRank {

    private static final Rank highCard = new HighCard();

    public Straight() {
        super(5);
    }

    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        List<PokerHand.Card> cards = pokerHand.getCards();
        Integer initialValue = cards.get(0).getValue().getActualValue();
        for (int i = 1; i < cards.size(); i++) {
            if (!cards.get(i).getValue().getActualValue().equals(--initialValue)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer getScore(PokerHand pokerHand) {
        return highCard.getScore(pokerHand);
    }
}
