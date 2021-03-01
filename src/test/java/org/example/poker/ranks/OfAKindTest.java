package org.example.poker.ranks;

import org.assertj.core.api.Assertions;
import org.example.poker.PokerHand;
import org.junit.Test;

public class OfAKindTest {

    @Test
    public void isApplicableTwoTrue() {
        String value = "QS 2S 3S QS 2S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new OfAKind.Pair().isApplicable(pokerHand)).isTrue();
        Assertions.assertThat(new OfAKind.Pair().getScore(pokerHand)).isEqualTo(PokerHand.Card.Value.QUEEN.getActualValue());
    }

    @Test
    public void isApplicableTwoFalse() {
        String value = "AS 2S 3S 4S 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new OfAKind.Pair().isApplicable(pokerHand)).isFalse();
    }

    @Test
    public void isApplicableThreeTrue() {
        String value = "AS 2S AS AS 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new OfAKind.ThreeOfAKind().isApplicable(pokerHand)).isTrue();
        Assertions.assertThat(new OfAKind.ThreeOfAKind().getScore(pokerHand))
                .isEqualTo(PokerHand.Card.Value.ACE.getActualValue());
    }

    @Test
    public void isApplicableThreeFalse() {
        String value = "AS 2S AS QS 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new OfAKind.ThreeOfAKind().isApplicable(pokerHand)).isFalse();
    }

    @Test
    public void isApplicableFourTrue() {
        String value = "AS JS JS JS JS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new OfAKind.FourOfAKind().isApplicable(pokerHand)).isTrue();
        Assertions.assertThat(new OfAKind.FourOfAKind().getScore(pokerHand))
                .isEqualTo(PokerHand.Card.Value.JACK.getActualValue());
    }

    @Test
    public void isApplicableFourFalse() {
        String value = "AS 2S AS AS 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new OfAKind.FourOfAKind().isApplicable(pokerHand)).isFalse();
    }
}