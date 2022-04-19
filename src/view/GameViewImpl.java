package view;

import controller.Features;
import game.ReadOnlyModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

  /**
   * Constructor For GameViewImpl class, creates a frame.
   * 
   * @param title String to appear on top of the window.
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
    this.addPlayerPanel = new AddPlayerPanel(dataModel);
    this.welcomePanel = new WelcomePanel();
  }

  @Override
  public void displayWelcomeScreen() {
    add(welcomePanel);
    welcomePanel.revalidate();
  }

  @Override
  public void displayAddPlayerScreen() {
    remove(welcomePanel);
    add(addPlayerPanel);
    addPlayerPanel.revalidate();
  }

  @Override
  public void displayPopupMessage(String message, String type) throws IllegalArgumentException {
    // TODO Auto-generated method stub

  }

  @Override
  public void displayGameScreen() {
    // TODO Auto-generated method stub

  }

  @Override
  public String displayInputPopup(String title, String[] options) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setFeatures(Features featuresController) throws IllegalArgumentException {
    if (featuresController == null) {
      throw new IllegalArgumentException("Features controller cannot be null");
    }
    
    this.welcomePanel.setFeatures(featuresController);

    newGame.addActionListener(event -> {
      featuresController.startGameIsClicked();
    });

    newWorld.addActionListener(event -> {
      int response = worldChooser.showOpenDialog(this);
      if (response == JFileChooser.APPROVE_OPTION) {
        Readable mansionReadable;
        try {
          mansionReadable = new FileReader(worldChooser.getSelectedFile());
          featuresController.updateWorldFile(mansionReadable);
        } catch (FileNotFoundException e) {
          // TODO display error message
        }
      }
    });
  }

}
