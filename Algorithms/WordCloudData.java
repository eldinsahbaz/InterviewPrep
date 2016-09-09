/*
You want to build a word cloud, an infographic where the size of a word corresponds to how often it appears in the body of text.
To do this, you'll need data. Write code that takes a long string and builds its word cloud data in a hash map, where the keys are words and the values are the number of times the words occurred.

Think about capitalized words. For example, look at these sentences:

"After beating the eggs, Dana read the next step:"
"Add milk and eggs, then add flour and sugar."

What do we want to do with "After", "Dana", and "add"? In this example, your final hash map should include one "Add" or "add" with a value of 2. Make reasonable (not necessarily perfect) decisions about cases like "After" and "Dana".

Assume the input will only contain words and standard punctuation.
*/


import java.util.Map;
import java.util.HashMap;

public class WordCloudData
{
  public Map<String, Integer> infographic(String str)
	{
		str = str.toLowerCase();
		String[] words = str.split(' ');
		Map<String, Integer> infographic = new HashMap<>();
		
		for(int i = 0; i < words.length; i++)
			if(infographic.contains(words[i]))
				infographic.put(words[i], infographic.getValue(words[i]) + 1);
			else
				infographic.put(words[i], 1);
		
		return infographic;
	}
}
