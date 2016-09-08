/*
Implement a queue with 2 stacks. 
Your queue should have an enqueue and a dequeue function and it should be "first in first out" (FIFO).
*/

import java.util.Stack;

public class MyQueue<T>
{
		Stack<T> inStack;
		Stack<T> outStack;
		
		public MyQueue() { inStack = new Stack<>(); outStack = new Stack<>(); }
		
		public void enQueue(T value)
		{
			while(!outStack.empty())
				inStack.push(outStack.pop());
			
			inStack.push(value);
		}
		
		public T deQueue()
		{
			while(!inStack.empty())
				outStack.push(inStack.pop());
			
			return outStack.pop();
		}
		
		public T peek()
		{
			while(!outStack.empty())
				inStack.push(outStack.pop());
			
			return inStack.peek();
		}
}
