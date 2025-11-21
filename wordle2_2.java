package class_package;

import java.util.*;
import java.lang.Math;

public class wordle2_2 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        Helper helper = new Helper();
        wordlist wordList = new wordlist();
        boolean allGreen = false;

        String[] guessletter;
        String[] secretletter;
        String[] values;
        String userinput;
        byte tries;
        boolean debug = false;
        boolean[] checked;
        boolean hasWon = false;
        boolean twoplayer = false;
        
        

        System.out.println("GAME INFO:");
        System.out.println("After inputting a word, you'll receive colors for each letter");
        System.out.println("After receiving this feedback, it's your job to crack the code with the information provided");
        System.out.println("---------------------------------------------------");
        System.out.println("Here's what each color means:");
        System.out.println("Gray - Letter is not in the word ");
        System.out.println("Yellow - Letter is in the word but not on the correct position");
        System.out.println("Green - Letter is in the word and in the correct position (correct)");
        System.out.println("---------------------------------------------------");
        System.out.println("You have a total of 6 tries, goodluck!");

        System.out.println("Would you like to enable two player mode? (true/false)");
        twoplayer = input.nextBoolean();
        input.nextLine(); // consume leftover newline because of nextBoolean

        System.out.println("Would you like to enable [DEBUG] mode? (true/false)");
        debug = input.nextBoolean();
        input.nextLine(); // consume leftover newline because of nextBoolean

        helper.inputcheck(twoplayer, input);

        String secretword = helper.secretword;
        int wordLength = secretword.length();

        // Arrays aanmaken op basis van de lengte van het geheime woord
        guessletter = new String[wordLength];
        secretletter = new String[wordLength];
        values = new String[wordLength];
        checked = new boolean[wordLength];

        // Startwaarden: alles "gray"
        for (int i = 0; i < values.length; i++) {
            values[i] = "gray";
        }

        int maxTries = wordLength + 1;
        
        for (tries = 0; tries < maxTries; tries++) {
            if (!twoplayer) {
                System.out.println("Enter a " + wordLength + " letter word!");
            } else {
                System.out.println("Player 2, enter a " + wordLength + " letter word!");
            }

            userinput = input.nextLine().trim().toLowerCase();

            if (debug) System.out.println("[DEBUG] input after conversion = " + userinput);

            if (userinput.length() != wordLength) {
                System.out.println("[ERROR]: Enter a word of exactly " + wordLength + " letters.");
                tries--;
                if (debug) System.out.println("[DEBUG] try failed. tries = " + tries);
                continue;
            }

            // Vul arrays met letters
            helper.arrayfill(guessletter, secretletter, userinput, secretword, debug);

            // Kleuren bepalen
            helper.colorcheck(secretletter, checked, debug, guessletter, values);

            // Resultaat tonen voor alle letters
            helper.renderRow(guessletter, values);

            System.out.println();

            // Check of alles groen is
            allGreen = true; // eerst aannemen dat alles groen is
            for (String v : values) {
                if (!v.equals("green")) {
                    allGreen = false;
                    break;
                }
            }

            if (allGreen) {
                hasWon = true;
                tries = (byte) maxTries; // forceren dat de loop stopt
            } else {
                helper.clearlist(values, checked, debug);
            }
        }

        if (hasWon == true) {
            System.out.println("YOU WON!");
            System.out.println("Congratulations, you won exactly nothing except some dopamine which your own brain created.");
            System.out.println("I hope you feel happy");
        } else {
            System.out.println("Like expected, you lost. The word was: " + helper.secretword + ". Try harder next time!");
        }

        input.close();
    }
}
