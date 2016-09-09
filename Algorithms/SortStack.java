
import java.util.Stack;

public class SortStack
{
  public Stack<Integer> sortStack(Stack<Integer> stack)
	{
		Stack<Integer> sorted = new Stack<>();
		
		while(!stack.empty())
		{
			int popped = stack.pop();
			
			while(!sorted.empty() && stack.peek() > popped)
				stack.push(sorted.pop());
			
			sorted.push(popped);
		}
		
		return sorted;
	}
}
