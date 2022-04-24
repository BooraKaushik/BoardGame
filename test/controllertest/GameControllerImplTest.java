package controllertest;

import static org.junit.Assert.assertEquals;

import controller.GameController;
import controller.GameControllerImpl;
import game.GameWorld;
import org.junit.Before;
import org.junit.Test;
import view.GameView;

/**
 * A test class for testing GameControllerImpl class.
 */
public class GameControllerImplTest {

  private StringBuffer out;
  private String uniqueCode;
  private GameWorld mockModel;
  private GameView gameView;
  private GameController controller;

  /**
   * Initializes all the fields of GameControllerImplTest.
   */
  @Before
  public void setup() {
    out = new StringBuffer();
    uniqueCode = "12344";
    mockModel = new MockGameWorld(out, uniqueCode);
    gameView = new MockView(out, uniqueCode);
    controller = new GameControllerImpl(mockModel, gameView);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForNullModel() {
    new GameControllerImpl(null, gameView);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForNullView() {
    new GameControllerImpl(mockModel, null);
  }
}