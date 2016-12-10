import java.util.Scanner;

/**
 * Created by Brian on 12/8/2016.
 */
public class WordScrambler {

    public static final int numGuesses = 3;

    public enum Difficulty {easy, hard}


    public static void main (String[] args){
        WordPair pair = getPairFromDifficulty();    //get scrambled word and solution

        Scanner scanner = new Scanner(System.in);

        System.out.println("Scrambled: " + pair.scrambledWord);

        int tries = 0;
        while (tries < numGuesses) {
            System.out.println("Answer: ");
            String guess = scanner.nextLine().toLowerCase();
            if (guess.equals(pair.unscrambledWord)) {
                System.out.println("YOU GOT IT RIGHT!!");
                break;
            } else {
                System.out.println("You are a failure. Scrambled word: " + pair.scrambledWord);
            }
            tries++;
        }
        if (tries == numGuesses) {  //if user ran out of guesses
            System.out.println("The word was: " + pair.unscrambledWord + ".");
        }


    }

    public static WordPair getScrambledWordAndAnswer(Difficulty difficulty) {

        switch(difficulty) {
            case easy:
                return Scrambler.generateWordPair(WordRetriever.getRandomWordFromApi());
            default:
                return Scrambler.generateWordPair(WordRetriever.getRandomWordFromTextFile());
        }

    }

    public static WordPair getPairFromDifficulty(){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("[h]ard or [e]asy?");
        while(!(input.equals("h") || input.equals("e"))) {
            input = scanner.nextLine();
            if (input.equals("h")) {
                return getScrambledWordAndAnswer(Difficulty.easy);
            } else if (input.equals("e")) {
                return getScrambledWordAndAnswer(Difficulty.hard);
            }
            System.out.println("[h]ard or [e]asy?");
        }
        System.out.println("HERE");
        return getScrambledWordAndAnswer(Difficulty.easy);
    }

}
