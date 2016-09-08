/*
"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."

Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.

Example: if the example string above is input with the number 10 (position of the first parenthesis), the output should be 79 (position of the last parenthesis).
*/

import java.util.Stack;

public class ParenthesisMatching
{
  public int parenthesis(String str, int position)
	{
		Stack<Character> characters = new Stack<>();
		int count = 0;
		
		while(position < str.length())
		{
			if(str.charAt(position) == '(')
				characters.push('(');
			else if(str.charAt(position) == ')' && characters.peek() == '(')
				characters.pop();
			else if(str.charAt(position) == ')' && characters.peek() != '(')
				break;
			
			if(characters.empty())
				return count;
		
			count++;
		}
		
		return -1;
	}
}
