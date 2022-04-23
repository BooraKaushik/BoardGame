package controllertest;

import game.GameWorld;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A class which represents a mock model of GameWorld model used for testing
 * exception handling of the controller..
 */
public class MockGameWorldExceptions implements GameWorld {

  @Override
  public String getInfoOfaSpace(String spaceName) {
    if (!"valid".equals(spaceName)) {
      throw new IllegalArgumentException(
          "Test of how controller handles DisplayInfoOfSpace exceptions.");
    }
    return "";
  }

  @Override
  public String drawImage() {
    return "Draw image output\n";
  }

  @Override
  public void addPlayer(String name, String startingSpaceName, boolean isHuman) {
    if (!name.contains("valid")) {
      throw new IllegalArgumentException("Test of how controller handles AddPlayer exceptions.");
    }
  }

  @Override
  public String getPlayerInfo(String name) throws IllegalArgumentException {
    if (!name.contains("valid")) {
      throw new IllegalArgumentException(
          "Test of how controller handles GetPlayerInfo exceptions.");
    }
    return "";
  }
  
  @Override
  public String pickItemByPlayer(String itemName) {
    if ("stateException".equals(itemName)) {
      throw new IllegalStateException(
          "Test of how controller handles PickItem illegal state exceptions.");
    } else {
      throw new IllegalArgumentException(
          "Test of how controller handles PickItem illegal argument exceptions.");
    }
  }

  @Override
  public String lookAroundByPlayer() {
    return "";
  }
  
  @Override
  public String performComputerAction() {
    return "";
  }

  @Override
  public String movePetByPlayer(String spaceName) throws IllegalArgumentException {
    if (!"valid".equals(spaceName)) {
      throw new IllegalArgumentException("Test of how controller handles MovePet exceptions.");
    }
    return "";
  }

  @Override
  public String attackTarget(String itemName) throws IllegalArgumentException {
    throw new IllegalArgumentException(
        "Test of how controller handles AttackTarget's illegal argument exceptions.");
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
  public String isGameOver() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getNumOfTurns() {
    // TODO Auto-generated method stub
    return 0;
  }

}
