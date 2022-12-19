// i'm sorry ... i got too focused on this program

import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static String guessWord;

    public static void main(String[] args) {
      while (true) {
        Word.play();
        new GameFrame();  // WIP
        while (Word.getChances() > 0 && !Word.isSolved()) {
          System.out.print("Word: ");
          Word.guess(sc.nextLine());
        }

        System.out.println("Game Over. The word was " + Word.getWord() + ".\n");
        if (!ask()) {
          System.exit(1);
        }
      }
    }
    private static boolean ask() {
      System.out.println("Do you want to play again? (yes or no)");
      String ans = sc.nextLine();
      return (ans.equals("y") || ans.equals("yes")) ? true : (ans.equals("n") || ans.equals("no")) ? false : ask();
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> 1f2e2ec0a6ab7b3175c27a5c92412c49f860ba76
