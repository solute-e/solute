package com.solute;

public class ELO {
	public static double R(double R1, double R2, double S) {
		double E1 = E(R1, R2);
		return R_(R1, E1, S);
	}
	
	private static double R_(double R, double E, double S) {
		return R + K.value() * (S - E);
	}
	
	private static double E(double R1, double R2) {
		return 1.0/(1 + Math.pow(10.0, (R1 - R2)/400.0));
	}
	
}
