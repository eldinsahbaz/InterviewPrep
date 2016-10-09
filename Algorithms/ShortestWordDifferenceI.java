/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.
*/

public class ShortestWordDifferenceI
{
	public int shortestDistance(String[] words, String one, String two)
	{
		int WordOneIndex = -1;
		int WordTwoIndex = -1;
		int minDistance = Integer.MAX_VALUE;
		
		for(int i = 0; i < words.length; i++)
		{
			if(words[i].intern() == one.intern())
			{
				WordOneIndex = i;
				
				if(WordTwoIndex != -1 && Math.abs(WordTwoIndex - i) < minDistance)
					minDistance = Math.abs(WordTwoIndex - i);
			}
			else if(words[i].intern() == two.intern())
			{
				WordTwoIndex = i;
				
				if(WordOneIndex != -1 && Math.abs(WordOneIndex - i) < minDistance)
					minDistance = Math.abs(WordOneIndex - i);
			}
		}
		
		return minDistance;
	}
}
