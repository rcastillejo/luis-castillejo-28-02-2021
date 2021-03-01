package org.example.poker;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerFinderTest {

    // Win Tests
    @Test
    public void highestCardFirstWins() {
        String value1 = "5D 8C 9S JS AC", value2 = "2C 5C 7D 8S QH";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(0);
    }

    @Test
    public void OnePairVsOnePairSecondWins(){
        String value1 = "5H 5C 6S 7S KD", value2 = "2C 3S 8S 8D TD";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(1);
    }

    @Test
    public void AnotherOnePairVsOnePairFirstWins(){
        String value1 = "4D 6S 9H QH QC", value2 = "3D 6D 7H QD QS";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(0);
    }

    @Test
    public void TwoPairVsTwoPairFirstWins(){
        String value1 = "4D TS TH QH QC", value2 = "3D 9D 9C QD QS";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(0);
    }

    @Test
    public void AnotherTwoPairVsTwoPairFirstWins(){
        String value1 = "4D 9S 9H QH QC", value2 = "3D 9D 9C QD QS";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(0);
    }

    @Test
    public void ThreeVsFlushFirstWins(){
        String value1 = "2D 9C AS AH AC", value2 = "3D 6D 7D TD QD";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(1);
    }

    @Test
    public void FullHouseVsFullHouseFirstWins(){
        String value1 = "2H 2D 4C 4D 4S", value2 = "3C 3D 3S 9S 9D";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(0);
    }

    @Test
    public void StraightFlushVsStraightFlushFirstWins(){
        String value1 = "7H 3H 4H 5H 6H", value2 = "2D 3D 4D 5D 6D";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(0);
    }

    //Tie Tests

    @Test
    public void RoyalFlushVsRoyalFlushTie(){
        String value1 = "TH JH QH KH AH", value2 = "TD JD QD KD AD";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(-1);
    }

    @Test
    public void StraightFlushVsStraightFlushTie(){
        String value1 = "2H 3H 4H 5H 6H", value2 = "2D 3D 4D 5D 6D";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(-1);
    }

    //FourVsFourTie -> No Exists
    //FullHouseVsFullHouseTie -> No Exists

    @Test
    public void FlushVsFlushTie(){
        String value1 = "2H TH 4H 8H 6H", value2 = "2D TD 4D 8D 6D";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(-1);
    }

    @Test
    public void StraightVsStraightTie(){
        String value1 = "2C 3H 4C 5H 6C", value2 = "2D 3S 4D 5S 6D";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(-1);
    }

    //ThreeVsThreeTie -> No Exists

    @Test
    public void TwoPairVsTwoPairTie(){
        String value1 = "4H 9S 9D QH QC", value2 = "4D 9C 9H QD QS";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(-1);
    }

    @Test
    public void OnePairVsOnePairTie(){
        String value1 = "4D 6S 9H QH QC", value2 = "4S 6D 9C QD QS";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(-1);
    }


}