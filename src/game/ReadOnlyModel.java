package game;

import java.util.List;

/**
 * Defines methods used by the View to read details directly from the model.
 *
 */
public interface ReadOnlyModel {

  /**
   * Fetches a list all the Players in the game. The Information of each player is
   * returned in the form of list following the order: Name, Location and Type.
   * 
   * @return the List that consists of all players' information.
   */
  public String[][] getAllPlayers();

  /**
   * Returns the information of a player like name of the player, in which space
   * he is currently present in and the items he is carrying as a string.
   * 
   * @param name Name of the player
   * @return The information of the specified player
   * @throws IllegalArgumentException when name is null or an empty string or when
   *                                  player does not exist in the world
   */
  public String getPlayerInfo(String name) throws IllegalArgumentException;

  /**
   * Returns the name, type and space of the current turn player and the target's
   * current space name as a string in the format:
   * Name,Type,SpaceName,TargetSpaceName.
   * 
   * @return A string in the format: Name,Type,SpaceName,TargetSpaceName
   */
  public String getTurnInfo();

  /**
   * Generates a List that contains names of all the spaces that can be used while
   * prompting user to select a landing location.
   * 
   * @return a list that contains all the space names.
   */
  public String[] getAllSpaces();

}
