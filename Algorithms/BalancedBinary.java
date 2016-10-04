/*
Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.
*/

public class BalancedBinary
{
	private class node
	{
		int value;
		node left;
		node right;

		public node() { }
		public node(int value) { this.value = value; }
	}

	public node convertArr(int[] arr)
	{
		return convertArr(arr, 0, arr.length - 1);
	}

	public node convertArr(int[] arr, int left, int right)
	{
		
		if(left > right)
			return null;

		int middle = (left + right) / 2;
	
		node root = new node(arr[middle]);
		root.left = convertArr(arr, left, middle - 1);
		root.right = convertArr(arr, middle + 1, right);
		
		return root;
	}
}
