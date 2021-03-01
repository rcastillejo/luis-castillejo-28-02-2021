package org.example.poker.ranks;

import org.example.poker.PokerHand;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class OfAKind extends AbstractRank {
    private final int n;

    OfAKind(int order, int n) {
        super(order);
        this.n = n;
    }

    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        Map<Integer, Integer> frequency = getFrequencyMap(pokerHand);
        return frequency.containsValue(n);
    }

    @Override
    public Integer getScore(PokerHand pokerHand) {
        return getFrequencyMap(pokerHand).entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getKey)))
                .filter(entry -> entry.getValue().equals(n))
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow(() -> new RuntimeException("Can't find an entry with value: " + n));
    }

    private Map<Integer, Integer> getFrequencyMap(PokerHand pokerHand) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (PokerHand.Card card : pokerHand.getCards()) {
            frequency.merge(card.getValue().getActualValue(), 1, Integer::sum);
        }
        return frequency;
    }

    public static class Pair extends OfAKind {

        public Pair() {
            super(2, 2);
        }
    }

    public static class TwoPairs extends OfAKind {

        public TwoPairs() {
            super(3, 2);
        }

        @Override
        public boolean isApplicable(PokerHand pokerHand) {
            List<PokerHand.Card> cards = pokerHand.getCards();
            Map<Integer, Integer> frequency = new HashMap<>();

            for (PokerHand.Card card : cards) {
                frequency.merge(card.getValue().getActualValue(), 1, Integer::sum);
            }
            int count = 0;
            for (Integer num : frequency.values()) {
                if (num >= 2) count++;
            }
            return count == 2;
        }
    }

    public static class ThreeOfAKind extends OfAKind {

        public ThreeOfAKind() {
            super(4, 3);
        }
    }

    public static class FourOfAKind extends OfAKind {

        public FourOfAKind() {
            super(8, 4);
        }
    }
}
