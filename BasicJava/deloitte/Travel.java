package com.deloitte;

public class Travel {

	public static void main(String[] args) {
		Car c1 = new Car();
		c1.setTyres(5);
		System.out.println("Car tyres = " + c1.getTyres());
		Bus b1 = new Bus();
		b1.setTyres(7);
		System.out.println("Bus tyres = " + b1.getTyres());
		Van v = new Van();
		v.move();
		Truck v1 = new Truck();
		v1.move();
		Movable m = new Car();
		m.move();
	}

}
