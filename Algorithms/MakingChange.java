/*
Your quirky boss found out that you're a programmer and has a weird request about something they've been wondering for a long time.

Write a function that, given:

an amount of money
an array of coin denominations
computes the number of ways to make amount of money with coins of the available denominations.

Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢), your program would output 4 the number of ways to make 4¢ with those denominations:

1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢
*/

public class MakingChange
{
  static int ways = 0;
	public static int moneyCombinations(int amount, int[] denoms)
	{
		int start = 0;
		return moneyCombinations(amount, denoms, start);
	}
	
	public static int moneyCombinations(int amount, int[] denoms, int start)
	{
		if(amount == 0)
			ways++;
		else if(amount < 0)
			;
		else
			for(int i = start; i < denoms.length; i++)
				moneyCombinations(amount - denoms[i], denoms, i);
		
		return ways;
	}
}
