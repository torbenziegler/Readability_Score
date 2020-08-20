package ziegler.torben;

public class Result {

    void showResults(String text, double words, double sentences, double characters, double syllables, double polysyllables) {
        Calculation calc = new Calculation();


        // ARI Results
        double ARITestResult = calc.ARITestResult(characters, words, sentences);
        int ARIScoreAge = (int) Math.ceil(ARITestResult);
        // FK Results
        double FKTestResult = calc.fleschKincaidTestResult(words, sentences, syllables);
        int FKScoreAge = (int) Math.ceil(FKTestResult);
        // SMOG Results
        double SMOGTestResult = calc.smogIndexResult(polysyllables, sentences);
        int SMOGScoreAge = (int) Math.ceil(SMOGTestResult);
        // CL Results
        double CLTestResult = calc.colemanLiauIndexResult(sentences, words, characters);
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
        String choice = Main.scanner.nextLine();
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
