package ziegler.torben;

/**
 * Calculation of test results
 */
public class Calculation {

    /**
     * Calculates Automated Readability Index
     *
     * @param characters amount of characters
     * @param words      amount of words
     * @param sentences  amount of sentences
     * @return ARI Test result
     */
    double ARITestResult(double characters, double words, double sentences) {
        return 4.71 * (characters / words) + 0.5 * (words / sentences) - 21.43;
    }

    /**
     * Calculates Flesch–Kincaid readability tests
     *
     * @param words     amount of words
     * @param sentences amount of sentences
     * @param syllables amount of syllables
     * @return FK Test result
     */
    double fleschKincaidTestResult(double words, double sentences, double syllables) {
        return (0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59);
    }

    /**
     * Calculates Simple Measure of Gobbledygook
     *
     * @param polysyllables amount of polysyllables
     * @param sentences     amount of sentences
     * @return SMOG Test result
     */
    double smogIndexResult(double polysyllables, double sentences) {
        return 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.1291;
    }

    /**
     * Calculates Coleman–Liau Index
     *
     * @param sentences  amount of sentences
     * @param words      amount of words
     * @param characters amount of characters
     * @return CLI Test result
     */
    double colemanLiauIndexResult(double sentences, double words, double characters) {
        double l = (characters / words) * 100;
        double s = (sentences / words) * 100;
        return 0.0588 * l - 0.296 * s - 15.8;
    }

}
