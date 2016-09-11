/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class MaxProfitIII
{
  public static int maxProfit(int[] Stocks)
  {
    	//single transaction
        int leftPtr = 0;
        int rightPtr = Stocks.length - 1;
        int leftStock = Integer.MAX_VALUE;
        int rightStock = Integer.MIN_VALUE;
        int leftStockIndex = 0;
        int rightStockIndex = 0;

        while(leftPtr < rightPtr)
        {
                if(Stocks[leftPtr] < leftStock)
                {
                    leftStock = Stocks[leftPtr];
                    leftStockIndex = leftPtr;
                }
                if(Stocks[rightPtr] > rightStock)
                {
                    rightStock = Stocks[rightPtr];
                    rightStockIndex = rightPtr;
                }

                rightPtr--;
                leftPtr++;
        }

        int oneTransaction = (rightStock - leftStock);
        int twoTransactions = 0;
        
        //two transactions
        
        //left of min
        
        leftPtr = 0;
        rightPtr = leftStockIndex;
        int leftStockTwo = Integer.MAX_VALUE;
        int rightStockTwo = Integer.MIN_VALUE;

        while(leftPtr < rightPtr)
        {
                if(Stocks[leftPtr] < leftStockTwo) leftStockTwo = Stocks[leftPtr];
                if(Stocks[rightPtr] > rightStockTwo) rightStockTwo = Stocks[rightPtr];

                rightPtr--;
                leftPtr++;
        }
        
        twoTransactions = (rightStockTwo - leftStockTwo) + oneTransaction;
        
        //between min and max
        
        leftPtr = leftStockIndex;
        rightPtr = rightStockIndex;
        leftStockTwo = Integer.MIN_VALUE;
        rightStockTwo = Integer.MAX_VALUE;

        while(leftPtr < rightPtr)
        {
                if(Stocks[leftPtr] > leftStockTwo) leftStockTwo = Stocks[leftPtr];
                if(Stocks[rightPtr] < rightStockTwo) rightStockTwo = Stocks[rightPtr];

                rightPtr--;
                leftPtr++;
        }
        if(((leftStockTwo - leftStock) + (rightStock - rightStockTwo)) > twoTransactions)
        	twoTransactions = (leftStockTwo - leftStock) + (rightStock - rightStockTwo);
        
        //right of max
        
        leftPtr = rightStockIndex;
        rightPtr = Stocks.length - 1;
        leftStockTwo = Integer.MAX_VALUE;
        rightStockTwo = Integer.MIN_VALUE;

        while(leftPtr < rightPtr)
        {
                if(Stocks[leftPtr] < leftStockTwo) leftStockTwo = Stocks[leftPtr];
                if(Stocks[rightPtr] > rightStockTwo) rightStockTwo = Stocks[rightPtr];

                rightPtr--;
                leftPtr++;
        }
        
        if(((rightStockTwo - leftStockTwo) + oneTransaction) > twoTransactions)
        	twoTransactions = (rightStockTwo - leftStockTwo) + oneTransaction;
        
        return (oneTransaction > twoTransactions) ? oneTransaction : twoTransactions;
  }
}
