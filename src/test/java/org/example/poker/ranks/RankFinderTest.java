package org.example.poker.ranks;

import org.assertj.core.api.Assertions;
import org.example.poker.PokerHand;
import org.junit.Test;

public class RankFinderTest {

    @Test
    public void getRank() {

        String hand = "4S 2S 3S 4S 5S";
        PokerHand pokerHand = new PokerHand(hand);

        RankFinder rankFinder = new RankFinder();

        Rank result = rankFinder.getRank(pokerHand);

        Assertions.assertThat(result).isNotNull();
    }
}