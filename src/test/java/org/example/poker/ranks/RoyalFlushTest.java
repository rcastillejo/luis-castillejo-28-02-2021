package org.example.poker.ranks;

import org.assertj.core.api.Assertions;
import org.example.poker.PokerHand;
import org.junit.Test;

public class RoyalFlushTest {

    @Test
    public void isApplicableTrue() {
        String value = "8S 9S TS JS QS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new RoyalFlush().isApplicable(pokerHand)).isFalse();
    }

    @Test
    public void isApplicableFalse() {
        String value = "TC JS QS KD AS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new RoyalFlush().isApplicable(pokerHand)).isFalse();
    }

    @Test
    public void isApplicableTrue2() {
        String value = "TC JC QC KC AC";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new RoyalFlush().isApplicable(pokerHand)).isTrue();
    }
}