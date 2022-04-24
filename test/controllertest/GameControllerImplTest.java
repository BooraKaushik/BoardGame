package controllertest;

import static org.junit.Assert.assertEquals;

import controller.Features;
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
  private Features controller;

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

  @Test
  public void updateGameScreenTest() {
    this.controller.spaceIsClicked(90, 90);
    assertEquals("12344", this.out.toString());
  }

  @Test
  public void startGameIsClickedTest() {
    this.controller.startGameIsClicked();
    assertEquals("12344", this.out.toString());
  }

  @Test
  public void lookAroundTest() {
    this.controller.lookAround();
    assertEquals("12344", this.out.toString());
  }

  @Test
  public void showGameScreenTest() {
    this.controller.showGameScreen();
    assertEquals("12344", this.out.toString());
  }

  @Test
  public void pickItemTest() {
    this.controller.pickItem("weapon");
    assertEquals("12344", this.out.toString());
  }

  @Test
  public void setFeaturesTest() {
    controller = new GameControllerImpl(mockModel, gameView);
    assertEquals("12344", this.out.toString());
  }

  @Test
  public void addPlayerIsClickedTest() {
    this.controller.addPlayerIsClicked();
    ;
    assertEquals("12344", this.out.toString());
  }

  @Test
  public void pickItemIsPressedTest() {
    this.controller.pickItemIsPressed();
    ;
    assertEquals("12344", this.out.toString());
  }

  @Test
  public void attackTargetIsPressedTest() {
    this.controller.attackTargetIsPressed();
    assertEquals("12344", this.out.toString());
  }
}