package game;

/**
 * The interface which is used by the controller to communicate with the model.
 */
public interface GameWorld {
  /**
   * Gets the information of a space like Name, items in the space and
   * neighbouring spaces.
   * 
   * @param spaceName Name of the space whose info we want to return
   * @return String with info about the given space
   * @throws IllegalArgumentException If space name is null or empty
   */
  public String getInfoOfaSpace(String spaceName) throws IllegalArgumentException;

  /**
   * Draw the image of the world in PNG format and saves it into the res folder.
   * 
   * @return String Path of the saved PNG image
   */
  public String drawImage() throws IllegalStateException;

  /**
   * Add a player to the world.
   * 
   * @param name              Name of the player
   * @param startingSpaceName Name of the space the player will start the game in
   * @param isHuman           The type of the player to add
   * @throws IllegalArgumentException When name or space name is null or an empty
   *                                  string or when the Space Name is not present
   *                                  in the world
   */
  public void addPlayer(String name, String startingSpaceName, boolean isHuman)
      throws IllegalArgumentException;

  /**
   * Returns the information of a player like name of the player, in which space
   * he is currently present in and the items he is carrying as a string.
   * 
   * @param name Name of the player
   * @return The information of the specified player
   * @throws IllegalArgumentException when name is null or an empty strimg or when
   *                                  player does not exist in the world
   */
  public String getPlayerInfo(String name) throws IllegalArgumentException;

  /**
   * Move the current turn player to the specified space.
   * 
   * @param spaceName Name of the space to which the player should be moved to
   * @return return a string which gives the summary of the action performed
   * @throws IllegalArgumentException when the space name is null or an empty
   *                                  string or when the space name is not present
   *                                  in the world
   * @throws IllegalStateException    when the specified space is not a neighbour
   *                                  of the current space
   */
  public String movePlayerInWorld(String spaceName)
      throws IllegalArgumentException, IllegalStateException;

  /**
   * Adds the specified item to the player's items list.
   * 
   * @param itemName Name of the item the player wants to pickup
   * @return return a string which gives the summary of the action performed
   * @throws IllegalArgumentException when the item name is null or an empty
   *                                  string or when the specified item is not a
   *                                  part of the space
   * @throws IllegalStateException    When the item is not part of the current
   *                                  player's space
   */
  public String pickItemByPlayer(String itemName)
      throws IllegalArgumentException, IllegalStateException;

  /**
   * Return the information of where the current turn player is in the world and
   * the spaces that can be seen from the current space.
   * 
   * @return the information of where the current turn player is in the world and
   *         the spaces that can be seen from the current space as a string
   */
  public String lookAroundByPlayer();

  /**
   * Returns the name, type and space of the current turn player and the target's
   * current space name as a string in the format:
   * Name,Type,SpaceName,TargetSpaceName.
   * 
   * @return A string in the format: Name,Type,SpaceName,TargetSpaceName
   */
  public String getCurrentPlayerInfoAndTargetInfo();

  /**
   * Performs an action as a computer contolled player and returns the summary.
   * 
   * @return Returns a string of the summary of the action performed.
   */
  public String performComputerAction();

  /**
   * Moves the pet to the specified space name by the the current turn player.
   * 
   * @param spaceName The name of the space to move the pet to
   * @throws IllegalArgumentException When space name is null or empty or if the
   *                                  pet's current space is the same space the
   *                                  player is trying to move the pet to or when
   *                                  the given space name is not part of the
   *                                  world
   */
  public String movePetByPlayer(String spaceName) throws IllegalArgumentException;

  /**
   * Attack the target by the current turn player using the item specified. Attack
   * target also works with "hand" as a weapon which decrease health by one point
   * 
   * @param itemName The name of the item which is to be used to attack the
   *                 target. If "hand" is specified, then it will do one point of
   *                 damage to the target
   * @return A String, -1 for unsuccessful attempt, 0 for successful attempt and 1
   *         for player won
   * @throws IllegalArgumentException If item name is null or empty or if the item
   *                                  does not exist with the current turn player
   *                                  or when the player is not in the same space
   *                                  as the target.
   */
  public String attackTarget(String itemName) throws IllegalArgumentException;

  /**
   * Returns if the game is completed after a player has won the game.
   * 
   * @return True/False based on if the game is completed or not
   */
  public boolean isGameOver();
}