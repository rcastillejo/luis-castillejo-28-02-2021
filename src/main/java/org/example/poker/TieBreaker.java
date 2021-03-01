package org.example.poker;


import org.example.poker.ranks.Rank;

public class TieBreaker {

    public int getWinner(PokerHand firstHand, PokerHand secondHand, Rank tiedRank) {
        Integer firstScore = tiedRank.getScore(firstHand);
        Integer secondScore = tiedRank.getScore(secondHand);
        int compareTo = firstScore.compareTo(secondScore);
        if (compareTo == 0) {
            if (firstScore == Rank.SCORE_NA) {
                return firstScore;
            }
            return firstHand.compareTo(secondHand);
        }

        return compareTo < 0 ? 1 : 0;
    }
}
