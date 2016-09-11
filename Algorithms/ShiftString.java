/*
Given two strings, Start and End, if possible, transform the string Start to the string End by moving one character at a time in start.
*/

public class ShiftString
{
  public static String shift(String start, String end)
	{
		if(start.length() != end.length()) return "";
		else if(start.intern() == end.intern()) return start;
		else
		{
			char[] startStr = start.toLowerCase().toCharArray();
			char[] endStr = end.toLowerCase().toCharArray();
			int sum1 = 0;
			int sum2 = 0;
			
			for(int pos = 0; pos < startStr.length; pos++)
			{
				sum1 += (int)startStr[pos];
				sum2 += (int)endStr[pos];
			}
			
			if(sum1 != sum2) return "";
			int current = 0;
			
			while(current < startStr.length)
			{
				char carry = startStr[current];
				int i = 1;
				
				for(; i < startStr.length; i++)
				{
					char temp = startStr[i];
					startStr[i] = carry;
					carry = temp;
				}
				
				startStr[current] = carry;
				if(startStr[current] == endStr[current])
					current++;
			}
			
			return start;
		}
	}
}
