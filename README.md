# CS 5010 Semester Project

This repo represents the coursework for CS 5010, the Fall 2022 Edition!

**Name:** Pranith Rao Nayeneni

**Email:** nayeneni.p@northeastern.edu

**Preferred Name:** Pranith



### About/Overview

This project a board game which is inspired by the game 'Kill Doctor Lucky'. The main aim of the game is to kill the target character and the person who kills him wins the game. 



### List of Features

The features of the project are:
1. The project takes an input text file which contains the world specifications like names, number of rows and columns, spaces in the game and items in the game. For an example text file of how the specifications should be mentioned can be found in the res folder with the name "mansion.txt".
2. Creates a graphical image of the given world specifications.
3. Move the target character around the world from one space to other when a turn is completed.
4. Display information about a specified space like the name of the space, items in the space, neighbours of that space and the players that are currently present in that space. This can be done any number of times by the current player and is not considered as a turn.
5. Add a human or computer controlled player with a name and a starting space he starts from at the start of the game.
6. Move a player to a neighbouring space of the current space. This is considered as a turn.
7. Pick an item from the current space. There is also a limitation of 5 items for each player and every player has the same maximum limit for now. This is considered as a turn.
8. A player can look around to see his current space and neighbouring spaces of the current space. This is considered as a turn.
9. Current player can view the description of other players in the game. This is not considered as a turn.
10. A computer-controlled player automatically chooses its action during its turn.
11. We can specify the maximum number of turns that a game session can have while running the command below to start the game. The game exits when the maximum number of turns is completed.
This indicates that the game has ended in a draw and the target character survives.
12. A target's pet makes the space invisible to other players in which it is present in. This allows the players to move the pet to their desired location to use it to their advantage.
13. A target's pet will always traverse the world in DFS.
14. A player can attempt to kill the target character when they are in the same space as the target using either an item or their hand to poke the target in the eye. If an item is used, it is removed from the world.
15. A computer player always attacks the target when it is in the same space as the target character.
16. An attack becomes unsuccessful when it is seen by another player. Thus, no damage is done to the target character and the item is removed from the world.
17. When the target's health reaches zero the game ends and the last player who has attacked the target wins the game.


### How to Run

You can run the "World.jar" file in the "res" folder using the command `java -jar TheWorld.jar mansion.txt 5`. You can give your own text file as an input in this command and a number which represents the maximum number of turns for that particular session of the game.


### How to Use the Program

Once you start the program, the program will guide you with clues on how to use the program by providing different options you can possibly do at that time. The user can just follow those instructions provided over there to play the game.


### Example Runs

There are five example run files to show the different features of the project. All the example run files are present in the "res" folder. The name of the example run file and the features it shows is given below:

'exampleRun1.txt' shows:
- the target character's pet effect on the visibility of a space from neighboring spaces
- the player moving the target character's pet

'exampleRun2.txt' shows:
- a human-player making an attempt on the target character's life
- a human-player winning the game by killing the target character

'exampleRun3.txt' shows:
- a computer-controlled player making an attempt on the target character's life
- a computer-controlled player winning the game by killing the target character

'exapleRun4.txt' shows:
- the target character escaping with his life and the game ending

'exampleRun5.txt' shows:
- The DFS traversal of the pet.

'exampleRunOld.txt' shows:
- The features that were implemented till milestone2

### Design/Model Changes

Milestone 1:
1. Added a method moveTarget() in World interface to move the target to the next space.
2. Keeping track of the index of current space in which the target is present in WorldImpl class.
3. Diving single getRowsAndColumns() method to two seperate methods for making it easy to use.
4. Added a method getCurrentSpaceOfTarget() to retrieve the current space using the index which is being tracked in the WorldImpl class.
5. Added a method to get info of a space in World interface.
6. Added a method to drawImage() of the world in the World interface.
7. Added some methods in the Space interface to get the name and coordinates of the space.

Milestone 2:
1. Moved the getNeighbours() method from Space to World.
2. Storing the current space information of a target in the target's instance instead of storing it in thw world.
3. Changed passing and returning of objects to passing around strings for some methods from milestone 1. Like, determining neighbouring space of a space requires only the space name instead of the space object as parameter to the method.
4. Moved the method to move a target from World to Target.
5. Removed methods like getAllSpaces() and getAllPlayers() from the world.
6. Added a facade interface for the world which only exposes the required methods to the controller.
7. Changed the type of relationship between controller and command interface.

Milestone 3:
1. Added a command 'IsGameOver' to determine whether the game is completed or not.
2. Using an enum to store player related commands. 
3. Using a Hash Map to store the functionality to call each command and then calling each of the functionality when required from the hash map.
4. Moving 'getCurrentSpaceOfPet()' from the 'GameWorld'(Facade) interface to the 'World' interface.


### Assumptions

1. The maximum number of turns are for the whole game, and each count is for each player's turn.
2. The name and starting space of a computer player will be given as an input by the user.
3. Displaying information about a space and a player is possible any number of times for every turn by the current turn player and is not considered as a turn.
4. Drawing the image of the world automatically at the start of the game and is not an option for the user.
5. A player can carry a maximum of 5 items at a time and every player has the same limit for now.
6. There can be a maximum of three players in the game.
7. When a DFS traversal is fully completed by the Pet then it starts the DFS traversal again from considering the same node as the root node.
8. A player can enter into a room at the start of the game even when that room is invisible(It contains the pet).


### Limitations

1. There can be only 3 players in the game and there is no option for the user to configure this.
2. A player can carry a maximum of 5 items with with no option for the user to configure this.


### Citations

[Creating image file from graphics object](https://examples.javacodegeeks.com/desktop-java/imageio/create-image-file-from-graphics-object/) - Used the provided example for generating graphical images of the world specification.




