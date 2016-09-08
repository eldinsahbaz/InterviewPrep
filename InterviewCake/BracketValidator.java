/*
You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces, brackets, and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses validator.
Let's say:

'(', '{', '[' are called "openers."
')', '}', ']' are called "closers."
Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.

Examples:

"{ [ ] ( ) }" should return true
"{ [ ( ] ) }" should return false
"{ [ }" should return false

*/

import java.util.Stack;

public class BracketValidator
{
  public boolean validator(String str)
	{
		Stack<Character> characters = new Stack<>();
	
		for(int i = 0; i < str.length(); i++)
		{
			switch(str.charAt(i))
			{
			case '(':
			characters.push('(');
			break;
			case '[':
			characters.push('[');
			break;
			case '{':
			characters.push('{');
			break;
			case ')':
			if(!characters.empty() && characters.peek() == '(')
				characters.pop();
			else
				return false;
			break;
			case ']':
			if(!characters.empty() && characters.peek() == '[')
				characters.pop();
			else
				return false;
			break;
			case '}':
			if(!characters.empty() && characters.peek() == '{')
				characters.pop();
			else
				return false;
			break;
			default:
			}
		}
		
		if(characters.empty())
			return true;
			
		return false;
	}
}
