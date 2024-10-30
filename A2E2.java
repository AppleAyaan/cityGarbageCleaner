package Unit2;

import java.util.Random;

import becker.robots.*;

/**
 * cleans the city using RobotVersion2 with updated functionality
 * @author ayaanfaisal
 * @version 30 October 2024
 */

public class A2E2 {

	public static void main(String[] args) {
		// init variables
		City oakville = new City();
		Random rand = new Random();
		RobotVersion2 bob = new RobotVersion2(oakville, 1, 1, Direction.EAST);

		// settings
		oakville.showThingCounts(true);

		// Create a 2D array to store walls in a 4x5 grid
		Wall[][] walls = new Wall[4][5];

		// Create the top and bottom wall
		for (int col = 0; col < 5; col++) {
			walls[0][col] = new Wall(oakville, 1, col + 1, Direction.NORTH);
			walls[3][col] = new Wall(oakville, 4, col + 1, Direction.SOUTH);
		}


		// Create the left and right wall
		for (int row = 0; row < 4; row++) {
			walls[row][0] = new Wall(oakville, row + 1, 1, Direction.WEST);
			walls[row][4] = new Wall(oakville, row + 1, 5, Direction.EAST);
		}

		// Randomly place 5 things in the city
		for (int i = 0; i < 5; i++) {
			int street = rand.nextInt(4) + 1; // Random street from 1 to 4
			int avenue = rand.nextInt(5) + 1; // Random avenue from 1 to 5
			new Thing(oakville, street, avenue);
		}

		// Robot cleans the city by picking up things and stacking them in the top-left corner
		for (int street = 1; street <= 4; street++) {
			for (int avenue = 1; avenue <= 5; avenue++) {
				while (bob.canPickThing()) {
					bob.pickAllThings();
				}
				// Move to the next avenue unless it's the last avenue
				if (avenue < 5) {
					bob.move();
				}
			}
			// Move down to the next street and reset to start of street if it's not the last street
			if (street < 4) {
				if (bob.getDirection() == Direction.EAST) {
					bob.turnRight();
					bob.move();
					bob.turnRight(); 
				} else {
					bob.turnLeft();
					bob.move();
					bob.turnLeft();   
				}
			}
		}

		// Return to the top-left corner (1,1) and stack things
		bob.turnRight();
		while (bob.getStreet() > 1) {
			bob.move();
		}
		bob.turnLeft();
		while (bob.getAvenue() > 1) {
			bob.move();
		}

		// put all things in top left
		while (bob.countThingsInBackpack() > 0) {
			bob.putThing();
		}
	}
}
