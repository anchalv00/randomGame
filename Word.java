import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Word {
    static int start = 0;
    static String word = "";
    static String solvingWord = "";
    public static final String reset = "\u001B[0m";
    public static final String green = "\u001b[32m";
    public static final String yellow = "\u001B[33m";
    public static final String gray = "\u001b[30;1m";
    
    
    public static void getRandomWord() {
        ArrayList<String> wordList = new ArrayList<String>();
        try {
            File myObj = new File("words.txt");
            Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            wordList.add(myReader.nextLine().toUpperCase());
            //data += myReader.nextLine() + "\n";
            //System.out.println(data);
        }
        myReader.close();
        } catch (Exception e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
        word = wordList.get((int) (Math.random() * 212 + 0.5)).toString().toUpperCase();
    }

    public static String getWord() {
        return word;
    }

    public static String getSolvingWord() {
        return solvingWord;
    }

    public static void setWord(String w) {
        word = w.toUpperCase();
    }

    public static void createBlanks() {
        String blanks = "";
        for (int j=0;j<6;j++) {
            for (int i=1;i<=word.length();i++) {
                blanks += "_ ";
            }
            blanks += "\n";
        }
        
        solvingWord = blanks;
    }

    public static void guess(String w) {
        String guess = w.toUpperCase();
        try {
            start = solvingWord.indexOf("_");
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        

        clear();
        for (int i = 0; i < 5; i++) {
            if (word.substring(i, i+1).equals(guess.substring(i, i+1))) {
                solvingWord = solvingWord.substring(0, start + i*2) + green + guess.substring(i, i + 1).toUpperCase() + reset + solvingWord.substring(start + i*2 + 1);
                start += 9;
            } else if (word.contains(guess.substring(i, i+1))) {
                solvingWord = solvingWord.substring(0, start + i*2) + yellow + guess.substring(i, i + 1).toUpperCase() + reset + solvingWord.substring(start + i*2 + 1);
                start += 9;
            } else {
                solvingWord = solvingWord.substring(0, start + i*2) + gray + guess.substring(i, i + 1).toUpperCase() + reset + solvingWord.substring(start + i*2 + 1);
                start += 11;
            }
        }
    }

    public static boolean checkInput(String guess) {
        return guess.matches("[a-zA-Z]+") && guess.length() == 5 && !guess.contains(" ") && check(guess);
    }

    private static boolean check(String word) {
        // System.out.println(word);
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(
                    "dictionary.txt"))) {
                String str;
                while ((str = in.readLine()) != null) {
                    if (str.indexOf(word.toLowerCase()) != -1) {
                        return true;
                    }
                }
                in.close();
            }
        } catch (IOException e) {
        }

        return false;
    }

    public static void clear() {
        System.out.println("\033[2J");
    }
}
