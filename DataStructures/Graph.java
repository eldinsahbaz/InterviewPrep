import java.uti.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph
{
	private int V;
	private LinkedList<Integer>[] adj;
	
	public Graph(int v)
	{
			V = v;
			adj = new LinkedList[V];
			
			for(int i = 0; i < adj.length; i++)
				adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int start, int end)
	{
		if(start <= V && end <= V)
			adj[start].add(end);
	}
	
	public void removeEdge(int start, int end)
	{
		if(start <= V && end <= V)
		{
			int i;
			for(i = 0; i < adj[start].size(); i++)
				if(adj[start].get(i) == end)
					break;
			
			if(i == adj[start].size())
				--i;
				
			adj[start].remove(i);
		}
	}
	
	public boolean hasEdge(int start, int end)
	{
		if(start <= V && end <= V)
			return adj[start].contains(end);
			
		return false;
	}
	
	public LinkedList<Integer> outEdges(int vertex)
	{
		if(vertex <= V)
			return adj[vertex];
			
		return new LinkedList<>();
	}
	
	public LinkedList<Integer> inEdges(int vertex)
	{
		LinkedList<Integer> inEdges = new LinkedList<>();
		
		for(int i = 0; i < adj.length; i++)
			if(adj[i].contains(vertex))
				inEdges.add(i);
		
		return inEdges;
	}
	
	public boolean hasPath(int start, int end)
	{
		HashSet<Integer> nodes = new HashSet<>();
		
		if(start <= V && end <= V)
			hasPath(start, end, nodes);
		
		return nodes.contains(end);
	}
	
	public void hasPath(int start, int end, HashSet<Integer> seen)
	{
		seen.add(start);
		
		for(int edge : outEdges(start))
			if(!seen.contains(edge))
				hasPath(edge, end, seen);
	}
}
