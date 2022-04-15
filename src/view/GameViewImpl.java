package view;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Creates a new Game frame by implementing Game View.
 */
public class GameViewImpl extends JFrame implements GameView {
  private static final long serialVersionUID = -2179965453492637485L;

  /**
   * Constructor For GameViewImpl class, creates a frame.
   * 
   * @param title String to appear on top of the window.
   */
  public GameViewImpl(String title) {
    super(title);

    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(null);

    JMenu menu = new JMenu("File");

    JMenuItem newGame = new JMenuItem("New Game");
    JMenuItem newWorld = new JMenuItem("New World");
    JMenuItem exit = new JMenuItem("Exit");

    menu.add(newGame);
    menu.add(newWorld);
    menu.add(exit);

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    setJMenuBar(menuBar);

    pack();
    setVisible(true);

  }

  @Override
  public void displayWelcomeScreen() {
    // TODO Auto-generated method stub

  }

  @Override
  public void displayAddPlayerScreen() {
    // TODO Auto-generated method stub

  }

  @Override
  public void displayPopupMessage(String message, String type) {
    // TODO Auto-generated method stub

  }

  @Override
  public void displayGameScreen() {
    // TODO Auto-generated method stub

  }

  @Override
  public String displayInputPopup(String title, String[] options) {
    // TODO Auto-generated method stub
    return null;
  }

}
