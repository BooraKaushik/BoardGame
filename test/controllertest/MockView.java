package controllertest;

import controller.Features;
import view.GameView;

/**
 * Creates a temporary view to test the inputs and outputs from controller.
 */
public class MockView implements GameView {

  private final StringBuffer out;
  private final String uniqueCode;

  public MockView(StringBuffer out, String uniqueCode) {
    this.out = out;
    this.uniqueCode = uniqueCode;
  }

  @Override
  public void displayWelcomeScreen(Features featuresController) throws IllegalArgumentException {
    this.out.append(this.uniqueCode);
  }

  @Override
  public void displayAddPlayerScreen(Features featuresController) throws IllegalArgumentException {
    this.out.append(this.uniqueCode);
  }

  @Override
  public void displayPopupMessage(String message, String type) throws IllegalArgumentException {
    this.out.append(String.format("%s, %s, %s", message, type, this.uniqueCode));
  }

  @Override
  public void displayGameScreen(Features featuresController) throws IllegalArgumentException {
    this.out.append(this.uniqueCode);
  }

  @Override
  public void updateGameScreen(String message) throws IllegalArgumentException {
    this.out.append(String.format("%s, %s", message, this.uniqueCode));
  }

  @Override
  public void setFeatures(Features featuresController) throws IllegalArgumentException {
    this.out.append(this.uniqueCode);

  }

  @Override
  public void displayAddPlayerPopup(Features featuresController) throws IllegalArgumentException {
    this.out.append(this.uniqueCode);
  }

  @Override
  public void displayPickItemPopup(Features featuresController) throws IllegalArgumentException {
    this.out.append(this.uniqueCode);
  }

  @Override
  public void displayAttackTargetPopup(Features featuresController)
      throws IllegalArgumentException {
    this.out.append(this.uniqueCode);
  }

  @Override
  public void displayMovePetPopup(Features featuresController) throws IllegalArgumentException {
    this.out.append(this.uniqueCode);
  }

  @Override
  public void exitGame() {
    this.out.append(this.uniqueCode);
  }

  @Override
  public void displayFileChooser(Features featuresController) throws IllegalArgumentException {
    this.out.append(this.uniqueCode);
  }

}
