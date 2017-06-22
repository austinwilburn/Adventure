/*
* [Player].java
* Author: [Austin Wilburn]
* Submission Date: [11/7/2014]
*
* Purpose: The program is the player class of a text based game. 
* It stores the key, the lamp, the players position, if the player
* had the lamp, and if the player has the key. It has methods to 
* construct the player, get the key, get the lamp, check if user
* has the lamp, and check if user has the key.
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
public class Player {
	//variables for player
private int xValue;
private int yValue;
private Key playerKey;
private Lamp playerLamp;
private boolean hasTheLamp;
private boolean hasTheKey;
//player constructor
public Player(int x, int y, Key theKey, Lamp theLamp){
	//sets the variables
	xValue = x;
	yValue = y;
	playerKey = theKey;
	playerLamp = theLamp;
}
public void setKey(Key theKey) {
	//set players key to the key in the argument
	playerKey = theKey;
}

public void setLamp(Lamp theLamp){
	//set players lamp to the lamp in the argument
	playerLamp = theLamp;
}
public boolean hasTheLamp(){
	//if player doesn't have the lamp
	if (playerLamp == null)
		hasTheLamp = false;
	//if player does have lamp
	else
		hasTheLamp = true;
	return hasTheLamp;
}
public boolean hasTheKey(){
	//if player doesn't have the key
	if (playerKey == null)
		hasTheKey = false;
	//if player does have the key
	else
		hasTheKey = true;
	return hasTheKey;
}
}
