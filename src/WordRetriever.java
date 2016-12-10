import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Brian on 12/8/2016.
 */
public class WordRetriever {
    final static String wordsFileName = "words.txt";

    public static String getRandomWordFromApi() {
        String word = "";

        try {
            URL url = new URL("http://www.setgetgo.com/randomword/get.php");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            word = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return word.toLowerCase();
    }

    public static String getRandomWordFromTextFile() {

        ArrayList<String> words = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(wordsFileName)));
            while ((line = br.readLine()) != null){
                words.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words.get(new Random().nextInt(words.size())).toLowerCase();

    }

}
