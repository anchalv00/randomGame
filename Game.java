import java.util.Scanner;
import java.io.File;

public class Game {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            File myObj = new File("words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}
