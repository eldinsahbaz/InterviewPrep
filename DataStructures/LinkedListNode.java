import java.util.HashSet;

public class LinkedListNode
{
	public int value;
	public LinkedListNode next;
	
	public LinkedListNode(int value) { this.value = value; }
	
	//delete Node, given a pointer to a specific node
	public void delete(LinkedListNode current)
	{
		LinkedListNode previous = null;
		
		while(current.next != null)
		{
			previous = current;
			current = current.next;
			previous.value = current.value;
		}
		
		if(previous != null)
			previous.next = null;
	}
	
	public boolean containsCycle()
	{
		LinkedListNode root = this;
		HashSet<LinkedListNode> nodes = new HashSet<>();
		
		while(root != null)
		{
			if(nodes.contains(root))
				return true;
				
			nodes.add(root);
			root = root.next;
		}
		
		return false;
	}
	
	public LinkedListNode reverse()
	{
		LinkedListNode previous = null;
		LinkedListNode current = this;
		LinkedListNode next = null;
		
		while(current != null)
		{
			next = current.next;
			current.next = previous;
			
			previous = current;
			current = next;
		}
		
		retur previous;
	}
	
	public LinkedListNode kthToLastNode(int k) { return kthToLastNode(k, this); }
	
	public LinkedListNode kthToLastNode(int k, LinkedListNode root)
	{
		LinkedListNode left = root;
		LinkedListNode right = root;
		int count = 0;
		
		while((right != null) && (count < k))
		{
			right = right.next;
			count++;
		}
		
		if(count < k)
			return right;
		
		while(right != null)
		{
			right = right.next;
			left = left.next;
		}
		
		return left;
	}
	
	public LinkedListNode kthToLastNodeAlternate(int k, LinkedListNode root)
	{
		LinkedListNode current = root;
		int count = 1;
		
		while(current != null)
		{
			current = current.next;
			count++;
		}
		
		int index = count - k;
		count = 1;
		
		if(index > 0)
			current = root;
		
		while(count <= index)
			current = current.next;
			
		return current;
	}
	
	public String toString()
	{
		String val = "";
		LinkedListNode current = this;
		while(current != null)
		{
			val += current.value + " ";
			current = current.next;
		}
		
		return val;
	}
}
