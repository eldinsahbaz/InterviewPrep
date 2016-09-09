import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AVLTree
{
	protected class Node
	{
		public int value;
		public int height;
		public Node left;
		public Node right;
		
		public Node() { height = 0; left = null; right = null; }
		public Node(int v)  { value = v; height = 0; left = null; right = null; }
		
		public Node insert(int val) { return insert(val, this); }
		
		public Node insert(int val, Node root)
		{
			if(root == null)
				root = new Node(val);
			else if(val < root.value)
				root.left = insert(val, root.left);
			else if(val > root.value)
				root.right = insert(val, root.right);
			else
				;
			
			root = balance(root);
			root.height = maxHeight(root);
			
			return root;
		}
		
		public Node delete(int val) { return delete(val, this); }
		
		public Node delete(int val, Node root)
		{
			if(root != null)
			{
				if(val < root.value)
					root.left = delete(val, root.left);
				else if(val > root.value)
					root.right = delete(val, root.right);
				else
				{
					if(root.left == null)
						return root.right;
					else if(root.right == null)
						return root.left;
				
						Node min = findMin(root.right);
						root.value = min.value;
						
						root.right = delete(min.value, root.right);
				}
					
				root = balance(root);
				root.height = maxHeight(root);
			}
			
			return root;
		}
		
		public Node findMin(Node root)
		{
			while(root.left != null)
				root = root.left;
			
			return root;
		}
		
		public int height(Node root) { return ((root == null) ? 0 : root.height); }
		
		public int maxHeight(Node root) { return (max(height(root.left), height(root.right)) + 1); }
		
		public int max(int one, int two) { return ((one > two) ? one : two); }
		
		public int balanceFactor(Node root) { return (height(root.right) - height(root.left)); }
		
		public Node balance(Node root)
		{
				if(balanceFactor(root) == 2)
					if(balanceFactor(root.right) == 1)
						root = LeftRotation(root);
					else
						root = LeftRightRotation(root);
				else if(balanceFactor(root) == (-2))
					if(balanceFactor(root.left) == (-1))
						root = RightRotation(root);
					else
						root = RightLeftRotation(root);
					
			return root;
		}
		
		public Node LeftRightRotation(Node root)
		{
			root.right = RightRotation(root.right);
			return LeftRotation(root);
		}
		
		public Node RightLeftRotation(Node root)
		{
			root.left = LeftRotation(root.left);
			return RightRotation(root);
		}
		
		public Node RightRotation(Node oldRoot)
		{
			Node newRoot = oldRoot.left;
			oldRoot.left = newRoot.right;
			newRoot.right = oldRoot;
			
			oldRoot.height = maxHeight(oldRoot);
			newRoot.height = maxHeight(newRoot);
			
			return newRoot;
		}
		
		public Node LeftRotation(Node oldRoot)
		{
			
			Node newRoot = oldRoot.right;
			oldRoot.right = newRoot.left;
			newRoot.left = oldRoot;
			
			oldRoot.height = maxHeight(oldRoot);
			newRoot.height = maxHeight(newRoot);
			
			return newRoot;
		}
		
		public void preOrder() { preOrder(this); }
		
		public void preOrder(Node root)
		{
			if(root != null)
			{
				System.out.print(root.value + " ");
				preOrder(root.left);
				preOrder(root.right);
			}
		}
		
		public void inOrder() { inOrder(this); }
		
		public void inOrder(Node root)
		{
			if(root != null)
			{
				inOrder(root.left);
				System.out.print(root.value + " ");
				inOrder(root.right);
			}
		}
		
		public void postOrder() { postOrder(this); }
		
		public void postOrder(Node root)
		{
			if(root != null)
			{
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.value + " ");
			}
		}
		
		public void BFS() { BFS(this); }
		
		public void BFS(Node root)
		{
			Queue<Node> nodes = new LinkedList<>();
			nodes.add(root);
			
			while(nodes.size() != 0)
			{
				Node removed = nodes.remove();
				System.out.println(removed.value + " ");
				
				if(removed.left != null)
					nodes.add(removed.left);
				
				if(removed.right != null)
					nodes.add(removed.right);
			}
			
		}
		
		public ArrayList<LinkedList<Node>> levels()
		{
			Node root = this;
			ArrayList<LinkedList<Node>> levels = new ArrayList<>();
			LinkedList<Node> previous = new LinkedList<>();
			previous.add(root);
			LinkedList<Node> current = new LinkedList<>();
			
			while(previous.size() > 0)
			{
				for(Node n : previous)
				{
					if(n.left != null)
						current.add(n.left);
				
					if(n.right != null)
						current.add(n.right);
				}
				levels.add(previous);
				previous = new LinkedList<>();
				
				while(current.size() > 0)
						previous.add(current.remove());
			}
			
			return levels;
		}
		
		public int distance(int start, int end)
		{
			ArrayList<Node> toStart = pathFromRoot(start);
			ArrayList<Node> toEnd = pathFromRoot(end);
			
			
			if(toStart.get(toStart.size()-1).value != start || toEnd.get(toEnd.size()-1).value != end)
				return (-1);
			
			
			int shortest = (toStart.size() > toEnd.size()) ? toEnd.size() : toStart.size();
			Node lca = null;
			int lcaDistance = 0;
			
			for(int i = 0; i < shortest; i++)
			{
				Node fromStart = toStart.get(i);
				Node fromEnd = toEnd.get(i);
				
				if(fromStart.value == fromEnd.value)
					lcaDistance = i;
			}
			
			return (((toStart.size() - 1) + (toEnd.size() - 1)) - (2 * lcaDistance));
		}
		
		public ArrayList<Node> path(int start, int end)
		{
			ArrayList<Node> path = new ArrayList<>();
			ArrayList<Node> toStart = pathFromRoot(start);
			ArrayList<Node> toEnd = pathFromRoot(end);
			
			
			if(toStart.get(toStart.size()-1).value != start || toEnd.get(toEnd.size()-1).value != end)
				return new ArrayList<>();
			
			
			int shortest = (toStart.size() > toEnd.size()) ? toEnd.size() : toStart.size();
			int lcaIndex = 0;
			
			for(int i = 0; i < shortest; i++)
			{
				Node fromStart = toStart.get(i);
				Node fromEnd = toEnd.get(i);
				
				if(fromStart.value == fromEnd.value)
					lcaIndex = i;
			}
			
			for(int i = toStart.size() - 1; i >= lcaIndex; i--)
					path.add(toStart.get(i));
			
			for(int i = lcaIndex+1; i < toEnd.size(); i++)
					path.add(toEnd.get(i));
			
			return path;
		}
		
		public Node LCA(int start, int end)
		{
			ArrayList<Node> toStart = pathFromRoot(start);
			ArrayList<Node> toEnd = pathFromRoot(end);
			
			
			if(toStart.get(toStart.size()-1).value != start || toEnd.get(toEnd.size()-1).value != end)
				return null;
			
			
			int shortest = (toStart.size() > toEnd.size()) ? toEnd.size() : toStart.size();
			Node lca = null;
			
			for(int i = 0; i < shortest; i++)
			{
				Node fromStart = toStart.get(i);
				Node fromEnd = toEnd.get(i);
				
				if(fromStart.value == fromEnd.value)
					lca = fromStart;
			}
			
			return lca;
		}
		
		public ArrayList<Node> pathFromRoot(int end)
		{
			ArrayList<Node> path = new ArrayList<>();
			Node current = this;
			
			while(current != null)
			{
				path.add(current);
				
				if(current.value > end)
					current = current.left;
				else if(current.value < end)
					current = current.right;
				else
					break;
			}
			
			return path;
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
		
		//more efficient way (only searches right most branch)
		public int secondLargest(Node root)
		{
			Node previous = null;
			
			while(root.right != null)
			{
				previous = root;
				root = root.right;
			}
			
			return previous.value;
		}
		
		//less efficient way (searches whole tree)
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		public int secondLargestAlterante(Node root)
		{
			
			if(root != null)
			{
				secondLargest(root.left);
			
				if(root.value > largest)
				{
					secondLargest = largest;
					largest = root.value;
				}
				else
					secondLargest = root.value;
			
				secondLargest(root.right);
			}
			
			return secondLargest;
		}
		
		public Node GCA(int one, int two) { return GCA(null, this, one, two); }
		
		public Node GCA(Node parent, Node root, int one, int two)
		{
			/*
			if(root == null)
				return root;
			else if((one < root.value && two > root.value) || (one > root.value && two < root.value))
				return root;
			else if((one == root.value && two > root.value) || (one == root.value && two < root.value)
					|| (one < root.value && two == root.value) || (one > root.value && two == root.value))
				return parent;
			
			Node leftSearch = GCA(root, root.left, one, two);
			Node rightSearch = GCA(root, root.right, one, two);
			
			return (leftSearch == null) ? rightSearch : leftSearch;
			*/
			
			ArrayList<Node> toStart = pathFromRoot(one);
			ArrayList<Node> toEnd = pathFromRoot(two);
			
			
			if(toStart.get(toStart.size()-1).value != one || toEnd.get(toEnd.size()-1).value != two)
				return null;
			
			
			int shortest = (toStart.size() > toEnd.size()) ? toEnd.size() : toStart.size();
			Node gca = new Node();
			for(int i = 0; i < shortest; i++)
			{
				if((one < toStart.get(i).value && two > toStart.get(i).value) || (one > toStart.get(i).value && two < toStart.get(i).value))
				{
					gca = toStart.get(i);
					break;
				}
				else if((one == toStart.get(i).value || two == toStart.get(i).value))
				{
					gca = toStart.get(i - 1);
					break;
				}
			}
			
			return gca;
		}
	}
	
	private Node root;
	
	public AVLTree() { root = null; }
	
	public void insert(int val) { root = ((root == null) ? (new Node(val)) : (root.insert(val))); }
	
	public void delete(int val) { if(root != null) root = root.delete(val); }
	
	public void maxHeight() { System.out.print((root != null) ? (root.maxHeight(root)) : (-1)); }
	
	public void preOrder() { if(root != null) root.preOrder(); }
	
	public void inOrder() { if(root != null) root.inOrder(); }
	
	public void postOrder() { if(root != null) root.postOrder(); }
	
	public void BFS() { if(root != null) root.BFS(); }
	
	public ArrayList<LinkedList<Node>> levels()
	{
		if(root != null)
			return root.levels();
		
		return new ArrayList<>();
	}
	
	public int distance(int start, int end)
	{
		if(root != null)
			return root.distance(start, end);
		
		return (-1);
	}
	
	public Integer GCA(int one, int two)
	{
		Node GCA = null;
		
		if(root != null)
			GCA = root.GCA(one, two);
		
		return (GCA == null) ? null : GCA.value;
	}
	
	public Node LCA(int start, int end)
	{
		if(root != null)
			return root.LCA(start, end);
		
		return null;
	}
	
	public ArrayList<Node> path(int start, int end)
	{
		if(root != null)
			return root.path(start, end);
		
		return null;
	}
	
	public int secondLargest()
	{
		if(root != null)
			return root.secondLargest(root);
		
		return (-1);
	}
	
	public boolean isBalanced(Node root) { return (root != null) ? (!(root.balanceFactor(root) > 1) || !(root.balanceFactor(root) < 1)) : false; }
	
	public boolean isBalanced(int value)
	{ 
		Node node = null;
		
		if(this.root != null)
			node = this.root.search(value, this.root);
		
		return (this.root != null) ? (!(this.root.balanceFactor(node) > 1) || !(this.root.balanceFactor(node) < 1)) : false;
	}
}
