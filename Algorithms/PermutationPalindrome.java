/*
Write an efficient function that checks whether any permutation ↴ of an input string is a palindrome ↴ .
Examples:

"civic" should return true
"ivicc" should return true
"civil" should return false
"livci" should return false
*/

import java.util.HashSet;

public class PermutationPalindrome
{
  public boolean isPalindrome(String str)
	{
		HashSet<Character> characters = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++)
		{
			if(characters.contains(str.charAt(i)))
				characters.remove(str.charAt(i));
			else
				characters.add(str.charAt(i));
		}
		
		return (characters.size() > 1);
	}
}
