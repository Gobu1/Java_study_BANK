package com.sh.start.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Car {
	
//	1.
	//Car는 Engine이 없으면 x
	//Car는 Engine에 의존적이다.
	//private Engine engine = new Engine();
	
//	2.
	// Car car = new Car();
	// car.engine = new engine;
	private Engine engine;
	private Wheel leftWheel;
	private Wheel rightWheel;
	
//	3.
//	public Car() {
//		this.engine=new Engine();
//	}
	
	public Car(Wheel leftWheel, Wheel rightWheel) {
		this.leftWheel=leftWheel;
		this.rightWheel=rightWheel;
	}
	//Engine engine = new engine();
	//Car car = new car(engine);

	
	
	//4.
//	{
//		this.engine=new Engine();
//	}
	
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	//5
	//Car car = new car();
	//Engine engine = new Engine();
	//car.setEngine(engine);
	
	
	
	
	
	
}
