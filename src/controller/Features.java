package controller;

/**
 * An interface of the controller which represents all the features provided by
 * the controller to the view.
 */
public interface Features {

  /**
   * Updates the path of the world specification file that must be used to build
   * the world.
   * 
   * @param path The path which contains the new world specification file
   */
  public void updateWorldPath(String path);

  /**
   * Used to exit the game.
   */
  public void exit();

  /**
   * Used to add a player into the game.
   * 
   * @param name             The name of the player to be added
   * @param startingLocation The starting space of the player to be added
   * @param isHuman          Whether the player is human or a bot
   */
  public void addPlayer(String name, String startingLocation, boolean isHuman);

  /**
   * Used to perform an action based on the key that is pressed.
   * 
   * @param keyName The key that is pressed by the user
   */
  public void keyIsPressed(String keyName);

  /**
   * Used to perform an action based on the mouse click.
   * 
   * @param xcoord The x coordinate of the location where mouse was clicked on the
   *               window
   * @param ycoord The y coordinate of the location where mouse was clicked on the
   *               window
   */
  public void mouseIsClicked(int xcoord, int ycoord);

  /**
   * Used to perform an action based on the type of action that is triggered.
   * 
   * @param actionName The name/type of the action that was triggered
   */
  public void actionIsPerformed(String actionName);

}