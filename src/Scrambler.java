import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Brian on 12/8/2016.
 */
public class Scrambler {
    public static String scrambleWord(String word){

        ArrayList<Character> charList = new ArrayList<>();
        for (Character c : word.toCharArray()){
            charList.add(c);    //adds each character to list
        }

        ArrayList<Character>scrambledCharacters = new ArrayList<>();
        Random rand = new Random();
        int numChars = charList.size();
        //rearranges the characters
        for (int i = 0; i < numChars; i++) {
            int randNum = rand.nextInt(charList.size());
            scrambledCharacters.add(charList.get(randNum));
            charList.remove(randNum);
        }

        //rebuilds the scrambled word
        StringBuilder sb  = new StringBuilder();
        for (Character c : scrambledCharacters) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static WordPair generateWordPair(String word){
        return new WordPair(word, scrambleWord(word));
    }

}
