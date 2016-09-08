/*
Find the length of the longest substring with unique characters in a given String.
*/

public class LongestSubStringLength
{
  public int longestSubStringLength(String str)
	{
		boolean[] seen = new boolean[256];
		StringBuilder sb = new StringBuilder();
		int longest = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			if(seen[str.charAt(i)])
			{
				if(sb.length() > longest)
					longest = sb.length();
				
				sb = new StringBuilder();
				sb.append(str.charAt(i));
				seen = new boolean[256];
			}
			else
				sb.append(str.charAt(i));
				
			seen[str.charAt(i)] = true;
		}
	
		return longest;
	}
}
