/*
Reverse a string in-place.
*/

public class ReverseString
{
  public String reverseString(String str) { return reverseString(str.toCharArray()); }
	
	public String reverseString(char[] string)
	{
		int left = 0;
		int right = string.length-1;
		
		while(left <= right)
		{
			char temp = string[right];
			string[right--] = string[left];
			string[left++] = temp;
		}
		
		return String.valueOf(string);
	}
	
	public String reverseString(char[] string, int left, int right)
	{		
		while(left <= right)
		{
			char temp = string[right];
			string[right--] = string[left];
			string[left++] = temp;
		}
		
		return String.valueOf(string);
	}
}
