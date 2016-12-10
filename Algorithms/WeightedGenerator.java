//weighted random number generator
import java.util.Random;

class WeightedGenerator
{
  public int generate(int[] weights)
  {
   int sum = 0;
   for(int i : weights)
      sum += i;

    Random rand = new Random();
    int randomNumber = Math.abs(rand.nextInt()) % (sum+1);

    for(int i = 0; i < weights.length; i++)
    {
      if(randomNumber - weights[i] > 0)
        randomNumber -= weights[i];
      else
      {
        randomNumber = i;
        break;
      }
    }

    return randomNumber;
  }
}
