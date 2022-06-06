package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		System.out.println(isArmstrongNumber(5));
	}
	public static boolean isArmstrongNumber(int input) {
		int amount = 0;
		int inputHolder = input;
		List<Integer> nums = new ArrayList<Integer>();
		List<Integer> numsTwo = new ArrayList<Integer>();
		int i = 0;
		
		while(input > 0) {
			int numToAdd = input % 10;
			nums.add(numToAdd);
			input /= 10;
			i++;
		}
		
		for(i = 0; i < nums.size(); i++) {
			if(!numsTwo.contains(nums.get(i))) {
				numsTwo.add(nums.get(i));
			}
		}
		System.out.println(numsTwo.toString());
		
		for(Integer k : numsTwo) {
			amount += Math.pow(k, nums.size());
			System.out.println(amount);
		}
		if(amount == inputHolder) {return true;}
		
		return false;
	}
}
