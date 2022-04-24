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
  public void spaceIsClickedTest() {
    this.controller.spaceIsClicked(90, 90);
    assertEquals("Mock called from setFeatures. uniqueCode: 12344" + "Input: 90, 90"
        + "Mock called from updateGameScreen. message : "
        + "Mock result for move player, Code: 12344, UniqueCode:  12344"
        + "Mock called from displayPopupMessage. message: "
        + "Mock for game over, Code: 12344, type: , uniqueCode: 12344"
        + "Mock called from exitGame. uniqueCode: 12344", this.out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void spaceIsClickedTestIllegalArg() {
    this.controller.spaceIsClicked(-90, -90);
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

  @Test(expected = IllegalArgumentException.class)
  public void pickItemTestIllegalArg() {
    this.controller.pickItem("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void pickItemTestNullArg() {
    this.controller.pickItem(null);
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

  @Test
  public void updateWorldSpecification() {
    String world = "Test world";
    this.controller.updateWorldSpecification(world);
    assertEquals("Mock called from setFeatures. uniqueCode: 12344", this.out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void updateWorldSpecificationIllegalArg() {
    this.controller.updateWorldSpecification("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void updateWorldSpecificationNullArg() {
    this.controller.updateWorldSpecification(null);
  }

  @Test
  public void addPlayerTest() {
    this.controller.addPlayer("Mock name", "Mock space", true);
    assertEquals(
        "Mock called from setFeatures. uniqueCode: 12344Received input: "
            + "(Name: Mock name, Starting space: Mock space, isHuman: true)\n",
        this.out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addPlayerTestEmptyName() {
    this.controller.addPlayer("", "Mock space", true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addPlayerTestNullName() {
    this.controller.addPlayer(null, "Mock space", true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addPlayerTestEmptySpace() {
    this.controller.addPlayer("Mock name", "", true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addPlayerTestNullSpace() {
    this.controller.addPlayer("Mock name", null, true);
  }

  @Test
  public void attackTargetTest() {
    this.controller.attackTarget("Mock item");
    assertEquals("Mock called from setFeatures. uniqueCode: 12344Input: Mock itemMock called "
        + "from updateGameScreen. message : Player has attacked the target with the item Mock "
        + "item, code: 12344\n"
        + ", UniqueCode:  12344Mock called from displayPopupMessage. message: Mock for game over, "
        + "Code: 12344, " + "type: , uniqueCode: 12344Mock called from exitGame. uniqueCode: 12344",
        this.out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void attacktargetTestEmptyName() {
    this.controller.attackTarget("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void attacktargetTestNullName() {
    this.controller.attackTarget(null);
  }

  @Test
  public void mpvePetTest() {
    this.controller.attackTarget("Mock space");
    assertEquals("Mock called from setFeatures. uniqueCode: 12344Input: Mock spaceMock called "
        + "from updateGameScreen."
        + " message : Player has attacked the target with the item Mock space, code: 12344\n"
        + ", UniqueCode:  12344Mock called from displayPopupMessage. message: Mock "
        + "for game over, Code: 12344, type: , "
        + "uniqueCode: 12344Mock called from exitGame. uniqueCode: 12344", this.out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void movePetTestEmptyName() {
    this.controller.movePet("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void movePetTestNullName() {
    this.controller.movePet(null);
  }

  @Test
  public void newWorldIsClickedTest() {
    this.controller.newWorldIsClicked();
    assertEquals("Mock called from setFeatures. uniqueCode: 12344Mock called from "
        + "displayFileChooser. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void exitIsClicked() {
    this.controller.exitIsClicked();
    assertEquals("Mock called from setFeatures. uniqueCode: 12344Mock called "
        + "from exitGame. uniqueCode: 12344", this.out.toString());
  }

  @Test
  public void movePetIsPressed() {
    this.controller.movePetIsPressed();
    assertEquals("Mock called from setFeatures. uniqueCode: 12344Mock "
        + "called from displayMovePetPopup. uniqueCode: 12344", this.out.toString());
  }
}