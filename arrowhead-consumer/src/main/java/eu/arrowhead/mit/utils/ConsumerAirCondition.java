package eu.arrowhead.mit.utils;


import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class ConsumerAirCondition {
	// this class will be extended with the code for the air conditioner
	boolean status = false; 
	
	public ConsumerAirCondition() {}
	
	public ConsumerAirCondition(boolean airCondition) { 
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String turnAirConditionOn() { 
		String ret = "ON"; 
		try {
			if(isStatus() == false) {
				Runtime.getRuntime().exec("/home/pi/PowerPlug/sem-6000.exp AC --on");
			}
			setStatus(true); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ret; 
	}
	
	public String turnAirConditionOff() {
		String ret = "OFF"; 
		try {
			if(isStatus() == true) {
			Runtime.getRuntime().exec("/home/pi/PowerPlug/sem-6000.exp AC --off");
			}
			setStatus(false); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ret; 
	}
}