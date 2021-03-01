package org.example.poker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ricar\\Documents\\poker\\poker\\src\\main\\resources\\poker.txt"));
        int handsDoesPlayer1 = 0;
        int handsDoesPlayer2 = 0;
        int neitherPlayerwin = 0;
        String line = br.readLine();
        WinnerFinder winnerFinder = new WinnerFinder();
        while (line != null) {
            String first = line.substring(0, 14);
            String second = line.substring(15);
            if (winnerFinder.findWinner(new PokerHand(first), new PokerHand(second)) == 0) {
                handsDoesPlayer1++;
            } else if (winnerFinder.findWinner(new PokerHand(first), new PokerHand(second)) == 1) {
                handsDoesPlayer2++;
            } else {
                neitherPlayerwin++;
            }
            line = br.readLine();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ricar\\Documents\\poker\\poker\\src\\main\\resources\\poker_output.txt"));
        writer.write("1: " + handsDoesPlayer1 + "\n");
        writer.write("2: " + handsDoesPlayer2 + "\n");
        writer.write("3: " + neitherPlayerwin + "\n");

        writer.close();
    }
}
