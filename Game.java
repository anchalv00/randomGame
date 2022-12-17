import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    static String word = "";
    static String solving = "";

    public static void main(String[] args) {
        word = Word.getWord();
        solving = Word.createBlanks(word);
        System.out.println(word + "\n" + solving);
    }
}
