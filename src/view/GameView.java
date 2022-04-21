package view;

import controller.Features;

/**
 * Defines the view Methods that are used to create GUI for the Board Game.
 *
 */
public interface GameView {

  /**
   * Creates a Welcome Screen View and sets the event listeners for that panel
   * using Features.
   * 
   * @param featuresController The features controller that the welcome panel uses
   * @throws IllegalArgumentException When features controller is null
   */
  public void displayWelcomeScreen(Features featuresController) throws IllegalArgumentException;

  /**
   * Creates Add Player Screen View and sets the event listeners for that panel
   * using Features.
   * 
   * @param featuresController The features controller that the add player panel
   *                           uses
   * @throws IllegalArgumentException When features controller is null
   */
  public void displayAddPlayerScreen(Features featuresController) throws IllegalArgumentException;

  /**
   * Creates a Pop up with the message provided.
   * 
   * @param message String that has to be displayed in the pop up.
   * @param type    Type of pop up that has to be created (example Error, message,
   *                etc).
   * 
   * @throws IllegalArgumentException WHen meesage or type is null or empty
   */
  public void displayPopupMessage(String message, String type) throws IllegalArgumentException;

  /**
   * Creates a Game Screen View and sets the event listeners for that panel using
   * Features.
   * 
   * @param featuresController The features controller that the game view panel
   *                           uses
   * @throws IllegalArgumentException When features controller is null
   */
  public void displayGameScreen(Features featuresController) throws IllegalArgumentException;

  /**
   * Updates the game screen after a turn has been performed.
   * 
   * @param delay The time to wait for before updating the UI
   */
  public void updateGameScreen(int delay);

  /**
   * Sets the features of the controller as call backs to event listeners that the
   * view can use.
   * 
   * @param featuresController The features controller that the view uses
   * @throws IllegalArgumentException When features controller is null
   */
  public void setFeatures(Features featuresController) throws IllegalArgumentException;

}
