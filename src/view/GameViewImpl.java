package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GameViewImpl extends JFrame implements GameView {

  public GameViewImpl(String title) {
    super(title);

    setMinimumSize(new Dimension(300, 300));
    setLocation(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());

    JMenu menu = new JMenu("File");
    JMenuBar menuBar = new JMenuBar();

    JMenuItem newGame = new JMenuItem("New Game");
    JMenuItem newWorld = new JMenuItem("New World");
    JMenuItem exit = new JMenuItem("Exit");

    menu.add(newGame);
    menu.add(newWorld);
    menu.add(exit);

    menuBar.add(menu);
    setJMenuBar(menuBar);

    JPanel wp = new WelcomePanel();
    add(wp);

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
