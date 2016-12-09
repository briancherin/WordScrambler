import java.util.Scanner;

/**
 * Created by Brian on 12/8/2016.
 */
public class WordScrambler {

    static final int hard = 9999;
    static final int easy = 1111;


    public static void main (String[] args){
        WordPair pair = getPairFromDifficulty();    //get scrambled word and solution

        Scanner scanner = new Scanner(System.in);

        System.out.println("Scrambled: " + pair.scrambledWord);

        int numGuesses = 0;
        while (numGuesses < 3) {
            System.out.println("Answer: ");
            String guess = scanner.nextLine().toLowerCase();
            if (guess.equals(pair.unscrambledWord)) {
                System.out.println("YOU GOT IT RIGHT!!");
                break;
            } else {
                System.out.println("You are a failure. Try again: " + pair.scrambledWord);
            }
            numGuesses++;
        }
        System.out.println("The word was: " + pair.unscrambledWord + ".");


    }

    public static WordPair getScrambledWordAndAnswer(int difficulty) {
        if (difficulty == hard) {
            return Scrambler.generateWordPair(WordRetriever.getRandomWordFromApi());
        }
        //default easy
        return Scrambler.generateWordPair(WordRetriever.getRandomWordFromTextFile());
    }

    public static WordPair getPairFromDifficulty(){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("[h]ard or [e]asy?");
        while(!(input.equals("h") || input.equals("e"))) {
            input = scanner.nextLine();
            if (input.equals("h")) {
                return getScrambledWordAndAnswer(hard);
            } else if (input.equals("e")) {
                return getScrambledWordAndAnswer(easy);
            }
            System.out.println("[h]ard or [e]asy?");
        }
        System.out.println("HERE");
        return getScrambledWordAndAnswer(easy);
    }

}
