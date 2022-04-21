package view;

import controller.Features;
import game.ReadOnlyModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
  private JLabel worldLabel;
  private List<ImageIcon> playerIcons;
  private JPanel worldPanel;
  private JLabel targetLabel;

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

    this.playerIcons = new ArrayList<ImageIcon>();
    for (int player = 0; player < 10; player++) {
      playerIcons.add(new ImageIcon(String.format("res/%d.png", player + 1)));
    }
    this.worldPanel = new JPanel();

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
   * Method used for creating the image of the world and setting it in the center
   * of GameView panel.
   * 
   * @throws IllegalStateException When the layout cannot be created
   */
  public void createWorldLayout() throws IllegalStateException {
    worldLabel = new JLabel(new ImageIcon("res/TheWorld.png"));
    worldLabel.setLayout(null);
    this.worldPanel.setLayout(new GridBagLayout());
    this.worldPanel.add(worldLabel);
    JScrollPane scrollableWorld = new JScrollPane(worldPanel);
    this.add(scrollableWorld, BorderLayout.CENTER);
  }

  /**
   * Update the position of the players in the world.
   */
  public void update() {
    // adding Target character.
    ImageIcon targetIcon = new ImageIcon("res/TargetCharacter.png");
    Image targetImage = targetIcon.getImage();
    Image newTargetImage = targetImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
    targetIcon = new ImageIcon(newTargetImage);
    this.targetLabel = new JLabel(targetIcon);
    this.targetLabel.setToolTipText("Target Character");
    List<String> turnInfo = this.dataModel.getTurnInfo();
    int[] targetCharacterCoordinates = this.dataModel.getCoordinates(turnInfo.get(3));
    int buffer = 30;
    int multiplicationFactor = 20;
    this.targetLabel.setBounds(targetCharacterCoordinates[3] * multiplicationFactor + buffer,
        targetCharacterCoordinates[0] * multiplicationFactor + buffer, 20, 20);
    worldLabel.add(targetLabel);

    // adding players.
    Map<String, List<Integer>> roomsInfo = new HashMap<>();
    String[][] playerList = dataModel.getAllPlayers();

    for (int playerIndex = 0; playerIndex < playerList.length; playerIndex++) {
      if (roomsInfo.containsKey(playerList[playerIndex][1])) {
        List<Integer> data = roomsInfo.get(playerList[playerIndex][1]);
        data.set(4, data.get(4) + 1);
        data.add(playerIndex);
      } else {
        List<Integer> data = Arrays
            .stream(this.dataModel.getCoordinates(playerList[playerIndex][1])).boxed()
            .collect(Collectors.toCollection(ArrayList::new));
        data.add(1);
        data.add(playerIndex);
        roomsInfo.put(playerList[playerIndex][1], data);
      }
    }

    for (Map.Entry<String, List<Integer>> entry : roomsInfo.entrySet()) {
      int dimensions = 20;
      Double roomAreay = Math
          .ceil(((entry.getValue().get(2) - entry.getValue().get(0)) * multiplicationFactor)
              / (dimensions));
      Double roomAreax = Math
          .ceil(((entry.getValue().get(3) - entry.getValue().get(1)) * multiplicationFactor)
              / dimensions);
      Double accomodateLength = Math.ceil(roomAreax * roomAreay);
      int accomodates = accomodateLength.intValue();
      int accomodatesx = 0;
      int accomodatesy = 0;
      int dimMultiplication = multiplicationFactor;

      if (entry.getValue().get(4) > accomodates) {
        dimensions = dimensions / 2;
        dimMultiplication = dimMultiplication / 2;
        roomAreay = Math
            .ceil(((entry.getValue().get(2) - entry.getValue().get(0)) * multiplicationFactor)
                / (dimensions));
        roomAreax = Math
            .ceil(((entry.getValue().get(3) - entry.getValue().get(1)) * multiplicationFactor)
                / dimensions);
      }

      for (int player = 5; player < entry.getValue().size(); player++) {

        ImageIcon playerIcon = this.playerIcons.get(entry.getValue().get(player));
        Image playerImage = playerIcon.getImage();
        Image newPlayerImage = playerImage.getScaledInstance(dimensions, dimensions,
            java.awt.Image.SCALE_SMOOTH);
        playerIcon = new ImageIcon(newPlayerImage);
        JLabel playerIconLabel = new JLabel(playerIcon);
        playerIconLabel.setToolTipText(playerList[entry.getValue().get(player)][0]);
        int refactoredx = entry.getValue().get(3) * multiplicationFactor + buffer
            - (accomodatesx * dimMultiplication);
        int refactoredy = entry.getValue().get(2) * multiplicationFactor + buffer
            - (accomodatesy * dimMultiplication);
        playerIconLabel.setBounds(refactoredx, refactoredy, dimensions, dimensions);

        if (accomodatesx + 1 >= roomAreax) {
          accomodatesy += 1;
          accomodatesx = 0;
        } else {
          accomodatesx += 1;
        }
        worldLabel.add(playerIconLabel);

      }
    }
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
