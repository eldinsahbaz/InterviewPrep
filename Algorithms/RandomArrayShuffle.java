/*
Given an array of distinct integers, give an algorithm to randomly reorder the
integers so that each possible reordering is equally likely. In other words, given a
deck of cards, how can you shuffle them such that any permutation of cards is 
equally likely?
*/

public class RandomArrayShuffle
{
  public void shuffle(int[] numbers)
	{
		for(int i = 0; i < numbers.length; i++)
		{
			int rand = getRandom(0, numbers.length - 1);
			
			int temp = numbers[rand];
			numbers[rand] = numbers[i];
			numbers[i] = temp;
		}
	}
}
