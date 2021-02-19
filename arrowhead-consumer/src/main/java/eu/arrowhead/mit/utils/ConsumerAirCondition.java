package eu.arrowhead.mit.utils;


import org.springframework.stereotype.Component;

@Component
public class ConsumerAirCondition {
	// this class will be extended with the code for the air conditioner
	
	
	public ConsumerAirCondition() {}
	
	public ConsumerAirCondition(boolean airCondition) { 
	}
	
	public void setAirCondition(boolean airCondition) { 
	}
	
	public String turnAirConditionOn() { 
		setAirCondition(true); 
		String ret = "ON"; 
		return ret; 
	}
	
	public String turnAirConditionOff() {
		setAirCondition(true); 
		String ret = "OFF"; 
		return ret; 
	}
}