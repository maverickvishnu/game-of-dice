package com.gt.gameofdice;

/**
 * This class will roll and update result according to output
 * it will also set penalty
 * @author vishn
 *
 */
public class Player {

	private int points;
	private boolean isPenalty;
	private int preDicePoint;
	private int rank;
	private Dice dice;
	private String name;
	private int order;

	public Player(Dice dice, String name, int order) {
		this.dice = dice;
		this.name = name;
		this.order = order;
	}
	public int getPoints() {
		return points;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public boolean isPenalty() {
		return isPenalty;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Logic to roll a dice and handle scenarios if dice output is 1 or 6
	 * @author vishnu
	 */
	
	public void roll() {
		
		int dicePoint = dice.rollDice();
		System.out.println("Dice output after rolling : "+dicePoint);
		this.points = this.points + dicePoint;
		
		if(dicePoint == 1 && preDicePoint == 1) {
			this.isPenalty = true;
		}	
		else if(dicePoint == 6) {
			dicePoint = dice.rollDice();
			this.points = this.points + dicePoint;
			this.preDicePoint = dicePoint;
		}
		 
		this.preDicePoint = dicePoint;
	}
	
}
