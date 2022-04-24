package controllertest;

import static org.junit.Assert.assertEquals;

import controller.Features;
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
    assertEquals("Mock called from setFeatures. uniqueCode: 12344" + "Input: 90, 90"
        + "Mock called from updateGameScreen. message : "
        + "Mock result for move player, Code: 12344, UniqueCode:  12344"
        + "Mock called from displayPopupMessage. message: "
        + "Mock for game over, Code: 12344, type: , uniqueCode: 12344"
        + "Mock called from exitGame. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void startGameIsClickedTest() {
    this.controller.startGameIsClicked();
    assertEquals("Mock called from setFeatures. uniqueCode: 12344"
        + "Mock called from displayAddPlayerScreen. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void lookAroundTest() {
    this.controller.lookAround();
    assertEquals("Mock called from setFeatures. uniqueCode: 12344"
        + "Mock called from updateGameScreen. message : , UniqueCode:  12344"
        + "Mock called from displayPopupMessage. message: Output: "
        + "Mock result for look around, code: 12344\n" + ", type: LookAround, uniqueCode: 12344"
        + "Mock called from displayPopupMessage. message: "
        + "Mock for game over, Code: 12344, type: , uniqueCode: 12344"
        + "Mock called from exitGame. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void showGameScreenTest() {
    this.controller.showGameScreen();
    assertEquals("Mock called from setFeatures. uniqueCode: 12344"
        + "Mock called from displayGameScreen. uniqueCode: 12344"
        + "Mock called from displayPopupMessage. message: "
        + "Mock for game over, Code: 12344, type: , uniqueCode: 12344"
        + "Mock called from exitGame. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void pickItemTest() {
    this.controller.pickItem("weapon");
    assertEquals("Mock called from setFeatures. uniqueCode: 12344"
        + "Input: weaponMock called from updateGameScreen."
        + " message : Player has picked up the Item weapon " + "successfully, code: 12344\n"
        + ", UniqueCode:  12344Mock called from displayPopupMessage. "
        + "message: Mock for game over, Code: 12344, type: , uniqueCode: 12344"
        + "Mock called from exitGame. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void setFeaturesTest() {
    controller = new GameControllerImpl(mockModel, gameView);
    assertEquals("Mock called from setFeatures. uniqueCode: 12344"
        + "Mock called from setFeatures. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void addPlayerIsClickedTest() {
    this.controller.addPlayerIsClicked();
    assertEquals("Mock called from setFeatures. uniqueCode: 12344"
        + "Mock called from displayAddPlayerPopup. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void pickItemIsPressedTest() {
    this.controller.pickItemIsPressed();
    ;
    assertEquals("Mock called from setFeatures. uniqueCode: 12344"
        + "Mock called from displayPickItemPopup. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void attackTargetIsPressedTest() {
    this.controller.attackTargetIsPressed();
    assertEquals(
        "Mock called from setFeatures. uniqueCode: 12344"
            + "Mock called from displayAttackTargetPopup. " + "uniqueCode: 12344",
        this.out.toString());
  }
}