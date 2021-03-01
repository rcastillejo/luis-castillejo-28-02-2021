package org.example.poker;

import org.example.poker.ranks.Rank;
import org.example.poker.ranks.RankFinder;

public class WinnerFinder {
    private static final RankFinder rankFinder = new RankFinder();
    private static final TieBreaker tieBreaker = new TieBreaker();

    public int findWinner(PokerHand first, PokerHand second) {
        Rank rankFirst = rankFinder.getRank(first);
        Rank rankSecond = rankFinder.getRank(second);
        int compareTo = rankFirst.compareTo(rankSecond);

        if (compareTo == 0) {
            return tieBreaker.getWinner(first, second, rankFirst);
        }

        return compareTo < 0 ? 1 : 0;
    }
}
