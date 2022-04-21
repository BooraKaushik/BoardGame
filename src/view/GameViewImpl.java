package view;

import controller.Features;
import game.ReadOnlyModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Creates a new Game frame by implementing Game View.
 */
public class GameViewImpl extends JFrame implements GameView {
  private static final long serialVersionUID = -2179965453492637485L;

  private final ReadOnlyModel dataModel;
  private final JMenu menu;
  private final JMenuItem newGame;
  private final JMenuItem newWorld;
  private final JMenuItem exit;
  private final JMenuBar menuBar;
  private final AddPlayerPanel addPlayerPanel;
  private final WelcomePanel welcomePanel;
  private final JFileChooser worldChooser;
  private final GameViewPanel gameViewPanel;

  /**
   * Constructor For GameViewImpl class, creates a frame.
   * 
   * @param title     String to appear on top of the window.
   * @param dataModel Read Only Model that is passed by the view.
   */
  public GameViewImpl(String title, ReadOnlyModel dataModel) {
    super(title);

    if (dataModel == null) {
      throw new IllegalArgumentException("Read only data model cannot be empty");
    }

    setMinimumSize(new Dimension(300, 300));
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());

    worldChooser = new JFileChooser();
    worldChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    FileNameExtensionFilter textFileFilter = new FileNameExtensionFilter("TEXT FILES", "txt",
        "text");
    worldChooser.setFileFilter(textFileFilter);

    menu = new JMenu("File");

    newGame = new JMenuItem("New Game");
    newWorld = new JMenuItem("New World");
    exit = new JMenuItem("Exit");

    exit.addActionListener(event -> {
      this.dispose();
    });

    menu.add(newGame);
    menu.add(newWorld);
    menu.add(exit);

    menuBar = new JMenuBar();
    menuBar.add(menu);
    setJMenuBar(menuBar);

    pack();
    setVisible(true);

    this.dataModel = dataModel;
    this.gameViewPanel = new GameViewPanel(dataModel);
    this.addPlayerPanel = new AddPlayerPanel(dataModel);
    this.welcomePanel = new WelcomePanel();
  }

  @Override
  public void displayWelcomeScreen(Features featuresController) throws IllegalArgumentException {

    if (featuresController == null) {
      throw new IllegalArgumentException("Features cannot be null");
    }

    this.newGame.setEnabled(true);
    this.newWorld.setEnabled(true);
    add(welcomePanel);
    welcomePanel.revalidate();
    this.welcomePanel.setFeatures(featuresController);
  }

  @Override
  public void displayAddPlayerScreen(Features featuresController) throws IllegalArgumentException {
    if (featuresController == null) {
      throw new IllegalArgumentException("Features cannot be null");
    }

    try {
      this.newGame.setEnabled(false);
      this.newWorld.setEnabled(false);
      gameViewPanel.createWorldLayout();
      remove(welcomePanel);
      add(addPlayerPanel);
      addPlayerPanel.revalidate();
      this.addPlayerPanel.setFeatures(featuresController);
    } catch (IllegalStateException ie) {
      displayPopupMessage(ie.getMessage(), "Error");
    }
  }

  @Override
  public void displayPopupMessage(String message, String type) {
    if (message == null) {
      throw new IllegalArgumentException("Message cant be null");
    }
    if (type == null) {
      throw new IllegalArgumentException("Type cant be null");
    }
    if ("Error".equals(type)) {
      JOptionPane.showMessageDialog(this, message, type, JOptionPane.ERROR_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(this, message, type, JOptionPane.PLAIN_MESSAGE);
    }
  }

  @Override
  public void displayGameScreen(Features featuresController) throws IllegalArgumentException {
    if (featuresController == null) {
      throw new IllegalArgumentException("Features cannot be null");
    }

    this.newGame.setEnabled(false);
    this.newWorld.setEnabled(false);
    remove(addPlayerPanel);
    remove(gameViewPanel);
    gameViewPanel.update();
    add(gameViewPanel);
    gameViewPanel.revalidate();
    this.gameViewPanel.setFeatures(featuresController);

  }

  @Override
  public String displayInputPopup(String title, String[] options) {
    if (title == null) {
      throw new IllegalArgumentException("Title cant be null");
    }
    if (options == null) {
      throw new IllegalArgumentException("Options cant be null");
    }
    if (options.length < 1) {
      throw new IllegalArgumentException("Options cant be Empty");
    }
    String output = (String) JOptionPane.showInputDialog(this,
        String.format("Choose an Option for %s", title), title, JOptionPane.INFORMATION_MESSAGE,
        null, options, options[0]);
    return output;
  }

  @Override
  public void setFeatures(Features featuresController) throws IllegalArgumentException {
    if (featuresController == null) {
      throw new IllegalArgumentException("Features controller cannot be null");
    }

    newGame.addActionListener(event -> {
      featuresController.startGameIsClicked();
    });

    newWorld.addActionListener(event -> {
      int response = worldChooser.showOpenDialog(this);
      if (response == JFileChooser.APPROVE_OPTION) {
        String mansionReadable;
        try {
          mansionReadable = Files
              .readString(Paths.get(worldChooser.getSelectedFile().getAbsolutePath()));
          featuresController.updateWorldSpecification(mansionReadable);
        } catch (FileNotFoundException e) {
          displayPopupMessage("File not found", "Error");
        } catch (IOException ie) {
          displayPopupMessage("Cannot read the content of file", "Error");
        }
      }
    });
  }

  @Override
  public void updateGameScreen() {
    gameViewPanel.update();
    gameViewPanel.repaint();
  }
}
