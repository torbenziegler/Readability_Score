package ziegler.torben;

import java.util.Scanner;

/**
 * Main class of the application. This is the entry point.
 */
public class Main {

    final static Scanner scanner = new Scanner(System.in);

    /**
     * Entry point of the application. Make sure the correct path to the text file is set.
     *
     * @param args no arguments needed
     */
    public static void main(String[] args) {
        Processing processing = new Processing();
        String text = processing.processText("input.txt"); // set text file

        if (text.equals("")) {
            System.out.println("No text was found in given file");
        } else {
            double characters = text.replaceAll("\\s", "").split("").length; // amount of characters
            double sentences = text.split("([!.?])").length; // amount of sentences
            double words = text.split("\\s").length; // amount of words (total)
            String[] wordsArray = text.split("\\s");

            processing.calculateSyllables(wordsArray);
            double syllables = processing.getSyllables();
            double polysyllables = processing.getPolysyllables();

            Result result = new Result();
            result.showResults(text, words, sentences, characters, syllables, polysyllables); // prints out test results
        }

    }

}

