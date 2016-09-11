/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class MaxProfitIII
{
  public static int maxProfit(int[] stocks)
  {
        if(stocks == null || stocks.length < 2) return 0;
        
        int[] firstPass = new int[stocks.length];
        int[] secondPass = new int[stocks.length];
        
        int i = 1;
        int min = stocks[0];
        int max = stocks[stocks.length - 1];
        int maxProfit = 0;
        
        firstPass[0] = 0;
        secondPass[stocks.length - 1] = 0;
        
        while(i < firstPass.length)
        {
            min = (min > stocks[i]) ? stocks[i] : min;
            firstPass[i] = ((stocks[i] - min) > firstPass[i - 1]) ? (stocks[i] - min) : firstPass[i - 1];
            i++;
        }
        
        i = secondPass.length - 2;
        while(i >= 0)
        {
            max = (max < stocks[i]) ? stocks[i] : max;
            secondPass[i] = ((max - stocks[i]) > secondPass[i + 1]) ? (max - stocks[i]) : secondPass[i + 1];
            i--;
        }
        
        i = 0;
        while(i < stocks.length)
        {
            maxProfit = (maxProfit > (firstPass[i] + secondPass[i])) ? maxProfit : (firstPass[i] + secondPass[i]);
            i++;
        }
            
        return maxProfit;
  }
}
