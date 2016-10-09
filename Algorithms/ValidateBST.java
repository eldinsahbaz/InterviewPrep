/*
Write a function that returns true if all the nodes of the BST satisfy the BST properties and false if there is at least one that does not
*/

public class ValidateBST
{	
	private class Node<T extends Comparable>
	{
		public T value;
		public Node<T> left;
		public Node<T> right;
		
		public Node(T val) { value = val; }
	}
	
	Node<Integer> previous = null;
	private boolean validate(Node<Integer> root)
	{
		if(root != null)
		{
			validate(root.left);
			
			if(previous != null && root.value < previous.value)
				return false;
			
			previous = root;
			
			return validate(root.right);
		}
		
		return true;
	}	
}
