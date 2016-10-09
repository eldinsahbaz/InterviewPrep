/*
Given an array where every element occurs three times, except one element which occurs only once. Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
*/

public class DistinctElementBitwise
{
  public int distinct(int[] array)
  {
    int element = 0;
    for(int i = 0; i < array.length; i++)
      element ^= array[i];
      
     return element;
  }
}
