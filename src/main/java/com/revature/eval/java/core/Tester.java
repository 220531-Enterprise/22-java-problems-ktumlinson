package com.revature.eval.java.core;

public class Tester {

	public static void main(String[] args) {
		double mph = toMilesPerHour(1.06934);
		
		System.out.println(printConversion(1.5));
	}

	public static long toMilesPerHour(double kilometersPerHour) {
		// check the kph
		
		// if less than 0 return -1
		if(kilometersPerHour < 0) {return -1;}
		
		// kph to mph = kph / 1.609
		return Math.round(kilometersPerHour / 1.609);
	}
	
	public static String printConversion(double kilometersPerHour) {
		// use speed converter for kph
		double mph = toMilesPerHour(kilometersPerHour);
		
		// if the speed converter returns -1 return "Invalid Value"
		if(mph < 0) {return "Invalid Value";}
		
		// print the format "XX km/h = YY mi/h"
		return kilometersPerHour + " km/h = " + String.format("%.0f", mph) + " mi/h";
	}
}
