package com.deloitte.movable;

import com.deloitte.Bus;
import com.deloitte.Car;
import com.deloitte.Movable;
import com.deloitte.Truck;
import com.deloitte.Van;

public class MovableFactory {
	//called factory method
	public static Movable getInstance(String type) {
		System.out.println(type);
		type=type.toLowerCase();
		Movable m =null;
		switch(type) {
		case "car":
			m = new Car();
			break;
		case "bus":
			m = new Bus();
			break;
		case "van":
			m = new Van();
			break;
		case "truck":
			m = new Truck();
			break;
			default:
				//m= new UnknownVehicle();
				// local, inner, anonymous class
				m=new Movable() {
					@Override
					public void move() {
						System.out.println("Anonymous vehicle moving");
				}
			};
				break;
		}
				return m;
	}
private static class UnknownVehicle implements Movable {

	@Override
	public void move() {
		System.out.println("Unknown Vehicle moving");
		}
}
}
