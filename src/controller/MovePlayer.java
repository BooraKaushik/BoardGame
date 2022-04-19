package controller;

import game.GameWorld;

/**
 * A class which is used as a command to execute the corresponding method in
 * GameWorld model to move a player in the world.
 */
public class MovePlayer implements GameCommand {

  private final String spaceName;
  private String output;

  /**
   * A constructor to create instance of the class with the specified space name.
   * 
   * @param spaceName The name of the space to move the player to
   * @throws IllegalArgumentException When spaceName is null or empty
   */
  public MovePlayer(String spaceName) throws IllegalArgumentException {
    if (spaceName == null) {
      throw new IllegalArgumentException("Space name cannot be null");
    }

    if (spaceName.length() == 0) {
      throw new IllegalArgumentException("Space name cannot be empty string");
    }

    this.spaceName = spaceName;
    this.output = "";
  }

  @Override
  public void execute(GameWorld model) throws IllegalArgumentException {

    if (model == null) {
      throw new IllegalArgumentException("GameWorld cannot be null");
    }

    this.output = model.movePlayerInWorld(spaceName);

  }

  @Override
  public String getOutput() {
    return this.output;
  }

}
