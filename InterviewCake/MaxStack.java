/*
Use the built-in Stack class to implement a new class MaxStack with a function getMax() that returns the largest element in the stack.
getMax() should not remove the item.

Your stacks will contain only integers.
*/

public class MaxStack extends java.util.Stack<Integer>
{
		
		private java.util.Stack<Integer> MaxStack;
	
		public MaxStack()
		{
			super();
			MaxStack = new java.util.Stack<>();
		}
		
		public void push(int val)
		{
			if(MaxStack.empty())
				MaxStack.push(val);
			else if(val >= MaxStack.peek())
				MaxStack.push(val);
			
			super.push(val);
		}
		
		public Integer pop()
		{
			if(MaxStack.empty())
				return (Integer.MIN_VALUE);
			
			int popped = super.pop();
			
			if(popped == MaxStack.peek())
				MaxStack.pop();
				
			return popped;
		}
		
		public Integer getMax() { return MaxStack.peek(); };
}
