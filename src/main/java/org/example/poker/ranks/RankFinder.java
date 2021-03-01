package org.example.poker.ranks;

import org.example.poker.PokerHand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankFinder {
    private static final List<Rank> RANKS = new ArrayList<>();

    static {
        RANKS.add(new HighCard());
        RANKS.add(new OfAKind.Pair());
        RANKS.add(new OfAKind.TwoPairs());
        RANKS.add(new OfAKind.ThreeOfAKind());
        RANKS.add(new Straight());
        RANKS.add(new Flush());
        RANKS.add(new FullHouse());
        RANKS.add(new OfAKind.FourOfAKind());
        RANKS.add(new StraightFlush());
        RANKS.add(new RoyalFlush());

        RANKS.sort(Collections.reverseOrder());
    }

    public Rank getRank(PokerHand pokerHand) {
        return RANKS.stream()
                .filter(rank -> rank.isApplicable(pokerHand))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching Rank"));
    }
}
