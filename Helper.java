package class_package;

import java.util.Scanner;
import java.util.Random;

public class Helper {
	Random random = new Random();
	wordlist wordList = new wordlist(); // ADD THIS at the top of Helper
	public String secretword;
	String userinput;

	public void renderRow(String[] guessletter, String[] values) {
		// Bovenrand
		System.out.print("+");
		for (int i = 0; i < guessletter.length; i++) {
			System.out.print("---+");
		}
		System.out.println();

		// Letterrij
		System.out.print("|");
		for (int i = 0; i < guessletter.length; i++) {
			String letter = (guessletter[i] == null) ? " " : guessletter[i].toUpperCase();
			System.out.print(" " + letter + " |");
		}
		System.out.println();

		// Kleurrij (G = green, Y = yellow, . = gray)
		System.out.print("|");
		for (int i = 0; i < values.length; i++) {
			String v = values[i];
			char c;
			if ("green".equals(v))
				c = 'G';
			else if ("yellow".equals(v))
				c = 'Y';
			else
				c = '.';
			System.out.print(" " + c + " |");
		}
		System.out.println();

		// Onderkant
		System.out.print("+");
		for (int i = 0; i < guessletter.length; i++) {
			System.out.print("---+");
		}
		System.out.println();
	}

	public void clearlist(String[] values, boolean[] checked, boolean debug) {
		for (byte i = 0; i < values.length; i++) {
			values[i] = "gray";
			checked[i] = false;
			if (debug) {
				System.out.println("[DEBUG] Cleared position " + i + " → " + values[i] + " | " + checked[i]);
			}
		}
	}

	public void inputcheck(boolean twoplayer, Scanner input) {
	    if (!twoplayer) {

	        // NEW: Ask word length
	        System.out.println("Choose word length (4 - 9): ");
	        int length = input.nextInt();
	        input.nextLine(); // clear newline

	        // Get random word from WordList
	        secretword = wordList.getRandomWord(length);

	    } else {
	        while (true) {
	            System.out.println("Player 1, enter the secret word (no spaces):");
	            String candidate = input.nextLine().trim().toLowerCase();
	            if (candidate.length() > 0 && !candidate.contains(" ")) {
	                secretword = candidate;
	                break;
	            }
	            System.out.println("[ERROR]: Enter a word with at least 1 letter and no spaces.");
	        }
	    }
	}


	public void arrayfill(String[] guessletter, String[] secretletter, String userinput, String secretword,
			boolean debug) {

		if (userinput == null || secretword == null || userinput.length() != secretword.length()) {
			System.out.println("[arrayfill] userinput and secretword must have the same length.");
			return; // voorkom out-of-bounds fouten
		}

		for (byte k = 0; k < userinput.length(); k++) {
			guessletter[k] = String.valueOf(userinput.charAt(k));
			secretletter[k] = String.valueOf(secretword.charAt(k));
			if (debug) {
				System.out.println("[DEBUG] Array fill | " + guessletter[k] + " | " + secretletter[k]);
			}
		}
	}

	public void colorcheck(String[] secretletter, boolean[] checked, boolean debug, String[] guessletter,
			String[] values) {
		// Groen/geel/grijs bepalen
		for (byte i = 0; i < guessletter.length; i++) {
			if (guessletter[i].equals(secretletter[i])) {
				values[i] = "green";
				checked[i] = true;
				if (debug) {
					System.out.println("[DEBUG] Green Comparison number " + i + " = " + guessletter[i] + " with "
							+ secretletter[i] + " is correct and checked is now set to " + checked[i]);
				}
			} else {
				for (byte e = 0; e < secretletter.length; e++) {
					if (guessletter[i].equals(secretletter[e]) && checked[e] == false) {
						values[i] = "yellow";
						checked[i] = true;
						if (debug) {
							System.out.println("[DEBUG] Yellow comparison number " + i + " = " + guessletter[i]
									+ " with " + secretletter[e] + " is correct");
						}
						break; // zodra geel is, stoppen
					}
				}
			}
		}
	}
}
