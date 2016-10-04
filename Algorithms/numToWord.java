/*
Convert a given integer to a string
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class numToWord
{	
	public String convert(int number)
	{
		String[] lengths = {"hundred", "thousand", "million", "billion"};

		Map<Integer, String> tens = new HashMap<>();
		tens.put(20, "twenty");
		tens.put(30, "thirty");	
		tens.put(40, "forty");
		tens.put(50, "fifty");
		tens.put(60, "sixty");
		tens.put(70, "seventy");
		tens.put(80, "eighty");
		tens.put(90, "ninty");

		String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

		Map<Integer, String> teens = new HashMap<>();
		tens.put(10, "ten");
		tens.put(11, "eleven");	
		tens.put(12, "twelve");
		tens.put(13, "thirteen");
		tens.put(14, "fourteen");
		tens.put(15, "fifteen");
		tens.put(16, "sixteen");
		tens.put(17, "seventeen");
		tens.put(18, "eighteen");
		tens.put(19, "nineteen");

		String words = ""; 
		if(number < 0)		
		{			
			number = Math.abs(number);
			words = "negative ";
		}

		Stack<Integer> components = new Stack<>();
		while(number != 0)
		{
			components.push(number%1000);
			number/=1000;
		}

		while(!components.empty())
			words += convert(components.pop(), ones, teens, tens) + " " + ((components.size() == 0) ? "" : lengths[components.size()]) + " ";
		
		return words;
	}

	public String convert(int number, String[] ones, Map<Integer, String> teens, Map<Integer, String> tens)
	{
		if(number >= 100)
			return convert(number/100, ones, teens, tens) + " hundred " + convert(number%100, ones, teens, tens);
		else if(number >= 20)
			return tens.get(number - number%10) + " " + ((convert(number%10, ones, teens, tens).intern() == "zero") ? "" : convert(number%10, ones, teens, tens));
		else if(number >= 10)
			return teens.get(number) + " ";
		else
			return ones[number];
	}
}
