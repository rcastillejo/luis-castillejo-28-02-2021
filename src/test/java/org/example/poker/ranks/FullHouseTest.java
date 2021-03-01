package org.example.poker.ranks;

import org.assertj.core.api.Assertions;
import org.example.poker.PokerHand;
import org.junit.Test;


public class FullHouseTest {

    @Test
    public void isApplicableTrue() {
        String value = "4D 4S 3S 4S 3H";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new FullHouse().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableFalse() {
        String value = "4D 2S 3S 4S 3H";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new FullHouse().isApplicable(pokerHand)).isFalse();
    }
}