package com.deloitte;

public class Travel {
public static void main(String args[]) {
	Car c1=new Car();
	c1.setTyres(4);
	System.out.println("Car tyres="+c1.getTyres());
	Bus b1=new Bus();
	b1.setTyres(6);
	System.out.println("Bus tyres="+b1.getTyres());
	b1.move();
	Vehicle v=new Van();
	c1.move();
	Vehicle v1=new Truck();
	v1.setTyres(8);
	System.out.println("Truck tyres="+v1.getTyres());
	b1.move();
	Movable m=new Car();
	m.move();
	}
}
