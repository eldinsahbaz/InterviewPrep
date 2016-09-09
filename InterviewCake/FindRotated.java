/*
I opened up a dictionary to a page in the middle and started flipping through, looking for words I didn't know. I put each word I didn't know at increasing indices in a huge array I created in memory. When I reached the end of the dictionary, I started from the beginning and did the same thing until I reached the page I started at.

Now I have an array of words that are mostly alphabetical, except they start somewhere in the middle of the alphabet, reach the end, and then start from the beginning of the alphabet. In other words, this is an alphabetically ordered array that has been "rotated." For example:

  String[] words = new String[]{
    "ptolemaic",
    "retrograde",
    "supplant",
    "undulate",
    "xenoepist",
    "asymptote", // <-- rotates here!
    "babka",
    "banoffee",
    "engender",
    "karpatka",
    "othellolagkage",
};

Write a function for finding the index of the "rotation point," which is where I started working from the beginning of the dictionary. This array is huge (there are lots of words I don't know) so we want to be efficient here.
*/

public class FindRotated
{
  public int findRotatedIndex(String[] dictionary)
	{
		if(dictionary.length == 0)
			return (-1);
			
		int rotatedIndex = 0;
		String min = dictionary[0].toLowerCase();
		
		for(int i = 0; i < dictionary.length; i++)
		{
			String current = dictionary[i].toLowerCase();
			
			if(current.compareTo(min) < 0)
			{
				rotatedIndex = i;
				min = current;
				break;
			}
		}
	
		return rotatedIndex;
	}
}
