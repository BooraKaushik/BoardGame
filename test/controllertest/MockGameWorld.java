package controllertest;

import game.GameWorld;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A class which represents a mock model of GameWorld model used for testing the
 * controller.
 */
public class MockGameWorld implements GameWorld {
  private StringBuilder log;
  private String code;
  private boolean gameOver;

  /**
   * A contructor which constructs the instance of MockGameWorld which represents
   * a mock GameWorld model used for testing purposes.
   * 
   * @param log  The log to append the input received by the mock methods of the
   *             mock model class
   * @param code A code which is used to verify if the mock class instance is the
   *             same one as expected
   */
  public MockGameWorld(StringBuilder log, String code) {
    this.log = log;
    this.code = code;
    this.gameOver = false;
  }

  @Override
  public String getInfoOfaSpace(String spaceName) {
    log.append("Input: " + spaceName);
    return String.format("Output: Result for %s as input, code: %s\n", spaceName, code);
  }

  @Override
  public String drawImage() {
    return "Draw image output\n";
  }

  @Override
  public void addPlayer(String name, String startingSpaceName, boolean isHuman) {
    log.append(String.format("Received input: (Name: %s, Starting space: %s, isHuman: %b)\n", name,
        startingSpaceName, isHuman));
  }

  @Override
  public String getPlayerInfo(String name) throws IllegalArgumentException {
    log.append("Input: " + name);
    return String.format("Output: Result for %s as input, code: %s\n", name, code);
  }

  @Override
  public String pickItemByPlayer(String itemName) {
    log.append("Input: " + itemName);
    return String.format("Player has picked up the Item %s successfully, code: %s\n", itemName,
        code);
  }

  @Override
  public String lookAroundByPlayer() {
    return "Output: Mock result for look around, code: " + code + "\n";
  }

  @Override
  public String performComputerAction() {
    return "Performed random computer action, code: " + code + "\n";
  }

  @Override
  public String movePetByPlayer(String spaceName) throws IllegalArgumentException {
    log.append("Input: " + spaceName);
    return String.format("Player has moved the pet to the space %s, code: %s\n", spaceName, code);
  }

  @Override
  public String attackTarget(String itemName) throws IllegalArgumentException {
    log.append("Input: " + itemName);
    if ("winningItem".equals(itemName)) {
      this.gameOver = true;
      return String.format("Target died! Player has won the game, code: %s\n", code);
    }
    return String.format("Player has attacked the target with the item %s, code: %s\n", itemName,
        code);
  }

  @Override
  public String isGameOver() {
    // TODO
    return "";
  }

  @Override
  public String[][] getAllPlayers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<String> getTurnInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String[] getAllSpaces() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int[] getCoordinates(String spaceName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String[] getCurrentSpaceItems() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String[] getCurrentPlayerItems() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getCurrentSpaceOfPet() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setWorldSpecification(Readable worldData)
      throws IllegalArgumentException, NoSuchElementException, InputMismatchException {
    // TODO Auto-generated method stub

  }

  @Override
  public String movePlayerInWorld(int xcoord, int ycoord) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getNumOfTurns() {
    // TODO Auto-generated method stub
    return 0;
  }

}
