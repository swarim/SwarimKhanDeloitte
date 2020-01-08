package com.deloitte;

public class Car extends Vehicle implements Movable {
	private int tyres;
	private String type;
	private double cost;
	public int getTyres() {
		return tyres;
	}
	public void setTyres(int tyres) {
		this.tyres = tyres;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public void move() {
		System.out.println("Car is moving");
		
	}
	
}