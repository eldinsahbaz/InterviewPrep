/*
Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.
*/

class IsArrayConsecutive
{
	public boolean isConsecutive(int[] numbers)
	{
		if(numbers == null || numbers.length == 0)
			return false;
		else if(numbers.length == 1)
			return true;
		
		int max = numbers[0];
		int min = numbers[0];
		int toCompare = 0;
		int xored = 0;
		
		for(int i = 1; i < numbers.length; i++)
			if(numbers[i] > max)
				max = numbers[i];
			else if(numbers[i] < min)
				min = numbers[i];
		
		for(; min <= max; min++)
			toCompare ^= min;
			
		for(int i = 0; i < numbers.length; i++)
			xored ^= numbers[i];
			
		return (toCompare ^ xored) == 0;
	}
}
