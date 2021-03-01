package org.example.poker.ranks;

import org.example.poker.PokerHand;

public class Flush extends AbstractRank {
    private static final Rank highCard = new HighCard();

    public Flush() {
        super(6);
    }

    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        PokerHand.Card.Suite suite = pokerHand.getCards().get(0).getSuite();
        return pokerHand.getCards()
                .stream()
                .filter(card -> card.getSuite().equals(suite))
                .count() == 5L;
    }

    @Override
    public Integer getScore(PokerHand pokerHand) {
        return highCard.getScore(pokerHand);
    }

}
