package Unit2;

import becker.robots.*;

/**
 * creates robot version 2 to add functionality
 * @author ayaanfaisal
 * @version 30 October 2024
 */

public class RobotVersion2 extends Robot {

	/**
	 * constructor class
	 * @param theCity - the city that is currently in use
	 * @param street - the "row" 
	 * @param avenue - the "column"
	 * @param direction - the direction it is facing
	 */
	public RobotVersion2 (City theCity, int street, int avenue, Direction direction){
		super(theCity, street, avenue, direction);
	}

	/**
	 * turn right using 3 turn lefts
	 */
	public void turnRight() {
		this.turnLeft();
		this.turnLeft();
		this.turnLeft();
	}

	/**
	 * move the amount of steps said
	 * @param steps - int amount of steps to move
	 */
	public void move(int steps) {
		// move the amount of steps
		for (int i = 0; i < steps; i++) {
			this.move();
		}
	}

	/**
	 * picks numThings
	 * @param numThings - pick the amount of things
	 */
	public void pickThing(int numThings) {
		// pick the amout of numThings
		for (int i = 0; i < numThings; i++) {
			this.pickThing();
		}
	}

	/**
	 * countThings in the intersection
	 * @return the number of things in the given intersection
	 */
	public int countThings() {
		int numThings = 0;

		// while theres stuff to pick, pick it and increment counter
		while (this.canPickThing()) {
			this.pickThing();
			numThings ++;
		}
		//put things back 
		for (int i = 0; i < numThings; i++) {
			this.putThing();
		}
		//return the amount of things counted
		return numThings;
	}

	/**
	 * pick all the things at the specified intersection 
	 */
	public void pickAllThings() {
		//countThings();
		for (int i = 0; i < countThings(); i++) {
			this.pickThing();
		}
	}

	/**
	 * put all the things in the intersection 
	 */
	public void putAllThings() {
		// put all the things where it is
		while (this.countThingsInBackpack() > 0) {
			this.putThing();
		}
		
	}

	}

