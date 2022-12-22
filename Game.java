import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static String guessWord;

    public static void main(String[] args) {
      while (true) {
        Word.play();
        Word.setWord("ANGER");
        //System.out.println(Word.getWord());
        new GameFrame();  // WIP
        while (Word.getChances() > 0 && Word.isSolved().equals("false")) {
          System.out.print("Word: ");
          Word.guess(sc.nextLine());
        }

        switch (Word.isSolved()) {
          case "true": {
            Word.setPoints();
            System.out.println("Game Over. You won! +1 point (Total: " + Word.getPoints() + ")");
            break;
          }
          case "false": {
            System.out.println("Game Over. The word was " + Word.getWord() + ".\n");
            break;
          }
        }
        
        if (!ask()) {
          System.exit(1);
        } else {
          Word.setChances(6);
          Word.setIsSolved(false);
        }
      }
    }
    private static boolean ask() {
      System.out.println("Do you want to play again? (yes or no)");
      String ans = sc.nextLine();
      return (ans.equals("y") || ans.equals("yes")) ? true : (ans.equals("n") || ans.equals("no")) ? false : ask();
  }
}
