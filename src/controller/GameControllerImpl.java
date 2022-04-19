package controller;

import game.GameWorld;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
  private String worldSpecification;
  private final Map<Command, Function<List<String>, GameCommand>> commands;
  private GameCommand currentCommand;
  private List<String> inputList;

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
    this.worldSpecification = "";
    this.currentCommand = null;
    this.inputList = new ArrayList<>();
  }

  private String executeCmd(GameWorld model) {
    String result = "";
    if (currentCommand != null) {
      currentCommand.execute(model);
      result = currentCommand.getOutput();
      currentCommand = null;
    }
    inputList.clear();
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

    commands.put(Command.SET_WORLD, (list) -> {
      return new SetWorld(new StringReader(list.get(0)));
    });

    gameView.displayWelcomeScreen();
  }

  @Override
  public void updateWorldSpecification(String worldSpecification) throws IllegalArgumentException {
    if (worldSpecification == null) {
      throw new IllegalArgumentException("World string cannot be null");
    }

    if (worldSpecification.length() == 0) {
      throw new IllegalArgumentException("World string cannot be empty");
    }

    this.worldSpecification = worldSpecification;
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
    try {
      Function<List<String>, GameCommand> cmd;

      if (worldSpecification.length() != 0) {
        cmd = commands.get(Command.SET_WORLD);
        inputList.add(worldSpecification);
        currentCommand = cmd.apply(inputList);
        executeCmd(gameModel);
      }

      cmd = commands.get(Command.DRAW_IMAGE);
      currentCommand = cmd.apply(inputList);
      executeCmd(gameModel);

      gameView.displayAddPlayerScreen();
      gameView.displayGameScreen();
    } catch (IllegalArgumentException | NoSuchElementException e) {
      gameView.displayPopupMessage(e.getMessage(), "Error");
    }
  }

}
