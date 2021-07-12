package com.gt.gameofdice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is the main class to take user input and execute accordingly
 * @author vishnu
 *
 */
public class GameHandler {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of players ..");
		int numPlayer = sc.nextInt();
		
		System.out.println("Enter number of points to accumulate ..");
        int pointToAccumulate = sc.nextInt();
        
        List<Player> playerList = new ArrayList<>();
        Dice dice = new Dice();
        
        // add player with name and order
        for(int i = 1 ; i <= numPlayer ;i++ ) {
        	playerList.add(new Player(dice,"Player-"+i,i));
        }
        
        startGame(playerList,pointToAccumulate, sc);
        
	}

	/**
	 * Taking all players and execute it sequentially by taking order into account
	 * @param players
	 * @param pointToAccumulate
	 * @param sc
	 */
	public static void startGame(List<Player> players, int pointToAccumulate, Scanner sc) {
		
		int timesToRoll = 1;
		while(timesToRoll > 0 && timesToRoll <= players.size()) {
			
			for(Player player : players) {
				
				if(player.getRank() > 0) {
					System.out.println(player.getName()+" has already finished game and the rank is :"+player.getRank());
					continue;
				}
				
				System.out.println(player.getName()+" its your turn (press ‘r’ to roll the dice) ");
				String r = sc.next();
				if(r.equals("r") || r.equals("R")) {
					DiceService service = new DiceService(player);
					service.executeDice(pointToAccumulate);
					timesToRoll = service.maxRank;
				}
				else {
					 System.out.println("You have press wrong key, kindly press 'r' or 'R' again ");
				}
				 
			}
			System.out.println("Current Rank Table after rolling : ");
			printTable(players);
		}
		
	}
	
	/**
	 * To print in tabular format
	 * @param players
	 */
	public static void printTable(List<Player> players) {
		
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%10s %5s %5s", "Player Name", "Points", "Rank");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
	    for(Player player: players){
	        System.out.format("%10s %5d %5d",
	        		player.getName(), player.getPoints(), player.getRank());
	        System.out.println();
	    }
	    System.out.println("-----------------------------------------------------------------------------");

	}
}
