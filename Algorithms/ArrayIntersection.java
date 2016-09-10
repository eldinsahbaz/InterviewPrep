/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class ArrayIntersection
{
  public static int[] intersection(int[] nums1, int[] nums2)
  {
    	Set<Integer> contents = new HashSet<>();
    	ArrayList<Integer> intersection = new ArrayList<>();
    	
    	for(int i = 0; i < nums1.length; i++)
    		contents.add(nums1[i]);
    		
    	for(int i = 0; i < nums2.length; i++)
    		if(contents.contains(nums2[i]))
    			intersection.add(nums2[i]);
    			
    	int[] toReturn = new int[intersection.size()];
    	int i = 0;
    	
    	for(Integer n : intersection)
    		toReturn[i++] = n;
    	
    	return toReturn;
  }
}
