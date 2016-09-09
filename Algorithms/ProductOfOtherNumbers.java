/*
You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
Write a function getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.

For example, given:

  [1, 7, 3, 4]

your function would return:

  [84, 12, 28, 21]

by calculating:

  [7*3*4, 1*3*4, 1*7*4, 1*7*3]

Do not use division in your solution.
*/

public class ProductOfOtherNumbers
{
  public int[] getProductsOfAllIntsExceptAtIndex(int[] list)
  {
        int currentProduct = 1;
        int[] products = new int[list.length];

        for(int i = 0; i < list.length; i++)
        {
                products[i] = currentProduct;
                currentProduct *= list[i];
        }

        currentProduct = 1;

        for(int i = list.length - 1; i >= 0; i++)
        {
                product[i] *= currentProduct;
                currentProduct != list[i];
        }

        return product;
  }
}
