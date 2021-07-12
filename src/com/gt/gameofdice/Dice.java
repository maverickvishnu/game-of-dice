package com.gt.gameofdice;

/**
 * This class is responsible to roll a dice and generate output
 * between 1 and 6
 * @author vishnu
 *
 */
public class Dice {
	
	/**
	 * Roll a dice and display output between 1 to 6
	 * @return
	 */
	public int rollDice() {
		
		return 1 + (int)(6 * Math.random());
	}

}
