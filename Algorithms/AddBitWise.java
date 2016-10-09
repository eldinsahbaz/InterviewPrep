/*
Write a function Add() that returns sum of two integers. The function should not use any of the arithmetic operators (+, ++, –, -, .. etc).
*/

public class AddBitWise
{
  public int Add(int one, int two)
  {
    while(two != 0)
    {
      int carryOver = one & two;
      one = one ^ two;
      two = carryOver << 1;
    }
    
    return one;
  }
}
