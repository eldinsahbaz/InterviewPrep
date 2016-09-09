/*
Write a function fib() that a takes an integer nn and returns the nnth fibonacci number.
Let's say our fibonacci series is 0-indexed and starts with 0
*/

public class Fibonacci
{
  public int fib(int n)
	{
		if(n <= 1)
			return n;
			
		return fib(n-1) + fib(n-2)
	}
}
