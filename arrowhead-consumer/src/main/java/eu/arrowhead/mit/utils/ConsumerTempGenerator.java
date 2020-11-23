package eu.arrowhead.mit.utils;

import java.util.Random;

import eu.arrowhead.common.mit.MITConstants;

public class ConsumerTempGenerator {
	double maxValue = MITConstants.MAX_MEASUREMENT_VALUE;
	double minValue = MITConstants.MIN_MEASUREMENT_VALUE;

	public double getTemperature() {
		Random r = new Random();
		double value = (r.nextInt((int) ((maxValue - minValue) * 10 + 1)) + minValue * 10) / 10.0;
		return value;
	}

	public double getTemperatureArray(int runs, int runBound) {
		double temperature = 0.0;
		if (runs < runBound) {
			temperature = MITConstants.VALUES_TEMPERATURE_LOW[runs];
		} else {
			temperature = MITConstants.VALUES_TEMPERATURE_HIGH[runs - runBound];
		}
		return temperature;
	}

}
