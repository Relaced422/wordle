package class_package;

import java.util.*;

public class wordle2_2reparatie {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
    	
        String[] dictionary = {"aback", "bicep", "cloud", "dusty", "epoch"};
        String[] guessLetter = new String[5];
        String[] secretLetter = new String[5];
        int rng = random.nextInt(5);
        String secretWord = dictionary[rng];
        boolean won = false;
        
        System.out.println("GAME INFO:");
        System.out.println("After inputting a word of 5 letters, you'll receive colors for each letter");
        System.out.println("After receiving this feedback, it's your job to crack the code with the information provided");
        System.out.println("---------------------------------------------------");
        System.out.println("Here's what each color means:");
        System.out.println("Gray - Letter is not in the word ");
        System.out.println("Yellow - Letter is in the word but not on the correct position");
        System.out.println("Green - Letter is in the word and in the correct position (correct)");
        System.out.println("---------------------------------------------------");
        System.out.println("You have a total of 6 tries, goodluck!");
        
        for (int tries = 0; tries < 6; tries++) {
        	String[] values = {"gray", "gray", "gray", "gray", "gray"};
        	boolean[] checked = new boolean[secretWord.length()];
            System.out.println("Enter a 5 letter word!");
            String userInput = input.nextLine();

            // Zorgen dat we 5 letters hebben
            if (userInput == null || userInput.length() > secretWord.length() || userInput.length() < secretWord.length()) {
                System.out.println("[ERROR]: Enter a word of exactly 5 letters.");
                tries--; // dezelfde poging nogmaals
                continue;
            }

            // Vul arrays met letters
            for (int k = 0; k < secretWord.length(); k++) {
                guessLetter[k] = String.valueOf(userInput.charAt(k));
                secretLetter[k] = String.valueOf(secretWord.charAt(k));
            }

            // Groen/geel/grijs bepalen
            for (int i = 0; i < secretWord.length(); i++) {
                if (guessLetter[i].equals(secretLetter[i])) {
                    values[i] = "green";
                    checked[i] = true;
                } else {
                    for (int e = 0; e < secretWord.length(); e++) {
                        if (guessLetter[i].equals(secretLetter[e]) && checked[e] == false) {
                            values[i] = "yellow";
                            checked[i] = true;
                            break; //  zodra geel is, stoppen
                        }
                    }
                }
            }

//            System.out.println("[" + guessLetter[0] + "]: " + values[0] + " "
//                    + "[" + guessLetter[1] + "]: " + values[1] + " "
//                    + "[" + guessLetter[2] + "]: " + values[2] + " "
//                    + "[" + guessLetter[3] + "]: " + values[3] + " "
//                    + "[" + guessLetter[4] + "]: " + values[4] + " ");
            for (int o = 0; o < secretWord.length(); o++) {
            	System.out.print("[" + guessLetter[o] + "]:"  + values[o] + " ");
            }
            System.out.println();

            if (values[0].equals("green") && values[1].equals("green") && values[2].equals("green")
                    && values[3].equals("green") && values[4].equals("green")) {
                won = true;
                break;
            }
        }

        if (won == true) {
            System.out.println("YOU WON! Congratulations, you won exactly nothing except some dopamine which your own brain created. I hope you feel happy.");
        } else {
            System.out.println("Like expected, you lost. The word was: " + secretWord + ". Try harder next time!");
        }
        input.close();
    }
}