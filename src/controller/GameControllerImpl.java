package controller;

import game.GameWorld;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
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

  }

  private String executeCmd(GameWorld model, Command currentCommand, List<String> args) {
    if (model == null) {
      throw new IllegalArgumentException("model cant be null");
    }
    if (currentCommand == null) {
      throw new IllegalArgumentException("Command cant be null");
    }
    if (args == null) {
      throw new IllegalArgumentException("Arguments cant be null");
    }

    Function<List<String>, GameCommand> cmd;
    String result = "";
    cmd = commands.get(currentCommand);
    GameCommand comandOut = cmd.apply(args);
    if (comandOut != null) {
      comandOut.execute(model);
      result = comandOut.getOutput();
    }
    return result;
  }

  @Override
  public void startGame() {
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
    if (name == null) {
      throw new IllegalArgumentException("Name Cant be null");
    }
    if (startingLocation == null) {
      throw new IllegalArgumentException("Starting Location Cant be null");
    }
    executeCmd(gameModel, Command.ADD_PLAYER,
        new ArrayList<String>(Arrays.asList(name, startingLocation, isHuman ? "true" : "false")));

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
      if (worldSpecification.length() != 0) {
        executeCmd(gameModel, Command.SET_WORLD,
            new ArrayList<String>(Arrays.asList(worldSpecification)));
      }
      executeCmd(gameModel, Command.DRAW_IMAGE, new ArrayList<String>());
      gameView.displayAddPlayerScreen();
      gameView.displayGameScreen();
    } catch (IllegalArgumentException | NoSuchElementException e) {
      gameView.displayPopupMessage(e.getMessage(), "Error");
    }
  }

  @Override
  public void showGameScreen() {
    gameView.displayGameScreen();
  }

}
