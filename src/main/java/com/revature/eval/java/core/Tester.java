package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester {

	public static void main(String[] args) {
		int[] set = {3, 5};
		System.out.println(getSumOfMultiples(20, set));
	}
	public static int getSumOfMultiples(int i, int[] set) {
		int total = 0;
		// for all the numbers up to the max
		for(int j = 1; j < i; j++) {
			// cycle through the sets
			for(int k = 0; k < set.length; k++) {
				if(j % set[k] == 0) {
					total += j;
					System.out.println("Total after adding " + j + " : " + total);
					break;
				}
			}
		}
		return total;
	}
}
