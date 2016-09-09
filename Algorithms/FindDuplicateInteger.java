/*
Find duplicate integer in a list of integer
*/

import java.util.Map;
import java.util.HashMap;

public class FindDuplicateInteger
{
  public Integer duplicate(int[] numbers)
	{
		Map<Integer, Integer> ints = new HashMap<>();
		
		for(int i = 0; i < numbers.length; i++)
		{
			if(ints.get(numbers[i]) == null)
				ints.put(numbers[i], 1);
			else
				ints.put(numbers[i], ints.get(numbers[i])+1);
		}
		
		for(Entry<Integer,Integer> entry : ints.entryset())
			if(entry.getValue() > 1)
				return entry.getKey();
				
		return null;
	}
}
