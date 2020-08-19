package ziegler.torben;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        // Syllables counting
        for (String word : wordsArray) {
            syllables += syllableCounter(word);
            if (syllableCounter(word) > 2) {
                polysyllables++;
            }
        }

        showResults(text, words, sentences, characters, syllables, polysyllables); // prints out test results

    }


    private static int syllableCounter(String word) {
        String i = "(?i)[aiouy][aeiouy]*|e[aeiouy]*(?!d?\\b)";
        Matcher matcher = Pattern.compile(i).matcher(word);
        int counter = 0;

        while (matcher.find()) {
            counter++;
        }

        // return at least 1
        return Math.max(counter, 1);


    }

    public static double ARITestResult(double characters, double words, double sentences) {
        return 4.71 * (characters / words) + 0.5 * (words / sentences) - 21.43;
    }

    public static double fleschKincaidTestResult(double words, double sentences, double syllables) {
        return (0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59);
    }

    public static double smogIndexResult(double polysyllables, double sentences) {
        return 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.1291;
    }

    public static double colemanLiauIndexResult(double sentences, double words, double characters) {
        double l = (characters / words) * 100;
        double s = (sentences / words) * 100;

        return 0.0588 * l - 0.296 * s - 15.8;
    }


    public static void showResults(String text, double words, double sentences, double characters, double syllables, double polysyllables) {

        // ARI Results
        double ARITestResult = ARITestResult(characters, words, sentences);
        int ARIScoreAge = (int) Math.ceil(ARITestResult);
        // FK Results
        double FKTestResult = fleschKincaidTestResult(words, sentences, syllables);
        int FKScoreAge = (int) Math.ceil(FKTestResult);
        // SMOG Results
        double SMOGTestResult = smogIndexResult(polysyllables, sentences);
        int SMOGScoreAge = (int) Math.ceil(SMOGTestResult);
        // CL Results
        double CLTestResult = colemanLiauIndexResult(sentences, words, characters);
        int CLScoreAge = (int) Math.ceil(CLTestResult);


        System.out.println("The text is:");
        System.out.println(text);
        System.out.println();
        System.out.println("Words: " + (int) words);
        System.out.println("Sentences: " + (int) sentences);
        System.out.println("Characters: " + (int) characters);
        System.out.println("Syllables: " + (int) syllables);
        System.out.println("Polysyllables: " + (int) polysyllables);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String choice = scanner.nextLine();
        System.out.println();

        switch (choice) {
            case "ARI":
                System.out.println("Automated Readability Index: " + String.format( "%.2f", ARITestResult) + " (about " + ARIScoreAge + " year olds).");
                break;
            case "FK":
                System.out.println("Flesch–Kincaid readability tests: " + String.format( "%.2f", FKTestResult) + " (about " + FKScoreAge + " year olds).");
                break;
            case "SMOG":
                System.out.println("Simple Measure of Gobbledygook: " + String.format( "%.2f", SMOGTestResult) + " (about " + SMOGScoreAge + " year olds).");
                break;
            case "CL":
                System.out.println("Coleman–Liau index: " + String.format( "%.2f", CLTestResult) + " (about " + CLScoreAge + " year olds).");
                break;
            case "all":
                System.out.println("Automated Readability Index: " + String.format( "%.2f", ARITestResult) + " (about " + ARIScoreAge + " year olds).");
                System.out.println("Flesch–Kincaid readability tests: " + String.format( "%.2f", FKTestResult) + " (about " + FKScoreAge + " year olds).");
                System.out.println("Simple Measure of Gobbledygook: " + String.format( "%.2f", SMOGTestResult) + " (about " + SMOGScoreAge + " year olds).");
                System.out.println("Coleman–Liau index: " + String.format( "%.2f", CLTestResult) + " (about " + CLScoreAge + " year olds).");
                System.out.println();
                double averageAge = (ARIScoreAge + FKScoreAge + SMOGScoreAge + CLScoreAge) / 4.0;
                System.out.println("This text should be understood by " + String.format( "%.2f", averageAge) + " year olds.");
                break;
        }


    }


}

