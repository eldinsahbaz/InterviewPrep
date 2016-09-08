/*
Write a function condenseMeetingTimes() that takes a list of meeting time ranges and returns a list of condensed ranges.
Do not assume the meetings are in order. The meeting times are coming from multiple teams.
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Meeting
{
		int startTime;
		int endTime;
	
    public Meeting(int startTime, int endTime)
    {
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
