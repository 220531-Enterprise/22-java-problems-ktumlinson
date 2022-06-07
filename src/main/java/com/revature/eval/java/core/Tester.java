package com.revature.eval.java.core;

import java.util.HashMap;
import java.util.Map;

public class Tester {

	public static void main(String[] args) {
		System.out.println(wordCount("one,\ntwo,\nthree"));
	}
	public static Map<String, Integer> wordCount(String string) {
		Map<String, Integer> words = new HashMap<String, Integer>();
		int whiteSpaceLocation;
		int startLocation = 0;
		String toAdd = "";
		
		if(string.contains("\n")) {
			string = string.replaceAll(",\n", " ");
		}
		System.out.println(string);
		
		
		// for the word
		while(string.length() > 0) {
			whiteSpaceLocation = 0;
			// make a substring of 0 - whitespace
			for(int i = 0; i < string.length(); i++) {
				if(!Character.isAlphabetic(string.charAt(i))) {
					whiteSpaceLocation = i;
					break;
				}
			}
			System.out.println(string.charAt(whiteSpaceLocation));
			if(whiteSpaceLocation == 0) {
				whiteSpaceLocation = string.length();
			}
			toAdd = string.substring(startLocation, whiteSpaceLocation);
			
			// if the string is in the set change the value
			if(words.containsKey(toAdd)) {
				words.put(toAdd, words.get(toAdd) + 1);
			}
			// if the string is not in the set add it in
			else {
				words.put(toAdd, 1);
			}
			
			// this gets all but the handles expanded lists one
			if(whiteSpaceLocation != string.length()) {
				string = string.replaceFirst(toAdd + string.charAt(whiteSpaceLocation), "");
			}
			else {
				
				string = string.replaceFirst(toAdd, "");
			}
			System.out.println(words.toString());
			System.out.println(string);
		}
		
		return words;
	}
}
