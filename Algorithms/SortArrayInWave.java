/*
Given an unsorted array of integers, sort the array into a wave like array. An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
*/
public class SortArrayInWave
{
	public void waveSort(int[] array)
	{
		for(int i = 0; i < array.length; i += 2)
		{
			if(i > 0 && array[i - 1] > array[i])
			{
				int temp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;
			}	
			
			if(i < array.length - 1 && array[i] < array[i + 1])
			{
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		}
	}
}
