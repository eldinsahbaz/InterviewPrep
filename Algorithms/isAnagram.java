/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
*/

import java.util.Arrays;

public class isAnagram
{
  public boolean isAnagram(String s, String t)
  {
    	if(s == t) return true;
    	if((s == null) ^ (t == null)) return false;
    	
        char[] String1 = s.toLowerCase().toCharArray();
        char[] String2 = t.toLowerCase().toCharArray();
        
        Arrays.sort(String1);
        Arrays.sort(String2);
        
        return (String.valueOf(String1)/*.intern()*/ == String.valueOf(String2)/*.intern()*/);
  }
  
    //more efficient since sorting is only as fast as sorting method.
    //Although this method is not as spatially efficient, it is more time
    //efficient
  	public static boolean isAnagramAlternate(String one, String two)
	  {

		  one = one.toLowerCase();
		  two = two.toLowerCase();
		  Map<Character, Integer> chars = new HashMap<>();
		
		  for(int i = 0; i < one.length(); i++)
			  if(chars.get(one.charAt(i)) == null)
				  chars.put(one.charAt(i), 1);
			  else
				  chars.put(one.charAt(i), chars.get(one.charAt(i)) + 1);

		
		  for(int i = 0; i < two.length(); i++)
			  if(chars.get(two.charAt(i)) == null)
				  return false;
			  else
			  {
				  chars.put(two.charAt(i), chars.get(two.charAt(i)) - 1);

				  if (chars.get(two.charAt(i)) == 0)
					  chars.remove(two.charAt(i));
			  }

		  return chars.isEmpty();
	  }
}
