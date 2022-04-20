package view;

import controller.Features;
import game.ReadOnlyModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Creates a Panel which Displays Game Layout, Results of a turn and turn
 * information on the screen .
 *
 */
public class GameViewPanel extends JPanel {

  private static final long serialVersionUID = 7525139079837574057L;

  private ReadOnlyModel dataModel;

  /**
   * Constructor for GameViewPanel to create a new Game Screen.
   * 
   * @param dataModel Read Only Model that is passed by the view.
   */
  public GameViewPanel(ReadOnlyModel dataModel) {

    if (dataModel == null) {
      throw new IllegalArgumentException("Data Model cant be Null");
    }
    this.dataModel = dataModel;
    this.setLayout(new BorderLayout(20, 15));
    this.setBackground(new Color(76, 17, 49));

    // EAST LAYOUT
    JPanel eastLayout = new JPanel();
    eastLayout.setLayout(new BoxLayout(eastLayout, BoxLayout.Y_AXIS));
    JLabel turnInfo = new JLabel("Lorem Ipsum");
    turnInfo.setPreferredSize(new Dimension(200, 100));
    turnInfo.setBackground(Color.GRAY);
    turnInfo.setBounds(0, 0, 100, 100);
    eastLayout.add(turnInfo);
    JLabel resultInfo = new JLabel("Lorem Ipsum");
    resultInfo.setPreferredSize(new Dimension(200, 100));
    resultInfo.setBackground(Color.GRAY);
    resultInfo.setBounds(0, 0, 100, 100);
    eastLayout.add(resultInfo);
    this.add(eastLayout, BorderLayout.EAST);

  }

  /**
   * Method used for creating the image of the world and setting it in the centre
   * of GameView panel.
   * 
   * @throws IllegalStateException When the layout cannot be created
   */
  public void createWorldLayout() throws IllegalStateException {
    try {
      BufferedImage worldImage = ImageIO.read(new File("res/TheWorld.png"));
      JLabel worldIcon = new JLabel(new ImageIcon(worldImage));
      JScrollPane scrollableWorld = new JScrollPane(worldIcon);
      this.add(scrollableWorld, BorderLayout.CENTER);
    } catch (IOException ioe) {
      throw new IllegalStateException("Cannot Read the Layout");
    }
  }

  /**
   * Update the position of the players in the world.
   * 
   * @throws IllegalStateException When the update cannot happen
   */
  public void update() throws IllegalStateException {

  }

  /**
   * Sets the features of the controller as callbacks to event listeners that this
   * panel can use.
   * 
   * @param featuresController The features controller that the panel uses
   * @throws IllegalArgumentException When features controller is null
   */
  public void setFeatures(Features featuresController) throws IllegalArgumentException {
    if (featuresController == null) {
      throw new IllegalArgumentException("Features controller cannot be null");
    }

  }

}
