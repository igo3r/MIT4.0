package eu.arrowhead.mit.utils;

import org.springframework.stereotype.Component;

@Component
public class ProducerAirCondition {
	
	public ProducerAirCondition() {}
	
	public ProducerAirCondition(boolean airCondition) { 
	}
	
	public void setAirCondition(boolean airCondition) { 
	}
	
	public String turnAirConditionOn() { 
		setAirCondition(true); 
		String ret = "ON"; 
		return ret; 
	}
}
