package com.pluralsight;

import java.util.Scanner;

public class CardApp {

    public static void main(String[] args) {
        // Makes a scanner object called input to read the user's input
        Scanner input = new Scanner(System.in);
        // Prompts the first player to enter their name and will be stored in String variable p1
        System.out.print("\nFirst player, please enter your name: ");
        String p1 = input.nextLine().trim();
        // Creates a player object called player1 for the first player using their name
        Player player1 = new Player(p1);
        // Similar
        System.out.print("Second player, please enter your name: ");
        String p2 = input.nextLine().trim();
        //
        Player player2 = new Player(p2);
        // Creates a deck of 52 cards
        Deck deck = new Deck();
        // Uses the shuffle method to shuffle the array list called deck
        deck.shuffle();
        // For each that runs twice to deal two cards to each player
        for (int i = 0; i < 2; i++) {
            /* STEP 1: Deal a card to player1
               deck.deal() - Remove and return the top card from the deck
               player1.getHand() - Get the Hand object belonging to player1
               player1.getHand().deal() - Add the card to player1's hand */
            player1.getHand().deal(deck.deal());
            /* STEP 2: Deal a card to player2
               This creates an alternating deal pattern (like in real card games)
               The methods work identically to the above line, but for player2 */
            player2.getHand().deal(deck.deal());
        }
        // Adds up the total value of player 1's hand
        int value1 = player1.getHand().getValue();
        System.out.println("\n" + p1 + "'s hand is worth " + value1);
        // Adds up the total value of player 2's hand
        int value2 = player2.getHand().getValue();
        System.out.println("\n" + p2 + "'s hand is worth " + value2);
        // Player1 wins if: their value is higher than player2's AND not over 21
        // OR if player2 busts (over 21) while player1 doesn't
        if ((value1 > value2 && value1 <= 21) || (value2 > 21 && value1 <= 21)) {
            System.out.println("\n" + p1 + " wins!");
        }
        // Player2 wins if: their value is higher than player1's AND not over 21
        // OR if player1 busts (over 21) while player2 doesn't
        else if ((value2 > value1 && value2 <= 21) || (value1 > 21 && value2 <= 21)) {
            System.out.println("\n" + p2 + " wins!");
        }
        // It's a tie if both players have the same value or both bust
        else {
            System.out.println("\nIt's a tie!");
        }

        //create the hand
//        Hand hand1 = new Hand();



        // deal 5 cards from the deck and add them to the hand
//        for (int i = 0; i < 5; i++) {
            // get a card from the deck
//            Card card = deck.deal();
            // deal that card to the hand
//            hand1.deal(card);
//        }

        //print out the value of all the cards in the hand
//        System.out.println("This hand is worth " + hand1.getValue());
    }

}
