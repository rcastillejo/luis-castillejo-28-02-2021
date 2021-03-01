package org.example.poker.ranks;

import org.example.poker.PokerHand;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FlushTest {

    @Test
    public void isApplicableTrue() {
        String value = "4S 2S 3S 4S 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new Flush().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableFalse() {
        String value = "4S 2S 3S 4S 5D";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new Flush().isApplicable(pokerHand)).isFalse();
    }
}