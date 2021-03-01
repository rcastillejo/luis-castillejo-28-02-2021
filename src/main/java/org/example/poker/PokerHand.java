package org.example.poker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PokerHand implements Comparable<PokerHand> {

    public static class Card implements Comparable<Card> {
        private final Value value;
        private final Suite suite;

        public enum Value {
            TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11),
            QUEEN(12), KING(13), ACE(14);

            Integer actualValue;

            Value(Integer value) {
                this.actualValue = value;
            }

            public static Value create(String value) {
                Value value1 = null;
                switch (value) {
                    case "2":
                        value1 = TWO;
                        break;
                    case "3":
                        value1 = THREE;
                        break;
                    case "4":
                        value1 = FOUR;
                        break;
                    case "5":
                        value1 = FIVE;
                        break;
                    case "6":
                        value1 = SIX;
                        break;
                    case "7":
                        value1 = SEVEN;
                        break;
                    case "8":
                        value1 = EIGHT;
                        break;
                    case "9":
                        value1 = NINE;
                        break;
                    case "T":
                        value1 = TEN;
                        break;
                    case "J":
                        value1 = JACK;
                        break;
                    case "Q":
                        value1 = QUEEN;
                        break;
                    case "K":
                        value1 = KING;
                        break;
                    case "A":
                        value1 = ACE;
                        break;
                }
                return value1;
            }

            public Integer getActualValue() {
                return actualValue;
            }
        }

        public enum Suite {
            CLUBS, HEARTS, DIAMONDS, SPADE;

            public static Suite create(String suite) {
                Suite suite1 = null;
                switch (suite) {
                    case "C":
                        suite1 = CLUBS;
                        break;
                    case "H":
                        suite1 = HEARTS;
                        break;
                    case "D":
                        suite1 = DIAMONDS;
                        break;
                    case "S":
                        suite1 = SPADE;
                        break;
                }
                return suite1;
            }
        }

        public Card(Value value, Suite suite) {
            this.value = value;
            this.suite = suite;
        }

        @Override
        public int compareTo(Card o) {
            return value.compareTo(o.value);
        }

        public Value getValue() {
            return value;
        }

        public Suite getSuite() {
            return suite;
        }

        public static Card createFrom(String cardValue) {
            Pattern regex = Pattern.compile("^([0-9][0-9]?|[A-Z])([A-Z])$");
            Matcher matcher = regex.matcher(cardValue);
            if (matcher.find()) {
                return new Card(Card.Value.create(matcher.group(1)), Card.Suite.create(matcher.group(2)));
            }
            throw new RuntimeException("Can't create Card from : " + cardValue);
        }

        @Override
        public String toString() {
            return "Card{" +
                    "value=" + value +
                    ", suite=" + suite +
                    '}';
        }
    }

    private List<Card> cards;

    public PokerHand(String pokerHand) {
        cards = Arrays.stream(pokerHand.split(" "))
                .map(Card::createFrom)
                .collect(Collectors.toList());
        if (cards.size() != 5) {
            throw new RuntimeException("Expected size is 5");
        }
        cards.sort(Collections.reverseOrder());
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public int compareTo(PokerHand pokerHand) {
        for (int i = 0; i < this.cards.size(); i++) {
            PokerHand.Card one = this.cards.get(i);
            PokerHand.Card two = pokerHand.getCards().get(i);
            int compareTo = one.compareTo(two);
            if ( compareTo != 0) {
                return compareTo < 0 ? 1 : 0;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "cards=" + cards +
                '}';
    }
}
