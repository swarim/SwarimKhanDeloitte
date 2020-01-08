package com.deloitte;

public class Truck extends Vehicle implements Movable {

	@Override
	public void move() {
		System.out.println("Truck is moving");	
	}
}
