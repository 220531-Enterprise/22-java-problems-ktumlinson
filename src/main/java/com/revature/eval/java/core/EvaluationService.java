package com.revature.eval.java.core;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EvaluationService {
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {
			// check the kph
			
			// if less than 0 return -1
			if(kilometersPerHour < 0) {return -1;}
			
			// kph to mph = kph / 1.609
			return Math.round(kilometersPerHour / 1.609);
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			// use speed converter for kph
			double mph = toMilesPerHour(kilometersPerHour);
			
			// if the speed converter returns -1 return "Invalid Value"
			if(mph < 0) {return "Invalid Value";}
			
			// print the format "XX km/h = YY mi/h"
			return kilometersPerHour + " km/h = " + String.format("%.0f", mph) + " mi/h";
		}
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int XX) {
		
		// if the amount of kilobytes is less than 0 return "Invalid Value"
		if(XX < 0) {return "Invalid Value";}
		
		// calculate megabytes and remaining kilobytes % 1 mb = 1000 kb
		int mb = XX / 1024;
		int kbRemain = XX % 1024;
		
		// return a string "XX KB = YY MB and ZZ KB
		return XX + " KB = " + mb + " MB and " + kbRemain + " KB";
	}
// QUESTION-----------------------------------------------------------------------------------

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		if(isBarking) {
			if((hourOfDay < 8 || hourOfDay > 22) && (hourOfDay > 0 && hourOfDay < 24)) {
				return true;
			}
		}
		return false;
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		double fNum;
		double sNum;
		//get the first 3 of each decimal
		DecimalFormat df = new DecimalFormat("#.###"); // sets the format to 3 decimal places
		df.setRoundingMode(RoundingMode.DOWN); // rounds them down
		String dx = df.format(firstNum); // sets the formatting of a decimal by turning it into a string
		fNum = Double.valueOf(dx); // back to a double from a string
		dx = df.format(secondNum);
		sNum = Double.valueOf(dx);
		
		// compare if they are the same if they are the same return true
		if(fNum == sNum) return true;
		return false;
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {
			
			if(isTeen(x)) {return true;}
			else if(isTeen(y)) {return true;}
			else if(isTeen(z)) {return true;}
			
			return false;
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		public static boolean isTeen(int number) {
			if(number > 12 && number < 20) {return true;}
			return false;
		}
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {
		if(minutes < 0) {System.out.println("Invalid Value");}
		int YY, DD;
		// calculate years and days, days first then years = days / 365, one day = 1440 minuts
		DD = (int)minutes / 1440;
		YY = DD / 365;
		DD = DD % 365;
		
		// output the information in the proper formatting
		return (minutes + " min = " + YY + " y and " + DD + " d");
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {
		switch(number) {
			case 0:
			{
				return "ZERO";
			}
			case 1:
			{
				return "ONE";
			}
			case 2:
			{
				return "TWO";
			}
			case 3:
			{
				return "THREE";
			}
			case 4:
			{
				return "FOUR";
			}
			case 5:
			{
				return "FIVE";
			}
			case 6:
			{
				return "SIX";
			}
			case 7:
			{
				return "SEVEN";
			}
			case 8:
			{
				return "EIGHT";
			}
			case 9:
			{
				return "NINE";
			}
			default:
			{
				return "OTHER";
			}
		}
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {
		if(first < 10 || second < 10) {return -1;}
		
		int lowest;
		if(first < second) {
			lowest = first;
		}
		else {
			lowest = second;
		}
		
		int GCD = 0;
		for(int i = 1; i < lowest; i++){
			if(first % i == 0 && second % i == 0) {
				GCD = i;
			}
		}
		
		return GCD;
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		int first = 0;
		int last, result;
		// get the last digit
		last = num % 10;
		
		// go through each number in num mod out 10 to see if it is the first number or not
		while(num != 0) {
			first = num % 10;
			num /= 10;
		}
		result = first + last;
		if(result < 0) {
			return -1;
		}
		else {
			return result;
		}
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {;
		String reversed = "";
		for(int i = 0; i < string.length(); i++) {
			reversed += (string.charAt((string.length() - 1) - i));
		}
		return reversed;
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		String acro = "" + phrase.charAt(0);
		for(int i = 1; i < phrase.length(); i++)
		{
			if(phrase.charAt(i - 1) == ' ' || phrase.charAt(i - 1) == '-') {
				char charToAdd = Character.toUpperCase(phrase.charAt(i));
				acro += charToAdd;
			}
		}
		// check if the letter is the first letter
		return acro;
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			
			if(sideOne == sideTwo && sideTwo == sideThree) {return true;}
			return false;
		}

		public boolean isIsosceles() {
			
			if(sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {return true;}
			return false;
		}

		public boolean isScalene() {
			if(isEquilateral() || isIsosceles()) {return false;}
			
			return true;
		}

	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		
		int total = 0;
		for(int i = 0; i < string.length(); i++) {
			switch(Character.toUpperCase(string.charAt(i))) {
			case 'A': case 'E': case 'I': case 'O': case 'U': case 'L': case 'N': case 'R': case 'S': case 'T': {total += 1; break;}
			case 'D': case 'G': {total += 2; break;}
			case 'B': case 'C': case 'M': case 'P': {total += 3; break;}
			case 'F': case 'H': case 'V': case 'W': case 'Y': {total += 4; break;}
			case 'K': {total += 5; break;}
			case 'J': case 'X': {total += 8; break;}
			case 'Q': case 'Z': {total += 10; break;}
			}
		}
		return total;
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		int i = 0;
		if(string.charAt(0) == '+') {
			i = 3;
		}
		String cleaned = "";
		
		for(; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i))) {
				cleaned += string.charAt(i);
			}
		}
		if(cleaned.length() == 10) {return cleaned;}
		throw new IllegalArgumentException();
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> words = new HashMap<String, Integer>();
		int whiteSpaceLocation;
		int startLocation = 0;
		String toAdd = "";
		
		if(string.contains("\n")) {
			string = string.replaceAll("\n", "");
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
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		int amount = 0;
		int inputHolder = input;
		List<Integer> nums = new ArrayList<Integer>();
		int i = 0;
		
		while(input > 0) {
			int numToAdd = input % 10;
			nums.add(numToAdd);
			input /= 10;
			i++;
		}
		
		for(Integer k : nums) {
			amount += Math.pow(k, nums.size());
		}
		if(amount == inputHolder) {return true;}
		
		return false;
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> primes = new ArrayList<Long>();
		
		// get all numbers that are even and make it a 2 beause they are divisible by 2
		while(l % 2 == 0) {
			primes.add(2l);
			l /= 2;
		}
		
		// get all odd numbers that are primes
		for(long i = 3; i <= l; i++) {
			while(l % i == 0) {
				primes.add(i);
				l /= i;
			}
		}
		
		// make sure if there is still a number you add it
		if(l > 2) {
			primes.add(l);
		}
		return primes;
	}
	
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
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
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: ?????? ????????????, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		for(int i = 97; i < 123; i++) {
			char check = (char)i;
			// check if lowercase is there
			if(string.indexOf(check) != -1) {
				continue;				
			} else if(string.indexOf(check - 32) != -1) {
				continue;
			}
			return false;
		}
		return true;
	}
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
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
// QUESTION-----------------------------------------------------------------------------------
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		int[] numbers = new int[3];
		
		for(int i = 0; i < 3; i++) {
			Random r = new Random();
			numbers[i] = r.nextInt(1, 101);
		}
		return numbers;
	}
// QUESTION-----------------------------------------------------------------------------------
	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		Random r = new Random();
		return r.nextInt(x, y+1);
	}
}
