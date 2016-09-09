public class ReverseInt
{
  public int reverse(int x)
    {
        int rebuild = 0;
        boolean isNegative = (x > 0) ? false : true;
        x = Math.abs(x);
        
        while(x > 0)
        {
           int modded = x%10;
           rebuild = (rebuild * 10) + modded;
           x -= modded;
           x /= 10;
        }
        
        return (isNegative) ? (-1*rebuild) : rebuild;
    }
}
