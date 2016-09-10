/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
*/

import java.util.Arrays;

public class isAnagram
{
  public static boolean isAnagram(String s, String t)
  {
    	if(s == t) return true;
    	if((s == null) ^ (t == null)) return false;
    	
        char[] String1 = s.toLowerCase().toCharArray();
        char[] String2 = t.toLowerCase().toCharArray();
        
        Arrays.sort(String1);
        Arrays.sort(String2);
        
        return (String.valueOf(String1).intern() == String.valueOf(String2).intern());
  }
}
