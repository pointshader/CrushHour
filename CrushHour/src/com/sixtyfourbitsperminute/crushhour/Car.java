package com.sixtyfourbitsperminute.crushhour;

//this is a comment

public class Car extends Vehicle {
	int length = 2;

	public Car (boolean direction, int[] position){
		this.horizontal = direction;
		this.position[0] = position[0];
		this.position[1] = position[1];
	}
}
