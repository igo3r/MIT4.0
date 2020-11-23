package eu.arrowhead.mit.utils;

import org.springframework.stereotype.Component;

import eu.arrowhead.common.mit.MITConstants;

@Component
public class ProducerSensorControl {

	public String getSensorDataArray(int runs, int currentRun) {
		int runBound = (runs/2); 
		double temperature = 0.0;
		if (runs % 2 != 0){
			return "Please enter an even number between 1 and 1000!";
		} else if (currentRun > (runBound * 2)) {
			return "Please enter for currentRun a number which is below or equal " + runBound*2; 
		} else {
			if (currentRun < runBound || currentRun == runBound) {
				temperature = MITConstants.VALUES_TEMPERATURE_LOW[currentRun -1];
			} else {
				temperature = MITConstants.VALUES_TEMPERATURE_HIGH[currentRun - runBound -1];
			}
			return  Double.toString(temperature);		
		}
	}
}
