package ziegler.torben;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();  // reads text from file into StringBuilder
        File file = new File(args[0]); // takes file as command line argument

        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNext()) {
                builder.append(fileReader.nextLine());  // reads lines of file and appends to builder
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file.getPath());
        }

        String text = builder.toString(); // converts from StringBuilder to String
        double characters = text.replaceAll("\\s", "").split("").length; // amount of characters
        double sentences = text.split("([!.?])").length; // amount of sentences
        double words = text.split("\\s").length; // amount of words (total)
        String[] wordsArray = text.split("\\s");
        double syllables = 0;
        double polysyllables = 0;

        Calculation calc = new Calculation();

        for (String word : wordsArray) {
            syllables += calc.syllableFinder(word);
            if (calc.syllableFinder(word) > 2) {
                polysyllables++;
            }
        }

        Result result = new Result();
        result.showResults(text, words, sentences, characters, syllables, polysyllables); // prints out test results

    }

}

