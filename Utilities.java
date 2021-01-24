import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Utilities {
    // reads the text file of words (words.txt)
    private static ArrayList<String> readWords(){
        File file = new File("words.txt");
        ArrayList<String> wordlist = new ArrayList<>();
        try{
            //adds each word to the arraylist
            Scanner readfile = new Scanner(file);
            while(readfile.hasNextLine()){
                String line = readfile.nextLine();
                wordlist.add(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("FiLe NoT FoUnD.");
        }
        return wordlist;
    }
    //gets random words from the arraylist of words created above
    public static String getWord(){
        ArrayList<String> words = readWords();
        Random random = new Random();
        int randomline = random.nextInt(words.size());
        String word = words.get(randomline);
        return word;
    }
}
