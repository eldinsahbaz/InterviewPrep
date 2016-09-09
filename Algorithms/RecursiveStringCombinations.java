/*
Write a recursive function for generating all combinations of an input string. Return them as a set.
Don't worry about time or space complexity—if we wanted efficiency we'd write an iterative version.

To start, assume every character in the input string is unique.

Your function can have loops—it just needs to also be recursive.
*/

import java.util.Set;
import java.util.LinkedHashSet;

public class RecursiveStringCombinations
{
  public Set<String> combinations(String str)
	{
		Set<String> combs = new LinkedHashSet<>();
		return combinations(str, "", combs);
	}
	
	public Set<String> combinations(String str, String perms, Set<String> set)
	{
		set.add(perms);
		
		for(int i = 0; i < str.length(); i++)
			combinations(str.substring(i+1), perms + str.charAt(i), set);
			
		return set;
	}
}
