import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Word {
    private static int chances = 6;
    private static int start = 0;
    private static boolean isSolved = false;
    private static String word = "";
    private static String solvingWord = "";
    private static final String reset = "\u001B[0m";
    private static final String green = "\u001b[32m";
    private static final String yellow = "\u001B[33m";
    private static final String gray = "\u001b[30;1m";
    
    /***
     * Getters
     */
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

    public static boolean isSolved() {
        return isSolved;
    }

    public static int getChances() {
        return chances;
    }

    public static String getWord() {    // wouldn't be used in an actual game
        return word;
    }

    public static String getSolvingWord() {
        return solvingWord;
    }

    /***
     * Setters for testing
     * @param input
     */
    public static void setWord(String input) {
        word = input.toUpperCase();
    }

    /***
     * Method to create the blanks of the pseudo-Wordle game
     */
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

    /***
     * Method for guessing the word, taking into account valid input
     * @param term
     */
    public static void guess(String term) {
        String guess = term.toUpperCase();

        try {
            start = solvingWord.indexOf("_");
            if (!checkInput(guess)) {
                System.out.println("Please put a valid 5-letter word in the English Dictionary.");
                return;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error");
            return;
        }
        
        clear();
        for (int i = 0; i < 5; i++) {
            // System.out.println(1);
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

        if (guess.equals(word)) {
            isSolved = true;
        }
        
        System.out.println(solvingWord);
        chances--;
    }

    /***
     * intuitive
     * @param guess
     * @return
     */
    private static boolean checkInput(String guess) {
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

    /***
     * Clears the terminal screen (only used when the program is finalized)
     */
    public static void clear() {
        System.out.println("\033[2J");
    }

    public static void play() {
        Word.getRandomWord();
        Word.createBlanks();
        // System.out.println("Word: "+ Word.getWord());    // test
        System.out.println(Word.getSolvingWord());
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 1f2e2ec0a6ab7b3175c27a5c92412c49f860ba76
