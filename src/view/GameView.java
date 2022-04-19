package view;

import controller.Features;

/**
 * Defines the view Methods that are used to create GUI for the Board Game.
 *
 */
public interface GameView {

  /**
   * Creates a Welcome Screen View.
   */
  public void displayWelcomeScreen();

  /**
   * Creates Add Player Screen View.
   */
  public void displayAddPlayerScreen();

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
   * Creates a Game Screen View.
   */
  public void displayGameScreen();

  /**
   * Creates a Pop up that lets the user select from one of the oprions.
   * 
   * @param title   String that has to be displayed in the pop up.
   * @param options List of options that has to be given to the user.
   * @return the option selected by the user.
   * 
   * @throws IllegalArgumentException When title is null or empty or options array
   *                                  is null
   */
  public String displayInputPopup(String title, String[] options) throws IllegalArgumentException;

  /**
   * Sets the features of the controller as callbacks to event listeners that the
   * view can use.
   * 
   * @param featuresController The features controller that the view uses
   * @throws IllegalArgumentException When features controller is null
   */
  public void setFeatures(Features featuresController) throws IllegalArgumentException;

}
