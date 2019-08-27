package com.di;

public class ChairMan {
	String carColor = null;
	int speed = 0;
	int wheelNum = 0;
	
	public ChairMan() {
	}
	
	public ChairMan(String carColor, int speed) {
		this.carColor = carColor;
		this.speed = speed;
	}
	
	public ChairMan(String carColor, int speed,int wheelNum) {
		this.carColor = carColor;
		this.speed = speed;
		this.wheelNum = wheelNum;
	}

	public String toString() {
		return this.carColor+" is her personal color. "
					+"she is as fast as "+this.speed
					+", and she has "+this.wheelNum+" wheels";
	}
	

}
