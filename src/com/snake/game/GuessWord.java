package com.snake.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessWord {
    private static final String[] WORDS = {
        "java", "python", "javascript", "html", "css", "bootstrap","c++","c","ruby","jquery","mysql","mojo","react","angular","php",".net"
    };
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = getRandomWord();
        int letter=word.length();
        char[] guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '*');
        ArrayList<Character> guessedLetters = new ArrayList<>();
        int tries = 0;

        System.out.println("Welcome to Sathish CodeWorld game!");
        System.out.println("==================================");
        System.out.println("Guess programming language or framework name ");

        while (tries < MAX_TRIES) {
            System.out.println("\nCurrent word: " + new String(guessedWord)+"    character : "+ letter);
            System.out.println("Tries left: " + (MAX_TRIES - tries));
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You have already guessed that letter. Try again.");
                continue;
            }

            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
                if (new String(guessedWord).equals(word)) {
                    System.out.println("Congratulations! You've guessed the word: " + word);
                    break;
                }
            } else {
                tries++;
                System.out.println("Incorrect guess. Try again.");
            }
        }

        if (tries == MAX_TRIES) {
            System.out.println("Sorry, you've been hanged. The word was: " + word);
        }

        scanner.close();
    }

    private static String getRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }
}
