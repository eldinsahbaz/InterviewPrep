/*
Given a String, find the longest substring of unique characters.
*/

public class LongestSubString
{
	public String longestSubString(String str)
	{
		boolean[] seen = new boolean[256];
		StringBuilder sb = new StringBuilder();
		String longest = "";
		
		for(int i = 0; i < str.length(); i++)
		{
			if(seen[str.charAt(i)])
			{
				if(sb.length() > longest.length())
					longest = sb.toString();
				
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
