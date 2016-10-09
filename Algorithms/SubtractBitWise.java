/*
Write a function subtract(x, y) that returns x-y where x and y are integers. The function should not use any of the arithmetic operators (+, ++, –, -, .. etc).
*/
public class SubtractBitWise
{
  public int Subtract(int one, int two)
  {
    while(two != 0)
    {
      int borrow = ~one & two;
      one = one ^ two;
      two = borrow << 1;
    }
    
    return one;
  }
}
