package controller;

import game.GameWorld;
import view.GameView;

/**
 * A class implementation of the GameController interface which is used to take
 * inputs from the view, send commands to the model and send the corresponding
 * output back to the view.
 */
public class GameControllerImpl implements GameController, Features {

  private final GameWorld gameModel;
  private final GameView gameView;
  private String worldPath;
  private final GameCommand commands;

  /**
   * A contructor that is used to create an instance of the GameControllerImpl
   * which is the primary controller of the game.
   * 
   * @param gameModel The model of the game that is to be used
   * @param gameView  The view of the game that is to be used
   * @throws IllegalArgumentException When gameModel or gameView is null
   */
  public GameControllerImpl(GameWorld gameModel, GameView gameView)
      throws IllegalArgumentException {

    if (gameModel == null) {
      throw new IllegalArgumentException("Game model cannot be null");
    }

    if (gameView == null) {
      throw new IllegalArgumentException("Game view cannot be null");
    }

    this.gameModel = gameModel;
    this.gameView = gameView;
    this.commands = null;
    this.worldPath = "";
  }

  @Override
  public void startGame() {
    gameView.displayWelcomeScreen();
  }

  @Override
  public void updateWorldPath(String path) {
    this.worldPath = path;
  }

  @Override
  public void exit() {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPlayer(String name, String startingLocation, boolean isHuman) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyIsPressed(String keyName) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseIsClicked(int xcoord, int ycoord) {
    // TODO Auto-generated method stub

  }

  @Override
  public void actionIsPerformed(String actionName) {
    // TODO Auto-generated method stub

  }

}
