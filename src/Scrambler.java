import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Brian on 12/8/2016.
 */
public class Scrambler {
    public static String scrambleWord(String word){
        String scrambledWord = "";

        ArrayList<Character> charList = new ArrayList<>();
        for (Character c : word.toCharArray()){
            charList.add(c);    //add each character to list
        }

        ArrayList<Character>scrambledCharacters = new ArrayList<>();
        Random rand = new Random();
        int numChars = charList.size();
        for (int i = 0; i < numChars; i++) {
            //rearrange the characters
            int randNum = rand.nextInt(charList.size());
            scrambledCharacters.add(charList.get(randNum));
            charList.remove(randNum);
        }

        //remake String
        for (Character c : scrambledCharacters) {
            scrambledWord += c;
        }

        return scrambledWord;
    }

    public static WordPair generateWordPair(String word){
        return new WordPair(word, scrambleWord(word));
    }

}
