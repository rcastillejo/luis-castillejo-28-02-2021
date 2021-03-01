package org.example.poker;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PokerHandTest {

    @Test
    public void testCardCreationForTen(){
        String value = "TS";
        PokerHand.Card card = PokerHand.Card.createFrom(value);
        PokerHand.Card actual = new PokerHand.Card(PokerHand.Card.Value.create("T"), PokerHand.Card.Suite.create("S"));

        Assertions.assertThat(card).isEqualByComparingTo(actual);
    }

    @Test
    public void testCardCreationForAce(){
        String value = "AD";
        PokerHand.Card card = PokerHand.Card.createFrom(value);
        PokerHand.Card actual = new PokerHand.Card(PokerHand.Card.Value.create("A"), PokerHand.Card.Suite.create("D"));

        Assertions.assertThat(card).isEqualByComparingTo(actual);
    }

    @Test
    public void testCardCreationForNumber(){
        String value = "5D";
        PokerHand.Card card = PokerHand.Card.createFrom(value);
        PokerHand.Card actual = new PokerHand.Card(PokerHand.Card.Value.create("5"), PokerHand.Card.Suite.create("D"));

        Assertions.assertThat(card).isEqualByComparingTo(actual);
    }

    @Test
    public void compareCards(){
        String value = "AS";
        PokerHand.Card card = PokerHand.Card.createFrom(value);
        PokerHand.Card other = new PokerHand.Card(PokerHand.Card.Value.create("J"), PokerHand.Card.Suite.create("D"));
        PokerHand.Card other2 = new PokerHand.Card(PokerHand.Card.Value.create("5"), PokerHand.Card.Suite.create("C"));

        Assertions.assertThat(card).isGreaterThan(other);
        Assertions.assertThat(other2).isLessThan(other);
    }

    @Test
    public void checkOrder() {
        String hand = "AS 2S KS 4S TS";
        PokerHand pokerHand = new PokerHand(hand);

        Assertions.assertThat(pokerHand.getCards().size()).isEqualByComparingTo(5);

        Assertions.assertThat(pokerHand.getCards().get(0).getValue()).isEqualByComparingTo(PokerHand.Card.Value.ACE);
        Assertions.assertThat(pokerHand.getCards().get(0).getSuite()).isEqualByComparingTo(PokerHand.Card.Suite.SPADE);
        Assertions.assertThat(pokerHand.getCards().get(1).getValue()).isEqualByComparingTo(PokerHand.Card.Value.KING);
        Assertions.assertThat(pokerHand.getCards().get(1).getSuite()).isEqualByComparingTo(PokerHand.Card.Suite.SPADE);
        Assertions.assertThat(pokerHand.getCards().get(2).getValue()).isEqualByComparingTo(PokerHand.Card.Value.TEN);
        Assertions.assertThat(pokerHand.getCards().get(2).getSuite()).isEqualByComparingTo(PokerHand.Card.Suite.SPADE);
        Assertions.assertThat(pokerHand.getCards().get(3).getValue()).isEqualByComparingTo(PokerHand.Card.Value.FOUR);
        Assertions.assertThat(pokerHand.getCards().get(3).getSuite()).isEqualByComparingTo(PokerHand.Card.Suite.SPADE);
        Assertions.assertThat(pokerHand.getCards().get(4).getValue()).isEqualByComparingTo(PokerHand.Card.Value.TWO);
        Assertions.assertThat(pokerHand.getCards().get(4).getSuite()).isEqualByComparingTo(PokerHand.Card.Suite.SPADE);
    }


}