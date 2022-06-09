package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester {

	public static void main(String[] args) {
		System.out.println(calculateNthPrime(10001));
	}
	public static int calculateNthPrime(int k) {
		if(k < 1)
		{
			throw new IllegalArgumentException();
		}
		// set value to the first prime
		int thePrime = 2;
		
		// find each prime after 2
		for(int i = 1; i < k; i++) {
			int counter = thePrime + 1;
			while(true) {
				// find the next prime
				if(isPrime(counter)) {
					thePrime = counter;
					break;
				}
				counter++;
			}
		}
		return thePrime;
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
