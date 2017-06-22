/*
* [Adventure].java
* Author: [Austin Wilburn]
* Submission Date: [11/7/2014]
*
* Purpose: The program is the main method of a text based game. 
* It tells user of the room they are in and takes user input for 
* commands. The user can go east, west, south, north, open chest,
* get key, unlock chest, get lamp, and light lamp upon certain 
* conditions. The game ends if the user gets eaten by a grue or 
* opens the chest.
* 
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/
import java.util.Scanner;
public class Adventure {

	public static void main(String[] args) {
		//setting up all the variables for the game
		Lamp theLamp = null;
		String command = "";
		Key theKey = null;
		int playerX = 0;
		int playerY = 0;
		//creating a new player starting at 0,0 with no lamp or key
		Player userPlayer = new Player(playerX, playerY, null, null);
		Chest theChest = null;
		//scanner for user input
		Scanner keyboard = new Scanner(System.in);
		Room theRoom;
		//new map
		Map advMap = new Map();
		
		System.out.println("Welcome to UGA Adventures: Episode 1");
		System.out.println("The Adventure of the Cave of Redundancy Adventure");
		System.out.println("By: Austin Wilburn");
		//setting the room to the 0,0 room
		theRoom = advMap.getRoom(playerX, playerY);
		//getting room description of the first room
		System.out.println(theRoom.getDescription());
		//creating boolean to keep track of the chest
		boolean isChestOpen = false;
		//loop until chest opens
		while(isChestOpen == false)
			{
			//take a command form the user
			command = keyboard.nextLine();
			//if command is look
			if (command.equalsIgnoreCase("look"))
				{
				//if the room is dark and the lamp is not present or it isnt lit
				if(theRoom.isDark() == true && (theLamp == null || theLamp.isLit() == false))
					{
					//warn user
					System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
				else
					{
					//get description of the room
					System.out.println(theRoom.getDescription());
					//if the lamp is in the room
					if(theRoom.getLamp() != null)
						{
						//tell user about lamp
						System.out.println("There is an old oil lamp that was made long ago here.");
						}
					//if the key is in the room
					if(theRoom.getKey() != null)
						{
						//tell user about key
						System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
						}
					//if the chest is in the room
					if(theRoom.getChest() != null)
						{
						//tell user about chest
						System.out.println("There is a large, wooden, massive, oaken chest here with the word 'CHEST' carved into it.");
						}
					//if the user can go east or north or south or west
					if(theRoom.canGoEast() || theRoom.canGoNorth() ||theRoom.canGoSouth() || theRoom.canGoWest())
						{
						//exits are:
						System.out.print("Exits are: ");
						}
					//if there is a path east
					if(theRoom.canGoEast())
						{
						System.out.println("east");
						}
					//if there is a path west
					if(theRoom.canGoWest())
						{
						System.out.println("west");
						}
					//if there is a path south
					if(theRoom.canGoSouth())
						{
						System.out.println("south");
						}
					//if there is a path north
					if(theRoom.canGoNorth())
						{
						System.out.println("north");
						}
					}
				}
			//if the user types east
			else if (command.equalsIgnoreCase("east"))
				{
				//if the room is dark and there is no lamp or it is not lit
				if (theRoom.isDark() && (theLamp == null || theLamp.isLit() == false))
					{
					//tell user he's been eaten and exit program
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					System.exit(0);
					}
				//else if there is a path to the east
				else if(theRoom.canGoEast())
					{
					//move player east by adding 1 to the Y value
					playerY += 1;
					//get new room
					theRoom = advMap.getRoom(playerX, playerY);
					//if the room is dark and there is no lamp or it is not lit
					if(theRoom.isDark() && (theLamp == null || theLamp.isLit() == false))
						{
						//warn user
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}
					else
						{
						//get new room description
						System.out.println(theRoom.getDescription());
						}
					}
				else
					{
					//error message
					System.out.println("Can't go that way.");
					}
				}
			//if the user types west
			else if (command.equalsIgnoreCase("west"))
				{
				//if the room is dark and there is no lamp or it is not lit
				if (theRoom.isDark() && (theLamp == null || theLamp.isLit() == false))
					{
					//tell user he's been eaten and exit program
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					System.exit(0);
					}
				//else if there is a path to the west
				else if(theRoom.canGoWest())
					{
					//move player west by subtracting 1 from the Y value
					playerY -= 1;
					//get new room
					theRoom = advMap.getRoom(playerX, playerY);
					//if the room is dark and there is no lamp or it is not lit
					if(theRoom.isDark() && (theLamp == null || theLamp.isLit() == false))
						{
						//warn user
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}
					else
						{
						//get new room description
						System.out.println(theRoom.getDescription());
						}
					}
				else
					{
					//error message
					System.out.println("Can't go that way.");
					}
		
				}
			//if the user types north
			else if (command.equalsIgnoreCase("north"))
				{
				//if the room is dark and there is no lamp or it is not lit
				if (theRoom.isDark() && (theLamp == null || theLamp.isLit() == false))
					{
					//tell user hes been eaten and exit program
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					System.exit(0);
					}
				//else if there is a path to the north
				else if(theRoom.canGoNorth())
					{
					//move player north by subtracting 1 from the X value
					playerX -= 1;
					//get new room
					theRoom = advMap.getRoom(playerX, playerY);
					//if the room is dark and there is no lamp or it is not lit
					if(theRoom.isDark() && (theLamp == null || theLamp.isLit() == false))
						{
						//warn user
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}
					else
						{
						//get new room description
						System.out.println(theRoom.getDescription());
						}
					}	
				else
					{
					//error message
					System.out.println("Can't go that way.");
					}
				}
			//if the user types south
			else if (command.equalsIgnoreCase("south"))
				{
				//if the room is dark and there is no lamp or it is not lit
				if (theRoom.isDark() && (theLamp == null || theLamp.isLit() == false))
					{
					//tell user hes been eaten and exit program
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					System.exit(0);
					}
				//else if there is a path to the south
				else if(theRoom.canGoSouth())
					{
					//move player south by adding 1 to the X value
					playerX += 1;
					//get new room
					theRoom = advMap.getRoom(playerX, playerY);
					//if the room is dark and there is no lamp or it is not lit
					if(theRoom.isDark() && (theLamp == null || theLamp.isLit() == false))
						{
						//warn user
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}
					else
						{
						//print room description
						System.out.println(theRoom.getDescription());
						}
					}
				else
					{
					//error message
					System.out.println("Can't go that way.");
					}
				}
			//if the user types get lamp
			else if (command.equalsIgnoreCase("get lamp"))
				{
				//if the lamp is not in the room
				if(theRoom.getLamp() == null)
					{
					//error message
					System.out.println("No lamp present.");
					}
				else
					{
					//call setlamp on userplayer and clear it from the room
					System.out.println("OK");
					userPlayer.setLamp(theRoom.getLamp());
					theLamp = theRoom.getLamp();
					theRoom.clearLamp();
					}
				}
			//if the user types get key
			else if(command.equalsIgnoreCase("get key"))
				{
				//if the key is not in the room
				if(theRoom.getKey() == null)
					{
					//error message
					System.out.println("No key present.");
					}
				else
					{
					//call setkey on userplayer and clear it from the room
					System.out.println("OK");
					userPlayer.setKey(theRoom.getKey());
					theKey = theRoom.getKey();
					theRoom.clearKey();
					}
				}
			//if the user types light lamp
			else if(command.equalsIgnoreCase("light lamp"))
				{
				//if the user has the lamp
				if(userPlayer.hasTheLamp())
					{
					//light the lamp
					theLamp.lightLamp();
					System.out.println("OK");
					}
				else
					{
					//error message
					System.out.println("You don't have the lamp to light.");
					}
				}
			//else if the user types open chest
			else if(command.equalsIgnoreCase("open chest"))
				{
				//set chest to the chest object in room
				theChest = theRoom.getChest();
				//if the chest is in the room and the player has they key
				if(theRoom.getChest() != null && userPlayer.hasTheKey())
					{
					//print chest contents and set isChestOpen to true
					System.out.println(theChest.getContents());
					isChestOpen = true;
					}
				//else if the chest is in the room and the chest is not unlocked
				else if(theRoom.getChest() != null && theChest.isLocked())
					{
					//error message
					System.out.println("The chest is locked.");
					}
				else 
					{
					//error message
					System.out.println("No chest present.");
					}
				}
			//if the user types unlock chest
			else if(command.equalsIgnoreCase("unlock chest"))
				{
				//set the chest to the room object chest
				theChest = theRoom.getChest();
				//if the user has the key and the chest is in the room
				if(theKey != null && theRoom.getChest() != null)
					{
					//unlock the chest
					theChest.unLock(theKey);
					System.out.println("OK");
					}
				//if the user doesn't have the key
				if(userPlayer.hasTheKey() == false)
					{
					//error message
					System.out.println("Need a key to do any unlocking!");
					}
				//if the chest isn't in the room
				if(theRoom.getChest() == null)
					{
					//error message
					System.out.println("No chest to unlock.");
					}
				}
			//if the user types something else
			else
				{
				//error message
				System.out.println("I'm sorry I don't know how to do that.");
				}
				
			}
	}
}

		


