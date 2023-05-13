package task;


import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "banana", "cherry", "date", "elderberry","sanket"};
        String word = words[(int) (Math.random() * words.length)];
        String asterisk = new String(new char[word.length()]).replace("\0", "*");
        int count = 0;

        while (count < 7 && asterisk.contains("*")) {
            System.out.println("Guess any letter in the word:");
            System.out.println(asterisk);
            String guess = scanner.next();
            if (guess.length() != 1) {
                System.out.println("Please enter only one letter.");
            } else {
                count++;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess.charAt(0)) {
                        asterisk = asterisk.substring(0, i) + guess.charAt(0) + asterisk.substring(i + 1);
                    }
                }
            }
        }

        scanner.close();

        if (count == 7) {
            System.out.println("Sorry, you lost. The word was " + word + ".");
        } else {
            System.out.println("Congratulations! You guessed the word " + word + " with " + count + " incorrect guesses.");
        }
    }
}
