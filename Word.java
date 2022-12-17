import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Word {

    public static String getWord() {
        String data = "";
        ArrayList wordList = new ArrayList();
        try {
            File myObj = new File("words.txt");
            Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            wordList.add(myReader.nextLine());
            //data += myReader.nextLine() + "\n";
            //System.out.println(data);
        }
        myReader.close();
        } catch (Exception e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
        return wordList.get((int) (Math.random() * 999 + 0.5)).toString();
    }

    public static String createBlanks(String word) {
        String blanks = "";

        for (int i=1;i<=word.length();i++) {
            blanks += "_ ";
        }
        
        return blanks;
    }
}
