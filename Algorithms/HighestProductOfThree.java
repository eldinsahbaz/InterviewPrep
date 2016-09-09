public class HighestProductOfThree
{
  public int highestProduct(int[] array)
  {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int firstNeg = Integer.MAX_VALUE;
        int secondNeg = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++)
        {
                int current = array[i];

                if(current > first)
                {
                        third = second;
                        second = first;
                        first = current;
                }
                else if(current > second)
                {
                        third = second;
                        second = current;
                }
                else if(current > third)
                        third = current;

                if(current < firstNeg)
                {
                        secondNeg = firstNeg;
                        firstNeg = current;
                }
                else if(current < secondNeg)
                        secondNeg = current;
        }

        int NegProd = firstNeg * secondNeg;
        int PosProd = first * second;

        return ((PosProd > NegProd) ? (PosProd * third) : (NegProd * first));
  }
}
