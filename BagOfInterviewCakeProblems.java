import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class BagOfInterviewCakeProblems
{
	public class Meeting
	{
		int startTime;
		int endTime;
	
    		public Meeting(int startTime, int endTime) {
        	// number of 30 min blocks past 9:00 am
        	this.startTime = startTime;
        	this.endTime   = endTime;
    		}

    		public String toString() { return String.format("(%d, %d)", startTime, endTime); }
	
		public static Meeting[] condenseMeetingTimes(Meeting[] meetings)
		{
			ArrayList<Meeting> ALMeetings = new ArrayList<Meeting>(Arrays.asList(meetings));
			Comparator<Meeting> comparator = new Comparator<Meeting>()
			{ public int compare(Meeting A, Meeting B) { return ((Integer)A.startTime).compareTo((Integer)B.startTime); }};
		
			Collections.sort(ALMeetings, comparator);
			Meeting previous = meetings[0];
			ArrayList<Meeting> merged = new ArrayList<>();
			int i = 0;
		
			while(i < ALMeetings.size())
			{
				if(previous.startTime == ALMeetings.get(i).startTime || previous.endTime >= ALMeetings.get(i).startTime)
				{	
					if(previous.endTime < ALMeetings.get(i).endTime)
						previous = new Meeting(previous.startTime, ALMeetings.get(i).endTime);
				}
				else
				{
					merged.add(previous);
					previous = ALMeetings.get(i);
				}
			
				i++;
			
				if(i == ALMeetings.size())
					merged.add(previous);
			}
		
			return merged.toArray(new Meeting[merged.size()]);
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public class MyQueue<T>
	{
		Stack<T> inStack;
		Stack<T> outStack;
		
		public MyQueue() { inStack = new Stack<>(); outStack = new Stack<>(); }
		
		public void enQueue(T value)
		{
			while(!outStack.empty())
				inStack.push(outStack.pop());
			
			inStack.push(value);
		}
		
		public T deQueue()
		{
			while(!inStack.empty())
				outStack.push(inStack.pop());
			
			return outStack.pop();
		}
		
		public T peek()
		{
			while(!outStack.empty())
				inStack.push(outStack.pop());
			
			return inStack.peek();
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public class MaxStack extends java.util.Stack<Integer>
	{
		
		private java.util.Stack<Integer> MaxStack;
	
		public MaxStack()
		{
			super();
			MaxStack = new java.util.Stack<>();
		}
		
		public void push(int val)
		{
			if(MaxStack.empty())
				MaxStack.push(val);
			else if(val >= MaxStack.peek())
				MaxStack.push(val);
			
			super.push(val);
		}
		
		public Integer pop()
		{
			if(MaxStack.empty())
				return (Integer.MIN_VALUE);
			
			int popped = super.pop();
			
			if(popped == MaxStack.peek())
				MaxStack.pop();
				
			return popped;
		}
		
		public Integer getMax() { return MaxStack.peek(); };
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public class IDProblem
	{
		public class ID
		{
			public String id;
			
			public ID(String identity) { id = identity; }
		}
	
		private ID[] idList;
	
		public test(String[] ids)
		{ 
			idList = new ID[ids.length];
			
			for(int i = 0 ; i < ids.length; i++)
				idList[i] = new ID(ids[i]);
		}
		
		public Integer findUnique()
		{
			if(idList != null)
			return findUnique(idList);
			
			return null;
		}
	
		private Integer findUnique(ID[] ids)
		{
			HashMap<String, Integer> ID_Hits = new HashMap<>();
			
			for(int i = 0; i < ids.length; i++)
			{
				if(ID_Hits.get(ids[i].id) == null)
					ID_Hits.put(ids[i].id, 1);
				else
					ID_Hits.put(ids[i].id, ++(ID_Hits.get(ids[i].id)));
			}
			
			for(Entry<String, Integer> set : ID_Hits.entrySet())
				if(set.getValue() == 1)
					return set.getKey();
		
			return null;
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	static int ways = 0;
	public static int moneyCombinations(int amount, int[] denoms)
	{
		int start = 0;
		return moneyCombinations(amount, denoms, start);
	}
	
	public static int moneyCombinations(int amount, int[] denoms, int start)
	{
		if(amount == 0)
			ways++;
		else if(amount < 0)
			;
		else
			for(int i = start; i < denoms.length; i++)
				moneyCombinations(amount - denoms[i], denoms, i);
		
		return ways;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public String longestSubString(String str)
	{
		boolean[] seen = new boolean[256];
		StringBuilder sb = new StringBuilder();
		String longest = "";
		
		for(int i = 0; i < str.length(); i++)
		{
			if(seen[str.charAt(i)])
			{
				if(sb.length() > longest.length())
					longest = sb.toString();
				
				sb = new StringBuilder();
				sb.append(str.charAt(i));
				seen = new boolean[256];
			}
			else
				sb.append(str.charAt(i));
			
			seen[str.charAt(i)] = true;
		}
	
		return longest;
	}

	public int longestSubStringLength(String str)
	{
		boolean[] seen = new boolean[256];
		StringBuilder sb = new StringBuilder();
		int longest = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			if(seen[str.charAt(i)])
			{
				if(sb.length() > longest)
					longest = sb.length();
				
				sb = new StringBuilder();
				sb.append(str.charAt(i));
				seen = new boolean[256];
			}
			else
				sb.append(str.charAt(i));
				
			seen[str.charAt(i)] = true;
		}
	
		return longest;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
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
	
	//---------------------------------------------------------------------------------------------------------------------
	
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
	
	//---------------------------------------------------------------------------------------------------------------------
	
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
	
	//---------------------------------------------------------------------------------------------------------------------
	
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
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public boolean isPalindrome(String str)
	{
		HashSet<Character> characters = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++)
		{
			if(characters.contains(str.charAt(i)))
				characters.remove(str.charAt(i));
			else
				characters.add(str.charAt(i));
		}
		
		return (characters.size() > 1);
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public Set<String> permutations(String str)
	{
		Set<String> perms = new Set<>();
		return permutations(str, "", perms);
	}
	
	public Set<String> permutations(String str, String perms, Set<String> set)
	{
		if(str.length() == 0)
			set.add(perms);
		
		for(int i = 0; i < str.length(); i++)
			permutations(str.substring(0, i) + str.substring(i+1), perms + str.charAt(i), set);
			
		return set;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public Set<String> combinations(String str)
	{
		Set<String> combs = new Set<>();
		return combinations(str, "", combs);
	}
	
	public Set<String> combinations(String str, String perms, Set<String> set)
	{
		set.add(perms);
		
		for(int i = 0; i < str.length(); i++)
			combinations(str.substring(i+1), perms + str.charAt(i), set);
			
		return set;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
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
	
	//---------------------------------------------------------------------------------------------------------------------
	
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
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void shuffle(int[] numbers)
	{
		for(int i = 0; i < numbers.length; i++)
		{
			int rand = getRandom(0, numbers.length - 1);
			
			int temp = numbers[rand];
			numbers[rand] = numbers[i];
			numbers[i] = temp;
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
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
	
	//---------------------------------------------------------------------------------------------------------------------

	public boolean Moviesum(int duration, int[] movieLengths)
	{
		boolean found = false;
		
		for(int i = 0 ; i < movieLengths.length; i++)
			for(int j = 0; j < movieLengths.length; j++)
				if(i == j)
					continue;
				else
					if((movieLengths[i] + movieLengths[j]) == duration)
					{	
						found = true;
						break;
					}
		
		return found;
	}

	public boolean MoviesumOptimized(int duration, int[] movieLengths)
	{
		Arrays.sort(movieLengths);
		int left = 0;
		int right = movieLengths.length-1;
	
		while(left < right)
			if((movieLengths[left] + movieLengths[right]) == duration)
				return true;
			else if((movieLengths[left] + movieLengths[right]) < duration)
				left++;
			else
				right++;
		
		return false;
	}
	
	//---------------------------------------------------------------------------------------------------------------------

	public int fib(int n)
	{
		if(n <= 1)
			return n;
			
		return fib(n-1) + fib(n-2)
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public Stack<Integer> sortStack(Stack<Integer> stack)
	{
		Stack<Integer> sorted = new Stack<>();
		
		while(!stack.empty())
		{
			int popped = stack.pop();
			
			while(!sorted.empty() && stack.peek() > popped)
				stack.push(sorted.pop());
			
			sorted.push(popped);
		}
		
		return sorted;
	}
}
