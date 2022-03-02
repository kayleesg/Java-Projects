
import java.util.Scanner;

public class SentenceStringAnalyzer {

	public static void main(String[] args) {
		/* Name: Kaylee
		   Class: 
		   Due: 23 FEB
		   Description: Assignment 5
		   This program takes a sentence entered by the user and processes it, extracting each word and digesting the contents of each word.
		   Things the program will print about each word: the word, it's first/last character, and the length.
		   Things the program will print about the entire sentence: the number of words, the total number of characters, the number of vowels,
		   the number of consonants, and the smallest/largest word.
		*/
		
		//open scanner
		Scanner input = new Scanner(System.in);
		
		//get user's input
		System.out.print("Enter a sequence of words ending with \"stop\": ");
		String text = input.nextLine();
		
		//close the scanner
		input.close();
		
		//clean up the ends because it can cause problems if there's an extra space at the end
		text = text.trim();
		
		
		// STEP 1 test if stop is at the end of the sentence
		if (text.substring(text.length() -4).equalsIgnoreCase("stop")) {
			
			int max_position = text.length() - 4;
			
			// STEP 2 initialize all my variables
			int position = 0;
			int iterations = 0;
			int characterCount = 0;
			int vowelCount = 0;
			int consonantCount = 0;
			
			// STEP 3 testing if stop was the only thing entered
			if (max_position != position) {
				
				// STEP 2.5 discovered errors where no white space is present, so I test for it
				if (text.indexOf(" ") > 0) {
				
					String smallestWord = text.substring(position, text.indexOf(" "));
					String largestWord = text.substring(position, text.indexOf(" "));
				
				
					
					// STEP 4a extracting and processing each word from the sentence
					while (position < max_position) {
						String word = text.substring(position, text.indexOf(" ", position));
						System.out.println("Processing word   " + word);
						int len = word.length();
						System.out.println("First character is   " + word.charAt(0));
						System.out.println("Last character is   " + word.charAt(len-1));
						System.out.println("Length is   " + len + "\n");
						position = 1 + position + len;
						iterations++;
						characterCount += len;
						
						// STEP 4b checking if each letter is a vowel, defaulting to a consonant
						for (int i = 0; i<len; i++) {
							switch (word.charAt(i)) {
							case 'a':
							case 'A':
							case 'e':
							case 'E':
							case 'i':
							case 'I':
							case 'o':
							case 'O':
							case 'u':
							case 'U':
								vowelCount++;
								break;
							case '.':
							case '!':
							case '?':
							case ',':
							case ':':
							case ';':
							case '"':
							case '-':
							case '=':
							case '_':
							case '$':
								break;
							default:
								consonantCount++;
								break;
							} // end switch
						} // end vowel tests
						
						// STEP 4c testing word length to see if it's the smallest or largest
						if (len < smallestWord.length()) {
							smallestWord = word;
						}
						if (len > largestWord.length()) {
							largestWord = word;
						}
					} // end extracting and processing
					
					// print out the results of the processing
					System.out.println("Number of words  = " + iterations);
					System.out.println("Number of characters  = " + characterCount);
					System.out.println("Number of vowels  = " + vowelCount);
					System.out.println("Number of consonants  = " + consonantCount);
					System.out.println("Smallest word  = " + smallestWord);
					System.out.println("Largest word  = " + largestWord);
				} /*end STEP3*/ else {
					System.out.println("Can not process, please add a space between the last word and \"stop\".");
				}
				
			} /*end SEP2.5*/ else {
				System.out.println("No words were entered except \"stop\"");
				}
			
			} /*end STEP1*/ else {
				System.out.println("You didn't put stop at the end of your sentence. Rerun and try again.");
			}
				
	} // main
} // Assignment 5
