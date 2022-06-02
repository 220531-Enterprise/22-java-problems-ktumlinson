package com.revature.eval.java.core;

public class Tester {

	public static void main(String[] args) {
		double mph = toMilesPerHour(1.06934);
		
		System.out.println(mph);
	}

	public static long toMilesPerHour(double kilometersPerHour) {
		// check the kph
		
		// if less than 0 return -1
		if(kilometersPerHour < 0) {return -1;}
		
		// kph to mph = kph / 1.609
		return Math.round(kilometersPerHour / 1.609);
	}
}
