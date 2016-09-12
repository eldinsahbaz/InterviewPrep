/*
Write a class TempTracker with these methods:

insert()—records a new temperature
getMax()—returns the highest temp we've seen so far
getMin()—returns the lowest temp we've seen so far
getMean()—returns the mean of all temps we've seen so far
getMode()—returns the mode of all temps we've seen so far
Optimize for space and time. Favor speeding up the getter functions (getMax(), getMin(), getMean(), and getMode()) over speeding up the insert() function.

getMean() should return a double, but the rest of the getter functions can return integers. Temperatures will all be inserted as integers. We'll record our temperatures in Fahrenheit, so we can assume they'll all be in the range 0..110.

If there is more than one mode, return any of the modes.
*/

import java.util.Map;
import java.util.HashMap;

public class TempTracker
{
		private Integer numOfTemps = 0;
		private Double sum = 0.0;
		private Double mean = 0.0;
		private Map<Integer, Integer> nums = new HashMap<>();
		private Integer mode = 0;
		private Integer max = Integer.MIN_VALUE;
		private Integer min = Integer.MAX_VALUE;
		
		public void insert(Integer temp)
		{
			//calculate min
			if(temp < min)
				min = temp;
			
			//calculate max
			if(temp > max)
				max = temp;
			
			//calculate mean
			numOfTemps++;
			sum += temp;
			mean = (Double)(sum / numOfTemps);
			
			//calculate mode
			if(nums.get(temp) == null)
				nums.put(temp, 1);
			else
				nums.put(temp, nums.get(temp) + 1);
				
			Map.Entry<Integer, Integer> mostSeen = null;
			
			for(Map.Entry<Integer, Integer> set : nums.entrySet())
				if(mostSeen == null)
					mostSeen = set;
				else if(set.getValue() >= mostSeen.getValue())
					mostSeen = set;
			
			mode = mostSeen.getKey();
		}
		
		public Integer getMax() { return max; }
		
		public Integer getMin() { return min; }
		
		public Double getMean() { return mean; }
		
		public Integer getMode() { return mode; }
}
