package com.gt.gameofdice;

/**
 * This is a service class responsible to all a dice and update points 
 * it also check for penaly to skip next turn
 * @author vishnu
 *
 */
public class DiceService {

	private Player player;
	public static int maxRank;
	public DiceService(Player player) {
		this.player = player;
	}
	
	/**
	 * Roll a dice , check for penalty and update rank
	 * @param pointsToAccumulate
	 */
	public void executeDice(int pointsToAccumulate) {
		
		player.roll();
		int totalPoint = player.getPoints();
		System.out.println("Total points achieved by "+player.getName()+" "+totalPoint);
		
		if(player.isPenalty()) {
			System.out.println("Skipping turn of the player because of penalty ");
			return;
		}
		
		if(totalPoint >= pointsToAccumulate) {
			player.setRank(maxRank+1);
		}
	}
}
