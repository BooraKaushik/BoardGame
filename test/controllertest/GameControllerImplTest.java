package controllertest;

import static org.junit.Assert.assertEquals;

import game.GameWorld;
import view.GameView;
import controller.GameController;
import controller.GameControllerImpl;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

/**
 * A test class for testing GameControllerImpl class.
 */
public class GameControllerImplTest {

  private StringBuffer out;
  private String uniqueCode;
  private GameWorld mockModel;
  private GameView gameView;
  private GameController controller;

  @Before
  public void setup() {
    out = new StringBuffer();
    uniqueCode = "12344";
    mockModel = new MockGameWorld(out, uniqueCode);
    gameView = new MockView(out, uniqueCode);
    controller = new GameControllerImpl(mockModel, gameView);
  }

  @Test
  public void invalidInput() {
  }
}