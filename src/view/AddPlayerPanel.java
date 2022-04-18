package view;

import game.ReadOnlyModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Creates a Panel which Displays players in the game and allows users to add
 * players.
 *
 */
public class AddPlayerPanel extends JPanel {

  private static final long serialVersionUID = 7525139079837574057L;

  private ReadOnlyModel dataModel;

  /**
   * Constructor of AddPlayerPanel to create AddPlayer Screen.
   * 
   * @param dataModel Read Only Model that is passed by the view.
   */
  public AddPlayerPanel(ReadOnlyModel dataModel) {
    if (dataModel == null) {
      throw new IllegalArgumentException("Data Model cant be Null");
    }
    this.dataModel = dataModel;
    this.setLayout(new BorderLayout(20, 15));
    this.setBackground(new Color(76, 17, 49));

    // NORTH LAYOUT

    JLabel heading = new JLabel("<html><font size='6'>List Of Players:</font></html>");
    heading.setForeground(new Color(68, 89, 165));

    JPanel north = new JPanel();
    north.setLayout(new BorderLayout());
    north.setBackground(new Color(76, 17, 49));
    north.add(heading, BorderLayout.CENTER);
    north.setBorder(new EmptyBorder(10, 50, 10, 10));

    add(north, BorderLayout.NORTH);

    // CENTER LAYOUT
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(10, 3, 25, 10));
    for (List<String> data : this.dataModel.getAllPlayers()) {
      center.add(
          new JLabel(String.format("<html><font size='3'>Name : %s</font></html>", data.get(0))));
      center.add(new JLabel(
          String.format("<html><font size='3'>Location : %s</font></html>", data.get(1))));
      center.add(
          new JLabel(String.format("<html><font size='3'>Type : %s</font></html>", data.get(2))));
    }
    center.setBackground(new Color(255, 242, 205));
    center.setBorder(new EmptyBorder(100, 10, 100, 10));

    add(center, BorderLayout.CENTER);

    // SOUTH LAYOUT
    JPanel south = new JPanel();
    south.setLayout(new BorderLayout());
    south.setBackground(new Color(76, 17, 49));
    south.setBorder(new EmptyBorder(100, 100, 100, 100));
    JPanel buttonPane = new JPanel();
    buttonPane.setLayout(new BorderLayout());
    buttonPane.setBackground(new Color(76, 17, 49));
    JButton addPlayers = new JButton("+ Add Players");
    buttonPane.add(addPlayers, BorderLayout.WEST);
    JButton startGame = new JButton("Start Game >");
    buttonPane.add(startGame, BorderLayout.EAST);
    south.add(buttonPane, BorderLayout.CENTER);

    add(south, BorderLayout.SOUTH);

    // WEST LAYOUT
    JPanel west = new JPanel();
    west.setLayout(new BorderLayout());
    west.setBackground(new Color(76, 17, 49));
    west.setBorder(new EmptyBorder(0, 20, 0, 20));

    add(west, BorderLayout.WEST);

    // EAST LAYOUT
    JPanel east = new JPanel();
    east.setLayout(new BorderLayout());
    east.setBackground(new Color(76, 17, 49));
    east.setBorder(new EmptyBorder(0, 20, 0, 20));

    add(east, BorderLayout.EAST);

  }

}
