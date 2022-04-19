package controller;

import game.GameWorld;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import view.GameView;

/**
 * A class implementation of the GameController interface which is used to take
 * inputs from the view, send commands to the model and send the corresponding
 * output back to the view.
 */
public class GameControllerImpl implements GameController, Features {

  private final GameWorld gameModel;
  private final GameView gameView;
  private Readable mansionReadable;
  private final Map<Command, Function<List<String>, GameCommand>> commands;
  private GameCommand currentCommand;

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

    gameView.setFeatures(this);

    this.gameModel = gameModel;
    this.gameView = gameView;
    this.commands = new HashMap<Command, Function<List<String>, GameCommand>>();
    this.mansionReadable = null;
    this.currentCommand = null;
  }

  private String executeCmd(GameWorld model) {
    String result = "";
    if (currentCommand != null) {
      currentCommand.execute(model);
      result = currentCommand.getOutput();
      currentCommand = null;
    }
    return result;
  }

  @Override
  public void startGame() {

    commands.put(Command.MOVE, (list) -> {
      return new MovePlayer(list.get(0));
    });

    commands.put(Command.PICK_ITEM, (list) -> {
      return new PickItem(list.get(0));
    });

    commands.put(Command.ADD_PLAYER, (list) -> {
      return new AddPlayer(list.get(0), list.get(1), "true".equals(list.get(2)));
    });

    commands.put(Command.ATTACK_TARGET, (list) -> {
      return new AttackTarget(list.get(0));
    });

    commands.put(Command.DISPLAY_SPACE_INFO, (list) -> {
      return new DisplayInfoOfSpace(list.get(0));
    });

    commands.put(Command.DRAW_IMAGE, (list) -> {
      return new DrawImage();
    });

    commands.put(Command.IS_GAME_OVER, (list) -> {
      return new IsGameOver();
    });

    commands.put(Command.LOOK_AROUND, (list) -> {
      return new LookAround();
    });

    commands.put(Command.MOVE_PET, (list) -> {
      return new MovePet(list.get(0));
    });

    commands.put(Command.PERFORM_COMPUTER_ACTION, (list) -> {
      return new PerformComputerAction();
    });

    gameView.displayWelcomeScreen();
  }

  @Override
  public void updateWorldFile(Readable mansionReadable) throws IllegalArgumentException {
    if (mansionReadable == null) {
      throw new IllegalArgumentException("File readable cannot be null");
    }

    this.mansionReadable = mansionReadable;
  }

  @Override
  public void exit() {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPlayer(String name, String startingLocation, boolean isHuman)
      throws IllegalArgumentException {
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
  public void actionIsPerformed(String actionName) throws IllegalArgumentException {
    // TODO
  }

  @Override
  public void startGameIsClicked() {
    if (mansionReadable != null) {
      // TODO use commands here
      gameModel.setWorldSpecification(mansionReadable);
    }

    gameView.displayAddPlayerScreen();
  }

}
