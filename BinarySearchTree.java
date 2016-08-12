public class BinarySearchTree
{
	protected class Node
	{
		public int value;
		public Node parent;
		public Node left;
		public Node right;
		
		public Node(int val) { value = val; parent = null; left = null; right = null; }
		
		public Node insert(int value) { return insert(value, this); }
		
		public Node insert(int val, Node root)
		{
			Node previous = null;
			Node current  = root;
			boolean isLeft = false;
			
			while(current != null)
			{
				previous = current;
				
				if(current.value > val)
				{
					current = current.left;
					isLeft = true;
				}
				else if(current.value < val)
				{
					current = current.right;
					isLeft = false;
				}
				else
					return root;
			}
			
			if(isLeft)
			{
				previous.left = new Node(val);
				previous.left.parent = previous;
			}
			else
			{
				previous.right = new Node(val);
				previous.right.parent = previous;
			}
			
			return root;
		}
		
		public void inOrder() { inOrder(this); }
		
		public void inOrder(Node n)
		{
			if(n != null)
			{
				inOrder(n.left);
				System.out.print(n.value + " ");
				inOrder(n.right);
			}
		}
		
		public Node getNext(int find, Node root) { return getNext(search(find, root)); }
		
		public Node getNext(Node current)
		{
			if(current == null)
				return current;
			else if(current.right != null)
				return findMin(current.right);
			else if(current.parent != null && current.parent.left == current)
				return current.parent;			
			else
				return getNext(current.parent);
		}

		public Node findMin(Node root)
		{
			while(root.left != null)
				root = root.left;
			
			return root;
		}
		
		public Node search(int n, Node current)
		{
			while(current != null)
			{
				 if(current.value > n)
					 current = current.left;
				 else if(current.value < n)
					 current = current.right;
				 else
					 break;
			}
			
			return current;
		}
		
		public boolean isBalanced(Node root) { return (root == null) ? false : !(((maxHeight(root.left) - maxHeight(root.right)) > 1) || (maxHeight(root.left) - maxHeight(root.right)) < -1); }
		public int maxHeight(Node root) { return (root == null) ? 0 : max(maxHeight(root.left), maxHeight(root.right)) + 1; }
		public int max(int one, int two) { return (one > two) ? one : two; }
	}
	
	private Node root;
		
	public Tree() { root = null; }	
	
	public void insert(int value)
	{
		if(root == null)
			root = new Node(value);
		else
			root.insert(value);
	}
	
	public Node getNext(int value)
	{
		if(root != null)
			return root.getNext(value, root);
		
		return null;
	}
	
	public void inOrder()
	{
		if(root != null)
			root.inOrder();
	}
	

	public boolean isBalanced(Node root) { return (root == null) ? false : root.isBalanced(root); }
	
	public boolean isBalanced(int value)
	{
		Node found = null;
		
		if(this.root != null)
			found = root.search(value, root);
		
		return isBalanced(found);
	}
}