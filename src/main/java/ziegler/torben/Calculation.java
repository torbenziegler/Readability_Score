package ziegler.torben;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation {

    protected int syllableFinder(String word) {
        String i = "(?i)[aiouy][aeiouy]*|e[aeiouy]*(?!d?\\b)";
        Matcher matcher = Pattern.compile(i).matcher(word);
        int counter = 0;

        while (matcher.find()) {
            counter++;
        }
        // return at least 1
        return Math.max(counter, 1);
    }


    double ARITestResult(double characters, double words, double sentences) {
        return 4.71 * (characters / words) + 0.5 * (words / sentences) - 21.43;
    }

    double fleschKincaidTestResult(double words, double sentences, double syllables) {
        return (0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59);
    }

    double smogIndexResult(double polysyllables, double sentences) {
        return 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.1291;
    }

    double colemanLiauIndexResult(double sentences, double words, double characters) {
        double l = (characters / words) * 100;
        double s = (sentences / words) * 100;
        return 0.0588 * l - 0.296 * s - 15.8;
    }

}
