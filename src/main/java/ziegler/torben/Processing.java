package ziegler.torben;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Processing the text input file
 */
public class Processing {

    private double syllables = 0;
    private double polysyllables = 0;

    /**
     * Reads text from file to make it processable
     *
     * @param path path to file
     * @return text of file
     */
    protected String processText(String path) {
        StringBuilder builder = new StringBuilder();  // reads text from file into StringBuilder
        File file = new File(path); // takes file as argument

        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNext()) {
                builder.append(fileReader.nextLine());  // reads lines of file and appends to builder
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file.getPath());
        }

        return builder.toString();
    }

    /**
     * Sets the amount of found syllables and calculates polysyllables
     *
     * @param wordsArray array containing words used for input
     */
    protected void calculateSyllables(String[] wordsArray) {
        for (String word : wordsArray) {
            syllables += syllableFinder(word);
            if (syllableFinder(word) > 2) {
                polysyllables++;
            }
        }
    }

    /**
     * Calculates the amount of syllables in a word
     *
     * @param word given word
     * @return amount of syllables in word
     */
    private int syllableFinder(String word) {
        String i = "(?i)[aiouy][aeiouy]*|e[aeiouy]*(?!d?\\b)";
        Matcher matcher = Pattern.compile(i).matcher(word);
        int counter = 0;

        while (matcher.find()) {
            counter++;
        }
        // return at least 1
        return Math.max(counter, 1);
    }

    /**
     * Returns the amount of syllables
     *
     * @return amount of syllables
     */
    public double getSyllables() {
        return syllables;
    }

    /**
     * Returns the amount of polysyllables
     *
     * @return amount of polysyllables
     */
    public double getPolysyllables() {
        return polysyllables;
    }
}
