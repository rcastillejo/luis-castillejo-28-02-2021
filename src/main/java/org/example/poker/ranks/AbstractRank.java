package org.example.poker.ranks;

import org.example.poker.PokerHand;

public abstract class AbstractRank implements Rank {

    private final int order;

    public AbstractRank(int order) {
        this.order = order;
    }

    @Override
    public Integer getScore(PokerHand pokerHand) {
        return SCORE_NA;
    }

    @Override
    public Integer getOrder() {
        return order;
    }

    @Override
    public int compareTo(Rank o) {
        return Integer.compare(order, o.getOrder());
    }
}
