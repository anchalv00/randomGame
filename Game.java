// i'm sorry ... i got too focused on this program

import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static String solving = "";
    static String guessWord;

    public static void main(String[] args) {
        Word.getRandomWord();
        Word.setWord("water");
        Word.createBlanks();
        // solving = Word.createBlanks();
        //guessWord = sc.nextLine();
        System.out.println(Word.getWord() + "\n" + Word.getSolvingWord());
        Word.guess("aeiou");
        Word.guess("fhifh");
        Word.guess("faiet");
        System.out.println(Word.getSolvingWord());
        System.out.println(Word.checkInput("hello"));
    }
}
