/*
* [Chest].java
* Author: [Austin Wilburn]
* Submission Date: [11/7/2014]
*
* Purpose: The program is the chest class of a text based game. 
* It stores whether the chest is locked, the chest key, and the 
* chest contents. It has methods to lock and store the key, unlock
* the chest, check to see if the chest is unlocked, get the contents
* of the chest, and store contents for the chest.
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
public class Chest {

	/*
	 * Instance variables go here, you're responsible for choosing
	 * which ones are needed and naming them
	 */
	private boolean isChestLocked;
	private Key chestKey;
	private String chestContents;
	/**
	 * This method is used by the Map class, you won't need to call it yourself
	 * It should result in this chest being locked and storing which key locked it.
	 */
	public void lock(Key theKey) {
		//set isChestlocked to true and set the key
		isChestLocked = true;
		chestKey = theKey;
		
	}
	
	/**
	 * If theKey is the same key that was used to lock this chest, then
	 * the chest is unlocked.  Otherwise this method does nothing.
	 */
	public void unLock(Key theKey) {
	//if it is the right key
	if(theKey.equals(chestKey))
		//set ischestlocked to false
		isChestLocked = false;
	}
	
	/**
	 * Should return true if the chest is locked, false otherwise
	 */
	public boolean isLocked() {
		return isChestLocked;
	}
	
	/**
	 * Return a string describing the contents of the chest.
	 */
	public String getContents() {
	return chestContents;
	}
	
	/**
	 * Set the contents of the chest to this string.  You should not need to call
	 * this method in your program (though you have to implement it anyway).
	 */
	public void setContents(String contents) {
		chestContents = contents;
	}
	
	
	
}
