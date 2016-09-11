/*
Suppose we could access yesterday's stock prices as a list, where:

The indices are the time in minutes past trade opening time, which was 9:30am local time.
The values are the price in dollars of Apple stock at that time.
So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500.

Write an efficient function that takes stock_prices_yesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
*/

public class AppleStock
{
  public int getMaxProfit(int[] Stocks)
  {
        int leftPtr = 0;
        int rightPtr = Stocks.length - 1;
        int leftStock = Integer.MAX_VALUE;
        int rightStock = Integer.MIN_VALUE;

        while(leftPtr < rightPtr)
        {
                if(Stocks[leftPtr] < leftStock) leftStock = Stocks[leftPtr];
                if(Stocks[rightPtr] > rightStock) rightStock = Stocks[rightPtr];

                rightPtr--;
                leftPtr++;
        }

        return (rightStock - leftStock);
  }
  
  public int getMaxProfitAlternate(int[] Stocks)
  {
      if(Stocks == null || Stocks.length < 2) return 0;
        
      int[] profits = new int[Stocks.length];
      int min = Stocks[0];
      profits[0] = 0;
      int i = 1;
        
      while(i < profits.length)
      {
          min = (min > Stocks[i]) ? Stocks[i] : min;
          profits[i] = ((Stocks[i] - min) > profits[i - 1]) ? (Stocks[i] - min) : profits[i - 1];
          i++;
      }
            
      return profits[Stocks.length - 1];
  }
}
