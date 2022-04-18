package driver;

import game.World;
import game.WorldImpl;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import utils.RandomManual;
import view.GameView;
import view.GameViewImpl;

/**
 * A driver class for starting the game.
 */
public class Game {

  /**
   * Main method of the driver class which starts the game.
   * 
   * @param args command line arguments which contains filename and number of
   *             turns
   */
  public static void main(String[] args) {
    try {
      if (args.length == 2) {
        String path = args[0];

        System.out.println(String.format("Reading the world specifications from %s...\n", path));

        Readable mansionReadable = null;

        mansionReadable = new FileReader(path);

        Readable input = new InputStreamReader(System.in);
        Appendable output = System.out;
        RandomManual rand = new RandomManual();

        int numOfTurns = Integer.parseInt(args[1]);

        System.out.println("Creating the world...\n");

        World world = new WorldImpl(mansionReadable, rand, numOfTurns);
      } else {
        GameView view = new GameViewImpl("Test");
        System.out.println("Please specify the correct command.");
      }
    } catch (FileNotFoundException fne) {
      System.out.println("Unable to find the world specification text file.");
    } catch (NumberFormatException e) {
      System.out.println("Please specify a number for the maximum turns in the game.");
    }
  }

}
