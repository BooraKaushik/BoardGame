package view;

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
   */
  public void displayPopupMessage(String message, String type);

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
   */
  public String displayInputPopup(String title, String[] options);

}
