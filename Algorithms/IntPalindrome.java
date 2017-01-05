/*
Given an int, return a boolean indicating whether or not the int is a palindrome.
*/

public class IntPalindrome
{
  public boolean isPalindrome(int x)
    {
        int rebuild = 0;
        int backUp = x;
        x = Math.abs(x);
        
        while(x > 0)
        {
           int modded = x%10;
           rebuild = (rebuild * 10) + modded;
           x -= modded;
           x /= 10;
        }
        
        return (rebuild == backUp);
    }
}
