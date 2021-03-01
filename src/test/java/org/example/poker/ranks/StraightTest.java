package org.example.poker.ranks;

import org.assertj.core.api.Assertions;
import org.example.poker.PokerHand;
import org.junit.Test;

public class StraightTest {

    @Test
    public void isApplicableTrue() {
        String value = "8S 9S TS JS QS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new StraightFlush().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableFalse() {
        String value = "8S 9S TD JS QS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new StraightFlush().isApplicable(pokerHand)).isFalse();
    }
}