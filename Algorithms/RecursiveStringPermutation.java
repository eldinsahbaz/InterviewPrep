/*
Write a recursive function for generating all permutations of an input string. Return them as a set.
Don't worry about time or space complexity—if we wanted efficiency we'd write an iterative version.

To start, assume every character in the input string is unique.

Your function can have loops—it just needs to also be recursive.


*/
import java.util.Set;
import java.util.LinkedHashSet;

public class RecursiveStringPermutation
{
  public Set<String> permutations(String str)
	{
		Set<String> perms = new LinkedHashSet<>();
		return permutations(str, "", perms);
	}
	
	public Set<String> permutations(String str, String perms, Set<String> set)
	{
		if(str.length() == 0)
			set.add(perms);
		
		for(int i = 0; i < str.length(); i++)
			permutations(str.substring(0, i) + str.substring(i+1), perms + str.charAt(i), set);
			
		return set;
	}
}
