/*
Your team is scrambling to decipher a recent message, worried it's a plot to break into a major European National Cake Vault. The message has been mostly deciphered, but all the words are backwards! Your colleagues have handed off the last step to you.

Write a function reverseWords() that takes a string message and reverses the order of the words in-place ↴
*/

public class ReverseWords
{
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
	
	public String reverseWords(String str) { return reverseWords(str.toCharArray()); }
	
	public String reverseWords(char[] string)
	{
		int start = 0;
		int index = 0;
		
		while(index < string.length())
		{
			if(string.charAt(index) == ' ')
			{
				reverseString(string, start, index-1);
				start = index+1;				
			}
			else if(index == string.length-1)
				reverseString(string, start, index);
			
			index++;
		}
		
		return String.valueOf(reverseString(string));
	}
}
