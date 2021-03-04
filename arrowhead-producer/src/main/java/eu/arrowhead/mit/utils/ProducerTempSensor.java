package eu.arrowhead.mit.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProducerTempSensor {
public double getTempFromSensor() throws IOException {
		// Raspberrycode
		FileReader fr = new FileReader("/home/pi/arrowhead/producer/PiLoggerTempValue/LogTemp.csv");
		BufferedReader br = new BufferedReader(fr); 		
		String line1 = br.readLine(); 
		return Double.parseDouble(line1); 
	}
	
}
